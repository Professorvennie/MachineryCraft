package com.professorvennie.machinerycraft.machines.bronze.charger;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

/**
 * Created by ProfessorVennie on 10/4/2014 at 5:47 PM.
 */
public class ContainerBronzeCharger extends Container {

    public int lastTankAmount;
    private TileEntityBronzeCharger tile;

    public ContainerBronzeCharger(InventoryPlayer inventory, TileEntityBronzeCharger tile) {
        this.tile = tile;

        addSlotToContainer(new Slot(tile, 0, 33, 9));
        addSlotToContainer(new Slot(tile, 1, 33, 58));
        addSlotToContainer(new Slot(tile, 2, 60, 35));
        addSlotToContainer(new Slot(tile, 3, 120, 35));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting icrafting) {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, lastTankAmount);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (lastTankAmount != tile.tank.getFluidAmount()) {
                icrafting.sendProgressBarUpdate(this, 0, tile.tank.getFluidAmount());
            }
        }
        lastTankAmount = tile.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        super.updateProgressBar(slot, par2);
        if (slot == 0) {
            if (tile.tank.getFluid() != null)
                tile.tank.getFluid().amount = par2;

        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUseableByPlayer(player);
    }
}
