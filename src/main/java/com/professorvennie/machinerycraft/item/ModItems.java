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

import com.professorvennie.lib.base.items.ItemBase;
import com.professorvennie.lib.base.items.ItemPowered;
import com.professorvennie.lib.base.items.ItemUpgrade;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.item.armor.ModArmor;
import com.professorvennie.machinerycraft.item.tools.ModTools;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ModItems {


    //misc.
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
    public static Item test;

    public static void mainRegistry() {
        InitialiseItem();
        ModTools.mainRegistry();
        ModArmor.mainRegistry();
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
        speedupgrade = new ItemUpgrade(Names.Items.SPPED_UPGRADE).setSpeedModifier(2);
        powerboost = new ItemBase(Names.Items.POWERBOOST).setMaxStackSize(1);
        efficiency = new ItemBase(Names.Items.EFFICIENCY).setMaxStackSize(2);
        ejectorUpgrade = new ItemUpgrade("ejectorUpgrade").setEjectorUpgrade(true);

        test = new ItemPowered("test", 10000);
    }
}