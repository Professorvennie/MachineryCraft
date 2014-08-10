/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block;

import com.professorvennie.core.block.slabs.*;
import com.professorvennie.core.block.stairs.*;
import com.professorvennie.core.item.itemblock.ItemBlockWalls;
import com.professorvennie.core.lib.Names;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;

import com.professorvennie.core.item.itemblock.ItemBlockWasher;
import com.professorvennie.core.main.utils.RegistryUtils;


public class ModBlocks {
	
	public static void mainRegistry(){
		InitialiseBlock();
		registerBlock();
	}

    public static Block BlockOres;
	public static Block BlockMetals;
	public static Block windmill;
	public static Block windmillground;

	public static Block copperFurnaceIdle;
	public static Block copperFurnaceActive;
	public static Block copperGrinderIdle;
	public static Block copperGrinderActive;

	public static Block ironOxideGrinderIdle;
	public static Block ironOxideGrinderActive;
	public static Block ironOxideFurnaceIdle;
	public static Block ironOxideFurnaceActive;
	public static Block ironOxideAlloyIdle;
	public static Block ironOxideAlloyActive;

	public static Block goldOxideGrinderIdle;
	public static Block goldOxideGrinderActive;
	public static Block goldOxideFurnaceIdle;
	public static Block goldOxideFurnaceActive;
	public static Block goldOxideAlloyIdle;
	public static Block goldOxideAlloyActive;
	public static Block washer;

	public static Block cable;

	public static Block plasticLog;
	public static Block plasticLeaf;
	public static Block plasticSapling;
    public static Block plasticFlower;
    public static Block plasticGrass;
    public static Block plasticDirt;
    public static Block plasticPlanks;
    public static Block plasticStairs;
    public static Block plasticSlabHalf;
    public static Block plasticSlabDouble;
    public static Block plasticChest;
    public static Block plasticFence;
    public static Block plasticFenceGate;
    public static Block portableCobbleGen;

    public static Block bronzeSteamBoiler;
    public static Block bronzeFurnace;
    public static Block bronzeGrinderIdle;
    public static Block bronzeGrinderActive;
    public static Block bronzeExtractor;
    public static Block steamPipe;

    public static Block metalWalls;
    public static Block copperStairs;
    public static Block bronzeStairs;
    public static Block tinStairs;
    public static Block silverStairs;
    public static Block leadStairs;
    public static Block zincStairs;
    public static Block brassStairs;

    public static Block copperSlabHalf;
    public static Block copperSlabDouble;
    public static Block bronzeSlabHalf;
    public static Block bronzeSlabDouble;
    public static Block tinSlabHalf;
    public static Block tinSlabDouble;
    public static Block silverSlabHalf;
    public static Block silverSlabDouble;
    public static Block leadSlabHalf;
    public static Block leadSlabDouble;
    public static Block zincSlabHalf;
    public static Block zincSlabDouble;
    public static Block brassSlabHalf;
    public static Block brassSlabDouble;

