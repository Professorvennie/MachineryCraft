package com.professorvennie.core.gui;

import com.professorvennie.core.lib.Reference;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.professorvennie.core.block.tileEntity.TileEntitySaltFurnace;
import com.professorvennie.core.gui.containers.ContainerSaltFurnace;
import com.professorvennie.core.main.MainRegistry;

public class GuiSaltFurnace extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/saltfurnace.png");
	
	public TileEntitySaltFurnace saltFurnace;
	
	public GuiSaltFurnace(InventoryPlayer inventoryPlayer, TileEntitySaltFurnace entity) {
		super(new ContainerSaltFurnace(inventoryPlayer, entity));
		
		this.saltFurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.saltFurnace.isInvNameLocalized() ? this.saltFurnace.getInvName() : I18n.format(this.saltFurnace.getInvName(), MainRegistry.instance);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("contaniner.inventory", MainRegistry.instance), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.saltFurnace.isBurning()){
			int k = this.saltFurnace.getBurnTimeReamingScaled(12);
			drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 2);
		}
		
		int k = this.saltFurnace.getCookProgressSacled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, k + 1, 16);
	}

}
