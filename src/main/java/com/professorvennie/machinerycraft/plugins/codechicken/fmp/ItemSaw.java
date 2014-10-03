package com.professorvennie.machinerycraft.plugins.codechicken.fmp;

import codechicken.microblock.Saw;
import com.professorvennie.lib.base.items.ItemBase;
import cpw.mods.fml.common.Optional;
import net.minecraft.item.ItemStack;

import java.util.Random;

/**
 * Created by ProfessorVennie on 9/20/2014 at 2:52 PM.
 */
@Optional.Interface(modid = "ForgeMultipart", iface = "codechicken.microblock.Saw")
public class ItemSaw extends ItemBase implements Saw {

    private int sawLevel;

    public ItemSaw(String name, int sawLevel) {
        super(name);
        this.sawLevel = sawLevel;
        setMaxStackSize(1);
        setMaxDamage(1 << sawLevel + 8);
    }

    public int getSawLevel() {
        return sawLevel;
    }

    @Override
    @Optional.Method(modid = "ForgeMultipart")
    public int getMaxCuttingStrength() {
        return sawLevel;
    }

    @Override
    @Optional.Method(modid = "ForgeMultipart")
    public int getCuttingStrength(ItemStack itemStack) {
        return sawLevel;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_) {
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.copy();
        itemStack1.attemptDamageItem(1, new Random());
        return itemStack1;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
