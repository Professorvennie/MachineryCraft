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
import com.professorvennie.api.book.IGuiBookEntry;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.LibBookText;

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
						drawLexiconGUI(entry, event.resolution);
				}
			}
    	}
    }

			private void drawLexiconGUI(BookEntry entry, ScaledResolution res) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				Minecraft mc = Minecraft.getMinecraft();
				int x = res.getScaledWidth() / 2  + 8;
				int y = res.getScaledHeight() / 2 - 4;

				int color = 0x6600FF00;

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
