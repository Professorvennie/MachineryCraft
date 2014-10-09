/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.tileEntity;

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.IChatComponent;


public class TileEntityPlasticChest extends TileEntityMod implements IInventory, IUpdatePlayerListBox {

    /**
     * The current angle of the lid (between 0 and 1)
     */
    public float lidAngle;
    /**
     * The angle of the lid last tick
     */
    public float prevLidAngle;
    /**
     * The number of players currently using this chest
     */
    public int numPlayersUsing;
    public ItemStack[] slots;
    private int ticksSinceSync;

    public TileEntityPlasticChest() {
        slots = new ItemStack[9 * 6];
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
        if (this.slots[var1] != null) {
            ItemStack itemstack;
            if (this.slots[var1].stackSize <= var2) {
                itemstack = this.slots[var1];
                this.slots[var1] = null;
                return itemstack;
            } else {
                itemstack = this.slots[var1].splitStack(var2);
                if (this.slots[var1].stackSize == 0) {
                    this.slots[var1] = null;
                }
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.slots[slot] != null) {
            ItemStack itemstack = this.slots[slot];
            this.slots[slot] = null;
            return itemstack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.slots[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < slots.length) {
                slots[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < slots.length; ++currentIndex) {
            if (slots[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                slots[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

    @Override
    public String getName() {
        return this.hasCustomInvName() ? this.getCustomName() : Names.Containers.CONTAINER_PLASTIC_CHEST;
    }

    @Override
    public boolean hasCustomName() {
        return hasCustomInvName();
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
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
    public void openInventory(EntityPlayer player) {
        this.numPlayersUsing++;
        this.worldObj.addBlockEvent(pos, ModBlocks.plasticChest, 1, this.numPlayersUsing);
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        this.numPlayersUsing--;
        this.worldObj.addBlockEvent(pos, ModBlocks.plasticChest, 1, this.numPlayersUsing);
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clearInventory() {
        for(int i = 0; i < slots.length; i++)
            slots[i] = null;
    }

    public void update() {

        if (++ticksSinceSync % 20 * 4 == 0) {
            worldObj.addBlockEvent(pos, ModBlocks.plasticChest, 1, numPlayersUsing);
        }

        prevLidAngle = lidAngle;
        float angleIncrement = 0.1F;
        double adjustedXCoord, adjustedZCoord;

        if (numPlayersUsing > 0 && lidAngle == 0.0F) {
            adjustedXCoord = pos.getX() + 0.5D;
            adjustedZCoord = pos.getZ() + 0.5D;
            worldObj.playSoundEffect(adjustedXCoord, pos.getY() + 0.5D, adjustedZCoord, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (numPlayersUsing == 0 && lidAngle > 0.0F || numPlayersUsing > 0 && lidAngle < 1.0F) {
            float var8 = lidAngle;

            if (numPlayersUsing > 0) {
                lidAngle += angleIncrement;
            } else {
                lidAngle -= angleIncrement;
            }

            if (lidAngle > 1.0F) {
                lidAngle = 1.0F;
            }

            if (lidAngle < 0.5F && var8 >= 0.5F) {
                adjustedXCoord = pos.getX() + 0.5D;
                adjustedZCoord = pos.getZ() + 0.5D;
                worldObj.playSoundEffect(adjustedXCoord, pos.getY() + 0.5D, adjustedZCoord, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (lidAngle < 0.0F) {
                lidAngle = 0.0F;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int eventID, int numUsingPlayers) {
        if (eventID == 1) {
            this.numPlayersUsing = numUsingPlayers;
            return true;
        } else {
            return super.receiveClientEvent(eventID, numUsingPlayers);
        }
    }
}