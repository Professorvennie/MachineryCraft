package com.professorvennie.core.gui.containers;

import com.professorvennie.core.block.tileEntity.TileEntityGoldOxideFurnace;
import com.professorvennie.core.block.tileEntity.TileEntityGoldOxideGrinder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

public class ContainerGoldoxideGrinder extends Container{
	
	private TileEntityGoldOxideGrinder Grinder;

	public ContainerGoldoxideGrinder(InventoryPlayer inventory, TileEntityGoldOxideGrinder entity) {
		this.Grinder = entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 11, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 1, 116, 35));
		
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
		return this.Grinder.isUseableByPlayer(var1);
	}

}
