/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.client.renderer.tileentity;

import com.professorvennie.core.lib.Reference;
import org.lwjgl.opengl.GL11;

import com.professorvennie.core.tileEntity.TileEntityCable;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityRendererCable extends TileEntitySpecialRenderer {
	
	private final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/cable.png");
	private float pixel = 1F/16F;
	private float texturePixel = 1F/32F;

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float var8) {

		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		TileEntityCable cable = (TileEntityCable) entity;
		if(!cable.onlyOneOppsoite(cable.connections)){
			RenderCenter();
			for(int i = 0; i < cable.connections.length; i++){
				if(cable.connections[i] != null){
					drawConnector(cable.connections[i]);
				}
			}
		}else {
			for(int i = 0; i < cable.connections.length; i++){
				if(cable.connections[i] != null){
					drawStriaght(cable.connections[i]);
					break;
				}
			}
		
		}
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x, -y, -z);
	}
	
	public void drawStriaght(ForgeDirection direction){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			GL11.glTranslated(0.5F, 0.5F, 0.5F);
			if(direction.equals(ForgeDirection.SOUTH) || direction.equals(ForgeDirection.NORTH)){
				GL11.glRotatef(90, 1, 0, 0);
			}else if(direction.equals(ForgeDirection.WEST) || direction.equals(ForgeDirection.EAST)){
				GL11.glRotatef(90, 0, 0, 1);
			}
			GL11.glTranslated(-0.5F, -0.5F, -0.5F);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
						
			tessellator.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);		
			
			tessellator.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 0, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);		
			
			tessellator.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 0*texturePixel);	
			
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 26*texturePixel, 0*texturePixel);	
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);	
		}
		tessellator.draw();
		
		GL11.glTranslated(0.5F, 0.5F, 0.5F);
		 if(direction.equals(ForgeDirection.SOUTH) || direction.equals(ForgeDirection.NORTH)){
			GL11.glRotatef(-90, 1, 0, 0);
		}else if(direction.equals(ForgeDirection.WEST) || direction.equals(ForgeDirection.EAST)){
			GL11.glRotatef(-90, 0, 0, 1);
		}
		GL11.glTranslated(-0.5F, -0.5F, -0.5F);
	}
	
	public void drawConnector(ForgeDirection direction){
		
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			GL11.glTranslated(0.5F, 0.5F, 0.5F);
			if(direction.equals(ForgeDirection.UP)){
				//rotate
			}else if(direction.equals(ForgeDirection.DOWN)){
				GL11.glRotatef(180, 1, 0, 0);
			}else if(direction.equals(ForgeDirection.SOUTH)){
				GL11.glRotatef(90, 1, 0, 0);
			}else if(direction.equals(ForgeDirection.NORTH)){
				GL11.glRotatef(270, 1, 0, 0);
			}else if(direction.equals(ForgeDirection.WEST)){
				GL11.glRotatef(90, 0, 0, 1);
			}else if(direction.equals(ForgeDirection.EAST)){
				GL11.glRotatef(270, 0, 0, 1);
			}
			GL11.glTranslated(-0.5F, -0.5F, -0.5F);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
						
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 5*texturePixel, 0*texturePixel);		
			
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);		
			
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 10*texturePixel, 0*texturePixel);	
			
			tessellator.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);	
			tessellator.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);	
		}
		tessellator.draw();
		
		GL11.glTranslated(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.UP)){
			//rotate
		}else if(direction.equals(ForgeDirection.DOWN)){
			GL11.glRotatef(-180, 1, 0, 0);
		}else if(direction.equals(ForgeDirection.SOUTH)){
			GL11.glRotatef(-90, 1, 0, 0);
		}else if(direction.equals(ForgeDirection.NORTH)){
			GL11.glRotatef(-270, 1, 0, 0);
		}else if(direction.equals(ForgeDirection.WEST)){
			GL11.glRotatef(-90, 0, 0, 1);
		}else if(direction.equals(ForgeDirection.EAST)){
			GL11.glRotatef(-270, 0, 0, 1);
		}
		GL11.glTranslated(-0.5F, -0.5F, -0.5F);
	}
	
	public void RenderCenter(){
		
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);		
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);			
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2,  0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2,  1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2,  1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2,  0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2,  11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2,  0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1- 11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2,  0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2,  11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 1- 11*pixel/2, 11*pixel/2,  5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1- 11*pixel/2, 1-11*pixel/2,  5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(1-11*pixel/2, 1- 11*pixel/2, 1-11*pixel/2,  5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 1- 11*pixel/2, 11*pixel/2,  5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(11*pixel/2, 1- 11*pixel/2, 11*pixel/2,  5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1- 11*pixel/2, 1-11*pixel/2,  5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			
			tessellator.addVertexWithUV(11*pixel/2, 1- 11*pixel/2, 1-11*pixel/2,  5*texturePixel, 5*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 1- 11*pixel/2, 11*pixel/2,  5*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tessellator.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
		}
		tessellator.draw();
	}
}
