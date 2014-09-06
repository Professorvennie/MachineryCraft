/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main.plugins;

import com.professorvennie.core.main.plugins.codechicken.nei.NEIHandler;
import cpw.mods.fml.common.Loader;

/**
 * Created by ProfessorVennie on 8/10/2014 at 4:19 PM.
 */
public class PluginHandler {

    public static void preInit(){

    }

    public static void Init(){
        registerMultiParts();
        if(Loader.isModLoaded("NotEnoughItems")){
            NEIHandler.loadConfig();
        }
    }

    public static void postInit(){

    }

    private static void registerMultiParts() {
        if(Loader.isModLoaded("ForgeMultipart")){
            try {
                Class clazz = Class.forName("com.professorvennie.core.main.plugins.codechicken.fmp.MultiPartHandler");
                clazz.newInstance();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
