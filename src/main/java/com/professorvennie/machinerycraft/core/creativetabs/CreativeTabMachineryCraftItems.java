/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
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
