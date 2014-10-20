/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft;

import com.professorvennie.machinerycraft.achievements.ModAchievements;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.common.events.ModEvents;
import com.professorvennie.machinerycraft.core.config.ConfigHandler;
import com.professorvennie.machinerycraft.core.creativetabs.CreativeTabMachineryCraft;
import com.professorvennie.machinerycraft.core.creativetabs.CreativeTabMachineryCraftEquipment;
import com.professorvennie.machinerycraft.core.creativetabs.CreativeTabMachineryCraftItems;
import com.professorvennie.machinerycraft.core.handlers.FuelHandler;
import com.professorvennie.machinerycraft.core.handlers.GuiHandler;
import com.professorvennie.machinerycraft.core.network.PacketHandler;
import com.professorvennie.machinerycraft.core.proxeys.ClientProxey;
import com.professorvennie.machinerycraft.core.proxeys.CommonProxey;
import com.professorvennie.machinerycraft.entitys.ModEntities;
import com.professorvennie.machinerycraft.fuilds.ModFuilds;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.BookData;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.bronze.alloy.MetalRegistry;
import com.professorvennie.machinerycraft.plugins.PluginHandler;
import com.professorvennie.machinerycraft.recipes.ModRecipes;
import com.professorvennie.machinerycraft.tileEntity.RegisterTileEntitys;
import com.professorvennie.machinerycraft.world.OreGen;
import com.professorvennie.machinerycraft.world.biome.ModBiomes;
import com.professorvennie.machinerycraft.world.village.VillageHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class MachineryCraft {

    @Mod.Instance(Reference.MOD_ID)
    public static MachineryCraft instance;

    public static CreativeTabs tabMachineryCraft = new CreativeTabMachineryCraft("MachineryCraft");
    public static CreativeTabs tabMachineryCraftEquipment = new CreativeTabMachineryCraftEquipment("MachineryCraftEquipment");
    public static CreativeTabs tabMachineryCraftItems = new CreativeTabMachineryCraftItems("MachineryCraftItems");

    @SidedProxy(clientSide = Reference.CLIENT_PROXEY, serverSide = Reference.SERVER_PROXEY)
    public static CommonProxey proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        ModBlocks.mainRegistry();
        ModItems.mainRegistry();
        ModFuilds.mainRegistry();
        ModEntities.init();
        //ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());

        ModRecipes.init();
        BookData.init();
        MetalRegistry.init();
        PluginHandler.preInit();
        VillageHandler.init();

        PacketHandler.init();
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) ClientProxey.preInit();

        //FluidContainerRegistry.registerFluidContainer(ModFuilds.fluidSteam, new ItemStack(ModItems.steamBucket), new ItemStack(Items.bucket));
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new OreGen(), 2);
        NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
        //MinecraftForge.EVENT_BUS.register(new HudHandler());
        ModAchievements.registerAchievements();
        ModEvents.registerEvents();
        PluginHandler.Init();
        RegisterTileEntitys.mainRegistry();
        proxy.registerRenderThings();
        ModBiomes.init();
        ModRecipes.addChestLoot();
        GameRegistry.registerFuelHandler(new FuelHandler());
        if (FMLCommonHandler.instance().getEffectiveSide().isClient()) ClientProxey.init();

//        DimensionManager.registerProviderType(12, WorldProviderMining.class, false);
//        DimensionManager.registerDimension(12, 12);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        ModRecipes.oreDict();
        PluginHandler.postInit();
    }
}
 