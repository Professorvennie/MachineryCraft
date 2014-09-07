/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.client.gui;

import com.professorvennie.machinerycraft.core.common.containers.ContainerBrassFurnace;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.TileEntityBrassFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiBrassFurnace extends GuiBase {

    public TileEntityBrassFurnace Furnace;

    public GuiBrassFurnace(InventoryPlayer inventoryPlayer, TileEntityBrassFurnace entity) {
        super(new ContainerBrassFurnace(inventoryPlayer, entity), entity);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/Ironoxide_Furnace.png");
        this.Furnace = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);

        List<String> text = new ArrayList<String>();
        if (Furnace.hasPower()) {
            text.clear();
            text.add(Furnace.getCurrentCharge() + "/" + Furnace.getChargeCapcity() + " Jewels");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 48, text, fontRendererObj);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        super.drawGuiContainerBackgroundLayer(var1, var2, var3);
        int i1;

        if (this.Furnace.hasPower()) {
            i1 = this.Furnace.getPowerRemainingScaled(45);
            this.drawElement(11, 53 - i1, 176, 62 - i1, 31, i1);
        }

        i1 = this.Furnace.getCookProgressScaled(24);
        this.drawElement(79, 34, 176, 0, i1 + 1, 16);
    }
}