	public static void InitialiseBlock(){
		BlockOres = new BlockOres();
		BlockMetals = new BlockMetals();
		windmill = new BlockWindmill();
		windmillground = new BlockWindmillGround();
	
		copperFurnaceIdle = new BlockCopperFurnace(false);
		copperFurnaceActive = new BlockCopperFurnace(true);
		copperGrinderIdle = new BlockCopperGrinder(false);
		copperGrinderActive = new BlockCopperGrinder(true);
		
		ironOxideGrinderIdle = new BlockIronoxideGrinder(false);
		ironOxideGrinderActive = new BlockIronoxideGrinder(true);
		ironOxideFurnaceIdle = new BlockIronoxideFurnace(false);
		ironOxideFurnaceActive = new BlockIronoxideFurnace(true);
		ironOxideAlloyIdle = new BlockIronoxideAlloy(false);
		ironOxideAlloyActive = new BlockIronoxideAlloy(true);
		
		goldOxideGrinderIdle = new BlockGoldoxideGrinder(false);
		goldOxideGrinderActive = new BlockGoldoxideGrinder(true);
		goldOxideFurnaceIdle = new BlockGoldoxideFurnace(false);
		goldOxideFurnaceActive = new BlockGoldoxideFurnace(true);
		goldOxideAlloyIdle = new BlockGoldoxideAlloy(false);
		goldOxideAlloyActive = new BlockGoldoxideAlloy(true);
		
		washer = new BlockWasher();
		cable = new BlockCable();
		plasticLog = new BlockPlasticLog();
		plasticLeaf = new BlockPlasticLeave();
		plasticSapling = new BlockPlasticSapling();
        plasticFlower = new BlockPlasticFlower();
        plasticGrass = new BlockPlasticGrass();
        plasticDirt = new BlockPlasticDirt();
        plasticPlanks = new BlockPlasticPlanks();
        plasticStairs = new BlockPlasticStairs(plasticPlanks);
        plasticSlabHalf = new BlockPlasticSlab(false);
        plasticSlabDouble = new BlockPlasticSlab(true);
        plasticChest = new BlockPlasticChest();
        plasticFence = new BlockPlasticFence();
        plasticFenceGate = new BlockPlasticFenceGate();

        portableCobbleGen = new BlockPortableCobbleGen();

        bronzeSteamBoiler = new BlockBronzeSteamBoiler();
        bronzeFurnace = new BlockBronzeFurnace(false);
        bronzeGrinderIdle = new BlockBronzeGrinder(false);
        bronzeGrinderActive = new BlockBronzeGrinder(true);
        bronzeExtractor = new BlockBronzeExtractor();
        steamPipe = new BlockSteamPipe();

        //stairs
       copperStairs = new BlockCopperStairs(BlockMetals, Names.Blocks.COPPER_STAIRS);
       bronzeStairs = new BlockBronzeStairs(BlockMetals, Names.Blocks.BRONZE_STAIRS);
       tinStairs = new BlockTinStairs(BlockMetals, Names.Blocks.TIN_STAIRS);
       silverStairs = new BlockSilverStairs(BlockMetals, Names.Blocks.SILVER_STAIRS);
       leadStairs = new BlockLeadStairs(BlockMetals, Names.Blocks.LEAD_STAIRS);
       zincStairs = new BlockZincStairs(BlockMetals, Names.Blocks.ZINC_STAIRS);
       brassStairs = new BlockBrassStairs(BlockMetals, Names.Blocks.BRASS_STAIRS);

       copperSlabHalf = new BlockCopperSlab(Names.Blocks.COPPER_SLAB, false);
       copperSlabDouble = new BlockCopperSlab(Names.Blocks.COPPER_SLAB, true);
       bronzeSlabHalf = new BlockBronzeSlab(Names.Blocks.BRONZE_SLAB, false);
       bronzeSlabDouble = new BlockBronzeSlab(Names.Blocks.BRONZE_SLAB, true);
       tinSlabHalf = new BlockTinSlab(Names.Blocks.TIN_SLAB, false);
       tinSlabDouble = new BlockTinSlab(Names.Blocks.TIN_SLAB, true);
       silverSlabHalf = new BlockSilverSlab(Names.Blocks.SILVER_SLAB, false);
       silverSlabDouble = new BlockSilverSlab(Names.Blocks.SILVER_SLAB, true);
       leadSlabHalf = new BlockLeadSlab(Names.Blocks.LEAD_SLAB, false);
       leadSlabDouble = new BlockLeadSlab(Names.Blocks.LEAD_SLAB, true);
       zincSlabHalf = new BlockZincSlab(Names.Blocks.ZINC_SLAB, false);
       zincSlabDouble = new BlockZincSlab(Names.Blocks.ZINC_SLAB, true);
       brassSlabHalf = new BlockBrassSlab(Names.Blocks.BRASS_SLAB, false);
       brassSlabDouble = new BlockBrassSlab(Names.Blocks.BRASS_SLAB, true);

        metalWalls = new BlockMetalWalls();
	}

