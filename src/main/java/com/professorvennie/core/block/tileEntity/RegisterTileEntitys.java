/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block.tileEntity;

import com.professorvennie.core.main.utils.RegistryUtils;


public class RegisterTileEntitys {
	
	public static void mainRegistry(){
		RegistryUtils.registerTileEntity(TileEntitySaltFurnace.class, "tileEntitysaltfurnace");
		RegistryUtils.registerTileEntity(TileEntitySaltGrinder.class, "tileEntityGrinder");
		RegistryUtils.registerTileEntity(TileEntitywindmillground.class, "windmillground");
		RegistryUtils.registerTileEntity(TileEntitywindmill.class, "WINDMILL");
		RegistryUtils.registerTileEntity(TileEntityironOxideGrinder.class, "ironxideGrinder");
		RegistryUtils.registerTileEntity(TileEntityIronOxideFurnace.class, "ironxideFurnace");
		RegistryUtils.registerTileEntity(TileEntityGoldOxideGrinder.class, "goldOxideGrinder");
		RegistryUtils.registerTileEntity(TileEntityGoldOxideFurnace.class, "goldOxideFurnace");
		RegistryUtils.registerTileEntity(TileEntityWasher.class, "washer");
		RegistryUtils.registerTileEntity(TileEntityCable.class, "cable");
		RegistryUtils.registerTileEntity(TileEntityIronOxideAlloy.class, "ironxideAlloy");
	}
}
