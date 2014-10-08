/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client.renderer.item;


public class ItemRenderPlasticChest/* implements IItemRenderer*/ {
   // private final ModelChest modelChest;

    /*public ItemRenderPlasticChest() {
        modelChest = new ModelChest();
    }

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
        switch (type) {
            case ENTITY: {
                renderChest(0.5F, 0.5F, 0.5F, item.getItemDamage());
                break;
            }
            case EQUIPPED: {
                renderChest(1.0F, 1.0F, 1.0F, item.getItemDamage());
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                renderChest(1.0F, 1.0F, 1.0F, item.getItemDamage());
                break;
            }
            case INVENTORY: {
                renderChest(0.0F, 0.075F, 0.0F, item.getItemDamage());
                break;
            }
            default:
                break;
        }
    }

    private void renderChest(float x, float y, float z, int metaData) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/model/plastic_chest.png"));

        GL11.glPushMatrix(); //start
        GL11.glTranslatef(x, y, z); //size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        modelChest.renderAll();
        GL11.glPopMatrix(); //end
    }*/
}
