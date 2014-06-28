/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.api.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.professorvennie.api.MachineryCraftAPI;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GrinderRecipes {
	
	private static final GrinderRecipes SMELTING_BASE = new GrinderRecipes();
	private Map grindingList = new HashMap();
	private Map expList = new HashMap();


	public static GrinderRecipes grinding(){
		return SMELTING_BASE;
	}
	
	public GrinderRecipes(){
		this.addRecipe(Item.getItemFromBlock(Blocks.iron_ore), new ItemStack(Items.iron_ingot, 2), 0.8f);
		this.addRecipe(Item.getItemFromBlock(Blocks.diamond_ore), new ItemStack(Items.diamond, 2), 0.8f);
		this.addRecipe(Item.getItemFromBlock(Blocks.redstone_ore), new ItemStack(Items.redstone, 6), 0.8f);
		this.addRecipe(Item.getItemFromBlock(Blocks.emerald_ore), new ItemStack(Items.emerald, 2), 0.8f);
		this.addRecipe(Item.getItemFromBlock(Blocks.quartz_ore), new ItemStack(Items.quartz, 6), 0.8f);
		this.addRecipe(Item.getItemFromBlock(ModBlocks.Saltore), new ItemStack(ModItems.saltcyrstals, 6), 0.8f);
	}
	
	public void addRecipe(Item item, ItemStack itemstack, float exp){
		this.addLists(item, itemstack, exp);
	}
	
	public void addLists(Item item, ItemStack itemstack, float exp){
		this.putLists(new ItemStack(item, 1, 32767), itemstack, exp);
	}
	
	public void putLists(ItemStack itemstack, ItemStack itemstack2, float exp){
		this.grindingList.put(itemstack, itemstack2);
		this.expList.put(itemstack2, Float.valueOf(exp));
	}
	
	public ItemStack getGrindingResult(ItemStack itemstack){
		Iterator iterator = this.grindingList.entrySet().iterator();
		
		Entry entry;
		
		do{
			if(!iterator.hasNext()){;
				return null;
			}
			entry = (Entry) iterator.next();
		}
		while(!canBeGrinded(itemstack, (ItemStack)entry.getKey()));
			return (ItemStack) entry.getValue();
	}

	private boolean canBeGrinded(ItemStack itemstack, ItemStack itemstack2) {
		return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 ||itemstack2.getItemDamage() == itemstack.getItemDamage());
	}
	
	public float giveExp(ItemStack itemstack){
		Iterator iterator = this.expList.entrySet().iterator();
		Entry entry;
		
		do{
			if(!iterator.hasNext()){
				return 0;
			}
			entry = (Entry) iterator.next();
		}
		while(!canBeGrinded(itemstack, (ItemStack)entry.getKey()));
		
		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
			return itemstack.getItem().getSmeltingExperience(itemstack);
		}
		
		return ((Float) entry.getValue()).floatValue();
	}

}
