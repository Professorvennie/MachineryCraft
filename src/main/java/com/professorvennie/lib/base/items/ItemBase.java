package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 9/7/2014 at 1:53 PM.
 */
public class ItemBase extends Item {

    public ItemBase(String name){
        setUnlocalizedName(name);
        setCreativeTab(MachineryCraft.tabMachineryCraftItems);
        setTextureName(Reference.MOD_ID + ":" + name);
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
