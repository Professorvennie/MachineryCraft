package com.professorvennie.machinerycraft.machines.basic.campfire;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ProfessorVennie on 9/14/2014 at 6:56 PM.
 */
public class GuiCampFire extends GuiBase {

    private TileEntityCampFire entity;

    public GuiCampFire(InventoryPlayer inventory, TileEntityCampFire entity) {
        super(new ContainerCampFire(inventory, entity), entity);
        this.entity = entity;

        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/saltfurnace.png");
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        super.drawGuiContainerBackgroundLayer(p_146976_1_, p_146976_2_, p_146976_3_);

        if (this.entity.isBurning()) {
            int k = this.entity.getBurnTimeReamingScaled(12);
            drawElement(56, 36 + 12 - k, 176, 12 - k, 14, k + 2);
        }

        int k = this.entity.getCookProgressScaled(24);
        drawElement(79, 34, 176, 14, k + 1, 16);
    }
}
