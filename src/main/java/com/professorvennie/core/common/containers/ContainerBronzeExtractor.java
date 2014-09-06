package com.professorvennie.core.common.containers;

import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.tileEntity.machines.steam.TileEntityBronzeExtractor;
import com.professorvennie.core.tileEntity.machines.steam.TileEntityBronzeGrinder;
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
 * Created by ProfessorVennie on 8/21/2014 at 8:20 PM.
 */
public class ContainerBronzeExtractor extends Container{

    private TileEntityBronzeExtractor entity;
    public int lastCookTime, lastTankAmount;

    public ContainerBronzeExtractor(InventoryPlayer inventory, TileEntityBronzeExtractor entity) {
       this. entity = entity;

        addSlotToContainer(new Slot(entity, 0, 33, 9 ));
        addSlotToContainer(new Slot(entity, 1, 33, 58 ));
        addSlotToContainer(new Slot(entity, 2, 60, 35 ));
        addSlotToContainer(new SlotFurnace(inventory.player,entity, 3, 120, 35 ));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return entity.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot0) {
        ItemStack itemStack = null;
        Slot slot = (Slot)inventorySlots.get(slot0);
        if(slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if(slot0 < entity.getSizeInventory()){
                if(!mergeItemStack(itemStack1, entity.getSizeInventory(), inventorySlots.size(), true)){
                    return null;
                }
            }else {
                if(FurnaceRecipes.smelting().getSmeltingResult(itemStack1) != null){
                    if(!mergeItemStack(itemStack1, TileEntityBronzeGrinder.INPUTSLOT, TileEntityBronzeGrinder.INPUTSLOT + 1, false)){
                        return null;
                    }
                }else if(itemStack1.getItem() == ModItems.steamBucket){
                    if(!mergeItemStack(itemStack1, TileEntityBronzeGrinder.WATERSLOT, TileEntityBronzeGrinder.WATERSLOT + 1, false)){
                        return null;
                    }
                } else if(itemStack1.getItem() == Items.bucket) {
                    if (!mergeItemStack(itemStack1, TileEntityBronzeGrinder.WATERSLOT, TileEntityBronzeGrinder.WATERSLOT + 1, false)) {
                        return null;
                    }
                }else
                    return null;
            }
            if(itemStack1.stackSize == 0){
                slot.putStack(null);
            }else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
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

        for(int i = 0; i < this.crafters.size(); i ++){
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if(this.lastCookTime != this.entity.cookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
            }

            if(lastTankAmount != entity.tank.getFluidAmount()){
                icrafting.sendProgressBarUpdate(this, 1, entity.tank.getFluidAmount());
            }
        }
        this.lastCookTime = this.entity.cookTime;
        lastTankAmount = entity.tank.getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        super.updateProgressBar(slot, par2);
        if(slot == 0) this.entity.cookTime = par2;
        if(slot == 1){
            if(entity.tank.getFluid() != null)
                entity.tank.getFluid().amount = par2;

        }
    }
}
