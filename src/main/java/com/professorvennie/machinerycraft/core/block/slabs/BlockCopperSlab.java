package com.professorvennie.machinerycraft.core.block.slabs;


import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.BlockSlab;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:10 PM.
 */
public class BlockCopperSlab extends BlockModSlab {

    public BlockCopperSlab(String name, boolean isFull) {
        super(name, isFull);
        setBlockTextureName(Reference.MOD_ID + ":" + "ores/" + "blockCopper");
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.copperSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab)ModBlocks.copperSlabDouble;
    }
}
