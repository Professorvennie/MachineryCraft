package com.professorvennie.core.block;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.tileEntity.TileEntitySteamPipe;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 8/10/2014 at 4:15 PM.
 */
public class BlockSteamPipe extends BlockMod implements ITileEntityProvider{

    public BlockSteamPipe() {
        super(Material.rock, Names.Blocks.STEAM_PIPE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySteamPipe();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
