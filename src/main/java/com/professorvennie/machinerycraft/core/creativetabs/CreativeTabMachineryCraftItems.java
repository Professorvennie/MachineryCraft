package com.professorvennie.machinerycraft.core.creativetabs;

import com.professorvennie.machinerycraft.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by ProfessorVennie on 9/16/2014 at 7:52 PM.
 */
public class CreativeTabMachineryCraftItems extends CreativeTabs {

    public CreativeTabMachineryCraftItems(String lable) {
        super(lable);
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.speedupgrade;
    }
}
