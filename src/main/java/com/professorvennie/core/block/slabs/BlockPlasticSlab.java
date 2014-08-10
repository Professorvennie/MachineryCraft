package com.professorvennie.core.block.slabs;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import net.minecraft.block.BlockSlab;

public class BlockPlasticSlab extends BlockModSlab {

    public BlockPlasticSlab(boolean isFull) {
        super(Names.Blocks.BLOCK_PLASTIC_SLAB, isFull);
        setBlockTextureName(Reference.MOD_ID + ":plasticPlanks");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.plasticSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab) ModBlocks.plasticSlabDouble;
    }
}
