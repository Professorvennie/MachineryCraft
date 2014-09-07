package com.professorvennie.machinerycraft.block.slabs;

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
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
