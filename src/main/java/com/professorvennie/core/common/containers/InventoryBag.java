/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.common.containers;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.main.helpers.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.UUID;

/**
 * Created by ProfessorVennie on 8/28/2014 at 7:02 PM.
 */
public class InventoryBag implements IInventory{

    public ItemStack parentItemStack;
    public ItemStack[] inventory;

    public InventoryBag(ItemStack itemStack) {
        parentItemStack = itemStack;

        if(itemStack.getItemDamage() == 0){
            inventory = new ItemStack[3 * 9];
        }else if(itemStack.getItemDamage() == 1){
            inventory = new ItemStack[4 * 9];
        }else if(itemStack.getItemDamage() == 2){
            inventory = new ItemStack[5 * 9];
        }else if(itemStack.getItemDamage() == 3){
            inventory = new ItemStack[6 * 9];
        }else if(itemStack.getItemDamage() == 4){
            inventory = new ItemStack[7 * 9];
        }else if(itemStack.getItemDamage() == 5){
            inventory = new ItemStack[8 * 9];
        }else if(itemStack.getItemDamage() == 6){
            inventory = new ItemStack[9 * 9];
        }else if(itemStack.getItemDamage() == 7){
            inventory = new ItemStack[9 * 11];
        }else if(itemStack.getItemDamage() == 8){
            inventory = new ItemStack[9 * 13];
        }
        if(parentItemStack.getTagCompound() != null)
            readFromNBT(parentItemStack.getTagCompound());
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
    public ItemStack decrStackSize(int slot, int amount) {
        if(this.inventory[slot] != null){
            ItemStack itemstack;
            if(this.inventory[slot].stackSize <= amount){
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;
                return itemstack;
            }else{
                itemstack = this.inventory[slot].splitStack(amount);
                if(this.inventory[slot].stackSize == 0){
                    this.inventory[slot] = null;
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
        this.inventory[slot] = itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {}

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

    public void readFromNBT(NBTTagCompound nbtTagCompound){
        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); i++){
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length){
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound){
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; currentIndex++){
            if (inventory[currentIndex] != null){
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

    /**
     * @author Pahimar
     */
    public void onGuiSaved(EntityPlayer player) {
        parentItemStack = findParentItemStack(player);

        if(parentItemStack != null){
            save();
        }
    }

    /**
     * @author Pahimar
     */
    public ItemStack findParentItemStack(EntityPlayer player){
        if(NBTHelper.hasUUID(parentItemStack)){
            UUID uuid = new UUID(parentItemStack.getTagCompound().getLong(Names.NBT.UUID_MOST_SIG), parentItemStack.getTagCompound().getLong(Names.NBT.UUID_LEAST_SIG));
            for(int i = 0; i < player.inventory.getSizeInventory(); i++){
                ItemStack itemStack = player.inventory.getStackInSlot(i);
                if(NBTHelper.hasUUID(itemStack)){
                    if(itemStack.getTagCompound().getLong(Names.NBT.UUID_MOST_SIG) == uuid.getMostSignificantBits() && itemStack.getTagCompound().getLong(Names.NBT.UUID_LEAST_SIG) == uuid.getLeastSignificantBits()){
                        return itemStack;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @author Pahimar
     */
    public void save(){
        NBTTagCompound nbtTagCompound = parentItemStack.getTagCompound();
        if(nbtTagCompound == null){
            nbtTagCompound = new NBTTagCompound();

            UUID uuid = UUID.randomUUID();
            nbtTagCompound.setLong(Names.NBT.UUID_MOST_SIG, uuid.getMostSignificantBits());
            nbtTagCompound.setLong(Names.NBT.UUID_LEAST_SIG, uuid.getLeastSignificantBits());
        }
        writeToNBT(nbtTagCompound);
        parentItemStack.setTagCompound(nbtTagCompound);
    }
}
