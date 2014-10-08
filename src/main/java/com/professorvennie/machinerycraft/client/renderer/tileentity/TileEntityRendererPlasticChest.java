/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client.renderer.tileentity;

import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.tileEntity.TileEntityPlasticChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntityRendererPlasticChest extends TileEntitySpecialRenderer {

    private final ModelChest modelChest = new ModelChest();
    private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/plastic_chest.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick, int i) {
        if (tileEntity instanceof TileEntityPlasticChest) {
            TileEntityPlasticChest tileEntityPlasticChest = (TileEntityPlasticChest) tileEntity;
            EnumFacing direction = null;

            if (tileEntityPlasticChest.getWorld() != null) {
                direction = tileEntityPlasticChest.getOrientation();
                //System.out.println(tileEntityPlasticChest.getOrientation());
            }
            this.bindTexture(texture);


            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short angle = 0;

            if (direction != null) {
                if (direction == EnumFacing.NORTH) {
                    angle = 180;
                } else if (direction == EnumFacing.SOUTH) {
                    angle = 0;
                } else if (direction == EnumFacing.WEST) {
                    angle = 90;
                } else if (direction == EnumFacing.EAST) {
                    angle = -90;
                }
            }

            GL11.glRotatef(angle, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float adjustedLidAngle = tileEntityPlasticChest.prevLidAngle + (tileEntityPlasticChest.lidAngle - tileEntityPlasticChest.prevLidAngle) * tick;
            adjustedLidAngle = 1.0F - adjustedLidAngle;
            adjustedLidAngle = 1.0F - adjustedLidAngle * adjustedLidAngle * adjustedLidAngle;
            modelChest.chestLid.rotateAngleX = -(adjustedLidAngle * (float) Math.PI / 2.0F);
            modelChest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
