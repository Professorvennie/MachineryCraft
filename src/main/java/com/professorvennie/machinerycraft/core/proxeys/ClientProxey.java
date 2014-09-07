/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.proxeys;

import com.professorvennie.machinerycraft.client.renderer.item.*;
import com.professorvennie.machinerycraft.client.renderer.tileentity.*;
import com.professorvennie.machinerycraft.entitys.EntityGrenade;
import com.professorvennie.machinerycraft.item.ModItems;
import com.professorvennie.machinerycraft.tileEntity.*;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.professorvennie.machinerycraft.block.ModBlocks;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxey extends CommonProxey {
	
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmill.class, new TileEntityRendererwindmill());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmillground.class, new TileEnitityRendererwindmillGround());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWasher.class, new TileEntityRendererWasher());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new TileEntityRendererCable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlasticChest.class, new TileEntityRendererPlasticChest());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.washer), new ItemRenderWasher());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cable), new ItemRenderCable());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.windmillground), new ItemRenderWindmillGround());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plasticChest), new ItemRenderPlasticChest());

        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(ModItems.gernades));
    }
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}