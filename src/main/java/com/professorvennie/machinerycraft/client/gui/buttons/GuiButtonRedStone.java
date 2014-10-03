package com.professorvennie.machinerycraft.client.gui.buttons;

import com.professorvennie.machinerycraft.client.gui.buttons.enums.RedStoneMode;
import com.professorvennie.machinerycraft.core.helpers.RenderHelper;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 9/26/2014 at 9:30 PM.
 */
public class GuiButtonRedStone extends GuiButton {

    private RedStoneMode mode;
    private TileEntityBasicMachine tile;

    public GuiButtonRedStone(int id, int x, int y, TileEntityBasicMachine tile) {
        super(id, x, y, 18, 18, "");
        this.mode = tile.getRedStoneMode();
        this.tile = tile;
    }

    @Override
    public void drawButton(Minecraft minecraft, int x, int y) {
        minecraft.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/guiElements.png"));

        this.field_146123_n = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
        int k = getHoverState(field_146123_n);
        List<String> tooltip = new ArrayList<String>();
        //int tooltipY = (tooltip.size() - 1) * 10;

        switch (mode) {
            case low:
                drawTexturedModalRect(xPosition, yPosition, 0, 122, 22, 22);
                tooltip.clear();
                tooltip.add(StatCollector.translateToLocal("tooltipRedStone.low"));
                if (k == 2)
                    RenderHelper.renderTooltip(x, y, tooltip);
                break;
            case high:
                drawTexturedModalRect(xPosition, yPosition, 0, 168, 22, 22);
                tooltip.clear();
                tooltip.add(StatCollector.translateToLocal("tooltipRedStone.high"));
                if (k == 2)
                    RenderHelper.renderTooltip(x, y, tooltip);
                break;
            case disabled:
                drawTexturedModalRect(xPosition, yPosition, 0, 145, 22, 22);
                tooltip.clear();
                tooltip.add(StatCollector.translateToLocal("tooltipRedStone.disabled"));
                if (k == 2)
                    RenderHelper.renderTooltip(x, y, tooltip);
                break;
        }
    }

    public RedStoneMode getMode() {
        return mode;
    }

    public void setMode(RedStoneMode mode) {
        this.mode = mode;
    }
}
