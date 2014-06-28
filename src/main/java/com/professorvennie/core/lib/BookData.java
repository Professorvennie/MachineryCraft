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
import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.gui.book.BBookEntry;
import com.professorvennie.core.gui.pages.PageCraftingRecipe;
import com.professorvennie.core.gui.pages.PageImage;
import com.professorvennie.core.gui.pages.PageRecipe;
import com.professorvennie.core.gui.pages.PageText;
import com.professorvennie.core.main.ModRecipes;

public class BookData {
	
	public static BookCategory categoryBasics;
	public static BookCategory categoryMachines;
	public static BookCategory categoryTools;
	public static BookCategory categoryArmor;
	public static BookCategory categoryOregen;
	public static BookCategory categoryMultiBlocks;
	
	//basic
	public static BookEntry basics;
	//machines
	public static BookEntry firstTierMachines;
	public static BookEntry secondTierMachines;
	public static BookEntry thridTierMachines;
	public static BookEntry miscMachines;
	
	//tools
	public static BookEntry saltTools;
	public static BookEntry ironoxideTools;
	public static BookEntry goldoxideTools;
	public static BookEntry emeraldTools;
	
	//armor

	
	public static void init() {
		MachineryCraftAPI.addCategory(categoryBasics = new BookCategory(LibBookText.CATEGORY_BASICS));
		MachineryCraftAPI.addCategory(categoryMachines = new BookCategory(LibBookText.CATEGORY_MACHINES));
		MachineryCraftAPI.addCategory(categoryTools = new BookCategory(LibBookText.CATEGORY_TOOLS));
		MachineryCraftAPI.addCategory(categoryArmor = new BookCategory(LibBookText.CATEGORY_ARMOR));
		MachineryCraftAPI.addCategory(categoryOregen = new BookCategory(LibBookText.CATEGORY_OREGEN));
		MachineryCraftAPI.addCategory(categoryMultiBlocks = new BookCategory(LibBookText.CATEGORY_MULTIBLOCKS));
		
		//basics
		basics = new BBookEntry(LibBookText.ENTRY_BASICS, categoryBasics);
		
		
		//machines
		firstTierMachines = new BBookEntry(LibBookText.ENTRY_FIRST_TIER_MACHINES, categoryMachines);
		firstTierMachines.setPriority();
		
		secondTierMachines = new BBookEntry(LibBookText.ENTRY_SECOND_TIER_MACHINES, categoryMachines);
		secondTierMachines.setPriority();
		
		thridTierMachines = new BBookEntry(LibBookText.ENTRY_THRID_TIER_MACHINES, categoryMachines);
		thridTierMachines.setPriority();
		
		miscMachines = new BBookEntry(LibBookText.ENTRY_MISC_MACHINES ,categoryMachines);
		miscMachines.setPriority();
		
		//tools
		saltTools = new BBookEntry(LibBookText.ENTRY_SALT_TOOLS, categoryTools);
		saltTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeSaltPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeSaltAxe), new PageCraftingRecipe("3", ModRecipes.recipeSaltSword), new PageCraftingRecipe("4", ModRecipes.recipeSaltSpade), new PageCraftingRecipe("5", ModRecipes.recipeSaltHoe), new PageCraftingRecipe("6", ModRecipes.recipeSaltShears));
		
		ironoxideTools = new BBookEntry(LibBookText.ENTRY_IRONOXIDE_TOOLS, categoryTools);
		ironoxideTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeIronoxidePickaxe), new PageCraftingRecipe("2", ModRecipes.recipeIronoxideAxe), new PageCraftingRecipe("3", ModRecipes.recipeIronoxideSword), new PageCraftingRecipe("4", ModRecipes.recipeIronoxideSpade), new PageCraftingRecipe("5", ModRecipes.recipeIronoxideHoe), new PageCraftingRecipe("6", ModRecipes.recipeIronoxideShears));
		
		goldoxideTools = new BBookEntry(LibBookText.ENTRY_GOLDOXIDE_TOOLS, categoryTools);
		goldoxideTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeGoldoxidePickaxe), new PageCraftingRecipe("2", ModRecipes.recipeGoldoxideAxe), new PageCraftingRecipe("3", ModRecipes.recipeGoldoxideSword), new PageCraftingRecipe("4", ModRecipes.recipeGoldoxideSpade), new PageCraftingRecipe("5", ModRecipes.recipeGoldoxideHoe), new PageCraftingRecipe("6", ModRecipes.recipeGoldoxideShears));
		
		emeraldTools = new BBookEntry(LibBookText.ENTRY_EMERALD_TOOLS, categoryTools);
		emeraldTools.setPriority().setBookPages(new PageText("0"), new PageCraftingRecipe("1", ModRecipes.recipeEmeraldPickaxe), new PageCraftingRecipe("2", ModRecipes.recipeEmeraldAxe), new PageCraftingRecipe("3", ModRecipes.recipeEmeraldSword), new PageCraftingRecipe("4", ModRecipes.recipeEmeraldSpade), new PageCraftingRecipe("5", ModRecipes.recipeEmeraldHoe), new PageCraftingRecipe("6", ModRecipes.recipeEmeraldShears));
		
	}

}
