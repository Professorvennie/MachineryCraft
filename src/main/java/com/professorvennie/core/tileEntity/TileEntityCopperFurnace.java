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


import com.professorvennie.core.block.BlockCopperFurnace;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;

import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityCopperFurnace extends TileEntityMod implements ISidedInventory{

	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_sides = new int[]{1};
	
	private ItemStack[] slots = new ItemStack[3];
	
	public int furnaceSpeed = 100;
	
	public int burnTime;
	
	public int currentItemBurnTime;
	
	public int cookTime;

    @Override
    public String getInventoryName(){
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.CONTAINER_COPPER_FURNACE;
    }

	public int getSizeInventory(){
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(this.slots[slot] != null){
			ItemStack itemstack;
			if(this.slots[slot].stackSize <= amount){
				itemstack = this.slots[slot];
				this.slots[slot] = null;
				return itemstack;
			}else{
				itemstack = this.slots[slot].splitStack(amount);
				if(this.slots[slot].stackSize == 0){
					this.slots[slot] = null;
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
	public boolean hasCustomInventoryName() {
		return this.hasCustomName();
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
		this.burnTime = (int)nbt.getShort("burnTime");
		this.cookTime = (int)nbt.getShort("cookTime");
		this.currentItemBurnTime = (int)nbt.getShort("currentItemBurnTime");
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		nbt.setShort("burnTime", (short) this.burnTime);
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
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}
	
	public boolean isBurning(){
		return this.burnTime > 0;
	}
	
	public void updateEntity(){
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		
		if(this.burnTime > 0) this.burnTime--;
		
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
				
				if(this.cookTime == this.furnaceSpeed){
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}else this.cookTime = 0;
			
			if(flag != this.isBurning()){
				flag1 = true;
				BlockCopperFurnace.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord, ModBlocks.copperFurnaceActive, ModBlocks.copperFurnaceIdle);
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
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return slot == 2 ? false : (slot == 1 ? isItemFuel(itemStack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 0 ? slots_bottom  : (side == 1 ? slots_top : slots_sides);
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
			this.currentItemBurnTime = this.furnaceSpeed;
		}
		
		return this.burnTime * i / this.currentItemBurnTime;
	}

	public int getCookProgressSacled(int i){
		return this.cookTime * i / this.furnaceSpeed;
	}
}
