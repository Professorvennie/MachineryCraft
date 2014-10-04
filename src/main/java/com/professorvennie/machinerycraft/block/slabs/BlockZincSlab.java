/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block.slabs;

import com.professorvennie.lib.base.blocks.BlockModSlab;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Reference;
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
        return (BlockSlab) ModBlocks.zincSlabDouble;
    }
}
