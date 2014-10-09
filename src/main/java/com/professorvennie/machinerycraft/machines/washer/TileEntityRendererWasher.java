/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.washer;

import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererWasher extends TileEntitySpecialRenderer {

    private final ResourceLocation texterwasher = new ResourceLocation(Reference.MOD_ID, "textures/blocks/ores/metal_6.png");
    private final ResourceLocation glass = new ResourceLocation("textures/blocks/glass.png");
    private float pixel = 1F / 16F;
    private int textureWidth = 32;
    private int textureHeight = 32;

    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float var8, int i) {
        int x1 = tileentity.getPos().getX();
        int y1 = tileentity.getPos().getY();
        int z1 = tileentity.getPos().getZ();

        int metadata = tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().getMetaFromState(tileentity.getWorld().getBlockState(tileentity.getPos()));

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float) x, (float) y, (float) z);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.bindTexture(texterwasher);
        worldRenderer.startDrawingQuads();

        if (metadata == 5) {
            this.bindTexture(glass);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

            worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        }
        if (metadata == 7) {
            this.bindTexture(glass);

            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);

        }
        if (metadata == 6) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

            worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
        }
        if (metadata == 3) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

            worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        }
        if (metadata == 2) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        }
        if (metadata == 4) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

            worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        }
        if (metadata == 1) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

            worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
        }
        if (metadata == 0) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(0, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
            worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

            worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

            worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
            worldRenderer.addVertexWithUV(0, 0, 1, 1, 0);
            worldRenderer.addVertexWithUV(0, 0, 0, 0, 0);
            worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);

            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        }
        if (metadata == 8) {
            this.bindTexture(texterwasher);
            worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
            worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
            worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
            worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        }
        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }

    public void renderInv() {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.startDrawingQuads();
        GL11.glDisable(GL11.GL_LIGHTING);
        worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
        worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
        worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);
        worldRenderer.addVertexWithUV(1, 1, 0, 0, 0);

        worldRenderer.addVertexWithUV(0, 0, 1, 1, 1);
        worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
        worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);
        worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);

        worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
        worldRenderer.addVertexWithUV(1, 1, 1, 1, 0);
        worldRenderer.addVertexWithUV(0, 1, 1, 0, 0);
        worldRenderer.addVertexWithUV(0, 0, 1, 0, 1);

        worldRenderer.addVertexWithUV(1, 1, 0, 1, 0);
        worldRenderer.addVertexWithUV(1, 0, 0, 1, 1);
        worldRenderer.addVertexWithUV(0, 0, 0, 0, 1);
        worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

        worldRenderer.addVertexWithUV(1, 0, 1, 1, 1);
        worldRenderer.addVertexWithUV(0, 0, 1, 1, 0);
        worldRenderer.addVertexWithUV(0, 0, 0, 0, 0);
        worldRenderer.addVertexWithUV(1, 0, 0, 0, 1);

        worldRenderer.addVertexWithUV(0, 1, 1, 1, 0);
        worldRenderer.addVertexWithUV(1, 1, 1, 1, 1);
        worldRenderer.addVertexWithUV(1, 1, 0, 0, 1);
        worldRenderer.addVertexWithUV(0, 1, 0, 0, 0);

        tessellator.draw();
        GL11.glEnable(GL11.GL_LIGHTING);
    }
}
