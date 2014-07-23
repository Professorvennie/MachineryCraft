package com.professorvennie.core.common.containers;

import com.professorvennie.core.tileEntity.TileEntityBronzeFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:38 AM.
 */
public class ContainerBronzeFurnace extends Container{

    private TileEntityBronzeFurnace entity;

    public ContainerBronzeFurnace(InventoryPlayer inventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        entity = tileEntityBronzeFurnace;

        addSlotToContainer(new Slot(entity, 0, 33, 9 ));
        addSlotToContainer(new Slot(entity, 1, 33, 58 ));
        addSlotToContainer(new Slot(entity, 2, 60, 35 ));
        addSlotToContainer(new SlotFurnace(inventory.player,entity, 3, 120, 35 ));

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
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        return super.transferStackInSlot(player, slot);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
