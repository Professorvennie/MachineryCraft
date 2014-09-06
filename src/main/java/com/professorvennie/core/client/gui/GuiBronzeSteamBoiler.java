/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.client.gui;

import com.professorvennie.core.common.containers.ContainerBronzeSteamBoiler;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.tileEntity.machines.steam.TileEntityBronzeSteamBoiler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

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

        if(this.entity.isBurning()){
            int k = this.entity.getBurnTimeReamingScaled(12);
            drawTexturedModalRect(guiLeft + 81, guiTop + 38 - k, 176, 12 - k, 14, k + 2);
        }
        drawTanks();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {

        String name = StatCollector.translateToLocal(entity.getInventoryName());
        int color = 0X00FF37;
        if(entity.temp < 200)
            color = 0X00FF37;
        if(entity.temp > 200 && entity.temp < 350)
            color = 0XFFD800;
        if(entity.temp > 350)
            color = 0XFF0000;
        int x = 84, x2 = 90;
        if(entity.temp < 10) {
            x = 84;
            x2 = 90;
        }
        if(entity.temp > 10) {
            x = 78;
            x2 = 98;
        }

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2 + 6, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 120, this.ySize - 96 + 2, 4210752);
        this.fontRendererObj.drawString(entity.temp + "", x , ySize - 100, color);
        this.fontRendererObj.drawString("F", x2 , ySize - 100, 4210752);

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

        List<String> text2 = new ArrayList<String>();
        if (entity.tanks[1].getFluidAmount() > 0 || (entity.tanks[1].getFluid() != null)) {
            text2.clear();
            text2.add(entity.tanks[1].getFluid().getFluid().getUnlocalizedName());
            text2.add(entity.tanks[1].getFluidAmount() + "/" + entity.tanks[1].getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 149, 8, 164, 73, text2, fontRendererObj);
        } else {
            text2.clear();
            text2.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text2, fontRendererObj);
        }
    }

    public void drawTanks() {
        int j;
        if (entity.tanks[0].getFluid() != null) {
            j = getValueScaled(entity.tanks[0].getFluidAmount(), entity.tanks[0].getCapacity(), 66);
            this.drawFluid(guiLeft + 11, guiTop + 74 - j, entity.tanks[0].getFluid(), 16, j);
        }
        int k;
        if (entity.tanks[1].getFluid() != null) {
            k = getValueScaled(entity.tanks[1].getFluidAmount(), entity.tanks[1].getCapacity(), 66);
            this.drawFluid(guiLeft + 149, guiTop + 74 - k, entity.tanks[1].getFluid(), 16, k);
        }
    }
}
