package com.professorvennie.core.gui.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

import com.professorvennie.core.block.tileEntity.TileEntitySaltFurnace;
import com.professorvennie.core.block.tileEntity.TileEntitywindmill;

public class ContainerWindmill extends Container{

	private TileEntitywindmill windmill;
	
	public ContainerWindmill(InventoryPlayer inventory,TileEntitywindmill tileentity) {
		this.windmill = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 54, 29));
		this.addSlotToContainer(new Slot(tileentity, 1, 104, 29));
		
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
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
