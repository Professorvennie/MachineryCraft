/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.common.events;


import com.professorvennie.machinerycraft.achievements.AchievementsEvents;
import com.professorvennie.machinerycraft.client.EventHandlerClient;
import com.professorvennie.machinerycraft.fuilds.ModFuilds;
import com.professorvennie.machinerycraft.items.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;


public class ModEvents {

    public static void registerEvents() {
        FMLCommonHandler.instance().bus().register(new AchievementsEvents());
        BucketHandler.INSTANCE.buckets.put(ModFuilds.blockSteam, ModItems.steamBucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        FMLCommonHandler.instance().bus().register(new EventHandlerClient());
        MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
    }
}
