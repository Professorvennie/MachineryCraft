package com.professorvennie.machinerycraft.machines.brass.charger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by ProfessorVennie on 9/29/2014 at 4:13 PM.
 */
public class ContainerBrassCharger extends Container {

    private TileEntityBrassCharger tileEntity;

    public ContainerBrassCharger(InventoryPlayer inventory, TileEntityBrassCharger entity) {
        this.tileEntity = entity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }
}
