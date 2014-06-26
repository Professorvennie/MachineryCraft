package com.professorvennie.core.main.utils;

import com.professorvennie.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryUtils {
	
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> tile, String name){
		GameRegistry.registerTileEntity(tile, Reference.MOD_ID + "_" + name);
	}
	
	public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass){
		GameRegistry.registerBlock(block, itemclass,block.getUnlocalizedName());
	}

}
