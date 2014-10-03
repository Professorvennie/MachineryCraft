/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.copper.furnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerCopperFurnace extends Container {

    public int lastBurnTime, lastItemBurnTime, lastCookTime;

    private TileEntityCopperFurnace copperFurnace;

    public ContainerCopperFurnace(InventoryPlayer inventory, TileEntityCopperFurnace tileentity) {
        this.copperFurnace = tileentity;

        this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));

        this.addSlotToContainer(new Slot(tileentity, 3, 179, 21));
        this.addSlotToContainer(new Slot(tileentity, 4, 179, 39));
        this.addSlotToContainer(new Slot(tileentity, 5, 179, 57));

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
        icrafting.sendProgressBarUpdate(this, 0, this.copperFurnace.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.copperFurnace.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.copperFurnace.currentItemBurnTime);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.copperFurnace.cookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.copperFurnace.cookTime);
            }

            if (this.lastBurnTime != this.copperFurnace.burnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.copperFurnace.burnTime);
            }

            if (this.lastItemBurnTime != this.copperFurnace.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.copperFurnace.currentItemBurnTime);
            }
        }
        this.lastCookTime = this.copperFurnace.cookTime;
        this.lastBurnTime = this.copperFurnace.burnTime;
        this.lastItemBurnTime = this.copperFurnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        if (slot == 0) this.copperFurnace.cookTime = par2;
        if (slot == 1) this.copperFurnace.burnTime = par2;
        if (slot == 2) this.copperFurnace.currentItemBurnTime = par2;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return copperFurnace.isUseableByPlayer(player);
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
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityCopperFurnace.isItemFuel(itemstack1)) {
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
