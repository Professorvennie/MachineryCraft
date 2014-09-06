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

import com.professorvennie.core.tileEntity.machines.copper.TileEntityCopperFurnace;
import com.professorvennie.core.tileEntity.TileEntityWasher;

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

public class ContainerWasher extends Container{
	
	public TileEntityWasher washer;
	
	private int lastTank1;
	private int lastmasterX, lastmasterY, lastmasterZ;
	private boolean lastHasMaster, lastIsMaster;

	public ContainerWasher(InventoryPlayer inventory, TileEntityWasher entity) {
		this.washer = entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 47, 35));
		this.addSlotToContainer(new Slot(entity, 1, 152, 64));
		this.addSlotToContainer(new Slot(entity, 2, 152, 46));
		this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 3, 120, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
		}
        
	}
	
	 @Override
	    public void addCraftingToCrafters(ICrafting par1ICrafting) {
	        super.addCraftingToCrafters(par1ICrafting);
	        par1ICrafting.sendProgressBarUpdate(this, 2, lastTank1);
	    }

	    @Override
	    public void detectAndSendChanges() {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.crafters.size(); ++i) {
	            ICrafting icrafting = (ICrafting) this.crafters.get(i);

	            if (lastTank1 != washer.getTank1Amount())
	                icrafting.sendProgressBarUpdate(this, 2, washer.getTank1Amount());
	            if(lastmasterX != washer.getMasterX())
	            	icrafting.sendProgressBarUpdate(this, 3, washer.getMasterX());
	            if(lastmasterY != washer.getMasterY())
	            	icrafting.sendProgressBarUpdate(this, 4, washer.getMasterY());
	            if(lastmasterZ != washer.getMasterZ())
	            	icrafting.sendProgressBarUpdate(this, 5, washer.getMasterZ());
	        }
	            
	        lastTank1 = washer.getTank1Amount();
	        lastmasterX = washer.getMasterX();
	        lastmasterY = washer.getMasterY();
	        lastmasterZ = washer.getMasterZ();
	        lastHasMaster = washer.hasMaster();
	        lastIsMaster = washer.isMaster();
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int par1, int par2) {
	        super.updateProgressBar(par1, par2);

	        if (par1 == 2) {
	            if (washer.tanks[0].getFluid() != null)
	                washer.tanks[0].getFluid().amount = par2;
	        }

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
					}else if(TileEntityCopperFurnace.isItemFuel(itemstack1)){
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
					slot.putStack((ItemStack)null);
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

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return this.washer.isUseableByPlayer(var1);
	}

}
