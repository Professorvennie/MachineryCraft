package com.professorvennie.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemPlasticSlab extends ItemSlab {
    public ItemPlasticSlab(Block par1) {
        super(par1, (BlockSlab) ModBlocks.plasticSlabHalf, (BlockSlab) ModBlocks.plasticSlabDouble, false);
    }
}
