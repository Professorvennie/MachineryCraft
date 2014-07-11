package com.professorvennie.core.block;

import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class BlockPlasticSlab extends BlockSlab {
    public BlockPlasticSlab(boolean isFull) {
        super(isFull, Material.wood);
        useNeighborBrightness = true;
        if(!isFull) {
            setBlockName("plasticSlabHalf");
            setCreativeTab(MachineryCraft.tabMachineryCraft);
        }
        if(isFull)
            setBlockName("plasticSlabFull");
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return null;
    }
}
