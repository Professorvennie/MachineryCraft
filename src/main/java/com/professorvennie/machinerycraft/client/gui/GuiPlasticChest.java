/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client.gui;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.common.containers.ContainerPlasticChest;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.tileEntity.TileEntityPlasticChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiPlasticChest extends GuiContainer {

    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/plasticChest.png");
    private TileEntityPlasticChest entity;

    public GuiPlasticChest(InventoryPlayer inventory, TileEntityPlasticChest entity) {
        super(new ContainerPlasticChest(inventory, entity));

        this.entity = entity;
        this.xSize = 176;
        this.ySize = 222;
    }

    public void drawGuiContainerForegroundLayer(int par1, int par2) {
        String name = this.entity.hasCustomName() ? this.entity.getCustomName() : I18n.format(this.entity.getInventoryName(), MachineryCraft.instance);

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format(Names.Containers.CONTAINER_INVENTORY, MachineryCraft.instance), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
