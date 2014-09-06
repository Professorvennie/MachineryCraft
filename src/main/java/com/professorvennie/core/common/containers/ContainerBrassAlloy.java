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

import com.professorvennie.core.tileEntity.machines.brass.TileEntityBrassAlloy;

import com.professorvennie.core.main.utils.PowerAmounts;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerBrassAlloy extends Container{
	
	public int lastBurnTime;
	
	public int lastItemBurnTime;
	
	public int lastCookTime;
	
	public TileEntityBrassAlloy Alloy;

	public ContainerBrassAlloy(InventoryPlayer inventory, TileEntityBrassAlloy entity) {
		this.Alloy = entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 56, 35));
		this.addSlotToContainer(new Slot(entity, 1, 11, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 2, 116, 35));
		this.addSlotToContainer(new Slot(entity, 3, 34, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.Alloy.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.Alloy.power);
		icrafting.sendProgressBarUpdate(this, 2, this.Alloy.currentItemBurnTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i ++){
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.Alloy.cookTime){
				icrafting.sendProgressBarUpdate(this, 0, this.Alloy.cookTime);
			}
			
			if(this.lastBurnTime != this.Alloy.power){
				icrafting.sendProgressBarUpdate(this, 1, this.Alloy.power);
			}
			
			if(this.lastItemBurnTime != this.Alloy.currentItemBurnTime){
				icrafting.sendProgressBarUpdate(this, 2, this.Alloy.currentItemBurnTime);
			}
		}
		this.lastCookTime = this.Alloy.cookTime;
		this.lastBurnTime = this.Alloy.power;
		this.lastItemBurnTime = this.Alloy.currentItemBurnTime;
	}
	
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int par2){
		if(slot == 0) this.Alloy.cookTime = par2;
		if(slot == 1) this.Alloy.power = par2;
		if(slot == 2) this.Alloy.currentItemBurnTime = par2;
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.Alloy.isUseableByPlayer(var1);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slot0){
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slot0);
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(slot0 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(slot0 != 1 && slot0 != 0){
				if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(PowerAmounts.isItemPower(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(slot0 >= 3 && slot0 < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(slot0 >= 30 && slot0 < 39){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}
		}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
			return null;
		}
			if(itemstack1.stackSize == 0){
				slot.putStack(null);
			}else{
				slot.onSlotChanged();
			}
			
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
	}
		return itemstack;
  }
}
