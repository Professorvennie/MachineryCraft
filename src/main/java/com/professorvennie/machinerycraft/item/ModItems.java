/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.item;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.MachineryCraft;
import net.minecraft.item.Item;

import com.professorvennie.machinerycraft.item.armor.ModArmor;
import com.professorvennie.machinerycraft.item.tools.ModTools;
import com.professorvennie.machinerycraft.core.utils.RegistryUtils;
import net.minecraft.item.ItemFood;

public class ModItems {


    public static void mainRegistry(){
		InitialiseItem();
		ModTools.mainRegistry();
		ModArmor.mainRegistry();
	}
	
	//misc.
	public static Item speedupgrade;
	public static Item powerboost;
	public static Item efficiency;
	public static Item Itemwindmill;
	public static Item Dusts;
	public static Item Ingots;
	public static Item book;
    public static Item itemPlasticApple;
    public static Item gears;
    public static Item nuggets;
    public static Item steamBucket;
    public static Item gernades;
    public static Item bags;


    public static void InitialiseItem(){
		//Random items
		Itemwindmill = new ItemWindmill();
		Dusts = new ItemDusts();
		Ingots = new ItemIngots();
		book = new ItemBook();
        itemPlasticApple = new ItemFood(5, 0.5F, false).setUnlocalizedName(Names.Items.PLASTIC_APPLE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID + ":plasticApple");
        gears = new ItemGears();
        nuggets = new ItemNuggets();
        steamBucket = new ItemSteamBucket();
        gernades = new ItemGrenade();
        bags = new ItemBags();

		//upgrades
		speedupgrade = new ItemSpeedUpgrade();
		powerboost = new ItemBase(Names.Items.POWERBOOST).setMaxStackSize(1);
		efficiency = new ItemBase(Names.Items.EFFICIENCY).setMaxStackSize(2);
	}
}