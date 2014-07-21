package com.professorvennie.core.common.containers;

import com.professorvennie.core.tileEntity.TileEntityPortableCobbleGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerPortableCobbleGen extends Container{

    private TileEntityPortableCobbleGen entity;

    public ContainerPortableCobbleGen(InventoryPlayer inventory, TileEntityPortableCobbleGen tileEntityPortableCobbleGen) {
        this.entity = tileEntityPortableCobbleGen;

            addSlotToContainer(new Slot(entity,0, 20, 35));
            addSlotToContainer(new Slot(entity,1, 140, 35));
            addSlotToContainer(new SlotFurnace(inventory.player, entity,2, 80, 35));

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
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        return super.transferStackInSlot(p_82846_1_, p_82846_2_);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
