package com.professorvennie.machinerycraft.core.common.containers;

import com.professorvennie.machinerycraft.core.tileEntity.machines.basic.TileEntityPortableCobbleGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerPortableCobbleGen extends Container{

    private TileEntityPortableCobbleGen entity;
    public int lastCookTime;

    public ContainerPortableCobbleGen(InventoryPlayer inventory, TileEntityPortableCobbleGen tileEntityPortableCobbleGen) {
        this.entity = tileEntityPortableCobbleGen;

            addSlotToContainer(new Slot(entity,0, 20, 35));
            addSlotToContainer(new Slot(entity,1, 140, 35));
            addSlotToContainer(new SlotFurnace(inventory.player, entity,2, 80, 35));

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
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for(int i = 0; i < this.crafters.size(); i ++){
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if(this.lastCookTime != this.entity.cookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.entity.cookTime);
            }
        }
        this.lastCookTime = this.entity.cookTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2) {
        if(slot == 0) this.entity.cookTime = par2;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        return super.transferStackInSlot(p_82846_1_, p_82846_2_);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
