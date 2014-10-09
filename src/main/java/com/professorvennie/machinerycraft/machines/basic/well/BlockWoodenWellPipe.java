package com.professorvennie.machinerycraft.machines.basic.well;

import com.professorvennie.lib.base.blocks.BlockBase;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/14/2014 at 5:04 PM.
 */
public class BlockWoodenWellPipe extends BlockBase implements ITileEntityProvider {

    public BlockWoodenWellPipe() {
        super(Material.wood, Names.Blocks.WOODEN_WELL_PIPE);
        float pixel = 1F / 16F;
        setBlockBounds((9) / 2 * pixel, 0, (9) / 2 * pixel, 1 - (9) / 2 * pixel, 1, 1 - (9) / 2 * pixel);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityWoodenWellPipe();
    }
}
