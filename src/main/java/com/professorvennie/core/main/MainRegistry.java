/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main;

import com.professorvennie.core.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.professorvennie.core.achievements.ModAchievements;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.tileEntity.RegisterTileEntitys;
import com.professorvennie.core.events.ModEvents;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.main.creativetab.CreativeTabsExtraFood;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.main.handlers.HudHandler;
import com.professorvennie.core.main.world.OreGen;
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



@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class MainRegistry {
	
	@Instance(Reference.MOD_ID)
	public static MainRegistry instance;
	
	GuiHandler GuiHandler = new GuiHandler();
	
	static OreGen oremanager = new OreGen();
	
	public static CreativeTabs tabMachineryCraft = new CreativeTabsExtraFood("MachineryCraft");
	@SidedProxy(clientSide = Reference.CLIENT_PROXEY , serverSide = Reference.SERVER_PROXEY)
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
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
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
 