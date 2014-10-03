package com.professorvennie.machinerycraft.machines.basic.campfire;

import com.professorvennie.machinerycraft.common.containers.ContainerBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

/**
 * Created by ProfessorVennie on 9/14/2014 at 6:52 PM.
 */
public class ContainerCampFire extends ContainerBase {

    public int lastBurnTime, lastItemBurnTime, lastCookTime;

    private TileEntityCampFire entity;

    public ContainerCampFire(InventoryPlayer inventory, TileEntityCampFire entity) {
        super(inventory, entity);
        this.entity = entity;

        this.addSlotToContainer(new Slot(entity, 0, 56, 17));
        this.addSlotToContainer(new Slot(entity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 2, 116, 35));
    }

    public void addCraftingToCrafters(ICrafting icrafting) {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.entity.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.entity.currentItemBurnTime);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.entity.cookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
            }

            if (this.lastBurnTime != this.entity.burnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.entity.burnTime);
            }

            if (this.lastItemBurnTime != this.entity.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.entity.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.entity.cookTime;
        this.lastBurnTime = this.entity.burnTime;
        this.lastItemBurnTime = this.entity.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        if (slot == 0) this.entity.cookTime = par2;
        if (slot == 1) this.entity.burnTime = par2;
        if (slot == 2) this.entity.currentItemBurnTime = par2;
    }
}
