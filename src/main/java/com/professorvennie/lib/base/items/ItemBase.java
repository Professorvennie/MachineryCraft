package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.MachineryCraft;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ProfessorVennie on 9/7/2014 at 1:53 PM.
 */
public class ItemBase extends Item {

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setCreativeTab(MachineryCraft.tabMachineryCraftItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public Item setUnlocalizedName(String name) {
        GameRegistry.registerItem(this, name);
        return super.setUnlocalizedName(name);
    }
}
