/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.common.containers;

import com.professorvennie.machinerycraft.core.tileEntity.TileEntityPlasticChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPlasticChest extends Container{

    private TileEntityPlasticChest entity;

    public ContainerPlasticChest(InventoryPlayer inventory, TileEntityPlasticChest entity) {
        this.entity = entity;
        entity.openInventory();

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(entity, i + j * 6, 8 + j * 18, 18 + i * 18));
            }
        }

        //player
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));
            }
        }
        //players hotbar
        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 198));
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slot1){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slot1);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slot1 < 54){
                if (!this.mergeItemStack(itemstack1, 54, this.inventorySlots.size(), true)){
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 54, false)){
                return null;
            }

            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer){
        super.onContainerClosed(entityPlayer);
        entity.closeInventory();
    }
}
