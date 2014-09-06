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

import com.professorvennie.core.entitys.ModEntities;
import com.professorvennie.core.main.creativetab.CreativeTabMachineryCraft;
import com.professorvennie.core.main.creativetab.CreativeTabMachineryCraftEquipment;
import com.professorvennie.core.main.handlers.FuelHandler;
import com.professorvennie.core.main.plugins.PluginHandler;
import com.professorvennie.core.main.proxeys.CommonProxey;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.world.biome.ModBiomes;
import com.professorvennie.core.world.dimesion.WorldProviderMining;
import com.professorvennie.core.world.village.VillageHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

import com.professorvennie.core.achievements.ModAchievements;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.tileEntity.RegisterTileEntitys;
import com.professorvennie.core.common.events.ModEvents;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.main.handlers.ConfigHandler;
import com.professorvennie.core.main.handlers.HudHandler;
import com.professorvennie.core.world.OreGen;
import com.professorvennie.core.main.handlers.GuiHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class MachineryCraft {
	
	@Instance(Reference.MOD_ID)
	public static MachineryCraft instance;

    public static CreativeTabs tabMachineryCraft = new CreativeTabMachineryCraft("MachineryCraft");
    public static CreativeTabs tabMachineryCraftEquipment = new CreativeTabMachineryCraftEquipment("MachineryCraftEquipment");

	@SidedProxy(clientSide = Reference.CLIENT_PROXEY , serverSide = Reference.SERVER_PROXEY)
	public static CommonProxey proxy;

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		ModBlocks.mainRegistry();
		ModItems.mainRegistry();
		ModFuilds.mainRegistry();
        ModEntities.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

		ModRecipes.init();
		BookData.init();
        PluginHandler.preInit();
        VillageHandler.init();

        FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("steam", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.steamBucket), new ItemStack(Items.bucket));
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(new OreGen(), 2);
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new HudHandler());
		ModAchievements.registerAchievements();
		ModEvents.registerEvents();
        PluginHandler.Init();
		RegisterTileEntitys.mainRegistry();
        proxy.registerRenderThings();
        ModBiomes.init();
        ModRecipes.addChestLoot();
        GameRegistry.registerFuelHandler(new FuelHandler());

        DimensionManager.registerProviderType(12, WorldProviderMining.class, false);
        DimensionManager.registerDimension(12, 12);
	}
	
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		ModRecipes.oreDict();
        PluginHandler.postInit();
	}
}
 