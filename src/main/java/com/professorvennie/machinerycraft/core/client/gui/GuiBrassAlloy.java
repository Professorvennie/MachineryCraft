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

import com.professorvennie.machinerycraft.core.common.containers.ContainerBrassAlloy;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.TileEntityBrassAlloy;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiBrassAlloy extends GuiBase {

    public TileEntityBrassAlloy Alloy;

    public GuiBrassAlloy(InventoryPlayer inventory, TileEntityBrassAlloy entity) {
        super(new ContainerBrassAlloy(inventory, entity), entity);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/Ironoxide_Alloy.png");

        this.Alloy = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);

        List<String> text = new ArrayList<String>();
        if (Alloy.getCurrentCharge() > 0) {
            text.clear();
            text.add(Alloy.getCurrentCharge() + "/" + Alloy.getChargeCapacity() + " Jewels");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 48, text, fontRendererObj);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        super.drawGuiContainerBackgroundLayer(var1, var2, var3);

        int i1;

        if (this.Alloy.hasPower()) {
            i1 = this.Alloy.getPowerRemainingScaled(45);
            this.drawElement(11, 53 - i1, 176, 62 - i1, 16, i1);
        }

        i1 = this.Alloy.getCookProgressScaled(24);
        this.drawElement(79, 34, 176, 0, i1 + 1, 16);
    }
}
