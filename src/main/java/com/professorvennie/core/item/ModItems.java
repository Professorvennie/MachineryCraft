package com.professorvennie.core.item;

import com.professorvennie.core.lib.ItemNames;
import com.professorvennie.core.lib.Reference;
import net.minecraft.item.Item;

import com.professorvennie.core.item.armor.ModArmor;
import com.professorvennie.core.item.tools.ModTools;
import com.professorvennie.core.main.MainRegistry;
import com.professorvennie.core.main.utils.RegistryUtils;

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
		saltcyrstals = new Item().setUnlocalizedName(ItemNames.saltcyrstals).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName(Reference.MOD_ID + ":saltcyrstals");
		Itemwindmill = new ItemWindmill().setUnlocalizedName(ItemNames.Itemwindmill).setCreativeTab(MainRegistry.tabMachineryCraft).setTextureName("diamond");
		Dusts = new ItemDusts();
		Ingots = new ItemIngots();
		book = new ItemBook();
		
		//upgrades
		speedupgrade = new ItemSpeedUpgrade().setUnlocalizedName(ItemNames.speedupgrade).setCreativeTab(MainRegistry.tabMachineryCraft).setMaxStackSize(2).setTextureName(Reference.MOD_ID + ":speedupgrade");
		powerboost = new Item().setUnlocalizedName(ItemNames.powerboost).setCreativeTab(MainRegistry.tabMachineryCraft).setMaxStackSize(1).setTextureName(Reference.MOD_ID + ":powerboost");
		efficiency = new Item().setUnlocalizedName(ItemNames.efficiency).setCreativeTab(MainRegistry.tabMachineryCraft).setMaxStackSize(2).setTextureName(Reference.MOD_ID + ":");
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