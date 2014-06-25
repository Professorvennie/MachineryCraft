package com.professorvennie.core.item.itemrender;

import org.lwjgl.opengl.GL11;

import com.professorvennie.core.block.tileEntity.render.TileEntityRenderCable;
import com.professorvennie.core.lib.LibStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemRenderCable implements IItemRenderer{
	
	private final ResourceLocation texter = new ResourceLocation(LibStrings.MODID, "textures/model/cable.png");

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
		Minecraft.getMinecraft().renderEngine.bindTexture(texter);
		new TileEntityRenderCable().drawStriaght(ForgeDirection.NORTH);
		GL11.glEnable(GL11.GL_LIGHTING);

	}


}
