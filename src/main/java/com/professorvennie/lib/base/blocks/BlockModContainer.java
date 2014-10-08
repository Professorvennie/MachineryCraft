package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/2/2014 at 3:39 PM.
 */
public class BlockModContainer extends BlockBase implements ITileEntityProvider {

    public int guiId;

    public BlockModContainer(Material mat, String name) {
        super(mat, name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (guiId != -1) {
            if (!world.isRemote) {
                player.openGui(MachineryCraft.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
