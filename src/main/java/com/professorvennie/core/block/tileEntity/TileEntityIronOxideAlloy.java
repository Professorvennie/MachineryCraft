/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block.tileEntity;

import java.util.Random;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.BlockIronoxideAlloy;
import com.professorvennie.core.block.BlockIronoxideGrinder;
import com.professorvennie.core.item.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.oredict.OreDictionary;

public class TileEntityIronOxideAlloy extends TileEntity implements ISidedInventory{
	private String localizedName;

	private  Random rand = new Random();
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_sides = new int[]{1};
	
	private ItemStack[] slots = new ItemStack[4];
	
	public int GrindeSpeed = 80;
	
	public int power;
	public final int  maxpower = 10000;
	
	public int currentItemBurnTime;
	
	public int cookTime;

	private int smeltItem;

	public int getsizeInventory(){
		return this.slots.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
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
	public ItemStack getStackInSlotOnClosing(int var1) {
		if(this.slots[var1] != null){
			ItemStack itemstack = this.slots[var1];
			this.slots[var1] = null;
			return itemstack;
		}
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		this.slots[var1]= var2;
		
		if(var2 != null && var2.stackSize > this.getInventoryStackLimit()){
			var2.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("items", Constants.NBT.TAG_COMPOUND);
		this.slots = new ItemStack[this.getsizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i ++){
			NBTTagCompound compound = list.getCompoundTagAt(i);
			 int j = compound.getByte("slot") & 0xff;
			
			if(j >= 0 && j < this.slots.length){
				this.slots[j] = ItemStack.loadItemStackFromNBT(compound);
				
			}
		}
		this.power = (int)nbt.getShort("burntime");
		this.cookTime = (int)nbt.getShort("cooktime");
		this.currentItemBurnTime = (int)nbt.getShort("currentItemBurnTime");
		
		if(nbt.hasKey("customname")){
			this.localizedName = nbt.getString("customname");
		}

	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		nbt.setShort("burntime", (short) this.power);
		nbt.setShort("cooktime", (short) this.cookTime);
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
		if(this.isInvNameLocalized()){
			nbt.setString("customname", this.localizedName);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean hasPower(){
		if(this.power> 0) return true;
		
		return false;
	}
	
	public boolean isGrinding(){
		return this.cookTime > 0;
	}
	
	public void updateEntity(){
		boolean flag = this.power > 0;
    	boolean flag1 = false;
	
    	if (hasPower() && isGrinding()){
        		this.power--;
    	}
    	
    	if(this.power > this.maxpower){
    		this.power = this.maxpower;
    	}

    	if (!this.worldObj.isRemote){
        	if (this.power < this.maxpower && this.getItemPower(this.slots[1]) > 0){
        		this.power += getItemPower(this.slots[1]);

        		flag1 = true;
        	
        		if (this.slots[1] != null){
                		this.slots[1].stackSize--;

                		if (this.slots[1].stackSize == 0){
                    		this.slots[1] = this.slots[1].getItem().getContainerItem(slots[1]);
                		}
            	}                
        	}
        	if (this.hasPower() && this.canGrinde())
        	{
            	this.cookTime++;

            	if (this.cookTime == this.GrindeSpeed)
            	{
                	this.cookTime = 0;
                	this.GrindItem();
               	flag1 = true;
            	}
        	}
        	else
        	{
            	this.cookTime = 0;
        	}
			
			if(flag != this.hasPower()){
				flag1 = true;
				BlockIronoxideAlloy.updateBlockState(this.power > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord, ModBlocks.ironOxideAlloyActive, ModBlocks.ironOxideAlloyIdle);
			}
			
		}
	
	
	if(flag1){
		this.markDirty();
	}
}

	private boolean canGrinde(){
		if(this.slots[0] == null){
			return false;
		}else{
			ItemStack itemstack = getresult(this.slots[0], this.slots[3]);
			
			if(itemstack == null) return false;
			if(this.slots[2] == null) return true;
			if(!this.slots[2].isItemEqual(itemstack)) return false;
			
			int result = this.slots[2].stackSize + itemstack.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
				
			
		}
	}
	
	private static ItemStack saltIngot = new ItemStack(ModItems.Ingots, 1, 4);
	private static ItemStack ironOxideIngot = new ItemStack(ModItems.Ingots, 4, 6);
	private static ItemStack goldOxideIngot = new ItemStack(ModItems.Ingots, 4, 5);
	
	public ItemStack getresult(ItemStack itemstack, ItemStack itemstack2) {
		if(itemstack != null && itemstack2 != null){
			int i = itemstack.getItem().getIdFromItem(itemstack.getItem());
			int j = itemstack2.getItem().getIdFromItem(itemstack2.getItem());
		if (i == Items.iron_ingot.getIdFromItem(Items.iron_ingot) && j == ModItems.Ingots.getIdFromItem(saltIngot.getItem()))
			return ironOxideIngot;
		if (i == ModItems.Ingots.getIdFromItem(saltIngot.getItem()) && j == Items.iron_ingot.getIdFromItem(Items.iron_ingot))
			return ironOxideIngot;
		if (i == Items.iron_ingot.getIdFromItem(Items.iron_ingot) && j == 0)
			return null;
		if (i == 0 && j == Items.iron_ingot.getIdFromItem(Items.iron_ingot))
			return null;
		if (i == ModItems.Ingots.getIdFromItem(saltIngot.getItem()) && j == 0)
			return null;
		if (i == 0 && j == ModItems.Ingots.getIdFromItem(saltIngot.getItem()))
			return null;
		}
		return null;

	}
	
	public void GrindItem(){
		if(this.canGrinde()){
			ItemStack itemstack = this.getresult(this.slots[0], this.slots[3]);

			if (this.slots[2] == null) {
				this.slots[2] = itemstack.copy();
			} else if (this.slots[2].isItemEqual(itemstack)) {
				this.slots[2].stackSize += itemstack.stackSize;
			}

			this.slots[0].stackSize--;
			this.slots[3].stackSize--;

			if (this.slots[0].stackSize <= 0) {
				this.slots[0] = null;
			}
	}
}
	
	public static int getItemPower(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			int i = itemstack.getItem().getIdFromItem(itemstack.getItem());
			
			
			
			if(i == ModItems.saltcyrstals.getIdFromItem(ModItems.saltcyrstals)) return 100;
			
			return 0;
		}
	}
	
	public static boolean isItemPower(ItemStack itemstack){
		return getItemPower(itemstack) > 0;
	}
	
	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
	
		return var1 == 2 ? false : (var1 == 1 ? isItemPower(var2) : true);
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
  		return this.cookTime * par1 / this.GrindeSpeed;
	}

	public int getPowerRemainingScaled(int par1){
    	return this.power * par1 / this.maxpower;
	}
	
	public boolean isInvNameLocalized() {
		return false;
	}

	public String getInvName() {
		return "container.IronOxideAlloy";
	}

	public void setGuiDisplayName(String displayName) {
		
	}



	@Override
	public int getSizeInventory() {
		return 0;
	}



	public int getCurrentCharge() {
		return this.power;
	}



	public int getChargeCapcity() {
		return this.maxpower;
	}

}
