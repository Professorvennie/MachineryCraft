package com.professorvennie.core.item.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldAxe;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldHoe;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldPickaxe;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldShears;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldShovel;
import com.professorvennie.core.item.tools.emerald.ItemEmeraldSword;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideAxe;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideHoe;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxidePickaxe;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideShears;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideShovel;
import com.professorvennie.core.item.tools.goldoxide.ItemGoldoxideSword;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideAxe;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideHoe;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxidePickaxe;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideShears;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideShovel;
import com.professorvennie.core.item.tools.ironoxide.ItemIronoxideSword;
import com.professorvennie.core.item.tools.salt.ItemSaltAxe;
import com.professorvennie.core.item.tools.salt.ItemSaltHoe;
import com.professorvennie.core.item.tools.salt.ItemSaltPickaxe;
import com.professorvennie.core.item.tools.salt.ItemSaltShears;
import com.professorvennie.core.item.tools.salt.ItemSaltShovel;
import com.professorvennie.core.item.tools.salt.ItemSaltSword;
import com.professorvennie.core.lib.LibNames;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.MainRegistry;
import com.professorvennie.core.main.utils.RegistryUtils;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTools {
	
	public static void mainRegistry(){
		init();
		registry();
	}
	//salt tools
	public static Item saltpickaxe;
	public static Item saltaxe;
	public static Item saltsword;
	public static Item salthoe;
	public static Item saltspade;
	public static Item saltshears;
	
	public static Item ironoxidepickaxe;
	public static Item ironoxideaxe;
	public static Item ironoxidesword;
	public static Item ironoxidehoe;
	public static Item ironoxidespade;
	public static Item ironoxideshears;
	
	public static Item emeraldpickaxe;
	public static Item emeraldaxe;
	public static Item emeraldsword;
	public static Item emeraldhoe;
	public static Item emeraldspade;
	public static Item emeraldshears;
	
	public static Item goldoxidepickaxe;
	public static Item goldoxideaxe;
	public static Item goldoxidesword;
	public static Item goldoxidehoe;
	public static Item goldoxidespade;
	public static Item goldoxideshears;

	private static void init() {
		//tools
				saltpickaxe = new ItemSaltPickaxe(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(LibNames.saltpickaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":salt_pickaxe");
				saltaxe = new ItemSaltAxe(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(LibNames.saltaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":salt_axe");
				saltsword = new ItemSaltSword(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(LibNames.saltsword).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":salt_sword");
				salthoe = new ItemSaltHoe(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(LibNames.salthoe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":salt_hoe");
				saltspade = new ItemSaltShovel(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(LibNames.saltspade).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":salt_spade");
				saltshears = new ItemSaltShears().setUnlocalizedName(LibNames.SALT_SHEARS).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID + ":Salt_Shears");
				
				emeraldpickaxe = new ItemEmeraldPickaxe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(LibNames.emeraldpickaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":emerald_pickaxe");
				emeraldaxe = new ItemEmeraldAxe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(LibNames.emeraldaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":emerald_axe");
				emeraldsword = new ItemEmeraldSword(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(LibNames.emeraldsword).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":emerald_sword");
				emeraldhoe = new ItemEmeraldHoe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(LibNames.emeraldhoe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":emerald_hoe");
				emeraldspade = new ItemEmeraldShovel(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(LibNames.emeraldspade).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":emerald_shovel");
				emeraldshears = new ItemEmeraldShears().setUnlocalizedName(LibNames.EMERALD_SHEARS).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID + ":Emerald_Shears");
				
				ironoxidepickaxe = new ItemIronoxidePickaxe(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(LibNames.ironoxidepickaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":ironoxide_pickaxe");
				ironoxideaxe = new ItemIronoxideAxe(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(LibNames.ironoxideaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":ironoxide_axe");
				ironoxidesword = new ItemIronoxideSword(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(LibNames.ironoxidesword).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":ironoxide_sword");
				ironoxidehoe = new ItemIronoxideHoe(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(LibNames.ironoxidehoe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":ironoxide_hoe");
				ironoxidespade = new ItemIronoxideShovel(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(LibNames.ironoxidespade).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":ironoxide_shovel");
				ironoxideshears = new ItemIronoxideShears().setUnlocalizedName(LibNames.IRONOXIDE_SHEARS).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID + ":Ironoxide_Shears");
				
				goldoxidepickaxe = new ItemGoldoxidePickaxe(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(LibNames.goldoxidepickaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":goldoxide_pickaxe");
				goldoxideaxe = new ItemGoldoxideAxe(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(LibNames.goldoxideaxe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":goldoxide_axe");
				goldoxidesword = new ItemGoldoxideSword(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(LibNames.goldoxidesword).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":goldoxide_sword");
				goldoxidehoe = new ItemGoldoxideHoe(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(LibNames.goldoxidehoe).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":goldoxide_hoe");
				goldoxidespade = new ItemGoldoxideShovel(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(LibNames.goldoxidespade).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID +":goldoxide_shovel");
				goldoxideshears = new ItemGoldoxideShears().setUnlocalizedName(LibNames.GOLDOXIDE_SHEARS).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(LibStrings.MODID + ":Goldoxide_Shears");
	}

	private static void registry() {
		RegistryUtils.registerItem(emeraldpickaxe);
		RegistryUtils.registerItem(emeraldaxe);
		RegistryUtils.registerItem(emeraldsword);
		RegistryUtils.registerItem(emeraldhoe);
		RegistryUtils.registerItem(emeraldspade);
		RegistryUtils.registerItem(emeraldshears);
		
		RegistryUtils.registerItem(salthoe);
		RegistryUtils.registerItem(saltpickaxe);
		RegistryUtils.registerItem(saltaxe);
		RegistryUtils.registerItem(saltsword);
		RegistryUtils.registerItem(saltspade);
		RegistryUtils.registerItem(saltshears);
		
		RegistryUtils.registerItem(goldoxidepickaxe);
		RegistryUtils.registerItem(goldoxideaxe);
		RegistryUtils.registerItem(goldoxidesword);
		RegistryUtils.registerItem(goldoxidehoe);
		RegistryUtils.registerItem(goldoxidespade);	
		RegistryUtils.registerItem(goldoxideshears);
		
		RegistryUtils.registerItem(ironoxidepickaxe);
		RegistryUtils.registerItem(ironoxideaxe);
		RegistryUtils.registerItem(ironoxidesword);
		RegistryUtils.registerItem(ironoxidehoe);
		RegistryUtils.registerItem(ironoxidespade);
		RegistryUtils.registerItem(ironoxideshears);
	}

}
