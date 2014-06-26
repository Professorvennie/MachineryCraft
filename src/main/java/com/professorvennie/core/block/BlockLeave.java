package com.professorvennie.core.block;

import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.main.MainRegistry;

import net.minecraft.block.BlockLeaves;
import net.minecraft.util.IIcon;

public class BlockLeave extends BlockLeaves {
	
	public BlockLeave(){
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
        this.setBlockName(BlockNames.BLOCK_LEAVES);
	}

	@Override
	public IIcon getIcon(int var1, int var2) {
		return null;
	}

	@Override
	public String[] func_150125_e() {
		return null;
	}

}
