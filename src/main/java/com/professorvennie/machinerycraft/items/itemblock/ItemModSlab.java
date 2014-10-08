/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.items.itemblock;

import com.professorvennie.lib.base.blocks.BlockModSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:08 PM.
 */
public class ItemModSlab extends ItemSlab {

    public ItemModSlab(Block block) {
        super(block, ((BlockModSlab) block).getBlockHalf(), ((BlockModSlab) block).getBlockDouble());
    }
}
