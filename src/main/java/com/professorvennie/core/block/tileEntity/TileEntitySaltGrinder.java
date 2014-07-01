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

import com.professorvennie.api.recipes.GrinderRecipes;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.BlockSaltGrinder;
import com.professorvennie.core.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntitySaltGrinder extends TileEntity implements ISidedInventory {

	private String localizedName;

	private static final int[] slots_top = new int[] { 0 };
	private static final int[] slots_bottom = new int[] { 2, 1 };
	private static final int[] slots_sides = new int[] { 1 };

	private ItemStack[] slots = new ItemStack[3];

	public int GrinderSpeed = 100;

	public int burnTime;
	
	public int currentItemBurnTime;
	
	public int cookTime;

	private int smeltItem;
	
	private  Random rand = new Random();

	public int getsizeInventory() {
		return this.slots.length;
	}

	public String getInvName() {
		return this.isInvNameLocalized() ? this.localizedName : "container.SaltGrinder";
	}

	public boolean isInvNameLocalized() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public void setGuiDisplayName(String displayName) {

		this.localizedName = displayName;
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
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
	public ItemStack getStackInSlotOnClosing(int var1) {
		if (this.slots[var1] != null) {
			ItemStack itemstack = this.slots[var1];
			this.slots[var1] = null;
			return itemstack;
		}

		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		this.slots[var1] = var2;

		if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
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

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList list = nbt.getTagList("items", Constants.NBT.TAG_COMPOUND);
		this.slots = new ItemStack[this.getsizeInventory()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = list.getCompoundTagAt(i);
			int j = compound.getByte("slot") & 0xff;

			if (j >= 0 && j < this.slots.length) {
				this.slots[j] = ItemStack.loadItemStackFromNBT(compound);

			}
		}
		this.burnTime = (int) nbt.getShort("burntime");
		this.cookTime = (int) nbt.getShort("cooktime");
		this.GrinderSpeed = (int) nbt.getShort("grindspeed");

		if (nbt.hasKey("customname")) {
			this.localizedName = nbt.getString("customname");
		}

	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setShort("burntime", (short) this.burnTime);
		nbt.setShort("cooktime", (short) this.cookTime);
		nbt.setShort("grindspeed", (short) this.GrinderSpeed);

		NBTTagList list = new NBTTagList();

		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("items", list);
		if (this.isInvNameLocalized()) {
			nbt.setString("customname", this.localizedName);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord,this.zCoord) != this ? false : var1.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,(double) this.zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}


	public boolean isBurning(){
		return this.burnTime > 0;
	}
	
	public void updateEntity(){
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		
		if(this.burnTime > 0){
			this.burnTime--;
		}
		
		if(!this.worldObj.isRemote){
			if(this.burnTime == 0 && this.canSmelt()){
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				if(this.burnTime > 0){
					flag1 = true;
					
					if(this.slots[1] != null){
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize == 0){
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
				
				}
			if(this.isBurning() && this.canSmelt()){
				this.cookTime++;
				
				if(this.cookTime == this.GrinderSpeed){
					this.cookTime = 0;
					this.SmeltItem();
					flag1 = true;
				}
			}else{
				this.cookTime = 0;
			}
			
			if(flag != this.isBurning()){
				flag1 = true;
				BlockSaltGrinder.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord,ModBlocks.SaltGrinderActive, ModBlocks.SaltGrinderIdle);
			}
			
		}
	
	
	if(flag1){
		this.markDirty();
	}
}

	private boolean canSmelt() {
		if (this.slots[0] == null) {
			return false;
		} else {
			ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.slots[0]);

			if (itemstack == null)
				return false;
			if (this.slots[2] == null)
				return true;
			if (!this.slots[2].isItemEqual(itemstack))
				return false;

			int result = this.slots[2].stackSize + itemstack.stackSize;

			return (result <= getInventoryStackLimit() && result <= itemstack
					.getMaxStackSize());

		}
	}

	public void SmeltItem() {
		if (this.canSmelt()) {
			ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.slots[0]);

			if (this.slots[2] == null) {
				this.slots[2] = itemstack.copy();
			} else if (this.slots[2].isItemEqual(itemstack)) {
				this.slots[2].stackSize += itemstack.stackSize;
			}

			this.slots[0].stackSize--;

			if (this.slots[0].stackSize <= 0) {
				this.slots[0] = null;
			}
		}
	}

	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			int i = itemstack.getItem().getIdFromItem(itemstack.getItem());
			
			Item item = itemstack.getItem();
			/*
			if(item instanceof ItemBlock && Block.blockRegistry != null){
				Block block = blockRegistry;
				
				if(block == Blocks.wooden_slab){
					return 150;
				}
				if(block.getMaterial().equals(Material.wood)){
					return 300;
				}
				
				if(block == Blocks.coal_block){
					return 16000;
				}
			*/
			
			//if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			//if(item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			//if(item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
			//if(i == Items.stick.getIdFromItem(Items.stick)) return 100;
			if(i == Items.coal.getIdFromItem(Items.coal)) return 1600;
			if(i == Items.lava_bucket.getIdFromItem(Items.lava_bucket)) return 20000;
			//if(i == Blocks.sapling.getIdFromBlock(Blocks.sapling)) return 100;
			if(i == Blocks.coal_block.getIdFromBlock(Blocks.coal_block)) return 16000;
			//if(i == Blocks.wooden_slab.getIdFromBlock(Blocks.wooden_slab)) return 300;
			if(i == Items.blaze_rod.getIdFromItem(Items.blaze_rod)) return 2400;
			
			
			if(i == ModItems.saltcyrstals.getIdFromItem(ModItems.saltcyrstals)) return 500;
			
			return GameRegistry.getFuelValue(itemstack);
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {

		return var1 == 2 ? false : (var1 == 1 ? isItemFuel(var2) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		return this.isItemValidForSlot(var1, var2);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
	}

	public int getBurnTimeReamingScaled(int i) {
		if(this.currentItemBurnTime == 0){
			this.currentItemBurnTime = this.GrinderSpeed;
		}
		
		return this.burnTime * i / this.currentItemBurnTime;
	}

	public int getCookProgressSacled(int i){
		return this.cookTime * i / this.GrinderSpeed;
	}

}
