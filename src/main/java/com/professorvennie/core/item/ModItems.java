/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item;

import com.professorvennie.core.lib.ItemNames;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.item.Item;

import com.professorvennie.core.item.armor.ModArmor;
import com.professorvennie.core.item.tools.ModTools;
import com.professorvennie.core.main.utils.RegistryUtils;
import net.minecraft.item.ItemFood;

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
    public static Item itemPlasticApple;


    public static void InitialiseItem(){
		//Random items
		saltcyrstals = new Item().setUnlocalizedName(ItemNames.saltcyrstals).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID + ":saltcyrstals");
		Itemwindmill = new ItemWindmill().setUnlocalizedName(ItemNames.Itemwindmill).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName("diamond");
		Dusts = new ItemDusts();
		Ingots = new ItemIngots();
		book = new ItemBook();
        itemPlasticApple = new ItemFood(5, 0.5F, false).setUnlocalizedName(ItemNames.PLASTIC_APPLE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID + ":plasticApple");

		//upgrades
		speedupgrade = new ItemSpeedUpgrade().setUnlocalizedName(ItemNames.speedupgrade).setCreativeTab(MachineryCraft.tabMachineryCraft).setMaxStackSize(2).setTextureName(Reference.MOD_ID + ":speedupgrade");
		powerboost = new Item().setUnlocalizedName(ItemNames.powerboost).setCreativeTab(MachineryCraft.tabMachineryCraft).setMaxStackSize(1).setTextureName(Reference.MOD_ID + ":powerboost");
		efficiency = new Item().setUnlocalizedName(ItemNames.efficiency).setCreativeTab(MachineryCraft.tabMachineryCraft).setMaxStackSize(2).setTextureName(Reference.MOD_ID + ":");
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
        RegistryUtils.registerItem(itemPlasticApple);

    }
}

;