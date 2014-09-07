package com.professorvennie.machinerycraft.core.client.gui;

import com.professorvennie.machinerycraft.core.common.containers.ContainerPortableCobbleGen;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.basic.TileEntityPortableCobbleGen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiPortableCobbleGen extends GuiBase {

    private TileEntityPortableCobbleGen entity;

    public GuiPortableCobbleGen(InventoryPlayer inventory, TileEntityPortableCobbleGen entityPortableCobbleGen) {
        super(new ContainerPortableCobbleGen(inventory, entityPortableCobbleGen), entityPortableCobbleGen);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/portableCobbleGen.png");

        entity = entityPortableCobbleGen;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);

        int lava = this.entity.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 45, guiTop + 36, 176, 0, lava + 1, 16);

        int water = this.entity.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 131 - 24, guiTop + 36, 176, 18, 24 + water + 1, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
    }
}
