package com.professorvennie.core.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.tileEntity.RegisterTileEntitys;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.creativetab.CreativeTabsExtraFood;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.main.handlers.GuiHandler;
import com.professorvennie.core.main.handlers.HudHandler;
import com.professorvennie.core.main.handlers.IGen;
import com.professorvennie.core.main.proxeys.ServerProxey;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = LibStrings.MODID, name = LibStrings.name , version = LibStrings.version)
public class MainRegistry {
	
	@Instance(LibStrings.MODID)
	public static MainRegistry instance;
	
	com.professorvennie.core.main.handlers.GuiHandler GuiHandler = new com.professorvennie.core.main.handlers.GuiHandler();
	
	static IGen oremanager = new IGen();
	
	public static CreativeTabs tabMachineryCraft = new CreativeTabsExtraFood("MachineryCraft");
	@SidedProxy(clientSide = "com.professorvennie.core.main.proxeys.ClientProxey", serverSide = "com.professorvennie.core.main.proxeys.ServerProxey")
	public static ServerProxey proxy;

	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent){
		ModBlocks.mainRegistry();
		ModItems.mainRegistry();
		ModFuilds.mainRegistry();
		proxy.registerRenderThings();
		ConfigHandler.init(PreEvent.getSuggestedConfigurationFile());
		ModRecipes.init();
		BookData.init();
	}

		

	@EventHandler
	public static void load(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(oremanager, 2);
		NetworkRegistry.INSTANCE.registerGuiHandler(LibStrings.MODID, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new HudHandler());
		
		RegisterTileEntitys.mainRegistry();
		OreDictionary.registerOre("oreSalt", new ItemStack(ModBlocks.Saltore));
		OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.BlockOres, 1, 0));
		OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.BlockOres, 1, 1));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.BlockOres, 1, 2));
		OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.BlockOres, 1, 3));
		
		OreDictionary.registerOre("ingotCopper", new ItemStack(ModItems.Ingots, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(ModItems.Ingots, 1, 1));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.Ingots, 1, 2));
		OreDictionary.registerOre("ingotLead", new ItemStack(ModItems.Ingots, 1, 3));
		OreDictionary.registerOre("ingotSalt", new ItemStack(ModItems.Ingots, 1, 4));
	}
	
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){
		
	}
	
}
 