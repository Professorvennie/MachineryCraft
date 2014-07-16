/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.tileEntity;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;


public class TileEntityPlasticChest extends TileEntityMod implements IInventory{

    /** The current angle of the lid (between 0 and 1) */
    public float lidAngle;
    /** The angle of the lid last tick */
    public float prevLidAngle;
    /** The number of players currently using this chest */
    public int numPlayersUsing;

    private int ticksSinceSync;

    public ItemStack[] slots;

    public TileEntityPlasticChest(){
        slots = new ItemStack[9*6];
    }

    @Override
    public int getSizeInventory() {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return slots[i];
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        if(this.slots[var1] != null){
            ItemStack itemstack;
            if(this.slots[var1].stackSize <= var2){
                itemstack = this.slots[var1];
                this.slots[var1] = null;
                return itemstack;
            }else{
                itemstack = this.slots[var1].splitStack(var2);
                if(this.slots[var1].stackSize == 0){
                    this.slots[var1] = null;
                }
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if(this.slots[slot] != null){
            ItemStack itemstack = this.slots[slot];
            this.slots[slot] = null;
            return itemstack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.slots[slot]= itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound){
        super.readFromNBT(nbtTagCompound);

        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i){
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < slots.length)
            {
                slots[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound){
        super.writeToNBT(nbtTagCompound);

        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < slots.length; ++currentIndex){
            if (slots[currentIndex] != null){
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                slots[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.CONTAINER_PLASTIC_CHEST;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return customName != null && customName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory() {
        this.numPlayersUsing++;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, ModBlocks.plasticChest, 1, this.numPlayersUsing);
    }

    @Override
    public void closeInventory() {
            this.numPlayersUsing--;
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, ModBlocks.plasticChest, 1, this.numPlayersUsing);
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }

    public void updateEntity(){
        super.updateEntity();

        if (++ticksSinceSync % 20 * 4 == 0){
            worldObj.addBlockEvent(xCoord, yCoord, zCoord, ModBlocks.plasticChest, 1, numPlayersUsing);
        }

        prevLidAngle = lidAngle;
        float angleIncrement = 0.1F;
        double adjustedXCoord, adjustedZCoord;

        if (numPlayersUsing > 0 && lidAngle == 0.0F){
            adjustedXCoord = xCoord + 0.5D;
            adjustedZCoord = zCoord + 0.5D;
            worldObj.playSoundEffect(adjustedXCoord, yCoord + 0.5D, adjustedZCoord, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (numPlayersUsing == 0 && lidAngle > 0.0F || numPlayersUsing > 0 && lidAngle < 1.0F){
            float var8 = lidAngle;

            if (numPlayersUsing > 0){
                lidAngle += angleIncrement;
            }
            else{
                lidAngle -= angleIncrement;
            }

            if (lidAngle > 1.0F){
                lidAngle = 1.0F;
            }

            if (lidAngle < 0.5F && var8 >= 0.5F){
                adjustedXCoord = xCoord + 0.5D;
                adjustedZCoord = zCoord + 0.5D;
                worldObj.playSoundEffect(adjustedXCoord, yCoord + 0.5D, adjustedZCoord, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (lidAngle < 0.0F){
                lidAngle = 0.0F;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int eventID, int numUsingPlayers){
        if (eventID == 1){
            this.numPlayersUsing = numUsingPlayers;
            return true;
        }
        else{
            return super.receiveClientEvent(eventID, numUsingPlayers);
        }
    }
}