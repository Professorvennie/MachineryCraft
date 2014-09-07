package com.professorvennie.machinerycraft.core.block.machines.basic;

import com.professorvennie.machinerycraft.core.block.BlockModContainer;
import com.professorvennie.machinerycraft.core.tileEntity.TileEntityBlockBreaker;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/2/2014 at 3:48 PM.
 */
public class BlockBlockBreaker extends BlockModContainer {

    public BlockBlockBreaker() {
        super(Material.rock, "blockBreaker");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityBlockBreaker();
    }
}
