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

import com.professorvennie.machinerycraft.common.containers.ContainerBag;
import com.professorvennie.machinerycraft.common.containers.InventoryBag;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by ProfessorVennie on 8/28/2014 at 7:03 PM.
 */
public class GuiBag extends GuiContainer {

    private ResourceLocation texture;

    public GuiBag(EntityPlayer player, InventoryBag inventoryBag) {
        super(new ContainerBag(player, inventoryBag));

        if (player.getHeldItem().getItemDamage() == 0) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/WoodenBag.png");
            this.xSize = 176;
            this.ySize = 168;
        } else if (player.getHeldItem().getItemDamage() == 1) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/TinBag.png");
            this.xSize = 176;
            this.ySize = 186;
        } else if (player.getHeldItem().getItemDamage() == 2) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/CopperBag.png");
            this.xSize = 176;
            this.ySize = 204;
        } else if (player.getHeldItem().getItemDamage() == 3) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/ZincBag.png");
            this.xSize = 176;
            this.ySize = 222;
        } else if (player.getHeldItem().getItemDamage() == 4) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/IronBag.png");
            this.xSize = 176;
            this.ySize = 240;
        } else if (player.getHeldItem().getItemDamage() == 5) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/SilverBag.png");
            this.xSize = 176;
            this.ySize = 256;
        } else if (player.getHeldItem().getItemDamage() == 6) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/LeadBag.png");
            this.xSize = 176;
            this.ySize = 256;
        } else if (player.getHeldItem().getItemDamage() == 7) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/GoldBag.png");
            this.xSize = 212;
            this.ySize = 256;
        } else if (player.getHeldItem().getItemDamage() == 8) {
            texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/DiamondBag.png");
            this.xSize = 248;
            this.ySize = 256;
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {

    }
}
