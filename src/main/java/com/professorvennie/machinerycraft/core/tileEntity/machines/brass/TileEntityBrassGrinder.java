/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.tileEntity.machines.brass;


import com.professorvennie.machinerycraft.api.recipes.GrinderRecipes;
import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.block.machines.brass.BlockBrassGrinder;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.main.utils.PowerAmounts;
import com.professorvennie.machinerycraft.core.tileEntity.TileEntityBasicSidedInventory;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityBrassGrinder extends TileEntityBasicSidedInventory {

    public final int maxPower = 10000;
    public int grindSpeed = 80, power, currentItemBurnTime, cookTime;

    public TileEntityBrassGrinder() {
        super(Names.Containers.CONTAINER_BRASS_GRINDER);
        slots_top = new int[]{0};
        slots_bottom = new int[]{2, 1};
        slots_sides = new int[]{1};
    }

    @Override
    public int getSizeInventory() {
        return 3;
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
        if (this.power > 0) return true;
        return false;
    }

    public boolean isGrinding() {
        return this.cookTime > 0;
    }

    public void updateEntity() {
        boolean flag = this.cookTime > 0;
        boolean flag1 = false;

        if (hasPower() && isGrinding()) this.power--;

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

                        if (this.inventory[1].stackSize == 0)
                            this.inventory[1] = this.inventory[1].getItem().getContainerItem(inventory[1]);
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
            } else this.cookTime = 0;

            if (flag != this.hasPower()) {
                flag1 = true;
                BlockBrassGrinder.updateBlockState(this.cookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord, ModBlocks.brassGrinderActive, ModBlocks.brassGrinderIdle);
            }

        }


        if (flag1) this.markDirty();
    }

    private boolean canGrind() {
        if (this.inventory[0] == null) {
            return false;
        } else {
            ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.inventory[0]);

            if (itemstack == null) return false;
            if (this.inventory[2] == null) return true;
            if (!this.inventory[2].isItemEqual(itemstack)) return false;

            int result = this.inventory[2].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());


        }
    }

    public void GrindItem() {
        if (this.canGrind()) {
            ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.inventory[0]);

            if (this.inventory[2] == null) {
                this.inventory[2] = itemstack.copy();
            } else if (this.inventory[2].isItemEqual(itemstack)) {
                this.inventory[2].stackSize += itemstack.stackSize;
            }

            this.inventory[0].stackSize--;

            if (this.inventory[0].stackSize <= 0) {
                this.inventory[0] = null;
            }
        }
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot == 2 ? false : (slot == 1 ? PowerAmounts.isItemPower(itemStack) : true);
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack itemStack, int var3) {
        return var3 != 0 || var1 != 1 || itemStack.getItem() == Items.bucket;
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

    public int getChargeCapcity() {
        return this.maxPower;
    }
}
