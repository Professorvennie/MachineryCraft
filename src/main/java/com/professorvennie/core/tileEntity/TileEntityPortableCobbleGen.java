package com.professorvennie.core.tileEntity;

import com.professorvennie.core.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public class TileEntityPortableCobbleGen extends TileEntityMod implements ISidedInventory{

    private int cookTime = 0, cookSpeed = 100;
    public ItemStack[] inventory = new ItemStack[3];

    @Override
    public void updateEntity() {
        if(!worldObj.isRemote){
                System.out.println(cookTime);
                if(inventory[0] != null && inventory[1] != null) {
                    if (inventory[0].getItem() == Items.lava_bucket && inventory[1].getItem() == Items.water_bucket) {
                        cookTime++;
                        if (cookTime == cookSpeed) {
                            cookTime = 0;
                            if (inventory[2] == null)
                                setInventorySlotContents(2, new ItemStack(Blocks.cobblestone));
                            else if (inventory[2].stackSize < getInventoryStackLimit())
                                inventory[2].stackSize++;
                            else inventory[2].stackSize = getInventoryStackLimit();
                        }
                    }
                }else
                    cookTime = 0;
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if(this.inventory[var1] != null){
            ItemStack itemstack;
            if(this.inventory[var1].stackSize <= var2){
                itemstack = this.inventory[var1];
                this.inventory[var1] = null;
                return itemstack;
            }else{
                itemstack = this.inventory[var1].splitStack(var2);
                if(this.inventory[var1].stackSize == 0){
                    this.inventory[var1] = null;
                }
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if(this.inventory[slot] != null){
            ItemStack itemstack = this.inventory[slot];
            this.inventory[slot] = null;
            return itemstack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.inventory[slot]= itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.CONTAINER_PORTABLE_COBBLEGEN;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }
}
