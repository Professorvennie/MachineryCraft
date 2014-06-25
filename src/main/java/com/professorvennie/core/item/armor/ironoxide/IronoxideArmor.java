package com.professorvennie.core.item.armor.ironoxide;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.item.armor.goldoxide.GoldoxideArmor;
import com.professorvennie.core.lib.LibStrings;

public class IronoxideArmor extends GoldoxideArmor {
	
	private static ItemStack ironOxideIngot = new ItemStack(ModItems.Ingots, 1, 6);


	public IronoxideArmor(int type, String name) {
		super(type, name, MachineryCraftAPI.ironoxideArmorMaterial);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return slot == 2 ? LibStrings.MODID + ":textures/armor/ironoxide_layer_2.png" : LibStrings.MODID + ":textures/armor/ironoxide_layer_1.png";
	}
	
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1){
		return itemstack1.getItem() == ironOxideIngot.getItem() ? true : super.getIsRepairable(itemstack, itemstack);
	}
}
