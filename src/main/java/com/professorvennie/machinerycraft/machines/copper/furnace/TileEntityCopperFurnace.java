/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.copper.furnace;

import com.professorvennie.machinerycraft.api.item.IItemUpgrade;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityCopperFurnace extends TileEntityBasicMachine {

    public int burnTime, currentItemBurnTime, cookTime;

    public TileEntityCopperFurnace() {
        super(Names.Containers.CONTAINER_COPPER_FURNACE);
        this.slots_top = new int[]{0};
        this.slots_bottom = new int[]{2, 1};
        this.slots_sides = new int[]{1};
        setMachineSpeed(95);
        upgradeSlots = new int[]{3, 4, 5};
    }

    public static int getItemBurnTime(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        } else {
            Item item = itemstack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab) {
                    return 150;
                }

                if (block.getMaterial() == Material.wood) {
                    return 300;
                }

                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    public static boolean isItemFuel(ItemStack itemstack) {
        return getItemBurnTime(itemstack) > 0;
    }

    @Override
    public int getSizeInventory() {
        return 6;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        this.cookTime = (int) nbt.getShort("cookTime");
        this.burnTime = (int) nbt.getShort("burnTime");
        this.currentItemBurnTime = (int) nbt.getShort("currentItemBurnTime");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("cookTime", (short) cookTime);
        nbt.setShort("burnTime", (short) this.burnTime);
        nbt.setShort("currentItemBurnTime", (short) this.currentItemBurnTime);
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    public void updateEntity() {
        super.updateEntity();
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

        if (this.burnTime > 0) this.burnTime--;

        if (!this.worldObj.isRemote) {
            if (this.burnTime == 0 && this.canSmelt() && canWork) {
                this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.inventory[1]) * 2;

                if (this.burnTime > 0) {
                    flag1 = true;

                    if (this.inventory[1] != null) {
                        this.inventory[1].stackSize--;

                        if (this.inventory[1].stackSize == 0) {
                            this.inventory[1] = this.inventory[1].getItem().getContainerItem(this.inventory[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt() && canWork) {
                this.cookTime++;

                if (this.cookTime == getMachineSpeed()) {
                    this.cookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            } else this.cookTime = 0;

            if (flag != this.isBurning()) {
                flag1 = true;
                BlockCopperFurnace.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord, ModBlocks.copperFurnaceActive, ModBlocks.copperFurnaceIdle);
            }

        }
        if (flag1) this.markDirty();

        if (!worldObj.isRemote) {
            eject(getEjectorMode(), 2);
        }
    }

    private boolean canSmelt() {
        if (this.inventory[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[0]);

            if (itemstack == null) return false;
            if (this.inventory[2] == null) return true;
            if (!this.inventory[2].isItemEqual(itemstack)) return false;

            int result = this.inventory[2].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[0]);

            if (this.inventory[2] == null)
                this.inventory[2] = itemstack.copy();
            else if (this.inventory[2].isItemEqual(itemstack))
                this.inventory[2].stackSize += itemstack.stackSize;


            this.inventory[0].stackSize--;

            if (this.inventory[0].stackSize <= 0)
                this.inventory[0] = null;
        }
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot == 2 ? false : (slot == 1 ? isItemFuel(itemStack) : true);
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3) {
        return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
    }

    public int getBurnTimeReamingScaled(int i) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = getMachineSpeed();
        }

        return this.burnTime * i / this.currentItemBurnTime;
    }

    public int getCookProgressScaled(int scale) {
        if (getMachineSpeed() != 0)
            return this.cookTime * scale / this.getMachineSpeed();
        return 0;
    }
}
