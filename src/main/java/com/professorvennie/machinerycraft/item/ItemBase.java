package com.professorvennie.machinerycraft.item;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.core.utils.RegistryUtils;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 9/7/2014 at 1:53 PM.
 */
public class ItemBase extends Item {

    public ItemBase(String name){
        setUnlocalizedName(name);
        setFull3D();
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setTextureName(Reference.MOD_ID + ":" + name);
    }

    @Override
    public Item setUnlocalizedName(String name) {
        GameRegistry.registerItem(this, name);
        return super.setUnlocalizedName(name);
    }

    @Override
    public String getUnlocalizedNameInefficiently(ItemStack itemStack) {
        return itemStack.getUnlocalizedName().replaceAll("item.", "item.machineryCraft:");
    }
}
