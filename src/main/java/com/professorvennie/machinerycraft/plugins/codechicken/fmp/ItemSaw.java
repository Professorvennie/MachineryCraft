/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
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
