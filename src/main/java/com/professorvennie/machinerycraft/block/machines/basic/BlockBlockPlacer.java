package com.professorvennie.machinerycraft.block.machines.basic;

import com.professorvennie.machinerycraft.block.BlockModContainer;
import com.professorvennie.machinerycraft.tileEntity.TileEntityBlockPlacer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/2/2014 at 3:48 PM.
 */
public class BlockBlockPlacer extends BlockModContainer {

    public BlockBlockPlacer() {
        super(Material.rock, "blockPlacer");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBlockPlacer();
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }
}
