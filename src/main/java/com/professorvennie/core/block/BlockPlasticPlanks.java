package com.professorvennie.core.block;

import com.professorvennie.core.lib.BlockNames;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPlasticPlanks extends BlockMod {

    public BlockPlasticPlanks() {
        super(Material.wood, BlockNames.BLOCK_PLASTIC_PLANKS);
        this.setHardness(1.5F);
        this.setHarvestLevel("axe", 0);
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
        return true;
    }

    public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face){
        return 20;
    }

    public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face){
        return 5;
    }
}
