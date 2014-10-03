package com.professorvennie.machinerycraft.common.containers;

import com.professorvennie.lib.base.tileentitys.TileEntityBasicSidedInventory;
import com.professorvennie.machinerycraft.common.containers.slots.SlotUpgrade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Created by ProfessorVennie on 9/6/2014 at 4:10 PM.
 */
public class ContainerBase extends Container {

    private TileEntityBasicSidedInventory tile;

    public ContainerBase(InventoryPlayer inventory, TileEntityBasicSidedInventory tileEntity) {
        this.tile = tileEntity;

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

    public void addUpgradeSlot(IInventory iInventory, int id, int x, int y) {
        this.addSlotToContainer(new SlotUpgrade(iInventory, id, x, y));
    }
}
