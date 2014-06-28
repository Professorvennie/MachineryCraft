/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item.armor.ironoxide;

import com.professorvennie.core.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.item.armor.goldoxide.GoldoxideArmor;

public class IronoxideArmor extends GoldoxideArmor {
	
	private static ItemStack ironOxideIngot = new ItemStack(ModItems.Ingots, 1, 6);


	public IronoxideArmor(int type, String name) {
		super(type, name, MachineryCraftAPI.ironoxideArmorMaterial);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return slot == 2 ? Reference.MOD_ID + ":textures/armor/ironoxide_layer_2.png" : Reference.MOD_ID + ":textures/armor/ironoxide_layer_1.png";
	}
	
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1){
		return itemstack1.getItem() == ironOxideIngot.getItem() ? true : super.getIsRepairable(itemstack, itemstack);
	}
}
