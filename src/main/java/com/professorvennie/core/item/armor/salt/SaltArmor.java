package com.professorvennie.core.item.armor.salt;

import com.professorvennie.core.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.item.armor.goldoxide.GoldoxideArmor;

public class SaltArmor extends GoldoxideArmor{
	
	private static ItemStack saltIngot = new ItemStack(ModItems.Ingots, 1, 4);


	public SaltArmor(int type, String name) {
		super(type, name, MachineryCraftAPI.saltArmorMaterial);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return slot == 2 ? Reference.MOD_ID + ":textures/armor/salt_amour2.png" : Reference.MOD_ID + ":textures/armor/salt_amour1.png";
	}
	
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1){
		return itemstack1.getItem() == saltIngot.getItem() ? true : super.getIsRepairable(itemstack, itemstack);
	}
	
}
