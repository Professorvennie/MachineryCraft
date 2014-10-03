/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.item.armor;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.item.ModItems;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemBrassArmor extends ItemArmor {

    private static ItemStack brassIngot = new ItemStack(ModItems.Ingots, 1, 5);

    public ItemBrassArmor(int type, String name) {
        this(type, name, MachineryCraftAPI.brassArmorMaterial);
    }

    public ItemBrassArmor(int type, String name, ArmorMaterial mat) {
        super(mat, 0, type);
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setUnlocalizedName(name);
        setTextureName(Reference.MOD_ID + ":" + name);
        setFull3D();
    }

    @Override
    public Item setUnlocalizedName(String name) {
        GameRegistry.registerItem(this, name);
        return super.setUnlocalizedName(name);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return slot == 2 ? Reference.MOD_ID + ":textures/armor/brass_Armor2.png" : Reference.MOD_ID + ":textures/armor/brass_Armor1.png";
    }

    public boolean getIsRepairable(ItemStack itemstack, ItemStack itemstack1) {
        return itemstack1.getItem() == brassIngot.getItem() ? true : super.getIsRepairable(itemstack, itemstack);
    }
}
