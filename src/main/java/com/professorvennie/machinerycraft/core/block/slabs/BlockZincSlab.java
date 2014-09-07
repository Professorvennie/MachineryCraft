package com.professorvennie.machinerycraft.core.block.slabs;


import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 6:00 PM.
 */
public class BlockZincSlab extends BlockModSlab {

    public BlockZincSlab(String zincSlab, boolean b) {
        super(zincSlab, b);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockZinc");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.zincSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab)ModBlocks.zincSlabDouble;
    }
}
