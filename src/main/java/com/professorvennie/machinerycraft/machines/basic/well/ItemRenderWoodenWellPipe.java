package com.professorvennie.machinerycraft.machines.basic.well;

import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ProfessorVennie on 9/14/2014 at 5:24 PM.
 */
public class ItemRenderWoodenWellPipe /*implements IItemRenderer*/ {

   /* @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glScalef(1.2F, 1.2F, 1.2F);
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/model/woodenWellPipe.png"));
        new TileEntityRendererWoodenWellPipe().renderInv();
        GL11.glScalef(-1.2F, -1.2F, -1.2F);
        GL11.glEnable(GL11.GL_LIGHTING);
    }*/
}
