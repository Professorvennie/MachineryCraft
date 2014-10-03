/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.lib;

import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.api.book.BookCategory;
import com.professorvennie.machinerycraft.client.gui.book.BookEntry;
import com.professorvennie.machinerycraft.client.gui.pages.PageCraftingRecipe;
import com.professorvennie.machinerycraft.client.gui.pages.PageText;
import com.professorvennie.machinerycraft.core.config.ConfigHandler;
import com.professorvennie.machinerycraft.recipes.ModRecipes;

public class BookData {

    public static BookCategory categoryBasics;
    public static BookCategory categoryMachines;
    public static BookCategory categoryTools;
    public static BookCategory categoryArmor;
    public static BookCategory categoryWorldgen;
    public static BookCategory categoryMultiBlocks;
    public static BookCategory categoryCraftingItems;

    //basic
    public static BookEntry basics;

    //machines
    public static BookEntry basicMachines;
    public static BookEntry firstTierMachines;
    public static BookEntry secondTierMachines;
    public static BookEntry thridTierMachines;

    //tools
    public static BookEntry zincTools;
    public static BookEntry brassTools;
    public static BookEntry emeraldTools;

    //armor
    public static BookEntry zincArmor;
    public static BookEntry brassArmor;
    public static BookEntry emeraldArmor;

    //crafting Items
    public static BookEntry gears;
    public static BookEntry nuggets;

    //worldgen
    public static BookEntry ores;
    public static BookEntry biome;
    public static BookEntry village;

