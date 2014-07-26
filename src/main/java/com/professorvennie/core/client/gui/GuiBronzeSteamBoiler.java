package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerBronzeSteamBoiler;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.tileEntity.TileEntityBronzeSteamBoiler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ProfessorVennie on 7/24/2014 at 11:46 PM.
 */
public class GuiBronzeSteamBoiler extends GuiBase{

    private TileEntityBronzeSteamBoiler entity;
    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/bronzeSteamBoiler.png");

    public GuiBronzeSteamBoiler(InventoryPlayer inventory, TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler) {
        super(new ContainerBronzeSteamBoiler(inventory, tileEntityBronzeSteamBoiler));
        entity = tileEntityBronzeSteamBoiler;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        drawTanks();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {

    }

    public void drawTanks() {
        int j;
        if (entity.tanks[0].getFluid() != null) {
            j = getValueScaled(entity.tanks[0].getFluidAmount(), entity.tanks[0].getCapacity(), 66);
            this.drawFluid(guiLeft + 11, guiTop + 74 - j, entity.tanks[0].getFluid(), 16, j);
        }

    }
}
