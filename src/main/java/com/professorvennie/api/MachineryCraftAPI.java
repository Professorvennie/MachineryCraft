package com.professorvennie.api;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.util.EnumHelper;

import com.professorvennie.api.book.BookCategory;
import com.professorvennie.api.book.BookEntry;

public class MachineryCraftAPI {
	//Armor Materials
	public static ArmorMaterial saltArmorMaterial = EnumHelper.addArmorMaterial("saltarmormaterial", 16, new int[]{3, 7, 5, 3}, 10);
	public static ArmorMaterial ironoxideArmorMaterial = EnumHelper.addArmorMaterial("ironoxidearmormaterial", 20, new int[]{3, 6, 3, 3}, 15);
	public static ArmorMaterial goldoxideArmorMaterial = EnumHelper.addArmorMaterial("goldoxidearmormaterial", 13, new int[]{3, 6, 4, 2}, 30);
	public static ArmorMaterial emeraldArmorMaterial = EnumHelper.addArmorMaterial("emeraldArmorMaterial", 40, new int[]{4, 10, 8, 4}, 18);
	//Tool Materials
	public static ToolMaterial saltToolMaterial = EnumHelper.addToolMaterial("saltmaterial", 2, 100, 14.0f, 3.0f, 14);
	public static ToolMaterial ironoxideToolMaterial = EnumHelper.addToolMaterial("ironoxidematerial", 3, 350, 12.0f, 5.0f, 16);
	public static ToolMaterial goldoxideToolMaterial = EnumHelper.addToolMaterial("goldoxidetoolmaterial", 1, 150, 16.0f, 5.0f, 26);
	public static ToolMaterial emeraldToolMaterial = EnumHelper.addToolMaterial("emeraldToolmaterial", 3, 2000, 10.0F, 5.0F, 15);
	
	private static List<BookCategory> categories = new ArrayList<BookCategory>();
	private static List<BookEntry> allEntries = new ArrayList<BookEntry>();
	
	public static List<BookCategory> getAllCategories() {
		return categories;
	}

	/**
	 * Registers a Lexicon Entry and adds it to the category passed in.
	 */
	public static void addEntry(BookEntry entry, BookCategory category) {
		allEntries.add(entry);
		category.entries.add(entry);
	}
	
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
		for(int i = x - 1; i >= 0; i--)
			newList.add(list.get(list.size() - 1 - i));

		return newList;
	}
	
}
