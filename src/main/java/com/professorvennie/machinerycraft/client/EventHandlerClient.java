package com.professorvennie.machinerycraft.client;

import com.professorvennie.machinerycraft.item.ModItems;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by ProfessorVennie on 8/22/2014 at 12:29 AM.
 */
public class EventHandlerClient {

    @SubscribeEvent
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
    }
}
