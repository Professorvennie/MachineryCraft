package com.professorvennie.machinerycraft.machines.bronze.extractor;

import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.machines.bronze.ContainerBasicSteamMachine;
import com.professorvennie.machinerycraft.machines.bronze.grinder.TileEntityBronzeGrinder;
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
 * Created by ProfessorVennie on 8/21/2014 at 8:20 PM.
 */
public class ContainerBronzeExtractor extends ContainerBasicSteamMachine {

    public int lastCookTime, lastTankAmount;
    private TileEntityBronzeExtractor entity;

    public ContainerBronzeExtractor(InventoryPlayer inventory, TileEntityBronzeExtractor entity) {
        super(inventory, entity);
        this.entity = entity;

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
                    if (!mergeItemStack(itemStack1, TileEntityBronzeGrinder.INPUTSLOT, TileEntityBronzeGrinder.INPUTSLOT + 1, false)) {
                        return null;
                    }
                } else if (itemStack1.getItem() == ModItems.steamBucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeGrinder.WATERSLOT, TileEntityBronzeGrinder.WATERSLOT + 1, false)) {
                        return null;
                    }
                } else if (itemStack1.getItem() == Items.bucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeGrinder.WATERSLOT, TileEntityBronzeGrinder.WATERSLOT + 1, false)) {
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

    @Override
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
        this.lastCookTime = this.entity.cookTime;
        //lastTankAmount = entity.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        entity.setField(slot, par2);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
