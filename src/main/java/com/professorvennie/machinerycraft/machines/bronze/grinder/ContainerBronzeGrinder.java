/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.grinder;

import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.machines.bronze.extractor.TileEntityBronzeExtractor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Created by ProfessorVennie on 8/9/2014 at 3:29 PM.
 */
public class ContainerBronzeGrinder extends Container {

    private TileEntityBronzeGrinder entity;
    private int lastCookTime, lastTankAmount;

    public ContainerBronzeGrinder(InventoryPlayer inventory, TileEntityBronzeGrinder entity) {
        this.entity = entity;

        addSlotToContainer(new Slot(entity, 0, 33, 9));
        addSlotToContainer(new Slot(entity, 1, 33, 58));
        addSlotToContainer(new Slot(entity, 2, 60, 35));
        addSlotToContainer(new SlotFurnace(inventory.player, entity, 3, 120, 35));

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
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
        iCrafting.sendProgressBarUpdate(this, 1, lastTankAmount);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.entity.cookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
            }

            if (lastTankAmount != entity.tank.getFluidAmount()) {
                icrafting.sendProgressBarUpdate(this, 1, entity.tank.getFluidAmount());
            }
        }
        this.lastCookTime = this.entity.cookTime;
        lastTankAmount = entity.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        if (slot == 0) this.entity.cookTime = par2;
        if (slot == 1) {
            if (entity.tank.getFluid() != null)
                entity.tank.getFluid().amount = par2;

        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot0) {
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(slot0);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (slot0 < entity.getSizeInventory()) {
                if (!mergeItemStack(itemStack1, entity.getSizeInventory(), inventorySlots.size(), true)) {
                    return null;
                }
            } else {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemStack1) != null) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeExtractor.INPUTSLOT, TileEntityBronzeExtractor.INPUTSLOT + 1, false)) {
                        return null;
                    }
                } else if (itemStack1.getItem() == ModItems.steamBucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeExtractor.WATERSLOT, TileEntityBronzeExtractor.WATERSLOT + 1, false)) {
                        return null;
                    }
                } else if (itemStack1.getItem() == Items.bucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeExtractor.WATERSLOT, TileEntityBronzeExtractor.WATERSLOT + 1, false)) {
                        return null;
                    }
                } else
                    return null;
            }
            if (itemStack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }
}
