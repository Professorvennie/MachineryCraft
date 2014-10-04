/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
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
