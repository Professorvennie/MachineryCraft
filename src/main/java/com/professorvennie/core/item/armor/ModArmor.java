/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item.armor;

import net.minecraft.item.Item;

import com.professorvennie.core.item.armor.emerald.EmeraldArmorBoots;
import com.professorvennie.core.item.armor.emerald.EmeraldArmorChest;
import com.professorvennie.core.item.armor.emerald.EmeraldArmorHelment;
import com.professorvennie.core.item.armor.emerald.EmeraldArmorPants;
import com.professorvennie.core.item.armor.goldoxide.ItemGoldoxideArmorBoots;
import com.professorvennie.core.item.armor.goldoxide.ItemGoldoxideArmorChest;
import com.professorvennie.core.item.armor.goldoxide.ItemGoldoxideArmorHelment;
import com.professorvennie.core.item.armor.goldoxide.ItemGoldoxideArmorPants;
import com.professorvennie.core.item.armor.ironoxide.ItemIronoxideArmorBoots;
import com.professorvennie.core.item.armor.ironoxide.ItemIronoxideArmorChest;
import com.professorvennie.core.item.armor.ironoxide.ItemIronoxideArmorHelment;
import com.professorvennie.core.item.armor.ironoxide.ItemIronoxideArmorPants;
import com.professorvennie.core.item.armor.salt.ItemSaltArmorBoots;
import com.professorvennie.core.item.armor.salt.ItemSaltArmorChest;
import com.professorvennie.core.item.armor.salt.ItemSaltArmorHelment;
import com.professorvennie.core.item.armor.salt.ItemSaltArmorPants;

public class ModArmor {
	
	public static void mainRegistry(){
		init();
	}
	
	public static Item salthelment;
	public static Item saltchest;
	public static Item saltpants;
	public static Item saltboots;
	public static Item ironoxidehelment;
	public static Item ironoxidechest;
	public static Item ironoxidepants;
	public static Item ironoxideboots;
	public static Item goldoxidehelment;
	public static Item goldoxidechest;
	public static Item goldoxidepants;
	public static Item goldoxideboots;
	public static Item emeraldhelment;
	public static Item emeraldchest;
	public static Item emeraldpants;
	public static Item emeraldboots;

	private static void init() {
		salthelment = new ItemSaltArmorHelment();
		saltchest = new ItemSaltArmorChest();
		saltpants = new ItemSaltArmorPants();
		saltboots = new ItemSaltArmorBoots();
		
		ironoxidehelment = new ItemIronoxideArmorHelment();
		ironoxidechest = new ItemIronoxideArmorChest();
		ironoxidepants = new ItemIronoxideArmorPants();
		ironoxideboots = new ItemIronoxideArmorBoots();
	
		goldoxidehelment = new ItemGoldoxideArmorHelment();
		goldoxidechest = new ItemGoldoxideArmorChest();
		goldoxidepants = new ItemGoldoxideArmorPants();
		goldoxideboots = new ItemGoldoxideArmorBoots();
		
		emeraldhelment = new EmeraldArmorHelment();
		emeraldchest = new EmeraldArmorChest();
		emeraldpants = new EmeraldArmorPants();
		emeraldboots = new EmeraldArmorBoots();
	}

}
