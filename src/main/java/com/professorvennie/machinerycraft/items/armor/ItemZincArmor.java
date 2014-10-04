/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.items.armor;

import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemZincArmor extends ItemBrassArmor {

    private static ItemStack saltIngot = new ItemStack(ModItems.Ingots, 1, 4);


    public ItemZincArmor(int type, String name) {
        super(type, name, MachineryCraftAPI.zincArmorMaterial);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return slot == 2 ? Reference.MOD_ID + ":textures/armor/zinc_Armor2.png" : Reference.MOD_ID + ":textures/armor/zinc_Armor1.png";
    }

    public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1) {
        return itemstack1.getItem() == saltIngot.getItem() ? true : super.getIsRepairable(itemstack, itemstack);
    }

}
