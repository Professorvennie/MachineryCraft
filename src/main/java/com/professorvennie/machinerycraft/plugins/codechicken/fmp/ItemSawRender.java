package com.professorvennie.machinerycraft.plugins.codechicken.fmp;


import java.util.Map;

/**
 * Created by ProfessorVennie on 9/20/2014 at 3:41 PM.
 */
public class ItemSawRender /*implements IItemRenderer*/ {

    /*Map<String, CCModel> models = CCModel.parseObjModels(new ResourceLocation("microblock", "models/saw.obj"), 7, new SwapYZ());
    CCModel handle = models.get("Handle");
    CCModel holder = models.get("BladeSupport");
    CCModel blade = models.get("Blade");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        double pi = Math.PI;

        Transformation t;
        switch (type) {
            case INVENTORY:
                t = new TransformationList(new Scale(1.8), new Translation(0, 0, -0.6), new Rotation(-pi / 4, 1, 0, 0), new Rotation(pi * 3 / 4, 0, 1, 0));
                break;
            case ENTITY:
                t = new TransformationList(new Scale(1), new Translation(0, 0, -0.25), new Rotation(-pi / 4, 1, 0, 0));
                break;
            case EQUIPPED_FIRST_PERSON:
                t = new TransformationList(new Scale(1.5), new Rotation(-pi / 3, 1, 0, 0), new Rotation(pi * 3 / 4, 0, 1, 0), new Translation(0.5, 0.5, 0.5));
                break;
            case EQUIPPED:
                t = new TransformationList(new Scale(1.5), new Rotation(pi / 5, 1, 0, 0), new Rotation(-pi * 3 / 4, 0, 1, 0), new Translation(0.75, 0.5, 0.75));
                break;
            default:
                t = null;
                break;
        }

        CCRenderState.reset();
        CCRenderState.useNormals = true;
        CCRenderState.pullLightmap();
        CCRenderState.changeTexture("microblock:textures/items/saw.png");
        CCRenderState.startDrawing();
        handle.render(t);
        holder.render(t);
        CCRenderState.draw();
        GL11.glDisable(GL11.GL_CULL_FACE);
        CCRenderState.changeTexture(Reference.MOD_ID + ":textures/items/sawColors.png");
        CCRenderState.startDrawing();

        int tex = 0;
        if (item.getItem() == FMPPlugin.copperSaw) {
            tex = 0;
        } else if (item.getItem() == FMPPlugin.tinSaw) {
            tex = 1;
        } else if (item.getItem() == FMPPlugin.silverSaw) {
            tex = 2;
        } else if (item.getItem() == FMPPlugin.leadSaw) {
            tex = 3;
        } else if (item.getItem() == FMPPlugin.zincSaw) {
            tex = 4;
        } else if (item.getItem() == FMPPlugin.bronzeSaw) {
            tex = 5;
        } else if (item.getItem() == FMPPlugin.brassSaw) {
            tex = 6;
        }
        blade.render(t, new UVTranslation(0, tex * 4 / 64D));
        CCRenderState.draw();
        GL11.glEnable(GL11.GL_CULL_FACE);
    }*/
}