	public static void registerBlock(){
		RegistryUtils.registerBlock(BlockOres, BlockOres.ItemBlockOres.class);
		RegistryUtils.registerBlock(BlockMetals, BlockMetals.ItemBlockMetals.class);
		RegistryUtils.registerBlock(copperFurnaceIdle);
		RegistryUtils.registerBlock(copperFurnaceActive);
		RegistryUtils.registerBlock(copperGrinderIdle);
		RegistryUtils.registerBlock(copperGrinderActive);
		RegistryUtils.registerBlock(windmill);
		RegistryUtils.registerBlock(windmillground);
		RegistryUtils.registerBlock(ironOxideGrinderIdle);
		RegistryUtils.registerBlock(ironOxideGrinderActive);
		RegistryUtils.registerBlock(ironOxideFurnaceIdle);
		RegistryUtils.registerBlock(ironOxideFurnaceActive);
		RegistryUtils.registerBlock(ironOxideAlloyIdle);
		RegistryUtils.registerBlock(ironOxideAlloyActive);
		RegistryUtils.registerBlock(goldOxideGrinderIdle);
		RegistryUtils.registerBlock(goldOxideGrinderActive);
		RegistryUtils.registerBlock(goldOxideFurnaceIdle);
		RegistryUtils.registerBlock(goldOxideFurnaceActive);
        RegistryUtils.registerBlock(goldOxideAlloyIdle);
        RegistryUtils.registerBlock(goldOxideAlloyActive);
		RegistryUtils.registerBlock(cable);
		RegistryUtils.registerBlock(washer, ItemBlockWasher.class);
		RegistryUtils.registerBlock(plasticLog);
		RegistryUtils.registerBlock(plasticLeaf);
		RegistryUtils.registerBlock(plasticSapling);
        RegistryUtils.registerBlock(plasticFlower);
        RegistryUtils.registerBlock(plasticGrass);
        RegistryUtils.registerBlock(plasticDirt);
        RegistryUtils.registerBlock(plasticPlanks);
        RegistryUtils.registerBlock(plasticChest);
        RegistryUtils.registerBlock(portableCobbleGen);
        RegistryUtils.registerBlock(bronzeExtractor);
        RegistryUtils.registerBlock(bronzeFurnace);
        RegistryUtils.registerBlock(bronzeGrinderIdle);
        RegistryUtils.registerBlock(bronzeGrinderActive);
        RegistryUtils.registerBlock(bronzeSteamBoiler);
        RegistryUtils.registerBlock(plasticFence);
        RegistryUtils.registerBlock(plasticFenceGate);
        RegistryUtils.registerBlock(metalWalls, ItemBlockWalls.class);
        RegistryUtils.registerBlock(steamPipe);

        ((BlockModSlab)copperSlabHalf).register();
        ((BlockModSlab)copperSlabDouble).register();
        ((BlockModSlab)bronzeSlabHalf).register();
        ((BlockModSlab)bronzeSlabDouble).register();
        ((BlockModSlab)tinSlabHalf).register();
        ((BlockModSlab)tinSlabDouble).register();
        ((BlockModSlab)silverSlabHalf).register();
        ((BlockModSlab)silverSlabDouble).register();
        ((BlockModSlab)leadSlabHalf).register();
        ((BlockModSlab)leadSlabDouble).register();
        ((BlockModSlab)zincSlabHalf).register();
        ((BlockModSlab)zincSlabDouble).register();
        ((BlockModSlab)brassSlabHalf).register();
        ((BlockModSlab)brassSlabDouble).register();
        ((BlockModSlab)plasticSlabHalf).register();
        ((BlockModSlab)plasticSlabDouble).register();
	}
}
