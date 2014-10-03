package com.professorvennie.machinerycraft.block.slabs;


import com.professorvennie.lib.base.blocks.BlockModSlab;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:58 PM.
 */
public class BlockSilverSlab extends BlockModSlab {

    public BlockSilverSlab(String silverSlab, boolean b) {
        super(silverSlab, b);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockSilver");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.silverSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab) ModBlocks.silverSlabDouble;
    }
}
