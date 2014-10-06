package com.professorvennie.machinerycraft.machines.bronze.alloy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by ProfessorVennie on 10/6/2014 at 4:37 PM.
 */
public class ContainerBronzeAlloy extends Container {

    private TileEntityBronzeAlloy tile;

    public ContainerBronzeAlloy(InventoryPlayer inventory, TileEntityBronzeAlloy tile) {
        this.tile = tile;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUseableByPlayer(player);
    }
}
