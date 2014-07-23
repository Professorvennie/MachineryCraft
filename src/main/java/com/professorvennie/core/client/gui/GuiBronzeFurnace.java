package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerBronzeFurnace;
import com.professorvennie.core.tileEntity.TileEntityBronzeFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:40 AM.
 */
public class GuiBronzeFurnace extends GuiContainer{

    private TileEntityBronzeFurnace entity;

    public GuiBronzeFurnace(InventoryPlayer inventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        super(new ContainerBronzeFurnace(inventory, tileEntityBronzeFurnace));
        entity = tileEntityBronzeFurnace;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {

    }
}
