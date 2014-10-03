/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.windmill;

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.tileEntity.TileEntityCable;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererwindmill extends TileEntitySpecialRenderer {

    private final ResourceLocation texterwindmill = new ResourceLocation(Reference.MOD_ID, "textures/model/WINDMILL.png");
    private float pixel = 1F / 16F;
    private int textureWidth = 32;
    private int textureHeight = 32;

    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        int x1 = tileentity.xCoord;
        int y1 = tileentity.yCoord;
        int z1 = tileentity.zCoord;
        while (tileentity.getWorldObj().getBlockMetadata(x1, y1, z1) < 7 && tileentity.getWorldObj().getBlock(x1, y1, z1).equals(ModBlocks.windmill)) {
            y1++;
        }

        int direction = tileentity.getWorldObj().getBlockMetadata(x1, y1, z1) - 8;
        int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x, (float) y, (float) z);

        GL11.glTranslatef(0.5F, 0, 0.5F);
        GL11.glRotatef(direction * 90, 0, 1, 0);
        GL11.glTranslatef(-0.5F, 0, -0.5F);

        if (metadata == 1) {
            TileEntity cable = tileentity.getWorldObj().getTileEntity(tileentity.xCoord - 1, tileentity.yCoord, tileentity.zCoord);
            if (cable instanceof TileEntityCable) drawConnector(ForgeDirection.EAST);

            cable = tileentity.getWorldObj().getTileEntity(tileentity.xCoord + 1, tileentity.yCoord, tileentity.zCoord);
            if (cable instanceof TileEntityCable) drawConnector(ForgeDirection.WEST);

            cable = tileentity.getWorldObj().getTileEntity(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord + 1);
            if (cable instanceof TileEntityCable) drawConnector(ForgeDirection.SOUTH);

            cable = tileentity.getWorldObj().getTileEntity(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord - 1);
            if (cable instanceof TileEntityCable) drawConnector(ForgeDirection.NORTH);
        }

        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(texterwindmill);
        tessellator.startDrawingQuads();
        {

            if (metadata > 0 && metadata < 7) {
                tessellator.addVertexWithUV((8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV((8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((8) / 2 * pixel, 1, (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((8) / 2 * pixel, 0, (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV((8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV((8) / 2 * pixel, 0, (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV((8) / 2 * pixel, 1, (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 1, (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 0, (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 0, (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 1, (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                tessellator.addVertexWithUV(1 - (8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));
            }
            if (metadata > 7) {
            }
        }
        tessellator.draw();

        if (metadata > 7) drawRoatar(tileentity);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    private void drawRoatar(TileEntity tileentity) {
        TileEntityWindmill windmill = (TileEntityWindmill) tileentity.getWorldObj().getTileEntity(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
        GL11.glTranslatef(0, 0.5F, 0.5F);
        GL11.glRotatef(windmill.rotaion, 1, 0, 0);
        GL11.glTranslatef(0, -0.5F, -0.5F);

        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(texterwindmill);
        tessellator.startDrawingQuads();
        {
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 2.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 2.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, 2.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 2.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, -1.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, -1.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, -1.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, -1.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 2.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 2.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 2.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 2.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            tessellator.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
        }
        tessellator.draw();
    }

    public void drawConnector(ForgeDirection direction) {
        ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/cable.png");

        float texturePixel = 1F / 32F;
        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(texture);
        tessellator.startDrawingQuads();
        {
            GL11.glTranslated(0.5F, 0.5F, 0.5F);
            if (direction.equals(ForgeDirection.EAST)) {
                GL11.glRotatef(-90, 1, 0, 0);
            } else if (direction.equals(ForgeDirection.SOUTH)) {
                GL11.glRotatef(-90, 0, 0, 1);
            } else if (direction.equals(ForgeDirection.NORTH)) {
                GL11.glRotatef(90, 0, 0, 1);
            } else if (direction.equals(ForgeDirection.WEST)) {
                GL11.glRotatef(90, 1, 0, 0);
            }
            GL11.glTranslated(-0.5F, -0.5F, -0.5F);

            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
        }
        tessellator.draw();

        GL11.glTranslated(0.5F, 0.5F, 0.5F);
        if (direction.equals(ForgeDirection.EAST)) {
            GL11.glRotatef(90, 1, 0, 0);
        } else if (direction.equals(ForgeDirection.SOUTH)) {
            GL11.glRotatef(90, 0, 0, 1);
        } else if (direction.equals(ForgeDirection.NORTH)) {
            GL11.glRotatef(-90, 0, 0, 1);
        } else if (direction.equals(ForgeDirection.WEST)) {
            GL11.glRotatef(-90, 1, 0, 0);
        }
        GL11.glTranslated(-0.5F, -0.5F, -0.5F);
    }
}
