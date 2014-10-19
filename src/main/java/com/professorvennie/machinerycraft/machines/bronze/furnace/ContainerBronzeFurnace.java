/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.furnace;

import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.machines.bronze.ContainerBasicSteamMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:38 AM.
 */
public class ContainerBronzeFurnace extends ContainerBasicSteamMachine {

    public int lastCookTime, lastTankAmount;
    private TileEntityBronzeFurnace entity;

    public ContainerBronzeFurnace(InventoryPlayer inventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        super(inventory, tileEntityBronzeFurnace);
        entity = tileEntityBronzeFurnace;

        addSlotToContainer(new Slot(entity, 0, 33, 9));
        addSlotToContainer(new Slot(entity, 1, 33, 58));
        addSlotToContainer(new Slot(entity, 2, 60, 35));
        addSlotToContainer(new SlotFurnaceOutput(inventory.player, entity, 3, 120, 35));

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

            if (this.lastCookTime != this.entity.cookTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.entity.getField(1));
            }

            /*if (lastTankAmount != entity.tank.getFluidAmount()) {
                icrafting.sendProgressBarUpdate(this, 2, entity.getField(2));
            }*/
        }
        this.lastCookTime = this.entity.getField(1);
        //lastTankAmount = entity.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        super.updateProgressBar(slot, par2);
        entity.setField(slot, par2);
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
                if (FurnaceRecipes.instance().getSmeltingResult(itemStack1) != null) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeFurnace.INPUTSLOT, TileEntityBronzeFurnace.INPUTSLOT + 1, false)) {
                        return null;
                    }
                } else if (itemStack1.getItem() == ModItems.steamBucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeFurnace.WATERSLOT, TileEntityBronzeFurnace.WATERSLOT + 1, false)) {
                        return null;
                    }
                } else if (itemStack1.getItem() == Items.bucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeFurnace.WATERSLOT, TileEntityBronzeFurnace.WATERSLOT + 1, false)) {
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
