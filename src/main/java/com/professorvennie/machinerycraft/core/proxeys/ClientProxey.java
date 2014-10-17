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
import com.professorvennie.machinerycraft.block.BlockPlasticFlower;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.client.gui.book.GuiBook;
import com.professorvennie.machinerycraft.client.gui.book.GuiBookEntry;
import com.professorvennie.machinerycraft.client.gui.book.GuiBookIndex;
import com.professorvennie.machinerycraft.client.renderer.tileentity.TileEntityRendererCable;
import com.professorvennie.machinerycraft.client.renderer.tileentity.TileEntityRendererPlasticChest;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.basic.campfire.TileEntityCampFire;
import com.professorvennie.machinerycraft.machines.basic.campfire.TileEntityRendererCampFire;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityRendererWoodenWellPipe;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityWoodenWellPipe;
import com.professorvennie.machinerycraft.machines.washer.TileEntityRendererWasher;
import com.professorvennie.machinerycraft.machines.washer.TileEntityWasher;
import com.professorvennie.machinerycraft.machines.windmill.*;
import com.professorvennie.machinerycraft.tileEntity.TileEntityCable;
import com.professorvennie.machinerycraft.tileEntity.TileEntityPlasticChest;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxey extends CommonProxey {

    public static void init(){
        for(Block block : ModBlocks.blocks) {
            registerItem(Item.getItemFromBlock(block), Reference.MOD_ID + ":" + block.getUnlocalizedName());
        }

        for(Item item : ModItems.items) {
            registerItem(item, Reference.MOD_ID + ":" + item.getUnlocalizedName());
        }

        registerItem(Item.getItemFromBlock(ModBlocks.BlockOres), 0, Reference.MOD_ID + ":copperOre");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockOres), 1, Reference.MOD_ID + ":tinOre");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockOres), 2, Reference.MOD_ID + ":silverOre");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockOres), 3, Reference.MOD_ID + ":leadOre");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockOres), 4, Reference.MOD_ID + ":zincOre");

        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 0, Reference.MOD_ID + ":copperBlock");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 1, Reference.MOD_ID + ":tinBlock");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 2, Reference.MOD_ID + ":silverBlock");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 3, Reference.MOD_ID + ":leadBlock");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 4, Reference.MOD_ID + ":zincBlock");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 5, Reference.MOD_ID + ":brassBlock");
        registerItem(Item.getItemFromBlock(ModBlocks.BlockMetals), 6, Reference.MOD_ID + ":bronzeBlock");

        for(int i = 0; i < Names.Items.BAGS.length; i++){
            registerItem(ModItems.bags, i, Reference.MOD_ID + ":" + Names.Items.BAGS[i]);
        }

        registerItem(ModItems.book, Reference.MOD_ID + ":item.ItemBook");
    }

    public static void preInit(){
        for(Block block : ModBlocks.blocks) {
            ModelBakery.addVariantName(Item.getItemFromBlock(block), Reference.MOD_ID + ":" + block.getUnlocalizedName());
        }

        ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.BlockOres), new String[]{Reference.MOD_ID + ":copperOre", Reference.MOD_ID + ":tinOre", Reference.MOD_ID + ":silverOre", Reference.MOD_ID + ":leadOre", Reference.MOD_ID + ":zincOre"});
        ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.BlockMetals), new String[]{Reference.MOD_ID + ":copperBlock", Reference.MOD_ID + ":tinBlock", Reference.MOD_ID + ":silverBlock", Reference.MOD_ID + ":leadBlock", Reference.MOD_ID + ":zincBlock", Reference.MOD_ID + ":brassBlock", Reference.MOD_ID + ":bronzeBlock"});

        for(Item item : ModItems.items) {
            ModelBakery.addVariantName(item, Reference.MOD_ID + ":" + item.getUnlocalizedName());
        }
        ModelBakery.addVariantName(ModItems.book, Reference.MOD_ID + ":item.ItemBook");

        ModelBakery.addVariantName(ModItems.bags, new String[]{Reference.MOD_ID + ":" + Names.Items.BAGS[0], Reference.MOD_ID + ":" + Names.Items.BAGS[1],Reference.MOD_ID + ":" + Names.Items.BAGS[2],Reference.MOD_ID + ":" + Names.Items.BAGS[3],Reference.MOD_ID + ":" + Names.Items.BAGS[4],Reference.MOD_ID + ":" + Names.Items.BAGS[5], Reference.MOD_ID + ":" + Names.Items.BAGS[6], Reference.MOD_ID + ":" + Names.Items.BAGS[7], Reference.MOD_ID + ":" + Names.Items.BAGS[8]});
    }

    public static void registerItem(Item item, int meta, String name){
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, meta, new ModelResourceLocation(name, "inventory"));
    }

    public static void registerBlock(Block block, int meta, String name){
        registerItem(Item.getItemFromBlock(block), meta, name);
    }

    public static void registerItem(Item item, String name){
        registerItem(item, 0, name);
    }

    public void registerRenderThings() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill.class, new TileEntityRendererwindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitywindmillground.class, new TileEnitityRendererwindmillGround());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWasher.class, new TileEntityRendererWasher());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, new TileEntityRendererCable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlasticChest.class, new TileEntityRendererPlasticChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodenWellPipe.class, new TileEntityRendererWoodenWellPipe());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampFire.class, new TileEntityRendererCampFire());

       /* MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.washer), new ItemRenderWasher());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cable), new ItemRenderCable());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.windmillground), new ItemRenderWindmillGround());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plasticChest), new ItemRenderPlasticChest());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.woodenWellPipe), new ItemRenderWoodenWellPipe());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.campFire), new ItemRenderCampFire());*/

//        RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.gernades, new RenderItem(Minecraft.getMinecraft().getTextureManager(), new ModelManager(Minecraft.getMinecraft().getTextureMapBlocks()))));
  //      RenderingRegistry.registerEntityRenderingHandler(EntityMCFishHook.class, new RenderFish(Minecraft.getMinecraft().getRenderManager()));

        if (Loader.isModLoaded("ForgeMultipart")) {
            /*MinecraftForgeClient.registerItemRenderer(FMPPlugin.copperSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.tinSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.silverSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.leadSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.zincSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.bronzeSaw, new ItemSawRender());
            MinecraftForgeClient.registerItemRenderer(FMPPlugin.brassSaw, new ItemSawRender());*/
        }
    }

    /*public int addArmor(String armor) {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }*/

    @Override
    public void setEntryToOpen(BookEntry entry) {
        GuiBook.currentOpenLexicon = new GuiBookEntry(entry, new GuiBookIndex(entry.category));
    }
}