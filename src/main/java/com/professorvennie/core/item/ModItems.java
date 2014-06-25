package com.professorvennie.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.item.armor.ModArmor;
import com.professorvennie.core.item.armor.goldoxide.GoldoxideArmor;
import com.professorvennie.core.item.armor.ironoxide.IronoxideArmor;
import com.professorvennie.core.item.armor.salt.SaltArmor;
import com.professorvennie.core.item.tools.ModTools;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldAxe;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldHoe;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldPickaxe;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldShovel;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldSword;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideAxe;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideHoe;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxidePickaxe;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideShovel;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideSword;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideAxe;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideHoe;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxidePickaxe;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideShovel;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideSword;
import com.professorvennie.core.item.tools.salt.ItemSaltAxe;
import com.professorvennie.core.item.tools.salt.ItemSaltHoe;
import com.professorvennie.core.item.tools.salt.ItemSaltPickaxe;
import com.professorvennie.core.item.tools.salt.ItemSaltShovel;
import com.professorvennie.core.item.tools.salt.ItemSaltSword;
import com.professorvennie.core.lib.LibNames;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.MainRegistry;
import com.professorvennie.core.main.creativetab.CreativeTabsExtraFood;
import com.professorvennie.core.main.utils.RegistryUtils;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static void mainRegistry(){
		InitialiseItem();
		registerItem();
		ModTools.mainRegistry();
		ModArmor.mainRegistry();
	}
	
	//misc.
	public static Item saltcyrstals;
	public static Item speedupgrade;
	public static Item powerboost;
	public static Item efficiency;
	public static Item Itemwindmill;
	public static Item Dusts;
	public static Item Ingots;
	public static Item book;
	
	public static void InitialiseItem(){
		//Random items
		saltcyrstals = new Item().setUnlocalizedName(LibNames.saltcyrstals).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID + ":saltcyrstals");
		Itemwindmill = new ItemWindmill().setUnlocalizedName(LibNames.Itemwindmill).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName("diamond");
		Dusts = new ItemDusts();
		Ingots = new ItemIngots();
		book = new ItemBook();
		
		//upgrades
		speedupgrade = new ItemSpeedUpgrade().setUnlocalizedName(LibNames.speedupgrade).setCreativeTab(MainRegistry.tabMachineryCraft).setMaxStackSize(2).setTextureName(LibStrings.MODID + ":speedupgrade");
		powerboost = new Item().setUnlocalizedName(LibNames.powerboost).setCreativeTab(MainRegistry.tabMachineryCraft).setMaxStackSize(1).setTextureName(LibStrings.MODID + ":powerboost");
		efficiency = new Item().setUnlocalizedName(LibNames.efficiency).setCreativeTab(MainRegistry.tabMachineryCraft).setMaxStackSize(2).setTextureName(LibStrings.MODID + ":");
	}
	
	
	public static void registerItem(){
		RegistryUtils.registerItem(saltcyrstals);	
		RegistryUtils.registerItem(Ingots);
		RegistryUtils.registerItem(speedupgrade);
		RegistryUtils.registerItem(powerboost);
		RegistryUtils.registerItem(efficiency);
		RegistryUtils.registerItem(Itemwindmill);
		RegistryUtils.registerItem(Dusts);
		RegistryUtils.registerItem(book);
	}
}

;