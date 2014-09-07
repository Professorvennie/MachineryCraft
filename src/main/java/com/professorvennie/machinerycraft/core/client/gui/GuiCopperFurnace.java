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

import com.professorvennie.machinerycraft.core.common.containers.ContainerCopperFurnace;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.copper.TileEntityCopperFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCopperFurnace extends GuiBase {

    public TileEntityCopperFurnace saltFurnace;

    public GuiCopperFurnace(InventoryPlayer inventoryPlayer, TileEntityCopperFurnace entity) {
        super(new ContainerCopperFurnace(inventoryPlayer, entity), entity);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/saltfurnace.png");

        this.saltFurnace = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        super.drawGuiContainerBackgroundLayer(var1, var2, var3);

        if (this.saltFurnace.isBurning()) {
            int k = this.saltFurnace.getBurnTimeReamingScaled(12);
            drawElement(56, 36 + 12 - k, 176, 12 - k, 14, k + 2);
        }

        int k = this.saltFurnace.getCookProgressSacled(24);
        drawElement(79, 34, 176, 14, k + 1, 16);
    }

}
