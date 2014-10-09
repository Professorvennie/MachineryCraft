package com.professorvennie.machinerycraft.machines.bronze.alloy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;

/**
 * Created by ProfessorVennie on 10/6/2014 at 4:37 PM.
 */
public class ContainerBronzeAlloy extends Container {

    private TileEntityBronzeAlloy tile;

    public ContainerBronzeAlloy(InventoryPlayer inventory, TileEntityBronzeAlloy tile) {
        this.tile = tile;

        addSlotToContainer(new Slot(tile, 0, 33, 9));
        addSlotToContainer(new Slot(tile, 1, 33, 58));
        addSlotToContainer(new Slot(tile, 2, 60, 35));
        addSlotToContainer(new Slot(tile, 3, 81, 35));
        addSlotToContainer(new SlotFurnaceOutput(inventory.player, tile, 4, 137, 35));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUseableByPlayer(player);
    }
}
