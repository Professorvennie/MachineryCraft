/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.common.handlers;

import java.io.File;

import com.professorvennie.core.lib.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

    public static Configuration configuration;

    public static boolean spawnCopper = true;
    public static boolean spawnTin = true;
    public static boolean spawnSilver = true;
    public static boolean spawnLead = true;
    public static boolean spawnSalt = true;

    public static int copperRate = 15;
    public static int tinRate = 16;
    public static int silverRate = 5;
    public static int leadRate = 20;
    public static int saltRate = 10;

    public static int copperVienSize = 6;
    public static int tinVienSize = 3;
    public static int silverVienSize = 5;
    public static int leadVienSize = 7;
    public static int saltVienSize = 4;

    public static void init(File configFile){
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    public void loadConfiguration(){
        spawnCopper = configuration.getBoolean("copperSpawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of copper veins.");
        spawnTin = configuration.getBoolean("tinSpawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of tin veins.");
        spawnSilver = configuration.getBoolean("silverSpawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of silver veins.");
        spawnLead = configuration.getBoolean("leadSpawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of lead veins.");
        spawnSalt= configuration.getBoolean("saltSpawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of salt veins.");

        copperRate = configuration.getInt("copperRate", Configuration.CATEGORY_GENERAL, 15, 1, 30, "Sets how much copper spawns in the world");
        tinRate = configuration.getInt("tinRate", Configuration.CATEGORY_GENERAL, 16, 1, 30, "Sets how much tin spawns in the world");
        silverRate = configuration.getInt("silverRate", Configuration.CATEGORY_GENERAL, 5, 1, 30, "Sets how much silver spawns in the world");
        leadRate = configuration.getInt("leadRate", Configuration.CATEGORY_GENERAL, 20, 1, 30, "Sets how much lead spawns in the world");
        saltRate = configuration.getInt("saltRate", Configuration.CATEGORY_GENERAL, 10, 1, 30, "Sets how much salt spawns in the world");

        copperVienSize = configuration.getInt("copperVienSize", Configuration.CATEGORY_GENERAL, 6, 1, 10, "Sets how much copper spawns in each vien");
        tinVienSize = configuration.getInt("tinVienSize", Configuration.CATEGORY_GENERAL, 3, 1, 10, "Sets how much tin spawns in each vien");
        silverVienSize = configuration.getInt("silverVienSize", Configuration.CATEGORY_GENERAL, 5, 1, 10, "Sets how much silver spawns in each vien");
        leadVienSize = configuration.getInt("leadVienSize", Configuration.CATEGORY_GENERAL, 7, 1, 10, "Sets how much lead spawns in each vien");
        saltVienSize = configuration.getInt("saltVienSize", Configuration.CATEGORY_GENERAL, 4, 1, 10, "Sets how much salt spawns in each vien");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
