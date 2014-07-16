/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.api.book.IBookable;
import com.professorvennie.core.item.ModItems;

public class HudHandler {

    private static final RenderItem itemRender = new RenderItem();

    @SubscribeEvent
    public void onDrawScreen(RenderGameOverlayEvent.Post event) {
    	if(event.type == ElementType.ALL) {
			Minecraft mc = Minecraft.getMinecraft();
			MovingObjectPosition pos = mc.objectMouseOver;
			if(pos != null && mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() == ModItems.book) {
				Block block = mc.theWorld.getBlock(pos.blockX, pos.blockY, pos.blockZ);
				if(block instanceof IBookable) {
					BookEntry entry = ((IBookable) block).getEntry(mc.theWorld, pos.blockX, pos.blockY, pos.blockZ, mc.thePlayer, mc.thePlayer.getCurrentEquippedItem());
					if(entry != null)
						drawBookGUI(entry, event.resolution);
				}
			}
    	}
    }

		private void drawBookGUI(BookEntry entry, ScaledResolution res) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft mc = Minecraft.getMinecraft();
			int x = res.getScaledWidth() / 2  + 8;
			int y = res.getScaledHeight() / 2 - 4;

			int color = 0xFF5A28;

			String info = StatCollector.translateToLocal("mc.book.shiftToRead");
			int itemX = x - (mc.fontRenderer.getStringWidth(new ItemStack(ModItems.book).getDisplayName()) / 2);
            mc.fontRenderer.drawStringWithShadow(StatCollector.translateToLocal(entry.getUnlocalizedName()), itemX, y + 6, color);
			mc.fontRenderer.drawStringWithShadow(info, x - (mc.fontRenderer.getStringWidth(info) / 2), y + 18, color);
			itemRender.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, new ItemStack(ModItems.book), itemX - 20, y + 2);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glColor4f(1F, 1F, 1F, 1F);
		}
}
