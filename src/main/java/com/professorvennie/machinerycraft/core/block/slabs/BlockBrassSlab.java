package com.professorvennie.machinerycraft.core.block.slabs;


import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 6:00 PM.
 */
public class BlockBrassSlab extends BlockModSlab {

    public BlockBrassSlab(String brassSlab, boolean b) {
        super(brassSlab, b);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockBrass");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.brassSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab)ModBlocks.brassSlabDouble;
    }
}
