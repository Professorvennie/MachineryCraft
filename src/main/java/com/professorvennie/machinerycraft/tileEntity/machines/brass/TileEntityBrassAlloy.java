/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.tileEntity.machines.brass;

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.block.machines.brass.BlockBrassAlloySmelter;
import com.professorvennie.machinerycraft.item.ModItems;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.core.utils.PowerAmounts;
import com.professorvennie.machinerycraft.tileEntity.TileEntityBasicSidedInventory;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityBrassAlloy extends TileEntityBasicSidedInventory {

    private static ItemStack saltIngot = new ItemStack(ModItems.Ingots, 1, 4);
    private static ItemStack ironOxideIngot = new ItemStack(ModItems.Ingots, 4, 6);
    public final int maxPower = 10000;
    public int grindSpeed = 80, power, cookTime, currentItemBurnTime;

    public TileEntityBrassAlloy() {
        super(Names.Containers.CONTAINER_BRASS_ALLOY);
        slots_top = new int[]{0};
        slots_bottom = new int[]{2, 1};
        slots_sides = new int[]{1};
    }

    public int getSizeInventory() {
        return 4;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        this.power = (int) nbt.getShort("burnTime");
        this.cookTime = (int) nbt.getShort("cookTime");
        this.currentItemBurnTime = (int) nbt.getShort("currentItemBurnTime");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("burnTime", (short) this.power);
        nbt.setShort("cookTime", (short) this.cookTime);
        nbt.setShort("currentItemBurnTime", (short) this.currentItemBurnTime);
    }

    public boolean hasPower() {
        return this.power > 0;
    }

    public boolean isGrinding() {
        return this.cookTime > 0;
    }

    public void updateEntity() {
        boolean flag = this.cookTime > 0;
        boolean flag1 = false;

        if (hasPower() && isGrinding()) {
            this.power--;
        }

        if (this.power > this.maxPower) {
            this.power = this.maxPower;
        }

        if (!this.worldObj.isRemote) {
            if (this.power < this.maxPower && PowerAmounts.getItemPower(this.inventory[1]) > 0) {
                if (maxPower - power > PowerAmounts.getItemPower(inventory[1])) {
                    this.power += PowerAmounts.getItemPower(this.inventory[1]);

                    flag1 = true;
                    if (this.inventory[1] != null) {
                        this.inventory[1].stackSize--;

                        if (this.inventory[1].stackSize == 0) {
                            this.inventory[1] = this.inventory[1].getItem().getContainerItem(inventory[1]);
                        }
                    }
                }
            }
            if (this.hasPower() && this.canGrind()) {
                this.cookTime++;

                if (this.cookTime == this.grindSpeed) {
                    this.cookTime = 0;
                    this.GrindItem();
                    flag1 = true;
                }
            } else {
                this.cookTime = 0;
            }

            if (flag != this.hasPower()) {
                flag1 = true;
                BlockBrassAlloySmelter.updateBlockState(this.cookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord, ModBlocks.brassAlloyActive, ModBlocks.brassAlloyIdle);
            }

        }


        if (flag1) {
            this.markDirty();
        }
    }

    private boolean canGrind() {
        if (this.inventory[0] == null) {
            return false;
        } else {
            ItemStack itemstack = getresult(this.inventory[0], this.inventory[3]);

            if (itemstack == null) return false;
            if (this.inventory[2] == null) return true;
            if (!this.inventory[2].isItemEqual(itemstack)) return false;

            int result = this.inventory[2].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());


        }
    }

    public ItemStack getresult(ItemStack itemstack, ItemStack itemstack2) {
        if (itemstack != null && itemstack2 != null) {
            int i = itemstack.getItem().getIdFromItem(itemstack.getItem());
            int j = itemstack2.getItem().getIdFromItem(itemstack2.getItem());
            if (i == Items.iron_ingot.getIdFromItem(Items.iron_ingot) && j == ModItems.Ingots.getIdFromItem(saltIngot.getItem()))
                return ironOxideIngot;
            if (i == ModItems.Ingots.getIdFromItem(saltIngot.getItem()) && j == Items.iron_ingot.getIdFromItem(Items.iron_ingot))
                return ironOxideIngot;
            if (i == Items.iron_ingot.getIdFromItem(Items.iron_ingot) && j == 0)
                return null;
            if (i == 0 && j == Items.iron_ingot.getIdFromItem(Items.iron_ingot))
                return null;
            if (i == ModItems.Ingots.getIdFromItem(saltIngot.getItem()) && j == 0)
                return null;
            if (i == 0 && j == ModItems.Ingots.getIdFromItem(saltIngot.getItem()))
                return null;
        }
        return null;

    }

    public void GrindItem() {
        if (this.canGrind()) {
            ItemStack itemstack = this.getresult(this.inventory[0], this.inventory[3]);

            if (this.inventory[2] == null) {
                this.inventory[2] = itemstack.copy();
            } else if (this.inventory[2].isItemEqual(itemstack)) {
                this.inventory[2].stackSize += itemstack.stackSize;
            }

            this.inventory[0].stackSize--;
            this.inventory[3].stackSize--;

            if (this.inventory[0].stackSize <= 0) {
                this.inventory[0] = null;
            }
        }
    }

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return var1 == 2 ? false : (var1 == 1 ? PowerAmounts.isItemPower(var2) : true);
    }


    @Override
    public boolean canExtractItem(int var1, ItemStack var2, int var3) {
        return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
    }

    public int getCookProgressScaled(int par1) {
        return this.cookTime * par1 / this.grindSpeed;
    }

    public int getPowerRemainingScaled(int par1) {
        return this.power * par1 / this.maxPower;
    }

    public int getCurrentCharge() {
        return this.power;
    }

    public int getChargeCapacity() {
        return this.maxPower;
    }
}
