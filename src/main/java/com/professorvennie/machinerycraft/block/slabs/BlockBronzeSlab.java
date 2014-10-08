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
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:53 PM.
 */
public class BlockBronzeSlab extends BlockModSlab {

    public BlockBronzeSlab(String bronzeSlab, boolean b) {
        super(bronzeSlab, b);
    }

    @Override
    public BlockSlab getBlockHalf() {
        return (BlockSlab) ModBlocks.bronzeSlabHalf;
    }

    @Override
    public BlockSlab getBlockDouble() {
        return (BlockSlab) ModBlocks.bronzeSlabDouble;
    }

    @Override
    public IProperty func_176551_l() {
        return null;
    }

    @Override
    public Object func_176553_a(ItemStack p_176553_1_) {
        return null;
    }
}
