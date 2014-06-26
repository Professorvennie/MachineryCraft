package com.professorvennie.core.block;

import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.main.MainRegistry;

import net.minecraft.block.BlockLog;

public class BlockModLog extends BlockLog {
	
	public BlockModLog(){
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
        this.setBlockName(BlockNames.BLOCK_LOG);
	}

}
