package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
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

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName().replaceAll("tile.", "tile.machineryCraft:");
    }

    public boolean canConnectFenceTo(IBlockAccess iBlockAccess, int x, int y, int z) {
        Block block = iBlockAccess.getBlock(x, y, z);
        return block != this && block != ModBlocks.plasticFenceGate ? (block.isOpaqueCube() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
}
