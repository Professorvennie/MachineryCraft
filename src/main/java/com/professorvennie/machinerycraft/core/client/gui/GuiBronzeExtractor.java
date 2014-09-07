package com.professorvennie.machinerycraft.core.client.gui;

import com.professorvennie.machinerycraft.core.common.containers.ContainerBronzeExtractor;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeExtractor;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 8/21/2014 at 8:22 PM.
 */
public class GuiBronzeExtractor extends GuiBase {

    private TileEntityBronzeExtractor entity;

    public GuiBronzeExtractor(InventoryPlayer inventory, TileEntityBronzeExtractor entity) {
        super(new ContainerBronzeExtractor(inventory, entity), entity);
        this.entity = entity;
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/bronzeExtractor.png");

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);
        int k = this.entity.getCookProgressScaled(24);
        drawElement(83, 35, 176, 1, k + 1, 16);
        drawTanks(entity.tank, 66, 11, 74, 16);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
        List<String> text = new ArrayList<String>();
        if (entity.tank.getFluidAmount() > 0 || (entity.tank.getFluid() != null && entity.tank.getFluid().getFluid() != null)) {
            text.clear();
            text.add(entity.tank.getFluid().getFluid().getLocalizedName());
            text.add(entity.tank.getFluidAmount() + "/" + entity.tank.getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 11, 8, 26, 73, text, fontRendererObj);
        }
    }
}
