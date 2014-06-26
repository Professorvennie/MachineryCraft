package com.professorvennie.core.item.armor.goldoxide;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.*;
import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

public class GoldoxideArmor extends ItemArmor{
	
	private static ItemStack goldOxideIngot = new ItemStack(ModItems.Ingots, 1, 5);


	public GoldoxideArmor(int type, String name) {
		this(type, name, MachineryCraftAPI.goldoxideArmorMaterial);
	}

	public GoldoxideArmor(int type, String name, ArmorMaterial mat) {
		super(mat, 0, type);
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MOD_ID + ":" + name);
	}
	
	public Item setUnlocalizedName(String name){
		GameRegistry.registerItem(this, name);
		return super.setUnlocalizedName(name);
	}
	
	public String getUnlocalizedNameInefficiently(ItemStack itemstack){
		return super.getUnlocalizedNameInefficiently(itemstack);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return slot == 2 ? Reference.MOD_ID + ":textures/armor/goldoxide_layer_2.png" : Reference.MOD_ID + ":textures/armor/goldoxide_layer_1.png";
	}
	
	public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1){
		return itemstack1.getItem() == goldOxideIngot.getItem() ? true : super.getIsRepairable(itemstack, itemstack);
	}

}
