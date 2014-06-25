package com.professorvennie.core.block;

import org.lwjgl.opengl.GL11;

import com.professorvennie.core.block.tileEntity.TileEntityCable;
import com.professorvennie.core.block.tileEntity.render.TileEntityRenderWasher;
import com.professorvennie.core.lib.LibNames;
import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCable extends BlockContainer {

	protected BlockCable(Material material) {
		super(material);
		float pixel = 1F/16F;
		this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1 - 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
		this.setBlockName(LibNames.cable);	
		this.useNeighborBrightness = true;	
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

}
