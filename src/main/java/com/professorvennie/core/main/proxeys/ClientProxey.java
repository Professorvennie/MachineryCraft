package com.professorvennie.core.main.proxeys;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.tileEntity.TileEntityCable;
import com.professorvennie.core.block.tileEntity.TileEntityWasher;
import com.professorvennie.core.block.tileEntity.TileEntitywindmill;
import com.professorvennie.core.block.tileEntity.TileEntitywindmillground;
import com.professorvennie.core.block.tileEntity.render.TileEnitityRenderwindmillGround;
import com.professorvennie.core.block.tileEntity.render.TileEntityRenderCable;
import com.professorvennie.core.block.tileEntity.render.TileEntityRenderWasher;
import com.professorvennie.core.block.tileEntity.render.TileEntityRenderwindmill;
import com.professorvennie.core.gui.book.GuiBook;
import com.professorvennie.core.gui.book.GuiBookEntry;
import com.professorvennie.core.gui.book.GuiBookIndex;
import com.professorvennie.core.item.itemrender.ItemRenderCable;
import com.professorvennie.core.item.itemrender.ItemRenderWasher;
import com.professorvennie.core.item.itemrender.ItemRenderWindmillGround;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxey extends ServerProxey {
	
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmill.class, new TileEntityRenderwindmill());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmillground.class, new TileEnitityRenderwindmillGround());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWasher.class, new TileEntityRenderWasher());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new TileEntityRenderCable());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.washer), new ItemRenderWasher());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cable), new ItemRenderCable());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.windmillground), new ItemRenderWindmillGround());
	}
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	@Override
	public void setEntryToOpen(BookEntry entry) {
		GuiBook.currentOpenLexicon = new GuiBookEntry(entry, new GuiBookIndex(entry.category));
	}
}