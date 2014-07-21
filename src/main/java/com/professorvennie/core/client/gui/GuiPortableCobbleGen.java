package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerPortableCobbleGen;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.tileEntity.TileEntityPortableCobbleGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiPortableCobbleGen extends GuiContainer{

    private TileEntityPortableCobbleGen entity;
    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/portableCobbleGen.png");

    public GuiPortableCobbleGen(InventoryPlayer inventory, TileEntityPortableCobbleGen entityPortableCobbleGen) {
        super(new ContainerPortableCobbleGen(inventory, entityPortableCobbleGen));
        entity = entityPortableCobbleGen;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String name = this.entity.hasCustomName() ? this.entity.getCustomName() : I18n.format(this.entity.getInventoryName(), MachineryCraft.instance);

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 8, this.ySize - 96 + 2, 4210752);
    }
}
