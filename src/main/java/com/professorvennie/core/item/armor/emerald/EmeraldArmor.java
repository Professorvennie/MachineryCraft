package com.professorvennie.core.item.armor.emerald;

import com.professorvennie.core.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.armor.goldoxide.GoldoxideArmor;


public class EmeraldArmor extends GoldoxideArmor{

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
