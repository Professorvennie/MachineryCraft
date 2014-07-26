package com.professorvennie.core.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.Container;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ProfessorVennie on 7/25/2014 at 12:26 PM.
 */
public class GuiBase extends GuiContainer{

    protected int mouseX = 0, mouseY = 0;

    public GuiBase(Container container) {
        super(container);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {

    }

    @Override
    public void handleMouseInput() {
        int x = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int y = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        mouseX = x - guiLeft;
        mouseY = y - guiTop;

        super.handleMouseInput();
    }

    public int getValueScaled(int value, int max, int scale) {
        return (value * scale) / max;
    }

    public void drawToolTipOverArea(int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, List<String> list, FontRenderer font) {
        if (list != null && font != null) {
            if ((mouseX >= minX && mouseX <= maxX) && (mouseY >= minY && mouseY <= maxY))
                drawHoveringText(list, mouseX, mouseY, font);
        }
    }

    @SuppressWarnings("rawtypes")
    protected void drawTooltipHoveringTextf(List list, int x, int y, FontRenderer font) {
        if (list == null || list.isEmpty())
            return;

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        int k = 0;
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            int l = font.getStringWidth(s);

            if (l > k) {
                k = l;
            }
        }
        int i1 = x + 12;
        int j1 = y - 12;
        int k1 = 8;

        if (list.size() > 1)
            k1 += 2 + (list.size() - 1) * 10;

        if (i1 + k > this.width)
            i1 -= 28 + k;

        if (j1 + k1 + 6 > this.height)
            j1 = this.height - k1 - 6;

        this.zLevel = 300.0F;
        itemRender.zLevel = 300.0F;
        int l1 = -267386864;
        this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
        this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
        this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
        this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
        this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
        int i2 = 1347420415;
        int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
        this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
        this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
        this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
        this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

        for (int k2 = 0; k2 < list.size(); ++k2) {
            String s1 = (String) list.get(k2);
            font.drawStringWithShadow(s1, i1, j1, -1);

            if (k2 == 0)
                j1 += 2;

            j1 += 10;
        }
        this.zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }

    public void drawFluid(int x, int y, FluidStack fluid, int width, int height) {
        if (fluid == null || fluid.getFluid() == null)
            return;
        mc.renderEngine.bindTexture(new ResourceLocation("textures/atlas/blocks.png"));
        GL11.glColor3ub((byte) (fluid.getFluid().getColor() >> 16 & 0xFF), (byte) (fluid.getFluid().getColor() >> 8 & 0xFF), (byte) (fluid.getFluid().getColor() & 0xFF));
        drawTiledTexture(x, y, fluid.getFluid().getIcon(fluid), width, height);
    }

    public void drawTiledTexture(int x, int y, IIcon icon, int width, int height) {
        int i = 0;
        int j = 0;

        int drawHeight = 0;
        int drawWidth = 0;

        for (i = 0; i < width; i += 16) {
            for (j = 0; j < height; j += 16) {
                drawWidth = (width - i) < 16 ? (width - i) : 16;
                drawHeight = (height - j) < 16 ? (height - j) : 16;
                drawScaledTexturedModelRectFromIcon(x + i, y + j, icon, drawWidth, drawHeight);
            }
        }
        GL11.glColor4f(1f, 1f, 1f, 1F);
    }

    public void drawScaledTexturedModelRectFromIcon(int x, int y, IIcon icon, int width, int height) {
        if (icon == null)
            return;

        double minU = icon.getMinU();
        double maxU = icon.getMaxU();
        double minV = icon.getMinV();
        double maxV = icon.getMaxV();

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0, y + height, this.zLevel, minU, minV + (maxV - minV) * height / 16F);
        tessellator.addVertexWithUV(x + width, y + height, this.zLevel, minU + (maxU - minU) * width / 16F, minV + (maxV - minV) * height / 16F);
        tessellator.addVertexWithUV(x + width, y + 0, this.zLevel, minU + (maxU - minU) * width / 16F, minV);
        tessellator.addVertexWithUV(x + 0, y + 0, this.zLevel, minU, minV);
        tessellator.draw();
    }
}
