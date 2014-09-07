package com.professorvennie.machinerycraft.core.block.slabs;

import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:53 PM.
 */
public class BlockBronzeSlab extends BlockModSlab {

    public BlockBronzeSlab(String bronzeSlab, boolean b) {
        super(bronzeSlab, b);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockBronze");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.bronzeSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab)ModBlocks.bronzeSlabDouble;
    }
}
