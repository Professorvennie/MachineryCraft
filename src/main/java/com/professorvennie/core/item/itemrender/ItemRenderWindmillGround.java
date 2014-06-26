package com.professorvennie.core.item.itemrender;

import com.professorvennie.core.lib.Reference;
import org.lwjgl.opengl.GL11;

import com.professorvennie.core.block.tileEntity.render.TileEnitityRenderwindmillGround;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderWindmillGround implements IItemRenderer{
	
	private final ResourceLocation texterwindmillground = new ResourceLocation(Reference.MOD_ID, "textures/model/windmillground.png");

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
		Minecraft.getMinecraft().renderEngine.bindTexture(texterwindmillground);
		new TileEnitityRenderwindmillGround().renderInv();
		GL11.glEnable(GL11.GL_LIGHTING);
	}

}
