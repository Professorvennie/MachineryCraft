package com.professorvennie.machinerycraft.plugins.codechicken.nei;

import codechicken.nei.recipe.FurnaceRecipeHandler;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.copper.furnace.GuiCopperFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;

/**
 * Created by ProfessorVennie on 9/29/2014 at 7:09 PM.
 */
public class CopperFurnaceHandler extends FurnaceRecipeHandler {

    @Override
    public String getRecipeName() {
        return "Copper Furnace";
    }

    @Override
    public String getGuiTexture() {
        return Reference.MOD_ID + ":textures/gui/saltfurnace.png";
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiCopperFurnace.class;
    }
}
