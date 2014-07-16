package com.professorvennie.core.block;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPlasticSlab extends BlockSlab {

    public BlockPlasticSlab(boolean isFull) {
        super(isFull, Material.wood);
        useNeighborBrightness = true;
        setStepSound(Block.soundTypeWood);
        setBlockTextureName(Reference.MOD_ID + ":plasticPlanks");
        if(!isFull) {
            setBlockName(Names.Blocks.BLOCK_PLASTIC_SLAB + "Half");
            setCreativeTab(MachineryCraft.tabMachineryCraft);
        }
        if(isFull)
            setBlockName(Names.Blocks.BLOCK_PLASTIC_SLAB + "Full");
    }

    @Override
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.plasticSlabHalf);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.plasticSlabHalf);
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return Names.Blocks.BLOCK_PLASTIC_SLAB;
    }
}
