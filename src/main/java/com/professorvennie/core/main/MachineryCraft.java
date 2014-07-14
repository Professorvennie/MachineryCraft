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

import com.professorvennie.core.common.proxey.CommonProxey;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.creativetab.CreativeTabsMachineryCraft;
import com.professorvennie.core.main.plugins.PluginTConstruct;
import com.professorvennie.core.world.biome.BiomePlastic;
import com.professorvennie.core.world.village.ComponentWorkShop;
import com.professorvennie.core.world.village.VillageTrades;
import com.professorvennie.core.world.village.VillageWorkShopHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.*;
import net.minecraftforge.common.MinecraftForge;

import com.professorvennie.core.achievements.ModAchievements;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.tileEntity.RegisterTileEntitys;
import com.professorvennie.core.common.events.ModEvents;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.common.handlers.ConfigHandler;
import com.professorvennie.core.client.handlers.HudHandler;
import com.professorvennie.core.world.OreGen;
import com.professorvennie.core.common.network.GuiHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class MachineryCraft {
	
	@Instance(Reference.MOD_ID)
	public static MachineryCraft instance;

    public static BiomeGenBase biomePlastic = new BiomePlastic(150).setBiomeName("plastic");

    public static CreativeTabs tabMachineryCraft = new CreativeTabsMachineryCraft("MachineryCraft");

	@SidedProxy(clientSide = Reference.CLIENT_PROXEY , serverSide = Reference.SERVER_PROXEY)
	public static CommonProxey proxy;

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		ModBlocks.mainRegistry();
		ModItems.mainRegistry();
		ModFuilds.mainRegistry();
		proxy.registerRenderThings();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
		ModRecipes.init();
		BookData.init();

        VillagerRegistry.instance().registerVillagerId(78906);
        VillagerRegistry.instance().registerVillagerSkin(78906, new ResourceLocation(Reference.MOD_ID, "/villager/workshopvillager"));
        VillagerRegistry.instance().registerVillageTradeHandler(78906, new VillageTrades());
        VillagerRegistry.instance().registerVillageCreationHandler(new VillageWorkShopHandler());
        MapGenStructureIO.func_143031_a(ComponentWorkShop.class, "MachineryCraft:WorkshopStructure");
	}

		

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(new OreGen(), 2);
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new HudHandler());
		ModAchievements.registerAchievements();
		ModEvents.registerEvents();
		
		RegisterTileEntitys.mainRegistry();

        BiomeDictionary.registerBiomeType(biomePlastic, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS);
        BiomeManager.addSpawnBiome(biomePlastic);
        BiomeManager.warmBiomes.add(new BiomeEntry(biomePlastic, 15));
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		ModRecipes.oreDict();
	}
	
}
 