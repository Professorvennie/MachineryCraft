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

import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEnitityRendererwindmillGround extends TileEntitySpecialRenderer {

    private final ResourceLocation texterwindmillground = new ResourceLocation(Reference.MOD_ID, "textures/model/windmillground.png");

    private int textureWidth = 32;
    private int textureHeight = 32;

    private float pixel = 1F / 16F;

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x, (float) y, (float) z);

        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.bindTexture(texterwindmillground);
        worldRenderer.startDrawingQuads();
        {
            if (tileentity.getBlockMetadata() == 0) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));
            }
            if (tileentity.getBlockMetadata() == 1) {
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0.5, 1F / textureWidth * (8 + 16), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0.5, 0, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, 0, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(pixel * 8, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(pixel * 8, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(pixel * 8, pixel * 14, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(pixel * 8, 0, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0.5, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, 0, 0.5, 1F / textureWidth * (8 + 16), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8 + 16));

            }
            if (tileentity.getBlockMetadata() == 2) {
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8 + 16));

                worldRenderer.addVertexWithUV(pixel * 8, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(pixel * 8, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(pixel * 8, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(pixel * 8, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0.5, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0.5, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8));

            }
            if (tileentity.getBlockMetadata() == 3) {
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0.5, 1F / textureWidth * (8 + 16), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8));

                worldRenderer.addVertexWithUV(pixel * 8, 0, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(pixel * 8, pixel * 14, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(pixel * 8, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(pixel * 8, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0, 0, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, pixel * 14, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, 0, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0, 0, 0.5, 1F / textureWidth * (8 + 16), 1F / textureHeight * (0));

            }
            if (tileentity.getBlockMetadata() == 4) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 0.5, 1F / textureWidth * (24), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (24), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (8), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, pixel * 14, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, 0, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (24), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(1, 0, 0.5, 1F / textureWidth * (24), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, 0, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (8), 1F / textureHeight * (8 + 16));

            }
            if (tileentity.getBlockMetadata() == 5) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (8 + 16), 1F / textureHeight * 8);
                worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * 8, 1F / textureHeight * 8);
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * 8, 1F / textureHeight * (8 + 16));

                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (8 + 16), 1F / textureHeight * 8);
                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (8 + 16), 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * 8, 1F / textureHeight * (8 + 16));
                worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * 8, 1F / textureHeight * 8);

            }
            if (tileentity.getBlockMetadata() == 6) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (24), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0.5, 1F / textureWidth * (24), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (8), 1F / textureHeight * (8));

                worldRenderer.addVertexWithUV(0, 0, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0, pixel * 14, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, 0, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 0.5, 1F / textureWidth * (24), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (24), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (8), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0, 0, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (0));

            }
            if (tileentity.getBlockMetadata() == 7) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (8), 1F / textureHeight * (24));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (24));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(1, pixel * 14, pixel * 8, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, 0, pixel * 8, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (8), 1F / textureHeight * (24));
                worldRenderer.addVertexWithUV(1, 0, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (24));

            }
            if (tileentity.getBlockMetadata() == 8) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (8), 1F / textureHeight * (24));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (8), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (24));

                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (8), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (8), 1F / textureHeight * (24));
                worldRenderer.addVertexWithUV(0.5, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (24));
                worldRenderer.addVertexWithUV(0.5, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (8));

            }
            if (tileentity.getBlockMetadata() == 9) {
                worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (8), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (8));

                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, pixel * 14, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, 0, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(0.5, pixel * 14, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (32));
                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (32), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(0.5, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

                worldRenderer.addVertexWithUV(1, 0, 0.5, 1F / textureWidth * (8), 1F / textureHeight * (0));
                worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (8), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0.5, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (8));
                worldRenderer.addVertexWithUV(0.5, 0, 0.5, 1F / textureWidth * (0), 1F / textureHeight * (0));

            }
        }
        worldRenderer.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void renderInv() {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.startDrawingQuads();

        worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (32));
        worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

        worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
        worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (32));

        worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
        worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (32));

        worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (32));
        worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

        worldRenderer.addVertexWithUV(1, pixel * 14, 1, 1F / textureWidth * (32), 1F / textureHeight * (32));
        worldRenderer.addVertexWithUV(1, 0, 1, 1F / textureWidth * (32), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(1, 0, 0, 1F / textureWidth * (0), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(1, pixel * 14, 0, 1F / textureWidth * (0), 1F / textureHeight * (32));

        worldRenderer.addVertexWithUV(0, pixel * 14, 0, 1F / textureWidth * (32), 1F / textureHeight * (32));
        worldRenderer.addVertexWithUV(0, 0, 0, 1F / textureWidth * (32), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, 0, 1, 1F / textureWidth * (0), 1F / textureHeight * (0));
        worldRenderer.addVertexWithUV(0, pixel * 14, 1, 1F / textureWidth * (0), 1F / textureHeight * (32));

        tessellator.draw();
    }
}
