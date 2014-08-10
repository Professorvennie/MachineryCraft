package com.professorvennie.core.main.plugins;

import cpw.mods.fml.common.Loader;

/**
 * Created by ProfessorVennie on 8/10/2014 at 4:19 PM.
 */
public class PluginHandler {

    public static void preInit(){

    }

    public static void Init(){
        registerMultiParts();
    }

    public static void postInit(){

    }

    private static void registerMultiParts() {
        if(Loader.isModLoaded("ForgeMultipart")){
            try {
                Class clazz = Class.forName("com.professorvennie.core.main.plugins.fmp.MultiPartHandler");
                clazz.newInstance();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
