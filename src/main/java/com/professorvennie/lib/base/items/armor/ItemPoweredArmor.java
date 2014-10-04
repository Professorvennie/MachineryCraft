package com.professorvennie.lib.base.items.armor;

import com.professorvennie.machinerycraft.api.item.IPowerdItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

/**
 * Created by ProfessorVennie on 10/4/2014 at 11:32 AM.
 */
public class ItemPoweredArmor extends ItemArmor implements ISpecialArmor, IPowerdItem {

    private int capacity;

    public ItemPoweredArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_, int capacity) {
        super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }

    @Override
    public void transferPower() {

    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        return null;
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {

    }
}
