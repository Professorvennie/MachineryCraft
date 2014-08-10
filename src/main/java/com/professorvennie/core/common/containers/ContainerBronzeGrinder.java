package com.professorvennie.core.common.containers;

import com.professorvennie.core.tileEntity.TileEntityBronzeGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by ProfessorVennie on 8/9/2014 at 3:29 PM.
 */
public class ContainerBronzeGrinder extends Container{

    private TileEntityBronzeGrinder entity;

    public ContainerBronzeGrinder(InventoryPlayer inventory, TileEntityBronzeGrinder entity) {
        this.entity = entity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
