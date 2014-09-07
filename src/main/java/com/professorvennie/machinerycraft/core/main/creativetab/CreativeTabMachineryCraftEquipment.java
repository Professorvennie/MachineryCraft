/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.main.creativetab;

import com.professorvennie.machinerycraft.core.item.armor.ModArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMachineryCraftEquipment extends CreativeTabs {

	public CreativeTabMachineryCraftEquipment(String TabLabel) {
		super(TabLabel);
	}

	@Override
	public Item getTabIconItem() {
		return ModArmor.emeraldchest;
	}

}
