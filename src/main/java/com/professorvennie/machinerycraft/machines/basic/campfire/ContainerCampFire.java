package com.professorvennie.machinerycraft.machines.basic.campfire;

import com.professorvennie.machinerycraft.common.containers.ContainerBase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ProfessorVennie on 9/14/2014 at 6:52 PM.
 */
public class ContainerCampFire extends ContainerBase {

    public int lastBurnTime, lastItemBurnTime, lastCookTime;

    private TileEntityCampFire entity;

    public ContainerCampFire(InventoryPlayer inventory, TileEntityCampFire entity) {
        super(inventory, entity);
        this.entity = entity;

        this.addSlotToContainer(new SlotFurnaceFuel(entity, 0, 56, 17));
        this.addSlotToContainer(new Slot(entity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(inventory.player, entity, 2, 116, 35));
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.entity.cookTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.entity.getField(1));
            }

            if (this.lastBurnTime != this.entity.burnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.entity.getField(2));
            }

            if (this.lastItemBurnTime != this.entity.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 3, this.entity.getField(3));
            }
        }
        this.lastCookTime = this.entity.getField(1);
        this.lastBurnTime = this.entity.getField(2);
        this.lastItemBurnTime = this.entity.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        entity.setField(slot, par2);
    }
}
