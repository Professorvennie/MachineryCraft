/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.charger;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 10/4/2014 at 4:11 PM.
 */
public class GuiBronzeCharger extends GuiBase {

    private TileEntityBronzeCharger tile;

    public GuiBronzeCharger(InventoryPlayer inventory, TileEntityBronzeCharger tile) {
        super(new ContainerBronzeCharger(inventory, tile), tile);
        this.tile = tile;

        backGround = new ResourceLocation(Reference.MOD_ID, "/textures/gui/bronzeCharger.png");
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);

        drawTanks(tile.tank, 66, 11, 74, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);

        List<String> text = new ArrayList<String>();
        if (tile.tank.getFluidAmount() > 0 || (tile.tank.getFluid() != null && tile.tank.getFluid().getFluid() != null)) {
            text.clear();
            text.add(tile.tank.getFluid().getFluid().getLocalizedName(null));
            text.add(tile.tank.getFluidAmount() + "/" + tile.tank.getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        }
    }
}
