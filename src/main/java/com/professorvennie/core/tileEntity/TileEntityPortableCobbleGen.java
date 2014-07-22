package com.professorvennie.core.tileEntity;

import com.professorvennie.core.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class TileEntityPortableCobbleGen extends TileEntityMod implements ISidedInventory{

    public int cookTime = 0, cookSpeed = 100;
    public ItemStack[] inventory = new ItemStack[3];
    private static final int[] slots_bottom = new int[]{2};

    @Override
    public void updateEntity() {
        if(!worldObj.isRemote){
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

    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);

        cookTime = nbt.getInteger("cookTime");

        NBTTagList list = nbt.getTagList("items", Constants.NBT.TAG_COMPOUND);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < list.tagCount(); i ++){
            NBTTagCompound compound = list.getCompoundTagAt(i);
            int j = compound.getByte("slot") & 0xff;

            if(j >= 0 && j < this.inventory.length){
                this.inventory[j] = ItemStack.loadItemStackFromNBT(compound);

            }
        }
    }

    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();

        for(int i = 0; i < this.inventory.length; i ++){
            if(this.inventory[i] != null){
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("slot", (byte) i);
                this.inventory[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }
        nbt.setInteger("cookTime", cookTime);
        nbt.setTag("items", list);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 0 ? slots_bottom : new int[0];
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public boolean canExtractItem(int var1, ItemStack itemStack, int var3) {
        return itemStack.getItem() == Item.getItemFromBlock(Blocks.cobblestone);
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

    public int getCookProgressScaled(int i){
        return this.cookTime * i / this.cookSpeed;
    }
}
