/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item.armor.goldoxide;

import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.*;

import cpw.mods.fml.common.registry.GameRegistry;

public class GoldoxideArmor extends ItemArmor{
	
	private static ItemStack goldOxideIngot = new ItemStack(ModItems.Ingots, 1, 5);


	public GoldoxideArmor(int type, String name) {
		this(type, name, MachineryCraftAPI.goldoxideArmorMaterial);
	}

	public GoldoxideArmor(int type, String name, ArmorMaterial mat) {
		super(mat, 0, type);
		this.setCreativeTab(MachineryCraft.tabMachineryCraft);
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
