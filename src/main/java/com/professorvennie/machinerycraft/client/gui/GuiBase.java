package com.professorvennie.machinerycraft.client.gui;

import com.professorvennie.lib.base.tileentitys.TileEntityBasicSidedInventory;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.client.gui.buttons.GuiButtonEjector;
import com.professorvennie.machinerycraft.client.gui.buttons.GuiButtonRedStone;
import com.professorvennie.machinerycraft.client.gui.buttons.enums.EjectorMode;
import com.professorvennie.machinerycraft.client.gui.buttons.enums.RedStoneMode;
import com.professorvennie.machinerycraft.core.network.MessageButton;
import com.professorvennie.machinerycraft.core.network.PacketHandler;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ProfessorVennie on 7/25/2014 at 12:26 PM.
 */
public class GuiBase extends GuiContainer {

    public ResourceLocation backGround;
    public ResourceLocation elements = new ResourceLocation(Reference.MOD_ID, "textures/gui/guiElements.png");
    protected int mouseX = 0, mouseY = 0;
    private TileEntityBasicSidedInventory tileEntity;
    private TileEntityBasicMachine basicMachine;

    public GuiBase(Container container, TileEntityBasicSidedInventory tileEntity) {
        super(container);
        this.tileEntity = tileEntity;
    }

    public GuiBase(Container container, TileEntityBasicMachine tile) {
        super(container);
        this.basicMachine = tile;
    }

    @Override
    public void initGui() {
        super.initGui();
        if (basicMachine != null) {
            buttonList.add(new GuiButtonRedStone(0, guiLeft + xSize + 1, guiTop + ySize - 73, basicMachine));

            if (basicMachine.hasEjectorUpgrade)
                buttonList.add(new GuiButtonEjector(0, guiLeft + xSize + 1, guiTop + ySize - (73 - 27), basicMachine));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(0F, 0.30F, 0.97F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(elements);
        drawTexturedModalRect(guiLeft + 176, guiTop + 3, 0, 0, 28, 89);

        if (basicMachine != null) {
            GL11.glColor4f(0.97F, 0.00F, 0F, 1F);
            drawTexturedModalRect(guiLeft + 176, guiTop + 92, 0, 94, 28, 28);

            if (basicMachine.hasEjectorUpgrade) {
                GL11.glColor4f(0F, 1F, 1F, 1F);
                drawTexturedModalRect(guiLeft + 176, guiTop + 119, 0, 94, 28, 28);
            }
        }

        GL11.glColor4f(1F, 1F, 1F, 1F);
        if (backGround != null) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(backGround);
            drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 8, this.ySize - 96 + 2, 4210752);
        String name = "";
        if (tileEntity != null)
            name = StatCollector.translateToLocal(tileEntity.getInventoryName());
        else if (basicMachine != null)
            name = StatCollector.translateToLocal(basicMachine.getInventoryName());

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
    }

    public void drawElement(int x, int y, int u, int v, int width, int height) {
        this.drawTexturedModalRect(guiLeft + x, guiTop + y, u, v, width, height);
    }

    public void drawTanks(FluidTank tank, int scale, int x, int y, int width) {
        int j;
        if (tank.getFluid() != null) {
            j = getValueScaled(tank.getFluidAmount(), tank.getCapacity(), scale);
            this.drawFluid(guiLeft + x, guiTop + y - j, tank.getFluid(), width, j);
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                if (button instanceof GuiButtonRedStone) {
                    if (basicMachine != null) {
                        GuiButtonRedStone buttonRedStone = (GuiButtonRedStone) button;
                        switch (basicMachine.getRedStoneMode()) {
                            case low:
                                buttonRedStone.setMode(RedStoneMode.high);
                                basicMachine.setRedstoneMode(RedStoneMode.high);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 0));
                                break;
                            case high:
                                buttonRedStone.setMode(RedStoneMode.disabled);
                                basicMachine.setRedstoneMode(RedStoneMode.disabled);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 1));
                                break;
                            case disabled:
                                buttonRedStone.setMode(RedStoneMode.low);
                                basicMachine.setRedstoneMode(RedStoneMode.low);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 2));
                                break;
                        }
                        break;
                    }
                }
            case 1:
                if (basicMachine != null) {
                    if (button instanceof GuiButtonEjector) {
                        GuiButtonEjector buttonEjector = (GuiButtonEjector) button;
                        switch (basicMachine.getEjectorMode()) {
                            case north:
                                buttonEjector.setMode(EjectorMode.south);
                                basicMachine.setEjectorMode(EjectorMode.south);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 3));
                                break;
                            case south:
                                buttonEjector.setMode(EjectorMode.east);
                                basicMachine.setEjectorMode(EjectorMode.east);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 4));
                                break;
                            case east:
                                buttonEjector.setMode(EjectorMode.west);
                                basicMachine.setEjectorMode(EjectorMode.west);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 5));
                                break;
                            case west:
                                buttonEjector.setMode(EjectorMode.up);
                                basicMachine.setEjectorMode(EjectorMode.up);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 6));
                                break;
                            case up:
                                buttonEjector.setMode(EjectorMode.down);
                                basicMachine.setEjectorMode(EjectorMode.down);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 7));
                                break;
                            case down:
                                buttonEjector.setMode(EjectorMode.disabled);
                                basicMachine.setEjectorMode(EjectorMode.disabled);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 8));
                                break;
                            case disabled:
                                buttonEjector.setMode(EjectorMode.north);
                                basicMachine.setEjectorMode(EjectorMode.north);
                                PacketHandler.INSTANCE.sendToServer(new MessageButton(basicMachine.xCoord, basicMachine.yCoord, basicMachine.zCoord, 9));
                                break;
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        int x = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int y = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        mouseX = x - guiLeft;
        mouseY = y - guiTop;
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
        tessellator.addVertexWithUV(x, y + height, this.zLevel, minU, minV + (maxV - minV) * height / 16F);
        tessellator.addVertexWithUV(x + width, y + height, this.zLevel, minU + (maxU - minU) * width / 16F, minV + (maxV - minV) * height / 16F);
        tessellator.addVertexWithUV(x + width, y, this.zLevel, minU + (maxU - minU) * width / 16F, minV);
        tessellator.addVertexWithUV(x, y, this.zLevel, minU, minV);
        tessellator.draw();
    }
}
