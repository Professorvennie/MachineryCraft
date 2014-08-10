package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerBronzeGrinder;
import com.professorvennie.core.tileEntity.TileEntityBronzeGrinder;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by ProfessorVennie on 8/9/2014 at 3:28 PM.
 */
public class GuiBronzeGrinder extends GuiBase{

    private TileEntityBronzeGrinder entity;

    public GuiBronzeGrinder(InventoryPlayer inventory, TileEntityBronzeGrinder entity) {
        super(new ContainerBronzeGrinder(inventory, entity));
        this.entity = entity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);
    }
}
