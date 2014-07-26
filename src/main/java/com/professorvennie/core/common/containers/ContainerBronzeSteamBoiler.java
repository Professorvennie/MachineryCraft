package com.professorvennie.core.common.containers;

import com.professorvennie.core.tileEntity.TileEntityBronzeSteamBoiler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by ProfessorVennie on 7/24/2014 at 11:44 PM.
 */
public class ContainerBronzeSteamBoiler extends Container{

    private TileEntityBronzeSteamBoiler entity;

    public ContainerBronzeSteamBoiler(InventoryPlayer inventory, TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler) {
        entity = tileEntityBronzeSteamBoiler;



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
    public boolean canInteractWith(EntityPlayer player) {
        return entity.isUseableByPlayer(player);
    }
}
