/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.item.armor.emerald;

import com.professorvennie.machinerycraft.core.item.armor.brass.BrassArmor;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.professorvennie.machinerycraft.api.MachineryCraftAPI;


public class EmeraldArmor extends BrassArmor {

	public EmeraldArmor(int type, String name) {
		super(type, name, MachineryCraftAPI.emeraldArmorMaterial);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return slot == 2 ? Reference.MOD_ID + ":textures/armor/emerald_layer_2.png" : Reference.MOD_ID + ":textures/armor/emerald_layer_1.png";
	}
	
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1){
		return itemstack1.getItem() == Items.emerald ? true : super.getIsRepairable(itemstack, itemstack); 
	}
}
