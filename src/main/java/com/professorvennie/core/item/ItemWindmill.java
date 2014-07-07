/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item;

import com.professorvennie.core.block.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWindmill extends Item {

	 public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2){
		 if(!world.isRemote){
			 if(side == 1 && world.getBlock(x, y, z).equals(ModBlocks.windmillground) && world.getBlockMetadata(x, y, z) == 5){
				boolean notEnoughspace = false;	
				 for(int x1 = -1; x1 < 1; x1++){
					 for(int z1 = -1; z1 < 1; z1++){
						 for(int y1 = 0; y1 < 7; y1++){
							 if(!world.isAirBlock(x+x1, y+y1+1, z+z1)) notEnoughspace = true;
						 }
						 
					 }
				 }
				 if(!notEnoughspace){
					int direction = (-(int)player.rotationYaw+45)/90;
					if(direction == 0) direction = 4;
					 for(int y1 = 0; y1 < 7; y1++){
						 world.setBlock(x, y+y1+1, z, ModBlocks.windmill, (y1+1) == 7?(y1+1+direction):(y1+1), 2);
							
					 }
					 return true;
				 }
			 }
				
			}
	        return false;
	    }
	

	
}
