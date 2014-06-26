package com.professorvennie.core.gui;

import com.professorvennie.core.lib.Reference;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.professorvennie.core.block.tileEntity.TileEntityGoldOxideFurnace;
import com.professorvennie.core.gui.containers.ContainerGoldoxideFurnace;
import com.professorvennie.core.main.MainRegistry;

public class GuiGoldoxideFurnace extends GuiContainer{
	
public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/Goldoxide_Furnace.png");
	
	public TileEntityGoldOxideFurnace Furnace;

	public GuiGoldoxideFurnace(InventoryPlayer inventory, TileEntityGoldOxideFurnace entity) {
		super(new ContainerGoldoxideFurnace(inventory, entity));
		
		this.Furnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.Furnace.isInvNameLocalized() ? this.Furnace.getInvName() : I18n.format(this.Furnace.getInvName(), MainRegistry.instance);
		
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
