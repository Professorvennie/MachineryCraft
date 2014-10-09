/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.charger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            //if (lastTankAmount != tile.tank.getFluidAmount()) {
                //icrafting.sendProgressBarUpdate(this, 0, tile.tank.getFluidAmount());
            //}
        }
        //lastTankAmount = tile.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        tile.setField(slot, par2);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUseableByPlayer(player);
    }
}
