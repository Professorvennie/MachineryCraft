/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.recipes;

import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.core.config.ConfigHandler;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.items.tools.ModTools;
import com.professorvennie.machinerycraft.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.Random;

public class ModRecipes {

    //machines
    public static IRecipe recipeCopperFurnace;
    public static IRecipe recipeCopperGrinder;
    public static IRecipe recipePortableCobbleGen;
    //tools
    public static IRecipe recipeZincPickaxe;
    public static IRecipe recipeZincAxe;
    public static IRecipe recipeZincSword;
    public static IRecipe recipeZincSpade;
    public static IRecipe recipeZincHoe;
    public static IRecipe recipeBrassPickaxe;
    public static IRecipe recipeBrassAxe;
    public static IRecipe recipeBrassSword;
    public static IRecipe recipeBrassSpade;
    public static IRecipe recipeBrassHoe;
    public static IRecipe recipeEmeraldPickaxe;
    public static IRecipe recipeEmeraldAxe;
    public static IRecipe recipeEmeraldSword;
    public static IRecipe recipeEmeraldSpade;
    public static IRecipe recipeEmeraldHoe;
    //armor
    public static IRecipe recipeZincHelm;
    public static IRecipe recipeZincChest;
    public static IRecipe recipeZincPants;
    public static IRecipe recipeZincBoots;
    public static IRecipe recipeBrassHelm;
    public static IRecipe recipeBrassChest;
    public static IRecipe recipeBrassPants;
    public static IRecipe recipeBrassBoots;
    public static IRecipe recipeEmeraldHelm;
    public static IRecipe recipeEmeraldChest;
    public static IRecipe recipeEmeraldPants;
    public static IRecipe recipeEmeraldBoots;
    //misc
    public static IRecipe recipePlasticPlanks;
    public static IRecipe recipePlasticStairs;
    public static IRecipe recipePlasticSlab;
    public static IRecipe recipePlasticChest;
    //nuggets
    public static IRecipe recipeStoneNugget;
    public static IRecipe recipeZincNugget;
    public static IRecipe recipeIronNugget;
    public static IRecipe recipeCopperNugget;
    public static IRecipe recipeTinNugget;
    public static IRecipe recipeSilverNugget;
    public static IRecipe recipeLeadNugget;
    public static IRecipe recipeBronzeNugget;
    public static IRecipe recipeBrassNugget;
    //gears
    public static IRecipe recipeWoodGear;
    public static IRecipe recipeStoneGear;
    public static IRecipe recipeIronGear;
    public static IRecipe recipeCopperGear;
    public static IRecipe recipeTinGear;
    public static IRecipe recipeBronzeGear;
    public static IRecipe recipeZincGear;
    public static IRecipe recipeSilverGear;
    public static IRecipe recipeLeadGear;
    public static IRecipe recipeBrassGear;
    public static IRecipe recipeGoldGear;
    //backPacks
    public static IRecipe recipeWoodenBag;
    public static IRecipe recipeTinBag;
    public static IRecipe recipeCopperBag;
    public static IRecipe recipeZincBag;
    public static IRecipe recipeIronBag;
    public static IRecipe recipeSilverBag;
    public static IRecipe recipeLeadBag;
    public static IRecipe recipeGoldBag;
    public static IRecipe recipeDiamondBag;

    private static Random random = new Random();

