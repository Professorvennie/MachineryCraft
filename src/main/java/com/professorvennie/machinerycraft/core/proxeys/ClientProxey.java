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

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.client.gui.book.GuiBook;
import com.professorvennie.machinerycraft.client.gui.book.GuiBookEntry;
import com.professorvennie.machinerycraft.client.gui.book.GuiBookIndex;
import com.professorvennie.machinerycraft.client.renderer.item.ItemRenderCable;
import com.professorvennie.machinerycraft.client.renderer.item.ItemRenderPlasticChest;
import com.professorvennie.machinerycraft.client.renderer.tileentity.TileEntityRendererCable;
import com.professorvennie.machinerycraft.client.renderer.tileentity.TileEntityRendererPlasticChest;
import com.professorvennie.machinerycraft.entitys.EntityGrenade;
import com.professorvennie.machinerycraft.entitys.EntityMCFishHook;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.machines.basic.campfire.ItemRenderCampFire;
import com.professorvennie.machinerycraft.machines.basic.campfire.TileEntityCampFire;
import com.professorvennie.machinerycraft.machines.basic.campfire.TileEntityRendererCampFire;
import com.professorvennie.machinerycraft.machines.basic.well.ItemRenderWoodenWellPipe;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityRendererWoodenWellPipe;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityWoodenWellPipe;
import com.professorvennie.machinerycraft.machines.washer.ItemRenderWasher;
import com.professorvennie.machinerycraft.machines.washer.TileEntityRendererWasher;
import com.professorvennie.machinerycraft.machines.washer.TileEntityWasher;
import com.professorvennie.machinerycraft.machines.windmill.*;
import com.professorvennie.machinerycraft.plugins.codechicken.fmp.FMPPlugin;
import com.professorvennie.machinerycraft.plugins.codechicken.fmp.ItemSawRender;
import com.professorvennie.machinerycraft.tileEntity.TileEntityCable;
import com.professorvennie.machinerycraft.tileEntity.TileEntityPlasticChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxey extends CommonProxey {

    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill.class, new TileEntityRendererwindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmillground.class, new TileEnitityRendererwindmillGround());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWasher.class, new TileEntityRendererWasher());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new TileEntityRendererCable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlasticChest.class, new TileEntityRendererPlasticChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodenWellPipe.class, new TileEntityRendererWoodenWellPipe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampFire.class, new TileEntityRendererCampFire());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.washer), new ItemRenderWasher());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cable), new ItemRenderCable());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.windmillground), new ItemRenderWindmillGround());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plasticChest), new ItemRenderPlasticChest());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.woodenWellPipe), new ItemRenderWoodenWellPipe());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.campFire), new ItemRenderCampFire());

        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(ModItems.gernades));
        RenderingRegistry.registerEntityRenderingHandler(EntityMCFishHook.class, new RenderFish());

        if (Loader.isModLoaded("ForgeMultipart")) {
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.copperSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.tinSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.silverSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.leadSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.zincSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.bronzeSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.brassSaw, new ItemSawRender());
        }
    }

    public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }

    @Override
    public void setEntryToOpen(BookEntry entry) {
        GuiBook.currentOpenLexicon = new GuiBookEntry(entry, new GuiBookIndex(entry.category));
    }
}