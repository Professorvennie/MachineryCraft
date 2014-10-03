/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.item.armor;

import com.professorvennie.machinerycraft.item.armor.brass.ItemBrassArmorBoots;
import com.professorvennie.machinerycraft.item.armor.brass.ItemBrassArmorChest;
import com.professorvennie.machinerycraft.item.armor.brass.ItemBrassArmorHelment;
import com.professorvennie.machinerycraft.item.armor.brass.ItemBrassArmorPants;
import com.professorvennie.machinerycraft.item.armor.emerald.ItemEmeraldArmorBoots;
import com.professorvennie.machinerycraft.item.armor.emerald.ItemEmeraldArmorChest;
import com.professorvennie.machinerycraft.item.armor.emerald.ItemEmeraldArmorHelment;
import com.professorvennie.machinerycraft.item.armor.emerald.ItemEmeraldArmorPants;
import com.professorvennie.machinerycraft.item.armor.zinc.ItemZincArmorBoots;
import com.professorvennie.machinerycraft.item.armor.zinc.ItemZincArmorChest;
import com.professorvennie.machinerycraft.item.armor.zinc.ItemZincArmorHelment;
import com.professorvennie.machinerycraft.item.armor.zinc.ItemZincArmorPants;
import net.minecraft.item.Item;

public class ModArmor {

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
        init();
    }

    private static void init() {
        zincHemlent = new ItemZincArmorHelment();
        zincChest = new ItemZincArmorChest();
        zincPants = new ItemZincArmorPants();
        zincBoots = new ItemZincArmorBoots();

        brassHelment = new ItemBrassArmorHelment();
        brassChest = new ItemBrassArmorChest();
        brassPants = new ItemBrassArmorPants();
        brassBoots = new ItemBrassArmorBoots();

        emeraldhelment = new ItemEmeraldArmorHelment();
        emeraldchest = new ItemEmeraldArmorChest();
        emeraldpants = new ItemEmeraldArmorPants();
        emeraldboots = new ItemEmeraldArmorBoots();
    }
}
