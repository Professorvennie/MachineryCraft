package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (guiId != -1) {
            if (!world.isRemote) {
                player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
