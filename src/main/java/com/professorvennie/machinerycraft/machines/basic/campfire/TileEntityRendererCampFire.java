package com.professorvennie.machinerycraft.machines.basic.campfire;

import com.professorvennie.machinerycraft.client.models.ModelCampFire;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

/**
 * Created by ProfessorVennie on 9/14/2014 at 6:40 PM.
 */
public class TileEntityRendererCampFire extends TileEntitySpecialRenderer {

    private ModelCampFire model = new ModelCampFire();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if (tileEntity instanceof TileEntityCampFire) {
            TileEntityCampFire tile = (TileEntityCampFire) tileEntity;

            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glPushMatrix();
            GL11.glRotatef(180f, 0.0F, 0.0F, 1.0F);
            GL11.glScalef(1f, -1f, -1f);
            model.render((Entity) null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
            GL11.glScalef(-1f, 1f, 1f);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_LIGHTING);
        }
    }
}
