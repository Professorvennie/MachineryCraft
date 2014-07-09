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

    public static boolean saltTools = true;
    public static boolean ironoxideTools = true;
    public static boolean goldoxideTools = true;
    public static boolean emeraldTools = true;

    public static boolean saltArmor = true;
    public static boolean ironoxideArmor = true;
    public static boolean goldoxideArmor = true;
    public static boolean emeraldArmor = true;


    public static void init(File configFile){
        // Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }
    }

    private static void loadConfiguration(){
        spawnCopper = configuration.getBoolean("copper Spawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of copper veins.");
        spawnTin = configuration.getBoolean("tin Spawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of tin veins.");
        spawnSilver = configuration.getBoolean("silver Spawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of silver veins.");
        spawnLead = configuration.getBoolean("lead Spawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of lead veins.");
        spawnSalt= configuration.getBoolean("salt Spawn", Configuration.CATEGORY_GENERAL, true, "Enables/disables the spawning of salt veins.");

        copperRate = configuration.getInt("copper Rate", Configuration.CATEGORY_GENERAL, 15, 1, 30, "Sets how much copper spawns in the world");
        tinRate = configuration.getInt("tin Rate", Configuration.CATEGORY_GENERAL, 16, 1, 30, "Sets how much tin spawns in the world");
        silverRate = configuration.getInt("silver Rate", Configuration.CATEGORY_GENERAL, 5, 1, 30, "Sets how much silver spawns in the world");
        leadRate = configuration.getInt("lead Rate", Configuration.CATEGORY_GENERAL, 20, 1, 30, "Sets how much lead spawns in the world");
        saltRate = configuration.getInt("salt Rate", Configuration.CATEGORY_GENERAL, 10, 1, 30, "Sets how much salt spawns in the world");

        copperVienSize = configuration.getInt("copper VienSize", Configuration.CATEGORY_GENERAL, 6, 1, 10, "Sets how much copper spawns in each vien");
        tinVienSize = configuration.getInt("tin VienSize", Configuration.CATEGORY_GENERAL, 3, 1, 10, "Sets how much tin spawns in each vien");
        silverVienSize = configuration.getInt("silver VienSize", Configuration.CATEGORY_GENERAL, 5, 1, 10, "Sets how much silver spawns in each vien");
        leadVienSize = configuration.getInt("lead VienSize", Configuration.CATEGORY_GENERAL, 7, 1, 10, "Sets how much lead spawns in each vien");
        saltVienSize = configuration.getInt("salt VienSize", Configuration.CATEGORY_GENERAL, 4, 1, 10, "Sets how much salt spawns in each vien");

        saltTools = configuration.getBoolean("Salt Tools", Configuration.CATEGORY_GENERAL, true, "Enables/disables salt tools");
        ironoxideTools = configuration.getBoolean("Ironoxide Tools", Configuration.CATEGORY_GENERAL, true, "Enables/disables Ironoxide tools");
        goldoxideTools = configuration.getBoolean("Goldoxide Tools", Configuration.CATEGORY_GENERAL, true, "Enables/disables Goldoxide tools");
        emeraldTools = configuration.getBoolean("Emerald Tools", Configuration.CATEGORY_GENERAL, true, "Enables/disables Emerald tools");

        saltArmor = configuration.getBoolean("Salt Armor", Configuration.CATEGORY_GENERAL, true, "Enables/disables salt Armor");
        ironoxideArmor = configuration.getBoolean("Ironoxide Armor", Configuration.CATEGORY_GENERAL, true, "Enables/disables Ironoxide Armor");
        goldoxideArmor = configuration.getBoolean("Goldoxide Armor", Configuration.CATEGORY_GENERAL, true, "Enables/disables Goldoxide Armor");
        emeraldArmor = configuration.getBoolean("Emerald Armor", Configuration.CATEGORY_GENERAL, true, "Enables/disables Emerald Armor");
        emeraldArmor = configuration.getBoolean("Emerald Armor", Configuration.CATEGORY_GENERAL, true, "Enables/disables Emerald Armor");

        if (configuration.hasChanged()){
            configuration.save();
        }
    }
}
