package com.professorvennie.core.block;

import java.util.Random;

import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockSaltOre extends Block {

	protected BlockSaltOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockName("Saltore");
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
		setHardness(2.0f);
		setResistance(2.0f);
		setStepSound(Block.soundTypeStone);
		setBlockTextureName(LibStrings.MODID + ":saltore");
	}
	
    public int quantityDropped(Random random)
    {
    	int random1 = new Random().nextInt(6);
        return random1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
        return (ModItems.saltcyrstals);
    }
}
