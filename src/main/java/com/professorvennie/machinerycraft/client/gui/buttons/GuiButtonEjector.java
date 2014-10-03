package com.professorvennie.machinerycraft.client.gui.buttons;

import com.professorvennie.machinerycraft.client.gui.buttons.enums.EjectorMode;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ProfessorVennie on 9/28/2014 at 12:54 PM.
 */
public class GuiButtonEjector extends GuiButton {

    private EjectorMode mode;

    public GuiButtonEjector(int id, int x, int y, TileEntityBasicMachine tile) {
        super(id, x, y, 18, 18, "");
        this.mode = tile.getEjectorMode();
    }

    @Override
    public void drawButton(Minecraft minecraft, int x, int y) {
        minecraft.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/guiElements.png"));

        switch (mode) {
            case north:
                drawTexturedModalRect(xPosition, yPosition, 29, 0, 22, 22);
                break;
            case south:
                drawTexturedModalRect(xPosition, yPosition, 29, 23, 22, 22);
                break;
            case east:
                drawTexturedModalRect(xPosition, yPosition, 29, 46, 22, 22);
                break;
            case west:
                drawTexturedModalRect(xPosition, yPosition, 29, 69, 22, 22);
                break;
            case up:
                drawTexturedModalRect(xPosition, yPosition, 29, 92, 22, 22);
                break;
            case down:
                drawTexturedModalRect(xPosition, yPosition, 29, 115, 22, 22);
                break;
            case disabled:
                drawTexturedModalRect(xPosition, yPosition, 29, 138, 22, 22);
                break;
        }
    }

    public EjectorMode getMode() {
        return mode;
    }

    public void setMode(EjectorMode mode) {
        this.mode = mode;
    }
}
