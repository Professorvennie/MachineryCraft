package com.professorvennie.core.common.containers;

import com.professorvennie.core.tileEntity.TileEntityBronzeSteamBoiler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

/**
 * Created by ProfessorVennie on 7/24/2014 at 11:44 PM.
 */
public class ContainerBronzeSteamBoiler extends Container{

    public int lastBurnTime, lastItemBurnTime, lastTemp, lastTank1, lastTank2;

    private TileEntityBronzeSteamBoiler entity;

    public ContainerBronzeSteamBoiler(InventoryPlayer inventory, TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler) {
        entity = tileEntityBronzeSteamBoiler;

        addSlotToContainer(new Slot(entity, 0, 127, 9));
        addSlotToContainer(new Slot(entity, 1, 127, 58));

        addSlotToContainer(new Slot(entity, 2, 33, 9));
        addSlotToContainer(new Slot(entity, 3, 33, 58));

        addSlotToContainer(new Slot(entity, 4, 80, 41));

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
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for(int i = 0; i < this.crafters.size(); i ++){
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if(this.lastBurnTime != this.entity.burnTime){
                icrafting.sendProgressBarUpdate(this, 0, this.entity.burnTime);
            }

            if(this.lastItemBurnTime != this.entity.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.entity.currentItemBurnTime);
            }

            if(lastTemp != entity.temp){
                icrafting.sendProgressBarUpdate(this, 2, entity.temp);
            }

            if(lastTank1 != entity.tanks[0].getFluidAmount()){
                icrafting.sendProgressBarUpdate(this, 3, entity.tanks[0].getFluidAmount());
            }

            if(lastTank2 != entity.tanks[1].getFluidAmount()){
                icrafting.sendProgressBarUpdate(this, 4, entity.tanks[1].getFluidAmount());
            }
        }
        this.lastBurnTime = this.entity.burnTime;
        this.lastItemBurnTime = this.entity.currentItemBurnTime;
        this.lastTemp = this.entity.temp;
        this.lastTank1 = this.entity.tanks[0].getFluidAmount();
        this.lastTank2 = this.entity.tanks[1].getFluidAmount();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int par2){
        if(slot == 0) this.entity.burnTime = par2;
        if(slot == 1) this.entity.currentItemBurnTime = par2;
        if(slot == 2) this.entity.temp = par2;
        if(slot == 3){
            if(entity.tanks[0].getFluid() != null)
                entity.tanks[0].getFluid().amount = par2;

        }
        if(slot == 4){
            if(entity.tanks[1].getFluid() != null)
                entity.tanks[1].getFluid().amount = par2;

        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.entity.burnTime);
        iCrafting.sendProgressBarUpdate(this, 1, this.entity.currentItemBurnTime);
        iCrafting.sendProgressBarUpdate(this, 2, this.entity.temp);
        iCrafting.sendProgressBarUpdate(this, 3, lastTank1);
        iCrafting.sendProgressBarUpdate(this, 4, lastTank2);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
