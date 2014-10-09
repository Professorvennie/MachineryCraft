package com.professorvennie.machinerycraft.machines.basic.campfire;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ProfessorVennie on 9/14/2014 at 6:38 PM.
 */
public class TileEntityCampFire extends TileEntityBasicMachine {

    public int cookTime, burnTime, currentItemBurnTime, machineSpeed = 125;

    public TileEntityCampFire() {
        super(Names.Containers.CAMPFIRE);
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
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    @Override
    public void update() {
        super.update();
        if (burnTime > 0) burnTime--;

        if (!this.worldObj.isRemote) {
            if (this.burnTime == 0 && this.canSmelt() && canWork) {
                this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.inventory[1]) / 2;

                if (this.burnTime > 0) {
                    if (this.inventory[1] != null) {
                        this.inventory[1].stackSize--;

                        if (this.inventory[1].stackSize == 0) {
                            this.inventory[1] = new ItemStack(this.inventory[1].getItem().getContainerItem());
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt() && canWork) {
                this.cookTime++;

                if (this.cookTime == machineSpeed) {
                    this.cookTime = 0;
                    this.smeltItem();
                }
            } else this.cookTime = 0;
        }
    }

    private boolean canSmelt() {
        if (this.inventory[0] == null) {
            return false;
        } else {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory[0]);

            if (itemstack == null) return false;
            if (this.inventory[2] == null) return true;
            if (!this.inventory[2].isItemEqual(itemstack)) return false;

            int result = this.inventory[2].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory[0]);

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
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        cookTime = nbtTagCompound.getInteger("cookTime");
        burnTime = nbtTagCompound.getInteger("burnTime");
        currentItemBurnTime = nbtTagCompound.getInteger("currentItemBurnTime");
        machineSpeed = nbtTagCompound.getInteger("machineSpeed");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setInteger("cookTime", cookTime);
        nbtTagCompound.setInteger("burnTime", burnTime);
        nbtTagCompound.setInteger("currentItemBurnTime", currentItemBurnTime);
        nbtTagCompound.setInteger("machineSpeed", machineSpeed);
    }

    @Override
    public int getSizeInventory() {
        return 3;
    }

    public boolean isBurning() {
        return burnTime > 0;
    }

    public boolean isItemFuel(ItemStack itemStack) {
        return getItemBurnTime(itemStack) > 0;
    }

    public int getCookProgressScaled(int scale) {
        if (machineSpeed != 0)
            return this.cookTime * scale / this.machineSpeed;
        return 0;
    }

    public int getBurnTimeReamingScaled(int i) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = machineSpeed;
        }

        return this.burnTime * i / this.currentItemBurnTime;
    }

    @Override
    public int getField(int id) {
        super.getField(id);
        switch (id){
            case 1:
                return cookTime;
            case 2:
                return burnTime;
            case 3:
                return currentItemBurnTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value) {
        super.setField(id, value);
        switch (id){
            case 1:
                cookTime = value;
                break;
            case 2:
                burnTime = value;
                break;
            case 3:
                currentItemBurnTime = value;
                break;
        }
    }

    @Override
    public int getFieldCount() {
        return super.getFieldCount() + 3;
    }
}
