package com.professorvennie.core.block;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

/**
 * Created by ProfessorVennie on 7/31/2014 at 10:46 AM.
 */
public class BlockPlasticFence extends BlockFence {

    public BlockPlasticFence() {
        super(Reference.MOD_ID + ":plasticPlanks", Material.wood);
        setBlockName(Names.Blocks.PLASTIC_FENCE);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
    }

    public boolean canConnectFenceTo(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_){
        Block block = p_149826_1_.getBlock(p_149826_2_, p_149826_3_, p_149826_4_);
        return block != this && block != ModBlocks.plasticFenceGate ? (block.isOpaqueCube() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
}
