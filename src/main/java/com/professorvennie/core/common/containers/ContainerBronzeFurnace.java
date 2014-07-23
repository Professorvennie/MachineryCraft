package com.professorvennie.core.common.containers;

import com.professorvennie.core.tileEntity.TileEntityBronzeFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:38 AM.
 */
public class ContainerBronzeFurnace extends Container{

    private TileEntityBronzeFurnace entity;

    public ContainerBronzeFurnace(InventoryPlayer inventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        entity = tileEntityBronzeFurnace;


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
