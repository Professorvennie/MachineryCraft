/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client;

import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by ProfessorVennie on 8/22/2014 at 12:29 AM.
 */
public class EventHandlerClient {

    /*@SubscribeEvent
    public void renderCustomArmor(RenderPlayerEvent.Specials.Post event) {
        for (ItemStack itemStack : event.entityPlayer.inventory.armorInventory) {
            if (itemStack != null) {
                if (itemStack.getItem() == ModItems.emeraldchest) {
                    event.entityPlayer.capabilities.allowFlying = true;
                    event.entityPlayer.capabilities.disableDamage = true;
                    ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/blocks/brassSolar_Top.png");
                    GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
                    Tessellator tessellator = Tessellator.instance;
                    tessellator.startDrawingQuads();
                    {
                        //render
                        tessellator.addVertexWithUV(0, 0, 0, 0, 0);
                        tessellator.addVertexWithUV(1, 0, 0, 0, 1);
                        tessellator.addVertexWithUV(1, 1, 0, 1, 1);
                        tessellator.addVertexWithUV(0, 1, 0, 1, 0);
                    }
                    tessellator.draw();
                    GL11.glPopMatrix();
                }
            }
        }
    }*/
}
