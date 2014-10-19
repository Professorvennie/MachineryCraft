package com.professorvennie.machinerycraft.machines.bronze;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ProfessorVennie on 10/18/2014 at 3:44 PM.
 */
public class ContainerBasicSteamMachine extends Container {

    private TileEntityBasicSteamMachine tile;
    private int lastSteamAmount;

    public ContainerBasicSteamMachine(InventoryPlayer inventoryPlayer, TileEntityBasicSteamMachine tile) {
        this.tile = tile;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastSteamAmount != tile.getField(2)) {
                icrafting.sendProgressBarUpdate(this, 2, this.tile.getField(2));
            }
        }
        this.lastSteamAmount = tile.getField(2);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        tile.setField(slot, par2);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tile.isUseableByPlayer(playerIn);
    }
}
