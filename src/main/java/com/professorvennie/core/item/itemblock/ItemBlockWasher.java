package com.professorvennie.core.item.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockWasher extends ItemBlock{

	public ItemBlockWasher(Block block) {
		super(block);
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par1){
		list.add("3x3x3 MultiBlock");
	}

}
