package com.professorvennie.core.gui;

import org.lwjgl.opengl.GL11;

import com.professorvennie.core.block.tileEntity.TileEntityGoldOxideGrinder;
import com.professorvennie.core.gui.containers.ContainerGoldoxideGrinder;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.MainRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiGoldoxideGrinder extends GuiContainer{
	
public static final ResourceLocation texture = new ResourceLocation(LibStrings.MODID, "textures/gui/Goldoxide_Grinder.png");
	
	public TileEntityGoldOxideGrinder Grinder;

	public GuiGoldoxideGrinder(InventoryPlayer inventory, TileEntityGoldOxideGrinder entity) {
		super(new ContainerGoldoxideGrinder(inventory, entity));
		this.Grinder = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.Grinder.isInvNameLocalized() ? this.Grinder.getInvName() : I18n.format(this.Grinder.getInvName(), MainRegistry.instance);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("contaniner.inventory", MainRegistry.instance), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
