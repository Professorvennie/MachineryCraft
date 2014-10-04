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
