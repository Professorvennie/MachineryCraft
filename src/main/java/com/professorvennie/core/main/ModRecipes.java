package com.professorvennie.core.main;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.item.tools.ModTools;
import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.ItemNames;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
	//machines
	public static IRecipe recipeSaltFurnace;
	
	
	//tools
	public static IRecipe recipeSaltPickaxe;
	public static IRecipe recipeSaltAxe;
	public static IRecipe recipeSaltSword;
	public static IRecipe recipeSaltSpade;
	public static IRecipe recipeSaltHoe;
	public static IRecipe recipeSaltShears;
	
	public static IRecipe recipeIronoxidePickaxe;
	public static IRecipe recipeIronoxideAxe;
	public static IRecipe recipeIronoxideSword;
	public static IRecipe recipeIronoxideSpade;
	public static IRecipe recipeIronoxideHoe;
	public static IRecipe recipeIronoxideShears;
	
	public static IRecipe recipeGoldoxidePickaxe;
	public static IRecipe recipeGoldoxideAxe;
	public static IRecipe recipeGoldoxideSword;
	public static IRecipe recipeGoldoxideSpade;
	public static IRecipe recipeGoldoxideHoe;
	public static IRecipe recipeGoldoxideShears;
	
	public static IRecipe recipeEmeraldPickaxe;
	public static IRecipe recipeEmeraldAxe;
	public static IRecipe recipeEmeraldSword;
	public static IRecipe recipeEmeraldSpade;
	public static IRecipe recipeEmeraldHoe;
	public static IRecipe recipeEmeraldShears;
	
	//armor
	
	
	
	public static void init() {
		//machines
		addOreDictRecipe(new ItemStack(ModBlocks.SaltFurnaceIdle),"SSS", "SFS", "SSS", 'S', new ItemStack(ModItems.Ingots, 1, 4), 'F', Blocks.furnace);
		recipeSaltFurnace = MachineryCraftAPI.getLatestAddedRecipe();
		
		//tools
		//salt tools
		addOreDictRecipe(new ItemStack(ModTools.saltpickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
		recipeSaltPickaxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.saltaxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
		recipeSaltAxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.saltsword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
		recipeSaltSword  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.saltspade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
		recipeSaltSpade  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.salthoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
		recipeSaltHoe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.saltshears), "   ", "  S", " S ", 'S', new ItemStack(ModItems.Ingots, 1, 4));
		recipeSaltShears  = MachineryCraftAPI.getLatestAddedRecipe();
		
		//ironoxide tools
		addOreDictRecipe(new ItemStack(ModTools.ironoxidepickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
		recipeIronoxidePickaxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.ironoxideaxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
		recipeIronoxideAxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.ironoxidesword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
		recipeIronoxideSword  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.ironoxidespade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
		recipeIronoxideSpade  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.ironoxidehoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
		recipeIronoxideHoe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.ironoxideshears), "   ", "  S", " S ", 'S', new ItemStack(ModItems.Ingots, 1, 6));
		recipeIronoxideShears  = MachineryCraftAPI.getLatestAddedRecipe();
		
		//goldoxide tools
		addOreDictRecipe(new ItemStack(ModTools.goldoxidepickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
		recipeGoldoxidePickaxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.goldoxideaxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
		recipeGoldoxideAxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.goldoxidesword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
		recipeGoldoxideSword  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.goldoxidespade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
		recipeGoldoxideSpade  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.goldoxidehoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
		recipeGoldoxideHoe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.goldoxideshears), "   ", "  S", " S ", 'S', new ItemStack(ModItems.Ingots, 1, 5));
		recipeGoldoxideShears  = MachineryCraftAPI.getLatestAddedRecipe();
		
		//emerald tools
		addOreDictRecipe(new ItemStack(ModTools.emeraldpickaxe), "SSS", " s ", " s ", 'S', Items.emerald , 's', Items.stick);
		recipeEmeraldPickaxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.emeraldaxe), "SS ", "Ss ", " s ", 'S', Items.emerald, 's', Items.stick);
		recipeEmeraldAxe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.emeraldsword), " S ", " S ", " s ", 'S', Items.emerald, 's', Items.stick);
		recipeEmeraldSword  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.emeraldspade), " S ", " s ", " s ", 'S', Items.emerald, 's', Items.stick);
		recipeEmeraldSpade  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.emeraldhoe), "SS ", " s ", " s ", 'S', Items.emerald, 's', Items.stick);
		recipeEmeraldHoe  = MachineryCraftAPI.getLatestAddedRecipe();
		
		addOreDictRecipe(new ItemStack(ModTools.emeraldshears), "   ", "  S", " S ", 'S', Items.emerald);
		recipeEmeraldShears  = MachineryCraftAPI.getLatestAddedRecipe();
		
		//armor
		
		//misc
	}
	
	
	
	
	
	private static void addOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, recipe));
	}

	private static void addShapelessOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(output, recipe));
	}
	
	public static void oreDict(){
		for(int i = 0; i < ItemNames.Ingots.length-2; i++){
			OreDictionary.registerOre(ItemNames.Ingots[i], new ItemStack(ModItems.Ingots, 1, i));
		}
		OreDictionary.registerOre("oreSalt", new ItemStack(ModBlocks.Saltore));
		
		for(int i = 0; i < BlockNames.BlockOres.length; i++){
			OreDictionary.registerOre(BlockNames.BlockOres[i], new ItemStack(ModBlocks.BlockOres, 1, i));
		}
	}
	
	public static void addChestLoot(){
		
	}
}
