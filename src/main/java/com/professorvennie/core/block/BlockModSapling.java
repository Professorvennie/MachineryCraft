package com.professorvennie.core.block;

import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.main.MainRegistry;

import net.minecraft.block.BlockSapling;

public class BlockModSapling extends BlockSapling {
	
	public BlockModSapling(){
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
        this.setBlockName(BlockNames.BLOCK_SAPLING);
	}

}
