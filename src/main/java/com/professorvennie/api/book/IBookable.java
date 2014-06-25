package com.professorvennie.api.book;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IBookable {
	
	public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon);

}
