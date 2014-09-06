package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerBronzeExtractor;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.tileEntity.machines.steam.TileEntityBronzeExtractor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 8/21/2014 at 8:22 PM.
 */
public class GuiBronzeExtractor extends GuiBase{

    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/bronzeExtractor.png");
    private TileEntityBronzeExtractor entity;

    public GuiBronzeExtractor(InventoryPlayer inventory, TileEntityBronzeExtractor entity) {
        super(new ContainerBronzeExtractor(inventory, entity));
        this.entity = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int k = this.entity.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 83, guiTop + 35, 176, 1, k + 1, 16);
        drawTanks();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String name = StatCollector.translateToLocal(entity.getInventoryName());

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2 + 6, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 120, this.ySize - 96 + 2, 4210752);

        List<String> text = new ArrayList<String>();
        if (entity.tank.getFluidAmount() > 0 || (entity.tank.getFluid() != null && entity.tank.getFluid().getFluid() != null)) {
            text.clear();
            text.add(entity.tank.getFluid().getFluid().getUnlocalizedName());
            text.add(entity.tank.getFluidAmount() + "/" + entity.tank.getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        }
    }

    public void drawTanks() {
        int j;
        if (entity.tank.getFluid() != null) {
            j = getValueScaled(entity.tank.getFluidAmount(), entity.tank.getCapacity(), 66);
            this.drawFluid(guiLeft + 11, guiTop + 74 - j, entity.tank.getFluid(), 16, j);
        }
    }
}
