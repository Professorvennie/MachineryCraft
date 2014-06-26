package com.professorvennie.core.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.professorvennie.core.achievements.ModAchievements;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.tileEntity.RegisterTileEntitys;
import com.professorvennie.core.events.ModEvents;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.LibResources;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.creativetab.CreativeTabsExtraFood;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.main.handlers.HudHandler;
import com.professorvennie.core.main.handlers.OreGen;
import com.professorvennie.core.main.proxeys.ServerProxey;
import com.professorvennie.core.main.handlers.GuiHandler;

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
	
	static OreGen oremanager = new OreGen();
	
	public static CreativeTabs tabMachineryCraft = new CreativeTabsExtraFood("MachineryCraft");
	@SidedProxy(clientSide = LibResources.CLIENT_PROXEY , serverSide = LibResources.COMMON_PROXEY)
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
		ModAchievements.registerAchievements();
		ModEvents.registerEvents();
		
		RegisterTileEntitys.mainRegistry();
		
	}
	
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){
		ModRecipes.oreDict();
	}
	
}
 