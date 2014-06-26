package com.professorvennie.core.block.tileEntity.render;

import com.professorvennie.core.lib.Reference;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderWasher extends TileEntitySpecialRenderer{
	
	private final ResourceLocation texterwasher = new ResourceLocation(Reference.MOD_ID, "textures/blocks/ores/metal_6.png");
	private final ResourceLocation glass = new ResourceLocation("textures/blocks/glass.png");
	private float pixel = 1F/16F;
	private int textureWidth = 32;
	private int textureHeight = 32;

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,double z, float var8) {
		int x1 = tileentity.xCoord;
		int y1 = tileentity.yCoord;
		int z1 = tileentity.zCoord;
		
		int metadata =tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glTranslatef((float)x, (float)y, (float)z);	
		
			
			
			Tessellator tessellator = Tessellator.instance;
			this.bindTexture(texterwasher);
			tessellator.startDrawingQuads();
			
			if(metadata == 5){
				this.bindTexture(glass);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
				
				tessellator.addVertexWithUV(1, 1, 0, 1, 0);
				tessellator.addVertexWithUV(1, 0, 0, 1, 1);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);


			}
			if(metadata == 7){
				this.bindTexture(glass);
				
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);

			}
			if(metadata == 6){
				this.bindTexture(texterwasher);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
				
				tessellator.addVertexWithUV(1, 1, 0, 1, 0);
				tessellator.addVertexWithUV(1, 0, 0, 1, 1);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 1, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 0, 1, 1, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 0);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
			}
			if(metadata == 3){
				this.bindTexture(texterwasher);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
				
				tessellator.addVertexWithUV(1, 1, 0, 1, 0);
				tessellator.addVertexWithUV(1, 0, 0, 1, 1);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
				
			}
			if(metadata == 2){
				this.bindTexture(texterwasher);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 0, 1, 1, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 0);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 1, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
			}
			
			if(metadata == 4){
				this.bindTexture(texterwasher);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 0, 1, 1, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 0);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
				
				tessellator.addVertexWithUV(1, 1, 0, 1, 0);
				tessellator.addVertexWithUV(1, 0, 0, 1, 1);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 1, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
			}
			if(metadata == 1){
				this.bindTexture(texterwasher);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
				
				tessellator.addVertexWithUV(1, 1, 0, 1, 0);
				tessellator.addVertexWithUV(1, 0, 0, 1, 1);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 1, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 0, 1, 1, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 0);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
			}
		if(metadata == 0){
				this.bindTexture(texterwasher);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 0);
				
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 1, 0, 0);
				tessellator.addVertexWithUV(0, 0, 1, 0, 1);
				
				tessellator.addVertexWithUV(1, 1, 0, 1, 0);
				tessellator.addVertexWithUV(1, 0, 0, 1, 1);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
			
				tessellator.addVertexWithUV(1, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 0, 1, 1, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 0);
				tessellator.addVertexWithUV(1, 0, 0, 0, 1);
				
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(1, 1, 1, 1, 1);
				tessellator.addVertexWithUV(1, 1, 0, 0, 1);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);

		}
		if(metadata == 8){
			this.bindTexture(texterwasher);
			tessellator.addVertexWithUV(0, 1, 1, 1, 0);
			tessellator.addVertexWithUV(1, 1, 1, 1, 1);
			tessellator.addVertexWithUV(1, 1, 0, 0, 1);
			tessellator.addVertexWithUV(0, 1, 0, 0, 0);
		}
			tessellator.draw();		
			GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
	
	public void renderInv(){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		GL11.glDisable(GL11.GL_LIGHTING);
		tessellator.addVertexWithUV(1, 1, 1, 1, 0);
		tessellator.addVertexWithUV(1, 0, 1, 1, 1);
		tessellator.addVertexWithUV(1, 0, 0, 0, 1);
		tessellator.addVertexWithUV(1, 1, 0, 0, 0);
		
		tessellator.addVertexWithUV(0, 0, 1, 1, 1);
		tessellator.addVertexWithUV(0, 1, 1, 1, 0);
		tessellator.addVertexWithUV(0, 1, 0, 0, 0);
		tessellator.addVertexWithUV(0, 0, 0, 0, 1);
		
		tessellator.addVertexWithUV(1, 0, 1, 1, 1);
		tessellator.addVertexWithUV(1, 1, 1, 1, 0);
		tessellator.addVertexWithUV(0, 1, 1, 0, 0);
		tessellator.addVertexWithUV(0, 0, 1, 0, 1);
		
		tessellator.addVertexWithUV(1, 1, 0, 1, 0);
		tessellator.addVertexWithUV(1, 0, 0, 1, 1);
		tessellator.addVertexWithUV(0, 0, 0, 0, 1);
		tessellator.addVertexWithUV(0, 1, 0, 0, 0);
	
		tessellator.addVertexWithUV(1, 0, 1, 1, 1);
		tessellator.addVertexWithUV(0, 0, 1, 1, 0);
		tessellator.addVertexWithUV(0, 0, 0, 0, 0);
		tessellator.addVertexWithUV(1, 0, 0, 0, 1);
		
		tessellator.addVertexWithUV(0, 1, 1, 1, 0);
		tessellator.addVertexWithUV(1, 1, 1, 1, 1);
		tessellator.addVertexWithUV(1, 1, 0, 0, 1);
		tessellator.addVertexWithUV(0, 1, 0, 0, 0);
		
		tessellator.draw();
		GL11.glEnable(GL11.GL_LIGHTING);

	}

}
