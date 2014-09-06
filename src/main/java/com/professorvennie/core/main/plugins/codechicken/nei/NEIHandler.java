/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main.plugins.codechicken.nei;

import codechicken.nei.api.API;
import codechicken.nei.recipe.DefaultOverlayHandler;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.client.gui.GuiCopperFurnace;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 8/28/2014 at 11:52 AM.
 */
public class NEIHandler {

    public static void loadConfig() {
        API.registerGuiOverlay(GuiCopperFurnace.class, "smelting");
        API.registerGuiOverlayHandler(GuiCopperFurnace.class, new DefaultOverlayHandler(), "smelting");

        API.registerRecipeHandler(new CopperGrinderHandler());
        API.registerUsageHandler(new CopperGrinderHandler());

        API.hideItem(new ItemStack(ModBlocks.copperFurnaceActive));
        API.hideItem(new ItemStack(ModBlocks.copperGrinderActive));
        API.hideItem(new ItemStack(ModBlocks.windmill));
    }
}
