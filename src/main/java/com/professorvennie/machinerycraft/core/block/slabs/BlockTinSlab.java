package com.professorvennie.machinerycraft.core.block.slabs;


import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:58 PM.
 */
public class BlockTinSlab extends BlockModSlab {

    public BlockTinSlab(String tinSlab, boolean b) {
        super(tinSlab, b);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockTin");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.tinSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab)ModBlocks.tinSlabDouble;
    }
}
