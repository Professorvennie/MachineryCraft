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

import net.minecraft.block.Block;

import com.professorvennie.core.item.itemblock.ItemBlockWasher;
import com.professorvennie.core.main.utils.RegistryUtils;

public class ModBlocks {
	
	public static void mainRegistry(){
		InitialiseBlock();
		registerBlock();
	}

	public static Block BlockOres;
	public static Block Saltore;
	public static Block BlockMetals;
	public static Block windmill;
	public static Block windmillground;
	public static Block SaltFurnaceIdle;
	public static Block SaltFurnaceActive;
	public static Block SaltGrinderIdle;
	public static Block SaltGrinderActive;
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

	public static void InitialiseBlock(){
		BlockOres = new BlockOres();
		Saltore = new BlockSaltOre();
		BlockMetals = new BlockMetals();
		windmill = new BlockWindmill();
		windmillground = new BlockWindmillGround();
	
		SaltFurnaceIdle = new BlockSaltFurnace(false);
		SaltFurnaceActive = new BlockSaltFurnace(true);
		SaltGrinderIdle = new BlockSaltGrinder(false);
		SaltGrinderActive = new BlockSaltGrinder(true);
		
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
	}
	
	public static void registerBlock(){
		RegistryUtils.registerBlock(BlockOres, BlockOres.ItemBlockOres.class);
		RegistryUtils.registerBlock(Saltore);
		RegistryUtils.registerBlock(BlockMetals, BlockMetals.ItemBlockMetals.class);
		RegistryUtils.registerBlock(SaltFurnaceIdle);
		RegistryUtils.registerBlock(SaltFurnaceActive);
		RegistryUtils.registerBlock(SaltGrinderIdle);
		RegistryUtils.registerBlock(SaltGrinderActive);
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
        RegistryUtils.registerBlock(plasticStairs);
        RegistryUtils.registerBlock(plasticSlabHalf, ItemPlasticSlab.class);
        RegistryUtils.registerBlock(plasticSlabDouble, ItemPlasticSlab.class);
        RegistryUtils.registerBlock(plasticChest);
	}
	
}
