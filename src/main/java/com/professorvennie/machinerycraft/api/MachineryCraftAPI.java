/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.api;

import com.professorvennie.machinerycraft.api.book.BookCategory;
import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.recipes.ExtractorRecipes;
import com.professorvennie.machinerycraft.api.recipes.GrinderRecipes;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;

public class MachineryCraftAPI {

    //temp until forge gets updated
    //Armor Materials
    public static ArmorMaterial zincArmorMaterial = ArmorMaterial.DIAMOND;/*EnumHelper.addArmorMaterial("zincArmorMaterial", 16, new int[]{3, 7, 5, 3}, 10);*/
    public static ArmorMaterial brassArmorMaterial = ArmorMaterial.CHAIN;/*EnumHelper.addArmorMaterial("brassArmorMaterial", 20, new int[]{3, 6, 3, 3}, 15);*/
    public static ArmorMaterial emeraldArmorMaterial = ArmorMaterial.GOLD;/*EnumHelper.addArmorMaterial("emeraldArmorMaterial", 66, new int[]{6, 16, 14, 6}, 20);*/

    //Tool Materials
    public static ToolMaterial zincToolMaterial = ToolMaterial.EMERALD;/*EnumHelper.addToolMaterial("zincToolMaterial", 2, 100, 14.0f, 3.0f, 14);*/
    public static ToolMaterial brassToolMaterial = ToolMaterial.GOLD;/*EnumHelper.addToolMaterial("brassToolMaterial", 3, 350, 12.0f, 5.0f, 16);*/
    public static ToolMaterial emeraldToolMaterial = ToolMaterial.IRON;/*EnumHelper.addToolMaterial("emeraldToolMaterial", 4, 2500, 16.0F, 6.0F, 18);*/

    private static List<BookCategory> categories = new ArrayList<BookCategory>();
    private static List<BookEntry> allEntries = new ArrayList<BookEntry>();

    public static List<BookCategory> getAllCategories() {
        return categories;
    }

    /**
     * Registers a Book Entry and adds it to the category passed in.
     */
    public static void addEntry(BookEntry entry, BookCategory category) {
        allEntries.add(entry);
        category.entries.add(entry);
    }

    /**
     * Register a Book Category
     */
    public static void addCategory(BookCategory category) {
        categories.add(category);
    }

    public static IRecipe getLatestAddedRecipe() {
        List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
        return list.get(list.size() - 1);
    }

    public static List<IRecipe> getLatestAddedRecipes(int x) {
        List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
        List<IRecipe> newList = new ArrayList();
        for (int i = x - 1; i >= 0; i--)
            newList.add(list.get(list.size() - 1 - i));

        return newList;
    }

    /**
     * @param input  An itemStack that can be grinded into the output
     * @param output What the input will be grinded into
     * @param xp     The amount of XP this recipe will reward the player
     */
    public static void registerGrinderRecipe(ItemStack input, ItemStack output, float xp) {
        GrinderRecipes.grinding().addRecipe(input, output, xp);
    }

    /**
     * @param input   An itemStack that can be extracted into the two outputs
     * @param outPut1 The primary output for the input
     * @param xp      The amount of XP this recipe will reward the player
     */
    public static void registerExtractorRecipe(ItemStack input, ItemStack outPut1, float xp) {
        ExtractorRecipes.extractoring().addRecipe(input, outPut1, xp);
    }
}
