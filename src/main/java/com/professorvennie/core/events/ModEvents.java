package com.professorvennie.core.events;

import cpw.mods.fml.common.FMLCommonHandler;

public class ModEvents {
	
	public static void registerEvents(){
		FMLCommonHandler.instance().bus().register(new EventOnCrafted());
	}

}