    public static void init() {
        MachineryCraftAPI.addCategory(categoryBasics = new BookCategory(LibBookText.CATEGORY_BASICS));
        MachineryCraftAPI.addCategory(categoryMachines = new BookCategory(LibBookText.CATEGORY_MACHINES));
        MachineryCraftAPI.addCategory(categoryTools = new BookCategory(LibBookText.CATEGORY_TOOLS));
        MachineryCraftAPI.addCategory(categoryArmor = new BookCategory(LibBookText.CATEGORY_ARMOR));
        MachineryCraftAPI.addCategory(categoryWorldgen = new BookCategory(LibBookText.CATEGORY_WORLD_GEN));
        MachineryCraftAPI.addCategory(categoryMultiBlocks = new BookCategory(LibBookText.CATEGORY_MULTIBLOCKS));
        MachineryCraftAPI.addCategory(categoryCraftingItems = new BookCategory(LibBookText.CATEGORY_CRAFTING_ITEMS));

        //basics
        basics = new BookEntry(LibBookText.ENTRY_BASICS, categoryBasics);

        //machines
        basicMachines = new BookEntry(LibBookText.ENTRY_BASIC_MACHINES, categoryMachines);
        basicMachines.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipePortableCobbleGen));

        firstTierMachines = new BookEntry(LibBookText.ENTRY_FIRST_TIER_MACHINES, categoryMachines);
        firstTierMachines.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeCopperFurnace), new PageText("2"), new PageCraftingRecipe("3", ModRecipes.recipeCopperGrinder));

        secondTierMachines = new BookEntry(LibBookText.ENTRY_SECOND_TIER_MACHINES, categoryMachines);
        secondTierMachines.setPriority().setBookPages(new PageText("0"));

        thridTierMachines = new BookEntry(LibBookText.ENTRY_THRID_TIER_MACHINES, categoryMachines);
        thridTierMachines.setPriority().setBookPages(new PageText("0"));

        //crafting items
        nuggets = new BookEntry(LibBookText.NUGGETS, categoryCraftingItems);
        nuggets.setPriority().setBookPages(new PageText("0"),
                new PageCraftingRecipe("1", ModRecipes.recipeStoneNugget),
                new PageCraftingRecipe("2", ModRecipes.recipeZincNugget),
                new PageCraftingRecipe("3", ModRecipes.recipeIronNugget),
                new PageCraftingRecipe("4", ModRecipes.recipeCopperNugget),
                new PageCraftingRecipe("5", ModRecipes.recipeTinNugget),
                new PageCraftingRecipe("6", ModRecipes.recipeSilverNugget),
                new PageCraftingRecipe("7", ModRecipes.recipeLeadNugget),
                new PageCraftingRecipe("8", ModRecipes.recipeBronzeNugget),
                new PageCraftingRecipe("9", ModRecipes.recipeBrassNugget));

        gears = new BookEntry(LibBookText.GEARS, categoryCraftingItems);
        gears.setPriority().setBookPages(new PageText("0"),
                new PageCraftingRecipe("1", ModRecipes.recipeWoodGear),
                new PageCraftingRecipe("2", ModRecipes.recipeStoneGear),
                new PageCraftingRecipe("3", ModRecipes.recipeIronGear),
                new PageCraftingRecipe("4", ModRecipes.recipeCopperGear),
                new PageCraftingRecipe("5", ModRecipes.recipeTinGear),
                new PageCraftingRecipe("6", ModRecipes.recipeBronzeGear),
                new PageCraftingRecipe("7", ModRecipes.recipeZincGear),
                new PageCraftingRecipe("8", ModRecipes.recipeSilverGear),
                new PageCraftingRecipe("9", ModRecipes.recipeLeadGear),
                new PageCraftingRecipe("10", ModRecipes.recipeBrassGear),
                new PageCraftingRecipe("11", ModRecipes.recipeGoldGear));

        //tools
        if (ConfigHandler.zincTools) {
            zincTools = new BookEntry(LibBookText.ZINC_TOOLS, categoryTools);
            zincTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeZincPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeZincAxe), new PageCraftingRecipe("3", ModRecipes.recipeZincSword), new PageCraftingRecipe("4", ModRecipes.recipeZincSpade), new PageCraftingRecipe("5", ModRecipes.recipeZincHoe));
        }

        if (ConfigHandler.brassTools) {
            brassTools = new BookEntry(LibBookText.BRASS_TOOLS, categoryTools);
            brassTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeBrassPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeBrassAxe), new PageCraftingRecipe("3", ModRecipes.recipeBrassSword), new PageCraftingRecipe("4", ModRecipes.recipeBrassSpade), new PageCraftingRecipe("5", ModRecipes.recipeBrassHoe));
        }

        if (ConfigHandler.emeraldTools) {
            emeraldTools = new BookEntry(LibBookText.ENTRY_EMERALD_TOOLS, categoryTools);
            emeraldTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeEmeraldPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeEmeraldAxe), new PageCraftingRecipe("3", ModRecipes.recipeEmeraldSword), new PageCraftingRecipe("4", ModRecipes.recipeEmeraldSpade), new PageCraftingRecipe("5", ModRecipes.recipeEmeraldHoe));
        }

        //armor
        if (ConfigHandler.zincArmor) {
            zincArmor = new BookEntry(LibBookText.ZINC_ARMOR, categoryArmor);
            zincArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeZincHelm), new PageCraftingRecipe("2", ModRecipes.recipeZincChest), new PageCraftingRecipe("3", ModRecipes.recipeZincPants), new PageCraftingRecipe("4", ModRecipes.recipeZincBoots));
        }

        if (ConfigHandler.brassArmor) {
            brassArmor = new BookEntry(LibBookText.BRASS_ARMOR, categoryArmor);
            brassArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeBrassHelm), new PageCraftingRecipe("2", ModRecipes.recipeBrassChest), new PageCraftingRecipe("3", ModRecipes.recipeBrassPants), new PageCraftingRecipe("4", ModRecipes.recipeBrassBoots));
        }

        if (ConfigHandler.emeraldArmor) {
            emeraldArmor = new BookEntry(LibBookText.ENTRY_EMERALD_ARMOR, categoryArmor);
            emeraldArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeEmeraldHelm), new PageCraftingRecipe("2", ModRecipes.recipeEmeraldChest), new PageCraftingRecipe("3", ModRecipes.recipeEmeraldPants), new PageCraftingRecipe("4", ModRecipes.recipeEmeraldBoots));
        }

        //crafting Items

        //worldgen
        ores = new BookEntry(LibBookText.ENTRY_ORES, categoryWorldgen);
        ores.setPriority().setBookPages(new PageText("0"));

        biome = new BookEntry(LibBookText.ENTRY_BIOME, categoryWorldgen);
        biome.setPriority().setBookPages(new PageText("0"));

        village = new BookEntry(LibBookText.ENTRY_VILLAGE, categoryWorldgen);
        village.setPriority().setBookPages(new PageText("0"));
    }

}
