/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.brass.grinder;


import com.professorvennie.machinerycraft.api.recipes.GrinderRecipes;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.core.utils.PowerAmounts;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class TileEntityBrassGrinder extends TileEntityBasicMachine {

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

    public void update() {
        super.update();
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
                            this.inventory[1] = new ItemStack(this.inventory[1].getItem().getContainerItem());
                    }
                }
            }
            if (this.hasPower() && this.canGrind() && canWork) {
                this.cookTime++;

                if (this.cookTime == this.grindSpeed) {
                    this.cookTime = 0;
                    this.GrindItem();
                    flag1 = true;
                }
            } else this.cookTime = 0;

            if (flag != this.hasPower()) {
                flag1 = true;
                BlockBrassGrinder.updateBlockState(this.cookTime > 0, this.worldObj, pos, ModBlocks.brassGrinderActive, ModBlocks.brassGrinderIdle);
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
    public boolean canExtractItem(int slotId, ItemStack stack, EnumFacing direction) {
        return direction != EnumFacing.DOWN || slotId != 1 || stack.getItem() == Items.bucket;
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

    @Override
    public int getFieldCount() {
        return super.getFieldCount() + 2;
    }

    @Override
    public int getField(int id) {
        super.getField(id);
        if(id == 1)
            return cookTime;
        else if (id == 2)
            return power;
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        super.setField(id, value);
        if(id == 1)
            cookTime = value;
        else if (id == 2)
            power = value;
    }
}
