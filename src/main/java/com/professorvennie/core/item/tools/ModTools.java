/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item.tools;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.item.Item;

import com.professorvennie.api.MachineryCraftAPI;
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
import com.professorvennie.core.main.utils.RegistryUtils;

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

	public static Item ironoxidepickaxe;
	public static Item ironoxideaxe;
	public static Item ironoxidesword;
	public static Item ironoxidehoe;
	public static Item ironoxidespade;

	public static Item emeraldpickaxe;
	public static Item emeraldaxe;
	public static Item emeraldsword;
	public static Item emeraldhoe;
	public static Item emeraldspade;

	public static Item goldoxidepickaxe;
	public static Item goldoxideaxe;
	public static Item goldoxidesword;
	public static Item goldoxidehoe;
	public static Item goldoxidespade;

	private static void init() {
		//tools
				saltpickaxe = new ItemSaltPickaxe(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(Names.Items.SALT_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":salt_pickaxe");
				saltaxe = new ItemSaltAxe(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(Names.Items.SALT_AXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":salt_axe");
				saltsword = new ItemSaltSword(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(Names.Items.SALT_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":salt_sword");
				salthoe = new ItemSaltHoe(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(Names.Items.SALT_HOE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":salt_hoe");
				saltspade = new ItemSaltShovel(MachineryCraftAPI.saltToolMaterial).setUnlocalizedName(Names.Items.SALT_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":salt_spade");

				emeraldpickaxe = new ItemEmeraldPickaxe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":emerald_pickaxe");
				emeraldaxe = new ItemEmeraldAxe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_AXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":emerald_axe");
				emeraldsword = new ItemEmeraldSword(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":emerald_sword");
				emeraldhoe = new ItemEmeraldHoe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_HOE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":emerald_hoe");
				emeraldspade = new ItemEmeraldShovel(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":emerald_shovel");

				ironoxidepickaxe = new ItemIronoxidePickaxe(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(Names.Items.IRONOXIDE_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":ironoxide_pickaxe");
				ironoxideaxe = new ItemIronoxideAxe(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(Names.Items.IRONOXIDE_AXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":ironoxide_axe");
				ironoxidesword = new ItemIronoxideSword(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(Names.Items.IRONOXIDE_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":ironoxide_sword");
				ironoxidehoe = new ItemIronoxideHoe(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(Names.Items.IRONOXIDE_HOE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":ironoxide_hoe");
				ironoxidespade = new ItemIronoxideShovel(MachineryCraftAPI.ironoxideToolMaterial).setUnlocalizedName(Names.Items.IRONOXIDE_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":ironoxide_shovel");

				goldoxidepickaxe = new ItemGoldoxidePickaxe(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(Names.Items.GOLDOXIDE_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":goldoxide_pickaxe");
				goldoxideaxe = new ItemGoldoxideAxe(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(Names.Items.GOLDOXIDE_AXE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":goldoxide_axe");
				goldoxidesword = new ItemGoldoxideSword(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(Names.Items.GOLDOXIDE_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":goldoxide_sword");
				goldoxidehoe = new ItemGoldoxideHoe(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(Names.Items.GOLDOXIDE_HOE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":goldoxide_hoe");
				goldoxidespade = new ItemGoldoxideShovel(MachineryCraftAPI.goldoxideToolMaterial).setUnlocalizedName(Names.Items.GOLDOXIDE_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraft).setTextureName(Reference.MOD_ID +":goldoxide_shovel");
	}

	private static void registry() {
        if(ConfigHandler.emeraldTools) {
            RegistryUtils.registerItem(emeraldpickaxe);
            RegistryUtils.registerItem(emeraldaxe);
            RegistryUtils.registerItem(emeraldsword);
            RegistryUtils.registerItem(emeraldhoe);
            RegistryUtils.registerItem(emeraldspade);
        }

        if(ConfigHandler.saltTools) {
            RegistryUtils.registerItem(salthoe);
            RegistryUtils.registerItem(saltpickaxe);
            RegistryUtils.registerItem(saltaxe);
            RegistryUtils.registerItem(saltsword);
            RegistryUtils.registerItem(saltspade);
        }

        if(ConfigHandler.goldoxideTools) {
            RegistryUtils.registerItem(goldoxidepickaxe);
            RegistryUtils.registerItem(goldoxideaxe);
            RegistryUtils.registerItem(goldoxidesword);
            RegistryUtils.registerItem(goldoxidehoe);
            RegistryUtils.registerItem(goldoxidespade);
        }

        if(ConfigHandler.ironoxideTools) {
            RegistryUtils.registerItem(ironoxidepickaxe);
            RegistryUtils.registerItem(ironoxideaxe);
            RegistryUtils.registerItem(ironoxidesword);
            RegistryUtils.registerItem(ironoxidehoe);
            RegistryUtils.registerItem(ironoxidespade);
        }
	}

}
