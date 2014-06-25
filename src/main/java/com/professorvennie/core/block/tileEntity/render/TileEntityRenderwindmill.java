package com.professorvennie.core.block.tileEntity.render;

import org.lwjgl.opengl.GL11;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.tileEntity.TileEntitywindmill;
import com.professorvennie.core.lib.LibStrings;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderwindmill extends TileEntitySpecialRenderer {

	private final ResourceLocation texterwindmill = new ResourceLocation(LibStrings.MODID, "textures/model/windmill.png");
	private float pixel = 1F/16F;
	private int textureWidth = 32;
	private int textureHeight = 32;
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int x1 = tileentity.xCoord;
		int y1 = tileentity.yCoord;
		int z1 = tileentity.zCoord;
		while(tileentity.getWorldObj().getBlockMetadata(x1, y1, z1) < 7 && tileentity.getWorldObj().getBlock(x1, y1, z1).equals(ModBlocks.windmill)){
			y1++;
		}
		
		int direction = tileentity.getWorldObj().getBlockMetadata(x1, y1, z1)-8;
		int metadata =tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glTranslatef((float)x, (float)y, (float)z);	
		
			GL11.glTranslatef(0.5F, 0, 0.5F);
			GL11.glRotatef(direction*90, 0, 1, 0);
			GL11.glTranslatef(-0.5F, 0, -0.5F);
			
			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(texterwindmill);
			tessellator.startDrawingQuads();
			{
				if(metadata > 0 && metadata < 7){
					tessellator.addVertexWithUV((8)/2*pixel, 0, 1-(8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
					tessellator.addVertexWithUV((8)/2*pixel, 1, 1-(8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV((8)/2*pixel, 1, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV((8)/2*pixel, 0, (8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
					
					tessellator.addVertexWithUV(1-(8)/2*pixel, 0, 1-(8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
					tessellator.addVertexWithUV(1-(8)/2*pixel, 1, 1-(8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV((8)/2*pixel, 1, 1-(8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV((8)/2*pixel, 0, 1-(8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
					
					tessellator.addVertexWithUV((8)/2*pixel, 0, (8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
					tessellator.addVertexWithUV((8)/2*pixel, 1, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV(1-(8)/2*pixel, 1, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV(1-(8)/2*pixel, 0, (8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
					
					tessellator.addVertexWithUV(1-(8)/2*pixel, 0, (8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
					tessellator.addVertexWithUV(1-(8)/2*pixel, 1, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV(1-(8)/2*pixel, 1, 1-(8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
					tessellator.addVertexWithUV(1-(8)/2*pixel, 0, 1-(8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				}
				if(metadata > 7){
					/*
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0, (8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, 1-(8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0, 1-(8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV((8)/2*pixel, 0, (8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0, (8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV((8)/2*pixel, 0, 1-(8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, 1-(8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0, (8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0, 1-(8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, 1-(8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, 1-(8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0, 1-(8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, 0.739, 8*(1F/textureWidth), 1*(1F/textureWidth));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, 1, 8*(1F/textureWidth), 0*(1F/textureWidth));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, 1, 0*(1F/textureWidth), 0*(1F/textureWidth));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, 0.739, 0*(1F/textureWidth), 1*(1F/textureWidth));
				
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, 1, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 1, 1, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 1, 1, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, 1, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, 1, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 1, 1, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 1, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, (8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV((8)/2*pixel, 0.5, (8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV((8)/2*pixel, 1, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 1, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, (8)/2*pixel, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, (8)/2*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 1, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 1, 1, 0*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 0.5, 1, 0*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(1-(8)/2*pixel, 1, 1, 8*(1F/textureWidth), 1*(1F/textureWidth));
				tessellator.addVertexWithUV(1-(8)/2*pixel, 1, (8)/2*pixel, 8*(1F/textureWidth), 0*(1F/textureWidth));
				tessellator.addVertexWithUV((8)/2*pixel, 1, (8)/2*pixel, 0*(1F/textureWidth), 0*(1F/textureWidth));
				tessellator.addVertexWithUV((8)/2*pixel, 1, 1, 0*(1F/textureWidth), 1*(1F/textureWidth));
				*/

				}
				
			}
			tessellator.draw();
			
			if(metadata > 7) drawRoatar(tileentity);
			GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
	private void drawRoatar(TileEntity tileentity){
		TileEntitywindmill windmill = (TileEntitywindmill) tileentity.getWorldObj().getTileEntity(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		GL11.glTranslatef(0, 0.5F, 0.5F);
		GL11.glRotatef(windmill.rotaion, 1, 0, 0);	
		GL11.glTranslatef(0, -0.5F, -0.5F);
		
		Tessellator tessellator = Tessellator.instance;
			this.bindTexture(texterwindmill);
			tessellator.startDrawingQuads();
			{
				
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 1*pixel+0.5F, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 2.5F, 1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 2.5F, -1*pixel+0.5F, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -1*pixel+0.5F, 8*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(-2*pixel, 2.5F, 1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 1*pixel+0.5F, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -1*pixel+0.5F, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 2.5F, -1*pixel+0.5F, 8*(1F/textureWidth), 0*(1F/textureHeight));
						
				tessellator.addVertexWithUV(-2*pixel, -1.5F, 1*pixel+0.5F, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1*pixel+0.5F, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, -1.5F, -1*pixel+0.5F, 8*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 1*pixel+0.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, -1.5F, 1*pixel+0.5F, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, -1.5F, -1*pixel+0.5F, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1*pixel+0.5F, 8*(1F/textureWidth), 0*(1F/textureHeight));
						
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 2.5F, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 2.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F+1*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F+1*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 2.5F, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 2.5F, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F+1*pixel, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F+1*pixel, 8*(1F/textureWidth), 0*(1F/textureHeight));
					
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F-1*pixel, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F-1*pixel, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -1.5F, 8*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1.5F, 8*(1F/textureWidth), 1*(1F/textureHeight));
				
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, 0.5F-1*pixel, 9*(1F/textureWidth), 0*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, 0.5F-1*pixel, 9*(1F/textureWidth) , 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F-1*pixel, -1.5F, 8*(1F/textureWidth), 1*(1F/textureHeight));
				tessellator.addVertexWithUV(-2*pixel, 0.5F+1*pixel, -1.5F, 8*(1F/textureWidth), 0*(1F/textureHeight));

				}
				
			tessellator.draw();
	}


}
