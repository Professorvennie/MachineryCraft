package com.professorvennie.machinerycraft.machines.basic.campfire;

import com.professorvennie.lib.base.blocks.BlockModContainer;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/14/2014 at 5:28 PM.
 */
public class BlockCampFire extends BlockModContainer {

    public BlockCampFire() {
        super(Material.wood, Names.Blocks.CAMPFIRE);
        guiId = LibGuiIds.CAMPFIRE;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCampFire();
    }

    @Override
    public boolean renderAsNormalBlock() {
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
}
