package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerBronzeFurnace;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.tileEntity.TileEntityBronzeFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:40 AM.
 */
public class GuiBronzeFurnace extends GuiBase{

    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/bronzeFurnace.png");
    private TileEntityBronzeFurnace entity;

    public GuiBronzeFurnace(InventoryPlayer inventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        super(new ContainerBronzeFurnace(inventory, tileEntityBronzeFurnace));
        entity = tileEntityBronzeFurnace;

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
        if (entity.tanks[0].getFluidAmount() > 0 || (entity.tanks[0].getFluid() != null)) {
            text.clear();
            text.add(entity.tanks[0].getFluid().getFluid().getUnlocalizedName());
            text.add(entity.tanks[0].getFluidAmount() + "/" + entity.tanks[0].getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        }
    }

    public void drawTanks() {
        int j;
        if (entity.tanks[0].getFluid() != null) {
            j = getValueScaled(entity.tanks[0].getFluidAmount(), entity.tanks[0].getCapacity(), 66);
            this.drawFluid(guiLeft + 11, guiTop + 74 - j, entity.tanks[0].getFluid(), 16, j);
        }

    }
}
