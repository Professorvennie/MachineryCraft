/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.lib;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.api.book.BookCategory;
import com.professorvennie.core.client.gui.book.BookEntry;
import com.professorvennie.core.client.gui.pages.PageCraftingRecipe;
import com.professorvennie.core.client.gui.pages.PageText;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.main.ModRecipes;

public class BookData {
	
	public static BookCategory categoryBasics;
	public static BookCategory categoryMachines;
	public static BookCategory categoryTools;
	public static BookCategory categoryArmor;
	public static BookCategory categoryWorldgen;
	public static BookCategory categoryMultiBlocks;
	
	//basic
	public static BookEntry basics;

	//machines
    public static BookEntry basicMachines;
	public static BookEntry firstTierMachines;
	public static BookEntry secondTierMachines;
	public static BookEntry thridTierMachines;

	//tools
	public static BookEntry saltTools;
	public static BookEntry ironoxideTools;
	public static BookEntry goldoxideTools;
	public static BookEntry emeraldTools;
	
	//armor
    public static BookEntry saltArmor;
    public static BookEntry ironoxideArmor;
    public static BookEntry goldoxideArmor;
    public static BookEntry emeraldArmor;

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
		
		//basics
		basics = new BookEntry(LibBookText.ENTRY_BASICS, categoryBasics);
		
		//machines
        basicMachines = new BookEntry(LibBookText.ENTRY_BASIC_MACHINES, categoryMachines);
        basicMachines.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipePortableCobbleGen));

		firstTierMachines = new BookEntry(LibBookText.ENTRY_FIRST_TIER_MACHINES, categoryMachines);
		firstTierMachines.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeSaltFurnace), new PageText("2"), new PageCraftingRecipe("3", ModRecipes.recipeSaltGrinder));
		
		secondTierMachines = new BookEntry(LibBookText.ENTRY_SECOND_TIER_MACHINES, categoryMachines);
		secondTierMachines.setPriority();
		
		thridTierMachines = new BookEntry(LibBookText.ENTRY_THRID_TIER_MACHINES, categoryMachines);
		thridTierMachines.setPriority();
		
		//tools
        if(ConfigHandler.saltTools) {
            saltTools = new BookEntry(LibBookText.ENTRY_SALT_TOOLS, categoryTools);
            saltTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeSaltPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeSaltAxe), new PageCraftingRecipe("3", ModRecipes.recipeSaltSword), new PageCraftingRecipe("4", ModRecipes.recipeSaltSpade), new PageCraftingRecipe("5", ModRecipes.recipeSaltHoe));
        }

        if(ConfigHandler.ironoxideTools) {
            ironoxideTools = new BookEntry(LibBookText.ENTRY_IRONOXIDE_TOOLS, categoryTools);
            ironoxideTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeIronoxidePickaxe), new PageCraftingRecipe("2", ModRecipes.recipeIronoxideAxe), new PageCraftingRecipe("3", ModRecipes.recipeIronoxideSword), new PageCraftingRecipe("4", ModRecipes.recipeIronoxideSpade), new PageCraftingRecipe("5", ModRecipes.recipeIronoxideHoe));
        }

        if(ConfigHandler.goldoxideTools) {
             goldoxideTools = new BookEntry(LibBookText.ENTRY_GOLDOXIDE_TOOLS, categoryTools);
             goldoxideTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeGoldoxidePickaxe), new PageCraftingRecipe("2", ModRecipes.recipeGoldoxideAxe), new PageCraftingRecipe("3", ModRecipes.recipeGoldoxideSword), new PageCraftingRecipe("4", ModRecipes.recipeGoldoxideSpade), new PageCraftingRecipe("5", ModRecipes.recipeGoldoxideHoe));
        }

        if(ConfigHandler.emeraldTools) {
            emeraldTools = new BookEntry(LibBookText.ENTRY_EMERALD_TOOLS, categoryTools);
            emeraldTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeEmeraldPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeEmeraldAxe), new PageCraftingRecipe("3", ModRecipes.recipeEmeraldSword), new PageCraftingRecipe("4", ModRecipes.recipeEmeraldSpade), new PageCraftingRecipe("5", ModRecipes.recipeEmeraldHoe));
        }

        //armor
        if(ConfigHandler.saltArmor) {
            saltArmor = new BookEntry(LibBookText.ENTRY_SALT_ARMOR, categoryArmor);
            saltArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeSaltHelm), new PageCraftingRecipe("2", ModRecipes.recipeSaltChest), new PageCraftingRecipe("3", ModRecipes.recipeSaltPants), new PageCraftingRecipe("4", ModRecipes.recipeSaltBoots));
        }

        if(ConfigHandler.ironoxideArmor) {
            ironoxideArmor = new BookEntry(LibBookText.ENTRY_IRONOXIDE_ARMOR, categoryArmor);
            ironoxideArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeIronoxideHelm), new PageCraftingRecipe("2", ModRecipes.recipeIronoxideChest), new PageCraftingRecipe("3", ModRecipes.recipeIronoxidePants), new PageCraftingRecipe("4", ModRecipes.recipeIronoxideBoots));
        }

        if(ConfigHandler.goldoxideArmor) {
            goldoxideArmor = new BookEntry(LibBookText.ENTRY_GOLDOXIDE_ARMOR, categoryArmor);
            goldoxideArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeGoldoxideHelm), new PageCraftingRecipe("2", ModRecipes.recipeGoldoxideChest), new PageCraftingRecipe("3", ModRecipes.recipeGoldoxidePants), new PageCraftingRecipe("4", ModRecipes.recipeGoldoxideBoots));
        }

        if(ConfigHandler.emeraldArmor) {
            emeraldArmor = new BookEntry(LibBookText.ENTRY_EMERALD_ARMOR, categoryArmor);
            emeraldArmor.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeEmeraldHelm), new PageCraftingRecipe("2", ModRecipes.recipeEmeraldChest), new PageCraftingRecipe("3", ModRecipes.recipeEmeraldPants), new PageCraftingRecipe("4", ModRecipes.recipeEmeraldBoots));
        }

        //worldgen
        ores = new BookEntry(LibBookText.ENTRY_ORES, categoryWorldgen);
        ores.setPriority().setBookPages(new PageText("0"));

        biome = new BookEntry(LibBookText.ENTRY_BIOME, categoryWorldgen);
        biome.setPriority().setBookPages(new PageText("0"));

        village = new BookEntry(LibBookText.ENTRY_VILLAGE, categoryWorldgen);
        village.setPriority().setBookPages(new PageText("0"));
    }

}
