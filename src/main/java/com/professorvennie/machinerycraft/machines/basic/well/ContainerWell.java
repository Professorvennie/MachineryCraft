package com.professorvennie.machinerycraft.machines.basic.well;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ProfessorVennie on 9/14/2014 at 6:50 PM.
 */
public class ContainerWell extends Container {

    public int lastTankAmount;
    private TileEntityWell entity;

    public ContainerWell(InventoryPlayer inventory, TileEntityWell entity) {
        this.entity = entity;

        addSlotToContainer(new Slot(entity, 0, 33, 9));
        addSlotToContainer(new Slot(entity, 1, 33, 58));
        addSlotToContainer(new Slot(entity, 2, 88, 34));

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

            /*if (lastTankAmount != entity.tank.getFluidAmount()) {
                icrafting.sendProgressBarUpdate(this, 0, entity.tank.getFluidAmount());
            }*/
        }
        //lastTankAmount = entity.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        super.updateProgressBar(slot, par2);
        /*if (slot == 0) {
            if (entity.tank.getFluid() != null)
                entity.tank.getFluid().amount = par2;

        }*/
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
