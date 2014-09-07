/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.common.containers;

import com.professorvennie.machinerycraft.item.ItemBags;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 8/28/2014 at 7:00 PM.
 */
public class ContainerBag extends Container {

    private InventoryBag invBag;

    public ContainerBag(EntityPlayer player, InventoryBag inventoryBag){
        invBag = inventoryBag;
        int invXOffset = 0, hotBarXOffset = 0, invYOffset = 0, hotBarYOffset = 0;

        if(player.getHeldItem().getItemDamage() == 0){
            invXOffset = 86;
            hotBarXOffset = 144;
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 3, 8 + j * 18, 18 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 1){
            invXOffset = 86 + 18;
            hotBarXOffset = 144 + 18;
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 4, 8 + j * 18, 18 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 2){
            invXOffset = 86 + (54 - 18);
            hotBarXOffset = 144 + (54 - 18);
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 5, 8 + j * 18, 18 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 3){
            invXOffset = 86 + 54;
            hotBarXOffset = 144 + 54;
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 6, 8 + j * 18, 18 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 4){
            invXOffset = 86 + (54 + 18);
            hotBarXOffset = 144 + (54 + 18);
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 7, 8 + j * 18, 18 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 5){
            invXOffset = 86 + ((54 * 2) - 20);
            hotBarXOffset = 144 + ((54 * 2) - 20);
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 8, 8 + j * 18, 16 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 6){
            invXOffset = 86  + ((54 * 2) - 20);
            hotBarXOffset = 144 + ((54 * 2) - 20);
            invYOffset = 8;
            hotBarYOffset = 8;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 9, 8 + j * 18, 7 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 7){
            invXOffset = 86 + ((54 * 2) - 20);
            hotBarXOffset = 144 + ((54 * 2) - 20);
            invYOffset = 8 + 18;
            hotBarYOffset = 8 + 18;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 11; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 9, 8 + j * 18, 7 + i * 18));
                }
            }
        }else if(player.getHeldItem().getItemDamage() == 8){
            invXOffset = 86 + ((54 * 2) - 20);
            hotBarXOffset = 144 + ((54 * 2) - 20);
            invYOffset = 8 + (18 * 2);
            hotBarYOffset = 8 + (18 * 2);
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 13; j++){
                    this.addSlotToContainer(new Slot(inventoryBag, i + j * 9, 8 + j * 18, 7 + i * 18));
                }
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, invYOffset + j * 18, invXOffset + i * 18));
            }
        }

        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(player.inventory, i, hotBarYOffset + i * 18, hotBarXOffset));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slot1){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slot1);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slot1 < invBag.getSizeInventory()){
                if (!this.mergeItemStack(itemstack1, invBag.getSizeInventory(), this.inventorySlots.size(), true)){
                    return null;
                }
            } else if(itemstack1.getItem() instanceof ItemBags){
                if(slot1 < (invBag.getSizeInventory()) + player.inventory.getSizeInventory()){
                    if(!this.mergeItemStack(itemstack1, invBag.getSizeInventory(), this.inventorySlots.size(), false)){
                        return null;
                    }
                } else if (!this.mergeItemStack(itemstack1, invBag.getSizeInventory(), this.inventorySlots.size(), false)){
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, invBag.getSizeInventory(), false)){
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
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        if(!player.worldObj.isRemote){
            invBag.onGuiSaved(player);
        }
    }
}
