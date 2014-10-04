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

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by ProfessorVennie on 8/16/2014 at 2:55 PM.
 */
public class ExtractorRecipes {

    private static final ExtractorRecipes SMELTING_BASE = new ExtractorRecipes();
    private Map extractorList = new HashMap();
    private Map expList = new HashMap();
    private Random random = new Random();

    public ExtractorRecipes() {

    }

    public static ExtractorRecipes extractoring() {
        return SMELTING_BASE;
    }

    public void addRecipe(ItemStack itemStack1, ItemStack outPut1, float exp) {
        this.addLists(itemStack1, outPut1, exp);
    }

    public void addLists(ItemStack itemStack1, ItemStack outPut1, float exp) {
        this.putLists(itemStack1, outPut1, exp);
    }

    public void putLists(ItemStack itemstack, ItemStack outPut1, float exp) {
        this.extractorList.put(itemstack, outPut1);
        this.expList.put(outPut1, Float.valueOf(exp));
    }

    public ItemStack getExtractoringResult(ItemStack itemstack) {
        Iterator iterator = this.extractorList.entrySet().iterator();

        Map.Entry entry;

        do {
            if (!iterator.hasNext()) {
                ;
                return null;
            }
            entry = (Map.Entry) iterator.next();
        }
        while (!canBeExtracted(itemstack, (ItemStack) entry.getKey()));
        return (ItemStack) entry.getValue();
    }

    private boolean canBeExtracted(ItemStack itemstack, ItemStack itemstack2) {
        return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
    }

    public float giveExp(ItemStack itemstack) {
        Iterator iterator = this.expList.entrySet().iterator();
        Map.Entry entry;

        do {
            if (!iterator.hasNext()) {
                return 0;
            }
            entry = (Map.Entry) iterator.next();
        }
        while (!canBeExtracted(itemstack, (ItemStack) entry.getKey()));

        if (itemstack.getItem().getSmeltingExperience(itemstack) != -1) {
            return itemstack.getItem().getSmeltingExperience(itemstack);
        }

        return ((Float) entry.getValue()).floatValue();
    }
}
