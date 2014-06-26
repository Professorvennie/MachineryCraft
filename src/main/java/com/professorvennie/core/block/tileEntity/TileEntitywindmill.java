package com.professorvennie.core.block.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntitywindmill extends TileEntity implements ISidedInventory{

	private ItemStack[] slots = new ItemStack[2];
	
	public float rotaion = 0;
	public int maxPower = 10000;
	public float power = 0;
	public float powerPerRoation = 0.1F;

	private String localizedName;
	
	public void updateEntity(){
		if(this.getWorldObj().getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) > 6){
		rotaion++;

		power +=powerPerRoation;
		if(power > maxPower) power = maxPower;
		
		
		}
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
		this.power = nbt.getShort("power");
		if(nbt.hasKey("customname")){
			this.setInventoryName(nbt.getString("customname"));
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt){
	super.writeToNBT(nbt);
		
	nbt.setShort("power", (short) this.power);
		
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
		if(this.hasCustomInventoryName()){
			nbt.setString("customname", this.getInventoryName());
		}
	}
	
	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(this.slots[i] != null){
			ItemStack itemstack;
			
			if(this.slots[i].stackSize <= j){
				itemstack = this.slots[i];
				this.slots[i] = null;
				return itemstack;
			}else{
				itemstack = this.slots[i].splitStack(j);
				
				if(this.slots[i].stackSize == 0){
					this.slots[i] = null;
				}
				return itemstack;
			}
		}
		
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i] != null){
			ItemStack itemstack = this.slots[i];
			this.slots[i]  = null;
		}
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slots[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		
	}
	public void setInventoryName(String string){
		
	}

	@Override
	public String getInventoryName() {
		return this.isInvNameLocalized() ? this.localizedName : "container.WINDMILL";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getPowerScaled(int i) {
		return (int) (this.power * i / this.maxPower);
	}

	public boolean isInvNameLocalized(){
		return this.localizedName != null && this.localizedName.length() > 0;
	}
}
