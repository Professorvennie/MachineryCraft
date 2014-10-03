/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.copper.grinder;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCopperGrinder extends GuiBase {

    public TileEntityCopperGrinder Grinder;

    public GuiCopperGrinder(InventoryPlayer inventoryPlayer, TileEntityCopperGrinder entity) {
        super(new ContainerCopperGrinder(inventoryPlayer, entity), entity);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/Grinder.png");

        this.Grinder = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        super.drawGuiContainerBackgroundLayer(var1, var2, var3);

        if (this.Grinder.isBurning()) {
            int k = this.Grinder.getBurnTimeReamingScaled(12);
            drawElement(56, 36 + 12 - k, 176, 12 - k, 14, k + 2);
        }

        int k = this.Grinder.getCookProgressSacled(24);
        drawElement(79, 34, 176, 14, k + 1, 16);
    }


}
