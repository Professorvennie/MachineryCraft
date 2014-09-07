package com.professorvennie.machinerycraft.item.itemblock;

import com.professorvennie.machinerycraft.block.slabs.BlockModSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:08 PM.
 */
public class ItemModSlab extends ItemSlab {

    public ItemModSlab(Block block) {
        super(block, ((BlockModSlab)block).getBlockHalf(), ((BlockModSlab)block).getBlockDouble(), false);
    }
}
