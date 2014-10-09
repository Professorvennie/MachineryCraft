/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.copper.grinder;

import com.professorvennie.machinerycraft.api.recipes.GrinderRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCopperGrinder extends Container {

    public int lastGrindTime, lastItemBurnTime, lastCookTime;

    private TileEntityCopperGrinder grinder;

    public ContainerCopperGrinder(InventoryPlayer inventory, TileEntityCopperGrinder tileentity) {
        this.grinder = tileentity;

        this.addSlotToContainer(new SlotFurnaceFuel(tileentity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(inventory.player, tileentity, 2, 116, 35));

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

            if (this.lastCookTime != this.grinder.getField(1)) {
                icrafting.sendProgressBarUpdate(this, 1, this.grinder.getField(1));
            }
            if (this.lastGrindTime != this.grinder.getField(2)) {
                icrafting.sendProgressBarUpdate(this, 2, this.grinder.getField(2));
            }
            if (this.lastItemBurnTime != this.grinder.getField(3)) {
                icrafting.sendProgressBarUpdate(this, 3, this.grinder.getField(3));
            }
        }
        this.lastCookTime = this.grinder.getField(1);
        this.lastGrindTime = this.grinder.getField(2);
        this.lastItemBurnTime = this.grinder.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        grinder.setField(slot, par2);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return grinder.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slot0) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slot0);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slot0 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (slot0 != 1 && slot0 != 0) {
                if (GrinderRecipes.grinding().getGrindingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityCopperGrinder.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } else if (slot0 >= 3 && slot0 < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (slot0 >= 30 && slot0 < 39) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
}
