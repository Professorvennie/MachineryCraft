/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.block;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.main.MachineryCraft;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.professorvennie.machinerycraft.core.tileEntity.TileEntityCable;


import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCable extends BlockContainer implements IBookable{

	protected BlockCable() {
		super(Material.rock);
		float pixel = 1F/16F;
		this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1 - 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
		this.setCreativeTab(MachineryCraft.tabMachineryCraft);
		this.setBlockName(Names.Blocks.CABLE);
		this.useNeighborBrightness = true;
        setStepSound(Block.soundTypeMetal);
        setHarvestLevel("pickAxe", 2);
        setHardness(5.0f);
	}
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		TileEntityCable cable = (TileEntityCable) world.getTileEntity(x, y, z);
		
		if(cable != null){
			float pixel = 1F/16F;
			float minX = 11*pixel/2 - (cable.connections[5] != null?(11*pixel/2):0);
			float minY = 11*pixel/2 - (cable.connections[1] != null?(11*pixel/2):0);
			float minZ = 11*pixel/2 - (cable.connections[2] != null?(11*pixel/2):0);
			float maxX = 1-11*pixel/2 + (cable.connections[3] != null?(11*pixel/2):0);
			float maxY = 1-11*pixel/2 + (cable.connections[0] != null?(11*pixel/2):0);
			float maxZ = 1-11*pixel/2 + (cable.connections[4] != null?(11*pixel/2):0);
			
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		
		}
		return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		TileEntityCable cable = (TileEntityCable) world.getTileEntity(x, y, z);
		
		if(cable != null){
			float pixel = 1F/16F;
			float minX = 11*pixel/2 - (cable.connections[5] != null?(11*pixel/2):0);
			float minY = 11*pixel/2 - (cable.connections[1] != null?(11*pixel/2):0);
			float minZ = 11*pixel/2 - (cable.connections[2] != null?(11*pixel/2):0);
			float maxX = 1-11*pixel/2 + (cable.connections[3] != null?(11*pixel/2):0);
			float maxY = 1-11*pixel/2 + (cable.connections[0] != null?(11*pixel/2):0);
			float maxZ = 1-11*pixel/2 + (cable.connections[4] != null?(11*pixel/2):0);
			
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		
		}
		return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}
	
	public int getRenderType(){
		return -1;
	}
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityCable();
	}

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
