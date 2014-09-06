package com.professorvennie.core.tileEntity.machines.brass;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.tileEntity.TileEntityMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:14 PM.
 */
public class TileEntityBrassGenerator extends TileEntityMod implements ISidedInventory{

    public ItemStack[] inventory;
    private int burnTime = 0, currentItemBurnTime = 0, power = 0, maxPower = 10000;

    public TileEntityBrassGenerator(){
        inventory = new ItemStack[1];
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if(burnTime > 0)
            burnTime--;

        if(!worldObj.isRemote){
            if(burnTime == 0){
                System.out.println(power);
                this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.inventory[0]);

                if(isBurning()){
                    if(power < maxPower)
                        power++;
                    if(inventory[0] != null){
                        inventory[0].stackSize--;

                        if(inventory[0].stackSize == 0)
                            inventory[0] = null;
                    }
                }
            }
        }
    }

    public static int getItemBurnTime(ItemStack itemstack){
        if (itemstack == null){
            return 0;
        }
        else{
            Item item = itemstack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab){
                    return 150;
                }

                if (block.getMaterial() == Material.wood){
                    return 300;
                }

                if (block == Blocks.coal_block){
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    public boolean isBurning(){
        return this.burnTime > 0;
    }

    public boolean isItemFuel(ItemStack itemStack){
        return getItemBurnTime(itemStack) > 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
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
    public ItemStack decrStackSize(int slot1, int slot2) {
        if(this.inventory[slot1] != null){
            ItemStack itemstack;
            if(this.inventory[slot1].stackSize <= slot2){
                itemstack = this.inventory[slot1];
                this.inventory[slot1] = null;
                return itemstack;
            }else{
                itemstack = this.inventory[slot1].splitStack(slot2);
                if(this.inventory[slot1].stackSize == 0){
                    this.inventory[slot1] = null;
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
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.CONTAINER_BRASS_GENERATOR;
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
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64D;
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
