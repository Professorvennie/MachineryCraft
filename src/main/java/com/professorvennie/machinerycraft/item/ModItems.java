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

import com.professorvennie.lib.base.items.ItemPowered;
import com.professorvennie.lib.base.items.ItemUpgrade;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.item.armor.ItemBrassArmor;
import com.professorvennie.machinerycraft.item.armor.ItemEmeraldArmor;
import com.professorvennie.machinerycraft.item.armor.ItemZincArmor;
import com.professorvennie.machinerycraft.item.tools.ModTools;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ModItems {

    public static Item speedupgrade;
    public static Item powerboost;
    public static Item efficiency;
    public static Item ejectorUpgrade;
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

    public static Item batteryTier1;
    public static Item batteryTier2;
    public static Item batteryTier3;

    public static Item zincHemlent;
    public static Item zincChest;
    public static Item zincPants;
    public static Item zincBoots;
    public static Item brassHelment;
    public static Item brassChest;
    public static Item brassPants;
    public static Item brassBoots;
    public static Item emeraldhelment;
    public static Item emeraldchest;
    public static Item emeraldpants;
    public static Item emeraldboots;

    public static void mainRegistry() {
        InitialiseItem();
        ModTools.mainRegistry();
    }

    public static void InitialiseItem() {
        Itemwindmill = new ItemWindmill();
        Dusts = new ItemDusts();
        Ingots = new ItemIngots();
        book = new ItemBook();
        itemPlasticApple = new ItemFood(5, 0.5F, false).setUnlocalizedName(Names.Items.PLASTIC_APPLE).setCreativeTab(MachineryCraft.tabMachineryCraftItems).setTextureName(Reference.MOD_ID + ":plasticApple");
        gears = new ItemGears();
        nuggets = new ItemNuggets();
        steamBucket = new ItemSteamBucket();
        gernades = new ItemGrenade();
        bags = new ItemBags();

        //upgrades
        speedupgrade = new ItemUpgrade(Names.Items.SPPED_UPGRADE, 2).setSpeedModifier(2);
        powerboost = new ItemUpgrade(Names.Items.POWERBOOST, 1).setPowerBoost(2);
        efficiency = new ItemUpgrade(Names.Items.EFFICIENCY, 2).setFuelEff(2);
        ejectorUpgrade = new ItemUpgrade(Names.Items.EJECTOR, 1).setEjectorUpgrade(true);

        batteryTier1 = new ItemPowered(Names.Items.BATTERY_TIER_1, 10000);
        batteryTier2 = new ItemPowered(Names.Items.BATTERY_TIER_2, 50000);
        batteryTier3 = new ItemPowered(Names.Items.BATTERY_TIER_3, 100000);

        zincHemlent = new ItemZincArmor(0, "zincHelment");
        zincChest = new ItemZincArmor(1, "zincChestPlate");
        zincPants = new ItemZincArmor(2, "zincPants");
        zincBoots = new ItemZincArmor(3, "zincBoots");

        brassHelment = new ItemBrassArmor(0, "brassHelment");
        brassChest = new ItemBrassArmor(1, "brassChest");
        brassPants = new ItemBrassArmor(2, "brassPants");
        brassBoots = new ItemBrassArmor(3, "brassBoots");

        emeraldhelment = new ItemEmeraldArmor(0, Names.Items.EMERALD_HELMENT);
        emeraldchest = new ItemEmeraldArmor(0, Names.Items.EMERALD_CHEST);
        emeraldpants = new ItemEmeraldArmor(0, Names.Items.EMERALD_PANTS);
        emeraldboots = new ItemEmeraldArmor(0, Names.Items.EMERALD_BOOTS);
    }
}