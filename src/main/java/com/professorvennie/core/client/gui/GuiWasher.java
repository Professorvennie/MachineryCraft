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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.professorvennie.core.tileEntity.TileEntityWasher;
import com.professorvennie.core.common.containers.ContainerWasher;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class GuiWasher extends GuiBase{
	
public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/Washer.png");
	
	public TileEntityWasher Washer;

	public GuiWasher(InventoryPlayer inventory, TileEntityWasher entity) {
		super(new ContainerWasher(inventory, entity));
		
		this.Washer = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.Washer.isInvNameLocalized() ? this.Washer.getInvName() : I18n.format(this.Washer.getInvName(), MachineryCraft.instance);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 30, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(I18n.format("In", MachineryCraft.instance), 141, this.ySize - 116, 4210752);
		this.fontRendererObj.drawString(I18n.format("Out", MachineryCraft.instance), 135, this.ySize - 99, 4210752);
		
		List<String> text = new ArrayList<String>();
		if (Washer.tanks[0].getFluidAmount() > 0 || (Washer.tanks[0].getFluid() != null)) {
            text.clear();
            text.add(Washer.tanks[0].getFluid().getFluid().getUnlocalizedName());
            text.add(Washer.tanks[0].getFluidAmount() + "/" + Washer.tanks[0].getCapacity() + "mB");
            drawToolTipOverArea(mouseX, mouseY, 80, 17, 95, 66, text, fontRendererObj);
        } else {
            text.clear();
            text.add("Empty");
            drawToolTipOverArea(mouseX, mouseY, 80, 17, 95, 66, text, fontRendererObj);
        }
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		drawTanks();
	}

    public void drawTanks() {
        int j;
        if (Washer.tanks[0].getFluid() != null) {
            j = getValueScaled(Washer.tanks[0].getFluidAmount(), Washer.tanks[0].getCapacity(), 49);
            this.drawFluid(guiLeft + 80, guiTop + 66 - j, Washer.tanks[0].getFluid(), 16, j);
        }
    }
}
