/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.api.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AlloyRecipes {

    public static List<AlloyRecipe> recipes = new ArrayList<AlloyRecipe>();

    public static void addRecipe(ItemStack[] recipe, ItemStack output) {
        recipes.add(new AlloyRecipe(recipe, output));
    }

    public static ItemStack getresoult(ItemStack[] recipe) {
        for (AlloyRecipe r : recipes) {
            if (r.doesRecipeMatch(recipe))
                return (r.getOutput());
        }
        return null;
    }
}
