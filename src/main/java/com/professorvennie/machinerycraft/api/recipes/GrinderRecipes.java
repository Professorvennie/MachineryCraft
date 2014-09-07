/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.api.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.item.ItemStack;

public class GrinderRecipes {
	
	private static final GrinderRecipes SMELTING_BASE = new GrinderRecipes();
	private Map grindingList = new HashMap();
	private Map expList = new HashMap();

	public static GrinderRecipes grinding(){
		return SMELTING_BASE;
	}
	
	public GrinderRecipes(){}

    public Map getGrindingList(){
        return grindingList;
    }
	
	public void addRecipe(ItemStack itemStack1, ItemStack itemStack2 , float exp){
		this.addLists(itemStack1, itemStack2, exp);
	}
	
	public void addLists(ItemStack itemStack1, ItemStack itemStack2, float exp){
		this.putLists(itemStack1, itemStack2, exp);
	}
	
	public void putLists(ItemStack itemstack, ItemStack itemStack2, float exp){
		this.grindingList.put(itemstack, itemStack2);
		this.expList.put(itemStack2, Float.valueOf(exp));
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