    public static void init() {
        //machines
        addOreDictRecipe(new ItemStack(ModBlocks.copperFurnaceIdle), " S ", "SFS", "SGS", 'S', "ingotCopper", 'F', Blocks.furnace, 'G', new ItemStack(ModItems.gears, 1, 3));
        recipeCopperFurnace = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.copperGrinderIdle), " s ", "sfs", "sGs", 's', "ingotCopper", 'f', ModBlocks.copperFurnaceIdle, 'G', new ItemStack(ModItems.gears, 1, 3));
        recipeCopperGrinder = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.portableCobbleGen), "CCC", "CSC", "CGC", 'C', Blocks.cobblestone, 'S', new ItemStack(ModItems.gears, 1, 1), 'G', new ItemStack(ModItems.gears, 1, 0));
        recipePortableCobbleGen = MachineryCraftAPI.getLatestAddedRecipe();

        //bags
        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 0), " W ", "WCW", "WGW", 'W', Blocks.planks, 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 0));
        recipeWoodenBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 1), " W ", "WCW", "WGW", 'W', "ingotTin", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 4));
        recipeTinBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 2), " W ", "WCW", "WGW", 'W', "ingotCopper", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 3));
        recipeCopperBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 3), " W ", "WCW", "WGW", 'W', "ingotZinc", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 6));
        recipeZincBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 4), " W ", "WCW", "WGW", 'W', "ingotIron", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 2));
        recipeIronBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 5), " W ", "WCW", "WGW", 'W', "ingotSilver", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 7));
        recipeSilverBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 6), " W ", "WCW", "WGW", 'W', "ingotLead", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 8));
        recipeLeadBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 7), " W ", "WCW", "WGW", 'W', "ingotGold", 'C', Blocks.chest, 'G', new ItemStack(ModItems.gears, 1, 10));
        recipeGoldBag = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.bags, 1, 8), " W ", "WCW", "WWW", 'W', Items.diamond, 'C', Blocks.chest);
        recipeDiamondBag = MachineryCraftAPI.getLatestAddedRecipe();

        //tools
        //zinc tools
        if (ConfigHandler.zincTools) {
            addOreDictRecipe(new ItemStack(ModTools.zincPickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
            recipeZincPickaxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.zincAxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
            recipeZincAxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.zincSword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
            recipeZincSword = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.zincSpade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
            recipeZincSpade = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.zincHoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 4), 's', Items.stick);
            recipeZincHoe = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //brass tools
        if (ConfigHandler.brassTools) {
            addOreDictRecipe(new ItemStack(ModTools.brassPickaxe), "SSS", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeBrassPickaxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.brassAxe), "SS ", "Ss ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeBrassAxe = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.brassSword), " S ", " S ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeBrassSword = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.brassSpade), " S ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeBrassSpade = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModTools.brassHoe), "SS ", " s ", " s ", 'S', new ItemStack(ModItems.Ingots, 1, 6), 's', Items.stick);
            recipeBrassHoe = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //emerald tools
        if (ConfigHandler.emeraldTools) {
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
        //zinc armor
        if (ConfigHandler.zincArmor) {
            addOreDictRecipe(new ItemStack(ModItems.zincHemlent), "sss", "s s", "   ", 's', new ItemStack(ModItems.Ingots, 1, 4));
            recipeZincHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.zincChest), "s s", "sss", "sss", 's', new ItemStack(ModItems.Ingots, 1, 4));
            recipeZincChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.zincPants), "sss", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 4));
            recipeZincPants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.zincBoots), "   ", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 4));
            recipeZincBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //brass armor
        if (ConfigHandler.brassArmor) {
            addOreDictRecipe(new ItemStack(ModItems.brassHelment), "sss", "s s", "   ", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeBrassHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.brassChest), "s s", "sss", "sss", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeBrassChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.brassPants), "sss", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeBrassPants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.brassBoots), "   ", "s s", "s s", 's', new ItemStack(ModItems.Ingots, 1, 6));
            recipeBrassBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }

        //emerald armor
        if (ConfigHandler.emeraldArmor) {
            addOreDictRecipe(new ItemStack(ModItems.emeraldhelment), "sss", "s s", "   ", 's', Items.emerald);
            recipeEmeraldHelm = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.emeraldchest), "s s", "sss", "sss", 's', Items.emerald);
            recipeEmeraldChest = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.emeraldpants), "sss", "s s", "s s", 's', Items.emerald);
            recipeEmeraldPants = MachineryCraftAPI.getLatestAddedRecipe();

            addOreDictRecipe(new ItemStack(ModItems.emeraldboots), "   ", "s s", "s s", 's', Items.emerald);
            recipeEmeraldBoots = MachineryCraftAPI.getLatestAddedRecipe();
        }
        //misc
        addShapelessOreDictRecipe(new ItemStack(ModBlocks.plasticPlanks, 4), ModBlocks.plasticLog);
        recipePlasticPlanks = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.plasticStairs, 4), "P  ", "PP ", "PPP", 'P', ModBlocks.plasticPlanks);
        recipePlasticStairs = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.plasticSlabHalf, 6), "   ", "   ", "PPP", 'P', ModBlocks.plasticPlanks);
        recipePlasticSlab = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModBlocks.plasticChest), "PPP", "P P", "PPP", 'P', ModBlocks.plasticPlanks);
        recipePlasticChest = MachineryCraftAPI.getLatestAddedRecipe();


        //nuggets
        addOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 0), " S ", " S ", " S ", 'S', Blocks.stone);
        recipeStoneNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 1), new ItemStack(ModItems.Ingots, 1, 4));
        recipeZincNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 2), Items.iron_ingot);
        recipeIronNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 3), new ItemStack(ModItems.Ingots, 0, 0));
        recipeCopperNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 4), new ItemStack(ModItems.Ingots, 1, 1));
        recipeTinNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 5), new ItemStack(ModItems.Ingots, 1, 2));
        recipeSilverNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 6), new ItemStack(ModItems.Ingots, 1, 3));
        recipeLeadNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 7), new ItemStack(ModItems.Ingots, 1, 6));
        recipeBronzeNugget = MachineryCraftAPI.getLatestAddedRecipe();

        addShapelessOreDictRecipe(new ItemStack(ModItems.nuggets, 9, 8), new ItemStack(ModItems.Ingots, 1, 5));
        recipeBrassNugget = MachineryCraftAPI.getLatestAddedRecipe();


        //gears
        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 0), " N ", "NIN", " N ", 'N', Items.stick, 'I', Blocks.planks);
        recipeWoodGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 1), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 0), 'I', Blocks.stone);
        recipeStoneGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 2), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 2), 'I', Items.iron_ingot);
        recipeIronGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 3), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 3), 'I', new ItemStack(ModItems.Ingots, 1, 0));
        recipeCopperGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 4), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 4), 'I', new ItemStack(ModItems.Ingots, 1, 1));
        recipeTinGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 5), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 7), 'I', new ItemStack(ModItems.Ingots, 1, 6));
        recipeBronzeGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 6), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 1), 'I', new ItemStack(ModItems.Ingots, 1, 4));
        recipeZincGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 7), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 5), 'I', new ItemStack(ModItems.Ingots, 1, 2));
        recipeSilverGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 8), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 6), 'I', new ItemStack(ModItems.Ingots, 1, 3));
        recipeLeadGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 9), " N ", "NIN", " N ", 'N', new ItemStack(ModItems.nuggets, 1, 8), 'I', new ItemStack(ModItems.Ingots, 1, 5));
        recipeBrassGear = MachineryCraftAPI.getLatestAddedRecipe();

        addOreDictRecipe(new ItemStack(ModItems.gears, 1, 10), " N ", "NIN", " N ", 'N', Items.gold_nugget, 'I', Items.gold_ingot);
        recipeGoldGear = MachineryCraftAPI.getLatestAddedRecipe();

        addSmelting();
        addGrindingRecipes();
        addExtractingRecipes();
    }

    private static void addOreDictRecipe(ItemStack output, Object... recipe) {
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(output, recipe));
    }

    private static void addShapelessOreDictRecipe(ItemStack output, Object... recipe) {
        CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(output, recipe));
    }

    public static void oreDict() {
        for (int i = 0; i < Names.Items.INGOTS.length; i++) {
            OreDictionary.registerOre(Names.Items.INGOTS[i], new ItemStack(ModItems.Ingots, 1, i));
        }

        for (int i = 0; i < Names.Blocks.ORES.length; i++) {
            OreDictionary.registerOre(Names.Blocks.ORES[i], new ItemStack(ModBlocks.BlockOres, 1, i));
        }

        for (int i = 0; i < Names.Items.NUGGETS.length; i++) {
            OreDictionary.registerOre(Names.Items.NUGGETS[i], new ItemStack(ModItems.nuggets, 1, i));
        }

        for (int i = 0; i < Names.Items.DUSTS.length; i++) {
            OreDictionary.registerOre(Names.Items.DUSTS[i], new ItemStack(ModItems.Dusts, 1, i));
        }
    }

    public static void addChestLoot() {

    }

    private static void addSmelting() {
/*iron*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 0), new ItemStack(Items.iron_ingot, 1), 0.8f);
/*gold*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 1), new ItemStack(Items.gold_ingot, 1), 0.8f);
/*tin*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 2), new ItemStack(ModItems.Ingots, 1, 1), 0.8f);
/*silver*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 3), new ItemStack(ModItems.Ingots, 1, 2), 0.8f);
/*lead*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 4), new ItemStack(ModItems.Ingots, 1, 3), 0.8f);
/*copper*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 5), new ItemStack(ModItems.Ingots, 1, 0), 0.8f);
/*zinc*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 6), new ItemStack(ModItems.Ingots, 1, 4), 0.8f);
/*brass*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 7), new ItemStack(ModItems.Ingots, 1, 5), 0.8f);
/*bronze*/
        GameRegistry.addSmelting(new ItemStack(ModItems.Dusts, 1, 8), new ItemStack(ModItems.Ingots, 1, 6), 0.8f);

/*copper*/
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BlockOres, 1, 0), new ItemStack(ModItems.Ingots, 1, 0), 0.8f);
/*tin*/
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BlockOres, 1, 1), new ItemStack(ModItems.Ingots, 1, 1), 0.8f);
/*silver*/
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BlockOres, 1, 2), new ItemStack(ModItems.Ingots, 1, 2), 0.8f);
/*lead*/
        GameRegistry.addSmelting(new ItemStack(ModBlocks.BlockOres, 1, 3), new ItemStack(ModItems.Ingots, 1, 3), 0.8f);
    }

    private static void addGrindingRecipes() {
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.iron_ore), new ItemStack(ModItems.Dusts, 2, 0), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.gold_ore), new ItemStack(ModItems.Dusts, 2, 1), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(ModBlocks.BlockOres, 1, 0), new ItemStack(ModItems.Dusts, 2, 5), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(ModBlocks.BlockOres, 1, 1), new ItemStack(ModItems.Dusts, 2, 2), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(ModBlocks.BlockOres, 1, 2), new ItemStack(ModItems.Dusts, 2, 3), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(ModBlocks.BlockOres, 1, 3), new ItemStack(ModItems.Dusts, 2, 4), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.diamond_ore), new ItemStack(Items.diamond, 2), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.redstone_ore), new ItemStack(Items.redstone, 6 + random.nextInt(2)), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.emerald_ore), new ItemStack(Items.emerald, 2), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.quartz_ore), new ItemStack(Items.quartz, 6 + random.nextInt(2)), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.lapis_ore), new ItemStack(Items.dye, 6 + random.nextInt(2), 4), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.coal_ore), new ItemStack(Items.coal, 5 + random.nextInt(2)), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.sand), 0.8f);
        MachineryCraftAPI.registerGrinderRecipe(new ItemStack(Items.blaze_rod), new ItemStack(Items.blaze_powder, 4), 0.8f);
    }

    private static void addExtractingRecipes() {
        MachineryCraftAPI.registerExtractorRecipe(new ItemStack(ModBlocks.BlockOres, 1, 4), new ItemStack(ModItems.Dusts, 2 + random.nextInt(1), 6), 0.8f);
    }
}
