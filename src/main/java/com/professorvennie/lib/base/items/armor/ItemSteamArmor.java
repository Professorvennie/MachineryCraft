/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.lib.base.items.armor;

import com.professorvennie.machinerycraft.api.steam.ISteamPoweredItem;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 10/4/2014 at 11:30 AM.
 */
public class ItemSteamArmor extends ItemArmor implements /*ISpecialArmor, */ISteamPoweredItem {

    private int capacity;

    public ItemSteamArmor(ArmorMaterial material, int p_i45325_2_, int p_i45325_3_, int capacity) {
        super(material, p_i45325_2_, p_i45325_3_);
        this.capacity = capacity;
    }

    /*@Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        return null;
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {

    }*/

    @Override
    public int getSteamCapacity() {
        return capacity;
    }

    @Override
    public void receiveSteam(ItemStack itemStack, int amount) {

    }

    @Override
    public void extractSteam(ItemStack itemStack, int amount) {

    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
