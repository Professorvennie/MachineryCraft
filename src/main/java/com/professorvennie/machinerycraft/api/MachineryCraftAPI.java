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
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class MachineryCraftAPI {

    //Armor Materials
    public static ArmorMaterial zincArmorMaterial = EnumHelper.addArmorMaterial("zincArmorMaterial", 16, new int[]{3, 7, 5, 3}, 10);
    public static ArmorMaterial brassArmorMaterial = EnumHelper.addArmorMaterial("brassArmorMaterial", 20, new int[]{3, 6, 3, 3}, 15);
    public static ArmorMaterial emeraldArmorMaterial = EnumHelper.addArmorMaterial("emeraldArmorMaterial", 40, new int[]{4, 10, 8, 4}, 18);
    public static ArmorMaterial cactusArmorMaterial = EnumHelper.addArmorMaterial("cactusArmorMaterial", 40, new int[]{4, 10, 8, 4}, 18);

    //Tool Materials
    public static ToolMaterial zincToolMaterial = EnumHelper.addToolMaterial("zincToolMaterial", 2, 100, 14.0f, 3.0f, 14);
    public static ToolMaterial brassToolMaterial = EnumHelper.addToolMaterial("brassToolMaterial", 3, 350, 12.0f, 5.0f, 16);
    public static ToolMaterial emeraldToolMaterial = EnumHelper.addToolMaterial("emeraldToolMaterial", 3, 2000, 10.0F, 5.0F, 15);

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
