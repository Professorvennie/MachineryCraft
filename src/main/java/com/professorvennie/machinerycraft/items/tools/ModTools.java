/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.items.tools;

import com.professorvennie.lib.base.items.ItemModBow;
import com.professorvennie.lib.base.items.ItemModFishingPole;
import com.professorvennie.lib.utils.RegistryUtils;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.core.config.ConfigHandler;
import com.professorvennie.machinerycraft.items.tools.brass.*;
import com.professorvennie.machinerycraft.items.tools.emerald.*;
import com.professorvennie.machinerycraft.items.tools.zinc.*;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.item.Item;

public class ModTools {

    //zinc tools
    public static Item zincPickaxe;
    public static Item zincAxe;
    public static Item zincSword;
    public static Item zincHoe;
    public static Item zincSpade;
    public static Item zincFishingRod;
    public static Item zincBow;
    public static Item brassPickaxe;
    public static Item brassAxe;
    public static Item brassSword;
    public static Item brassHoe;
    public static Item brassSpade;
    public static Item brassFishingRod;
    public static Item brassBow;
    public static Item emeraldpickaxe;
    public static Item emeraldaxe;
    public static Item emeraldsword;
    public static Item emeraldhoe;
    public static Item emeraldspade;
    public static Item emeraldFishingRod;
    public static Item emeraldBow;

    public static void mainRegistry() {
        init();
        registry();
    }

    private static void init() {
        //tools
        zincPickaxe = new ItemZincPickaxe(MachineryCraftAPI.zincToolMaterial).setUnlocalizedName(Names.Items.ZINC_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":zincPickaxe");
        zincAxe = new ItemZincAxe(MachineryCraftAPI.zincToolMaterial).setUnlocalizedName(Names.Items.ZINC_AXE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":zincAxe");
        zincSword = new ItemZincSword(MachineryCraftAPI.zincToolMaterial).setUnlocalizedName(Names.Items.ZINC_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":zincSword");
        zincHoe = new ItemZincHoe(MachineryCraftAPI.zincToolMaterial).setUnlocalizedName(Names.Items.ZINC_HOE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":zincHoe");
        zincSpade = new ItemZincSpade(MachineryCraftAPI.zincToolMaterial).setUnlocalizedName(Names.Items.ZINC_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":zincSpade");
        zincFishingRod = new ItemModFishingPole(MachineryCraftAPI.zincToolMaterial, Names.Items.ZINC_FISHINGROD);
        zincBow = new ItemModBow(MachineryCraftAPI.zincToolMaterial, Names.Items.ZINC_BOW);

        emeraldpickaxe = new ItemEmeraldPickaxe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":emerald_pickaxe");
        emeraldaxe = new ItemEmeraldAxe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_AXE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":emerald_axe");
        emeraldsword = new ItemEmeraldSword(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":emerald_sword");
        emeraldhoe = new ItemEmeraldHoe(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_HOE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":emerald_hoe");
        emeraldspade = new ItemEmeraldShovel(MachineryCraftAPI.emeraldToolMaterial).setUnlocalizedName(Names.Items.EMEARALD_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":emerald_shovel");
        emeraldFishingRod = new ItemModFishingPole(MachineryCraftAPI.emeraldToolMaterial, Names.Items.EMEARALD_FISHINGROD);
        emeraldBow = new ItemModBow(MachineryCraftAPI.emeraldToolMaterial, Names.Items.EMEARALD_BOW);

        brassPickaxe = new ItemBrassPickaxe(MachineryCraftAPI.brassToolMaterial).setUnlocalizedName(Names.Items.BRASS_PICKAXE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":brassPickaxe");
        brassAxe = new ItemBrassAxe(MachineryCraftAPI.brassToolMaterial).setUnlocalizedName(Names.Items.BRASS_AXE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":brassAxe");
        brassSword = new ItemBrassSword(MachineryCraftAPI.brassToolMaterial).setUnlocalizedName(Names.Items.BRASS_SWORD).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":brassSword");
        brassHoe = new ItemBrassHoe(MachineryCraftAPI.brassToolMaterial).setUnlocalizedName(Names.Items.BRASS_HOE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":brassHoe");
        brassSpade = new ItemBrassSpade(MachineryCraftAPI.brassToolMaterial).setUnlocalizedName(Names.Items.BRASS_SPADE).setCreativeTab(MachineryCraft.tabMachineryCraftEquipment).setTextureName(Reference.MOD_ID + ":brassSpade");
        brassFishingRod = new ItemModFishingPole(MachineryCraftAPI.brassToolMaterial, Names.Items.BRASS_FISHINGROD);
        brassBow = new ItemModBow(MachineryCraftAPI.brassToolMaterial, Names.Items.BRASS_BOW);
    }

    private static void registry() {
        if (ConfigHandler.emeraldTools) {
            RegistryUtils.registerItem(emeraldpickaxe);
            RegistryUtils.registerItem(emeraldaxe);
            RegistryUtils.registerItem(emeraldsword);
            RegistryUtils.registerItem(emeraldhoe);
            RegistryUtils.registerItem(emeraldspade);
            RegistryUtils.registerItem(emeraldFishingRod);
            RegistryUtils.registerItem(emeraldBow);
        }

        if (ConfigHandler.zincTools) {
            RegistryUtils.registerItem(zincHoe);
            RegistryUtils.registerItem(zincPickaxe);
            RegistryUtils.registerItem(zincAxe);
            RegistryUtils.registerItem(zincSword);
            RegistryUtils.registerItem(zincSpade);
            RegistryUtils.registerItem(zincFishingRod);
            RegistryUtils.registerItem(zincBow);
        }

        if (ConfigHandler.brassArmor) {
            RegistryUtils.registerItem(brassPickaxe);
            RegistryUtils.registerItem(brassAxe);
            RegistryUtils.registerItem(brassSword);
            RegistryUtils.registerItem(brassHoe);
            RegistryUtils.registerItem(brassSpade);
            RegistryUtils.registerItem(brassFishingRod);
            RegistryUtils.registerItem(brassBow);
        }
    }
}
