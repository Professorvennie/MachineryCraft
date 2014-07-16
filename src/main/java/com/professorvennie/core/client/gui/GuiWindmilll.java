/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.client.gui;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.professorvennie.core.tileEntity.TileEntitywindmill;
import com.professorvennie.core.common.containers.ContainerWindmill;

public class GuiWindmilll extends GuiContainer{
	public TileEntitywindmill windmill;

	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/WINDMILL.png");
	
	public GuiWindmilll(InventoryPlayer inventory, TileEntitywindmill entity) {
		super(new ContainerWindmill(inventory, entity));
		this.windmill = entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.windmill.isInvNameLocalized() ? this.windmill.getInventoryName() : I18n.format(this.windmill.getInventoryName(), MachineryCraft.instance);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 8, this.ySize - 96 + 2, 4210752);
	}
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int i = this.windmill.getPowerScaled(45);
		drawTexturedModalRect(guiLeft+80, guiTop+21+45-i, 176, 45-i, 16, i);
		
	}

}
