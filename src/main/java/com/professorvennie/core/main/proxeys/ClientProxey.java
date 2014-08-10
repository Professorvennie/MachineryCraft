/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main.proxeys;

import com.professorvennie.core.client.renderer.item.*;
import com.professorvennie.core.client.renderer.tileentity.*;
import com.professorvennie.core.entitys.EntityGrenade;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.tileEntity.*;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.client.gui.book.GuiBook;
import com.professorvennie.core.client.gui.book.GuiBookEntry;
import com.professorvennie.core.client.gui.book.GuiBookIndex;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxey extends CommonProxey {
	
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmill.class, new TileEntityRendererwindmill());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmillground.class, new TileEnitityRendererwindmillGround());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWasher.class, new TileEntityRendererWasher());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new TileEntityRendererCable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlasticChest.class, new TileEntityRendererPlasticChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamPipe.class, new TileEntityRendererSteamPipe());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.washer), new ItemRenderWasher());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cable), new ItemRenderCable());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.windmillground), new ItemRenderWindmillGround());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plasticChest), new ItemRenderPlasticChest());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.steamPipe), new ItemRenderSteamPipe());

        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(ModItems.gernade));
    }
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}