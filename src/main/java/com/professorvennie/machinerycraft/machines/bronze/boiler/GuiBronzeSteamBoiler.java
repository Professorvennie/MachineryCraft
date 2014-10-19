/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.boiler;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 7/24/2014 at 11:46 PM.
 */
public class GuiBronzeSteamBoiler extends GuiBase {

    private TileEntityBronzeSteamBoiler entity;

    public GuiBronzeSteamBoiler(InventoryPlayer inventory, TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler) {
        super(new ContainerBronzeSteamBoiler(inventory, tileEntityBronzeSteamBoiler), tileEntityBronzeSteamBoiler);
        entity = tileEntityBronzeSteamBoiler;
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/bronzeSteamBoiler.png");

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);

        if (this.entity.isBurning()) {
            int k = this.entity.getBurnTimeReamingScaled(12);
            drawElement(81, 38 - k, 176, 12 - k, 14, k + 2);
        }
        //drawTanks(entity.tanks[0], 66, 11, 74, 16);
        //drawTanks(entity.tanks[1], 66, 149, 74, 16);

        int j = getValueScaled(entity.waterAmount, entity.waterCapacity, 66);
        drawElement(guiLeft + 11, guiTop + 74 - j, 176, 79 - j, 16, j);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {

        String name = StatCollector.translateToLocal(entity.getName());
        int color = 0X00FF37;
        if (entity.temp < 200)
            color = 0X00FF37;
        if (entity.temp > 200 && entity.temp < 350)
            color = 0XFFD800;
        if (entity.temp > 350)
            color = 0XFF0000;
        int x = 84, x2 = 90;
        if (entity.temp < 10) {
            x = 84;
            x2 = 90;
        }
        if (entity.temp > 10) {
            x = 78;
            x2 = 98;
        }

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2 + 6, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 120, this.ySize - 96 + 2, 4210752);
        this.fontRendererObj.drawString(entity.temp + "", x, ySize - 100, color);
        this.fontRendererObj.drawString("F", x2, ySize - 100, 4210752);

        List<String> text = new ArrayList<String>();
       /* if (entity.tanks[0].getFluidAmount() > 0 || (entity.tanks[0].getFluid() != null)) {
            text.clear();
            text.add(entity.tanks[0].getFluid().getFluid().getLocalizedName(null));
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
            text2.add(entity.tanks[1].getFluid().getFluid().getLocalizedName(null));
            text2.add(entity.tanks[1].getFluidAmount() + "/" + entity.tanks[1].getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 149, 8, 164, 73, text2, fontRendererObj);
        } else {
            text2.clear();
            text2.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text2, fontRendererObj);
        }*/

        text.clear();
        text.add("Water");
        text.add(entity.waterAmount + "/" + entity.waterCapacity + "mB");
        drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);

        List<String> text2 = new ArrayList<String>();
        text2.clear();
        text2.add("Steam");
        text2.add(entity.steamAmount + "/" + entity.steamCapacity + "mB");
        drawToolTipOverArea(mouseX, mouseY, 149, 8, 164, 73, text2, fontRendererObj);
    }
}
