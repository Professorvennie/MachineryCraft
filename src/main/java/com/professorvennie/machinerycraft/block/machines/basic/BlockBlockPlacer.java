package com.professorvennie.machinerycraft.block.machines.basic;

import com.professorvennie.machinerycraft.block.BlockModContainer;
import com.professorvennie.machinerycraft.tileEntity.TileEntityBlockPlacer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/2/2014 at 3:48 PM.
 */
public class BlockBlockPlacer extends BlockModContainer {

    public BlockBlockPlacer() {
        super(Material.rock, "blockPlacer");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityBlockPlacer();
    }
}
