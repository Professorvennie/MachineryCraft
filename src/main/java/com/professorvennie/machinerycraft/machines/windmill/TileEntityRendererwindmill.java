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
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererwindmill extends TileEntitySpecialRenderer {

    private final ResourceLocation texterwindmill = new ResourceLocation(Reference.MOD_ID, "textures/model/WINDMILL.png");
    private float pixel = 1F / 16F;
    private int textureWidth = 32;
    private int textureHeight = 32;

    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {
        int x1 = tileentity.getPos().getX();
        int y1 = tileentity.getPos().getY();
        int z1 = tileentity.getPos().getZ();
        while (tileentity.getBlockMetadata() < 7 && tileentity.getWorld().getBlockState(new BlockPos(x1, y1, z1)).equals(ModBlocks.windmill)) {
            y1++;
        }

        int direction = tileentity.getBlockMetadata() - 8;
        int metadata = tileentity.getBlockMetadata();

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x, (float) y, (float) z);

        GL11.glTranslatef(0.5F, 0, 0.5F);
        GL11.glRotatef(direction * 90, 0, 1, 0);
        GL11.glTranslatef(-0.5F, 0, -0.5F);

        if (metadata == 1) {
            int xCoord = tileentity.getPos().getX();
            int yCoord = tileentity.getPos().getY();
            int zCoord = tileentity.getPos().getZ();
            TileEntity cable = tileentity.getWorld().getTileEntity(new BlockPos(xCoord - 1, yCoord, zCoord));
            if (cable instanceof TileEntityCable) drawConnector(EnumFacing.EAST);

            cable = tileentity.getWorld().getTileEntity(new BlockPos(xCoord + 1, yCoord, zCoord));
            if (cable instanceof TileEntityCable) drawConnector(EnumFacing.WEST);

            cable = tileentity.getWorld().getTileEntity(new BlockPos(xCoord, yCoord, zCoord + 1));
            if (cable instanceof TileEntityCable) drawConnector(EnumFacing.SOUTH);

            cable = tileentity.getWorld().getTileEntity(new BlockPos(xCoord, yCoord, zCoord - 1));
            if (cable instanceof TileEntityCable) drawConnector(EnumFacing.NORTH);
        }

        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.bindTexture(texterwindmill);
        worldRenderer.startDrawingQuads();
        {

            if (metadata > 0 && metadata < 7) {
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 1, (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 0, (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                worldRenderer.addVertexWithUV((8) / 2 * pixel, 0, (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                worldRenderer.addVertexWithUV((8) / 2 * pixel, 1, (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 1, (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 0, (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));

                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 0, (8) / 2 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 1, (8) / 2 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 1, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 0 * (1F / textureHeight));
                worldRenderer.addVertexWithUV(1 - (8) / 2 * pixel, 0, 1 - (8) / 2 * pixel, 0 * (1F / textureWidth), 1 * (1F / textureHeight));
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
        TileEntityWindmill windmill = (TileEntityWindmill) tileentity.getWorld().getTileEntity(tileentity.getPos());
        GL11.glTranslatef(0, 0.5F, 0.5F);
        GL11.glRotatef(windmill.rotaion, 1, 0, 0);
        GL11.glTranslatef(0, -0.5F, -0.5F);

        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.bindTexture(texterwindmill);
        worldRenderer.startDrawingQuads();
        {
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 2.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 2.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, 2.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 2.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, -1.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, -1.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, -1.5F, 1 * pixel + 0.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, -1.5F, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1 * pixel + 0.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 2.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 2.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 2.5F, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 2.5F, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F + 1 * pixel, 8 * (1F / textureWidth), 0 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));

            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 0 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, 0.5F - 1 * pixel, 9 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F - 1 * pixel, -1.5F, 8 * (1F / textureWidth), 1 * (1F / textureHeight));
            worldRenderer.addVertexWithUV(-2 * pixel, 0.5F + 1 * pixel, -1.5F, 8 * (1F / textureWidth), 0 * (1F / textureHeight));
        }
        tessellator.draw();
    }

    public void drawConnector(EnumFacing direction) {
        ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/cable.png");

        float texturePixel = 1F / 32F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.bindTexture(texture);
        worldRenderer.startDrawingQuads();
        {
            GL11.glTranslated(0.5F, 0.5F, 0.5F);
            if (direction.equals(EnumFacing.EAST)) {
                GL11.glRotatef(-90, 1, 0, 0);
            } else if (direction.equals(EnumFacing.SOUTH)) {
                GL11.glRotatef(-90, 0, 0, 1);
            } else if (direction.equals(EnumFacing.NORTH)) {
                GL11.glRotatef(90, 0, 0, 1);
            } else if (direction.equals(EnumFacing.WEST)) {
                GL11.glRotatef(90, 1, 0, 0);
            }
            GL11.glTranslated(-0.5F, -0.5F, -0.5F);

            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 26 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(1 - 11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);

            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 1 - 11 * pixel / 2, 10 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 1 - 11 * pixel / 2, 14 * texturePixel, 5 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1 - 4 * pixel, 11 * pixel / 2, 14 * texturePixel, 0 * texturePixel);
            worldRenderer.addVertexWithUV(11 * pixel / 2, 1, 11 * pixel / 2, 10 * texturePixel, 0 * texturePixel);
        }
        tessellator.draw();

        GL11.glTranslated(0.5F, 0.5F, 0.5F);
        if (direction.equals(EnumFacing.EAST)) {
            GL11.glRotatef(90, 1, 0, 0);
        } else if (direction.equals(EnumFacing.SOUTH)) {
            GL11.glRotatef(90, 0, 0, 1);
        } else if (direction.equals(EnumFacing.NORTH)) {
            GL11.glRotatef(-90, 0, 0, 1);
        } else if (direction.equals(EnumFacing.WEST)) {
            GL11.glRotatef(-90, 1, 0, 0);
        }
        GL11.glTranslated(-0.5F, -0.5F, -0.5F);
    }
}
