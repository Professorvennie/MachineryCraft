package com.professorvennie.machinerycraft.block.slabs;


import com.professorvennie.lib.base.blocks.BlockModSlab;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:59 PM.
 */
public class BlockLeadSlab extends BlockModSlab {

    public BlockLeadSlab(String leadSlab, boolean b) {
        super(leadSlab, b);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockLead");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.leadSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab) ModBlocks.leadSlabDouble;
    }
}
