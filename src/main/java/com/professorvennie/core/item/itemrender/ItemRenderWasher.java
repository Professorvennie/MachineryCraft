package com.professorvennie.core.item.itemrender;

import org.lwjgl.opengl.GL11;

import com.professorvennie.core.block.tileEntity.render.TileEntityRenderWasher;
import com.professorvennie.core.lib.LibStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.MinecraftForge;

public class ItemRenderWasher implements IItemRenderer{
	
	private final ResourceLocation texterwasher = new ResourceLocation(LibStrings.MODID, "textures/blocks/ores/metal_6.png");

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
		Minecraft.getMinecraft().renderEngine.bindTexture(texterwasher);
		new TileEntityRenderWasher().renderInv();
	}

}
