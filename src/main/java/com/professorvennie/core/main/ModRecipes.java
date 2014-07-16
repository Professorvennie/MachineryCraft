/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.item.armor.ModArmor;
import com.professorvennie.core.item.tools.ModTools;

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
    public static IRecipe recipeSaltGrinder;
	
	//tools
	public static IRecipe recipeSaltPickaxe;
	public static IRecipe recipeSaltAxe;
	public static IRecipe recipeSaltSword;
	public static IRecipe recipeSaltSpade;
	public static IRecipe recipeSaltHoe;

	public static IRecipe recipeIronoxidePickaxe;
	public static IRecipe recipeIronoxideAxe;
	public static IRecipe recipeIronoxideSword;
	public static IRecipe recipeIronoxideSpade;
	public static IRecipe recipeIronoxideHoe;

	public static IRecipe recipeGoldoxidePickaxe;
	public static IRecipe recipeGoldoxideAxe;
	public static IRecipe recipeGoldoxideSword;
	public static IRecipe recipeGoldoxideSpade;
	public static IRecipe recipeGoldoxideHoe;

	public static IRecipe recipeEmeraldPickaxe;
	public static IRecipe recipeEmeraldAxe;
	public static IRecipe recipeEmeraldSword;
	public static IRecipe recipeEmeraldSpade;
	public static IRecipe recipeEmeraldHoe;

	//armor
    public static IRecipe recipeSaltHelm;
    public static IRecipe recipeSaltChest;
    public static IRecipe recipeSaltPants;
    public static IRecipe recipeSaltBoots;

    public static IRecipe recipeIronoxideHelm;
    public static IRecipe recipeIronoxideChest;
    public static IRecipe recipeIronoxidePants;
    public static IRecipe recipeIronoxideBoots;

    public static IRecipe recipeGoldoxideHelm;
    public static IRecipe recipeGoldoxideChest;
    public static IRecipe recipeGoldoxidePants;
    public static IRecipe recipeGoldoxideBoots;

    public static IRecipe recipeEmeraldHelm;
    public static IRecipe recipeEmeraldChest;
    public static IRecipe recipeEmeraldPants;
    public static IRecipe recipeEmeraldBoots;

    //misc
    public static IRecipe recipePlasticPlanks;
    public static IRecipe recipePlasticStairs;
    public static IRecipe recipePlasticSlab;
    public static IRecipe recipePlasticChest;



    public static void init() {
		//machines
		addOreDictRecipe(new ItemStack(ModBlocks.SaltFurnaceIdle),"SSS", "SFS", "SSS", 'S', new ItemStack(ModItems.Ingots, 1, 4), 'F', Blocks.furnace);
		recipeSaltFurnace = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.SaltGrinderIdle), " s ", "sfs", "sss", 's', "ingotSalt", 'f', ModBlocks.SaltFurnaceIdle);
        recipeSaltGrinder = MachineryCraftAPI.getLatestAddedRecipe();
		
		//tools
		//salt tools
        if(ConfigHandler.saltTools) {
            addOreDictRecipe(new ItemStack(ModTools.saltpickaxe), "SSS", " s ", " s ", 'S', "ingotSalt", 's', Items.stick);
            recipeSaltPickaxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.saltaxe), "SS ", "Ss ", " s ", 'S', "ingotSalt", 's', Items.stick);
            recipeSaltAxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.saltsword), " S ", " S ", " s ", 'S', "ingotSalt", 's', Items.stick);
            recipeSaltSword = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.saltspade), " S ", " s ", " s ", 'S', "ingotSalt", 's', Items.stick);
            recipeSaltSpade = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.salthoe), "SS ", " s ", " s ", 'S', "ingotSalt", 's', Items.stick);
            recipeSaltHoe = MachineryCraftAPI.getLatestAddedRecipe();
        }

		//ironoxide tools
        if(ConfigHandler.ironoxideTools) {
            addOreDictRecipe(new ItemStack(ModTools.ironoxidepickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeIronoxidePickaxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.ironoxideaxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeIronoxideAxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.ironoxidesword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeIronoxideSword = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.ironoxidespade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeIronoxideSpade = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.ironoxidehoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeIronoxideHoe = MachineryCraftAPI.getLatestAddedRecipe();
        }

		//goldoxide tools
        if(ConfigHandler.goldoxideTools) {
            addOreDictRecipe(new ItemStack(ModTools.goldoxidepickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
            recipeGoldoxidePickaxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.goldoxideaxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
            recipeGoldoxideAxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.goldoxidesword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
            recipeGoldoxideSword = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.goldoxidespade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
            recipeGoldoxideSpade = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.goldoxidehoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 5), 's', Items.stick);
            recipeGoldoxideHoe = MachineryCraftAPI.getLatestAddedRecipe();
        }

		//emerald tools
        if(ConfigHandler.emeraldTools) {
            addOreDictRecipe(new ItemStack(ModTools.emeraldpickaxe), "SSS", " s ", " s ", 'S', Items.emerald, 's', Items.stick);
            recipeEmeraldPickaxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.emeraldaxe), "SS ", "Ss ", " s ", 'S', Items.emerald, 's', Items.stick);
            recipeEmeraldAxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.emeraldsword), " S ", " S ", " s ", 'S', Items.emerald, 's', Items.stick);
            recipeEmeraldSword = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.emeraldspade), " S ", " s ", " s ", 'S', Items.emerald, 's', Items.stick);
            recipeEmeraldSpade = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.emeraldhoe), "SS ", " s ", " s ", 'S', Items.emerald, 's', Items.stick);
            recipeEmeraldHoe = MachineryCraftAPI.getLatestAddedRecipe();
        }

		//armor

        //salt armor
        if(ConfigHandler.saltArmor) {
            addOreDictRecipe(new ItemStack(ModArmor.salthelment), "sss", "s s", "   ", 's', "ingotSalt");
            recipeSaltHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.saltchest), "s s", "sss", "sss", 's', "ingotSalt");
            recipeSaltChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.saltpants), "sss", "s s", "s s", 's', "ingotSalt");
            recipeSaltPants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.saltboots), "   ", "s s", "s s", 's', "ingotSalt");
            recipeSaltBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //ironoxide armor
        if(ConfigHandler.ironoxideArmor) {
            addOreDictRecipe(new ItemStack(ModArmor.ironoxidehelment), "sss", "s s", "   ", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeIronoxideHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.ironoxidechest), "s s", "sss", "sss", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeIronoxideChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.ironoxidepants), "sss", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeIronoxidePants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.ironoxideboots), "   ", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeIronoxideBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //goldoxide armor
        if(ConfigHandler.goldoxideArmor) {
            addOreDictRecipe(new ItemStack(ModArmor.goldoxidehelment), "sss", "s s", "   ", 's', new ItemStack(ModItems.Ingots, 1, 5));
            recipeGoldoxideHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.goldoxidechest), "s s", "sss", "sss", 's', new ItemStack(ModItems.Ingots, 1, 5));
            recipeGoldoxideChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.goldoxidepants), "sss", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 5));
            recipeGoldoxidePants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.goldoxideboots), "   ", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 5));
            recipeGoldoxideBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //emerald armor
        if(ConfigHandler.emeraldArmor) {
            addOreDictRecipe(new ItemStack(ModArmor.emeraldhelment), "sss", "s s", "   ", 's', Items.emerald);
            recipeEmeraldHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.emeraldchest), "s s", "sss", "sss", 's', Items.emerald);
            recipeEmeraldChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.emeraldpants), "sss", "s s", "s s", 's', Items.emerald);
            recipeEmeraldPants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModArmor.emeraldboots), "   ", "s s", "s s", 's', Items.emerald);
            recipeEmeraldBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }
		//misc
        addShapelessOreDictRecipe(new ItemStack(ModBlocks.plasticPlanks, 4), ModBlocks.plasticLog);
        recipePlasticPlanks = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.plasticStairs, 4), "P  ", "PP ", "PPP", 'P', ModBlocks.plasticPlanks);
        recipePlasticStairs = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.plasticSlabHalf, 6), "   ", "   ", "PPP",'P', ModBlocks.plasticPlanks);
        recipePlasticSlab = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.plasticChest), "PPP", "P P", "PPP",'P', ModBlocks.plasticPlanks);
        recipePlasticChest = MachineryCraftAPI.getLatestAddedRecipe();
	}
	
	
	
	
	
	private static void addOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, recipe));
	}

	private static void addShapelessOreDictRecipe(ItemStack output, Object... recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(output, recipe));
	}
	
	public static void oreDict(){
		for(int i = 0; i < Names.Items.INGOTS.length-2; i++){
			OreDictionary.registerOre(Names.Items.INGOTS[i], new ItemStack(ModItems.Ingots, 1, i));
		}
		OreDictionary.registerOre("oreSalt", new ItemStack(ModBlocks.Saltore));
		
		for(int i = 0; i < Names.Blocks.ORES.length; i++){
			OreDictionary.registerOre(Names.Blocks.ORES[i], new ItemStack(ModBlocks.BlockOres, 1, i));
		}
	}
	
	public static void addChestLoot(){
		
	}
}
