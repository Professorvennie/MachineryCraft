/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client.gui;

import com.professorvennie.machinerycraft.common.containers.ContainerWasher;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.tileEntity.TileEntityWasher;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiWasher extends GuiBase {

    public TileEntityWasher Washer;

    public GuiWasher(InventoryPlayer inventory, TileEntityWasher entity) {
        super(new ContainerWasher(inventory, entity), entity);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/Washer.png");

        this.Washer = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);
        this.fontRendererObj.drawString(I18n.format("In", MachineryCraft.instance), 141, this.ySize - 116, 4210752);
        this.fontRendererObj.drawString(I18n.format("Out", MachineryCraft.instance), 135, this.ySize - 99, 4210752);

        List<String> text = new ArrayList<String>();
        if (Washer.tanks[0].getFluidAmount() > 0 || (Washer.tanks[0].getFluid() != null)) {
            text.clear();
            text.add(Washer.tanks[0].getFluid().getFluid().getUnlocalizedName());
            text.add(Washer.tanks[0].getFluidAmount() + "/" + Washer.tanks[0].getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 80, 17, 95, 66, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 80, 17, 95, 66, text, fontRendererObj);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        super.drawGuiContainerBackgroundLayer(var1, var2, var3);

        this.drawTanks(Washer.tanks[0], 49, 80, 66, 16);
    }
}
