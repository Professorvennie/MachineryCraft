/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.common.containers.slots;

import com.professorvennie.machinerycraft.api.item.IItemUpgrade;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 9/8/2014 at 8:39 PM.
 */
public class SlotUpgrade extends Slot {

    public SlotUpgrade(IInventory iInventory, int id, int x, int y) {
        super(iInventory, id, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack.getItem() instanceof IItemUpgrade ? true : false;
    }
}
