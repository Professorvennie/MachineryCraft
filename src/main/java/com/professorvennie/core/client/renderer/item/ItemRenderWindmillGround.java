/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.client.renderer.item;

import com.professorvennie.core.client.renderer.tileentity.TileEnitityRendererwindmillGround;
import com.professorvennie.core.lib.Reference;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderWindmillGround implements IItemRenderer{
	
	private final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/model/windmillground.png");

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
		GL11.glDisable(GL11.GL_LIGHTING);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		new TileEnitityRendererwindmillGround().renderInv();
		GL11.glEnable(GL11.GL_LIGHTING);
	}

}
