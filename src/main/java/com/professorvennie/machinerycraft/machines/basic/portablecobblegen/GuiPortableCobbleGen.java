package com.professorvennie.machinerycraft.machines.basic.portablecobblegen;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
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
        drawElement(45, 36, 176, 0, lava + 1, 16);

        int water = this.entity.getCookProgressScaled(24);
        drawElement(131, 36, 176, 18, water + 1, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
    }
}
