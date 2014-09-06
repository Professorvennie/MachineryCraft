/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.tileEntity.machines.brass;


import com.professorvennie.api.blocks.IMachine;
import com.professorvennie.core.block.machines.brass.BlockBrassFurnace;
import com.professorvennie.core.block.ModBlocks;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.main.utils.PowerAmounts;
import com.professorvennie.core.tileEntity.TileEntityMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class TileEntityBrassFurnace extends TileEntityMod implements ISidedInventory, IMachine {

    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};
	
	private ItemStack[] slots = new ItemStack[3];
	
	public int furnaceSpeed = 70;
	
	public int power;

	public final int maxPower = 10000;
	
	public int currentItemBurnTime;
	
	public int cookTime;

    @Override
	public int getSizeInventory(){
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot1, int slot2) {
		if(this.slots[slot1] != null){
			ItemStack itemstack;
			if(this.slots[slot1].stackSize <= slot2){
				itemstack = this.slots[slot1];
				this.slots[slot1] = null;
				return itemstack;
			}else{
				itemstack = this.slots[slot1].splitStack(slot2);
				if(this.slots[slot1].stackSize == 0){
					this.slots[slot1] = null;
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

	@Override
	public String getInventoryName() {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.CONTAINER_BRASS_FURNACE;
    }

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("items", Constants.NBT.TAG_COMPOUND);
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i ++){
			NBTTagCompound compound = list.getCompoundTagAt(i);
			 int j = compound.getByte("slot") & 0xff;
			
			if(j >= 0 && j < this.slots.length){
				this.slots[j] = ItemStack.loadItemStackFromNBT(compound);
				
			}
		}
		this.power = (int)nbt.getShort("burnTime");
		this.cookTime = (int)nbt.getShort("cookTime");
		this.currentItemBurnTime = (int)nbt.getShort("currentItemBurnTime");
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		nbt.setShort("burnTime", (short) this.power);
		nbt.setShort("cookTime", (short) this.cookTime);
		nbt.setShort("currentItemBurnTime", (short) this.currentItemBurnTime);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < this.slots.length; i ++){
			if(this.slots[i] != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("items", list);
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}
	
	public boolean hasPower(){
		return this.power > 0;
	}
	
	public boolean isSmelting(){
		return this.cookTime > 0;
	}
	
	public void updateEntity(){
		boolean flag = this.cookTime > 0;
    	boolean flag1 = false;
	
    	if (hasPower() && isSmelting()) this.power--;
    	
    	if(this.power > this.maxPower) this.power = this.maxPower;

    	if (!this.worldObj.isRemote){
        	if (this.power < this.maxPower && PowerAmounts.getItemPower(this.slots[1]) > 0) {
                if (maxPower - power > PowerAmounts.getItemPower(slots[1])) {
                    this.power += PowerAmounts.getItemPower(this.slots[1]);

                    flag1 = true;

                    if (this.slots[1] != null) {
                            this.slots[1].stackSize--;

                        if (this.slots[1].stackSize == 0) {
                            this.slots[1] = this.slots[1].getItem().getContainerItem(slots[1]);
                        }
                    }
                }
            }
        	if (this.hasPower() && this.canSmelt()){
            	this.cookTime++;

            	if (this.cookTime == this.furnaceSpeed){
                    this.smeltItem();
                	this.cookTime = 0;
               	flag1 = true;
            	}
        	}else this.cookTime = 0;
			
			if(flag != this.hasPower()){
				flag1 = true;
				BlockBrassFurnace.updateBlockState(this.cookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord, ModBlocks.brassFurnaceActive, ModBlocks.brassFurnaceIdle);
			}
			
		}
	
	
	if(flag1) this.markDirty();
}

	private boolean canSmelt(){
		if(this.slots[0] == null){
			return false;
		}else{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(itemstack == null) return false;
			if(this.slots[2] == null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize + itemstack.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
				
			
		}
	}
	
	public void smeltItem(){
		if(this.canSmelt()){
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if(this.slots[2] == null){
				this.slots[2] = itemstack.copy();
			}else if(this.slots[2].isItemEqual(itemstack)){
				this.slots[2].stackSize += itemstack.stackSize;
			}
			
			this.slots[0].stackSize--;
			
			if(this.slots[0].stackSize <= 0){
				this.slots[0] = null;
		}
	}
}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return slot == 2 ? false : (slot == 1 ? PowerAmounts.isItemPower(itemStack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom  : (var1 == 1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		return this.isItemValidForSlot(var1, var2);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
	}

	public int getCookProgressScaled(int par1)
	{
  		return this.cookTime * par1 / this.furnaceSpeed;
	}

	public int getPowerRemainingScaled(int par1){
    	return this.power * par1 / this.maxPower;
	}

	public boolean isInvNameLocalized() {
		return hasCustomName();
	}

	public int getCurrentCharge() {
		return this.power;
	}

	public int getChargeCapcity() {
		return this.maxPower;
	}
}