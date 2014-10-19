/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.furnace;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:40 AM.
 */
public class GuiBronzeFurnace extends GuiBase {

    private TileEntityBronzeFurnace entity;

    public GuiBronzeFurnace(InventoryPlayer inventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        super(new ContainerBronzeFurnace(inventory, tileEntityBronzeFurnace), tileEntityBronzeFurnace);
        entity = tileEntityBronzeFurnace;
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/bronzeFurnace.png");

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);

        int k = this.entity.getCookProgressScaled(24);
        drawElement(83, 35, 176, 1, k + 1, 16);

        // drawTanks(entity.tank, 66, 11, 74, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);

        List<String> text = new ArrayList<String>();
        /*if (entity.tank.getFluidAmount() > 0 || (entity.tank.getFluid() != null && entity.tank.getFluid().getFluid() != null)) {
            text.clear();
            text.add(entity.tank.getFluid().getFluid().getLocalizedName(null));
            text.add(entity.tank.getFluidAmount() + "/" + entity.tank.getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        }*/

        text.clear();
        text.add("Steam");
        text.add(entity.steamAmount + "/" + entity.steamCapacity + "mB");
        drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
    }
}
