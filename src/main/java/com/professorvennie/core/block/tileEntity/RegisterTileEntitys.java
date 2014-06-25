package com.professorvennie.core.block.tileEntity;

import com.professorvennie.core.main.utils.RegistryUtils;


public class RegisterTileEntitys {
	
	public static void mainRegistry(){
		RegistryUtils.registerTileEntity(TileEntitySaltFurnace.class, "tileEntitysaltfurnace");
		RegistryUtils.registerTileEntity(TileEntitySaltGrinder.class, "tileEntityGrinder");
		RegistryUtils.registerTileEntity(TileEntitywindmillground.class, "windmillground");
		RegistryUtils.registerTileEntity(TileEntitywindmill.class, "windmill");
		RegistryUtils.registerTileEntity(TileEntityironOxideGrinder.class, "ironxideGrinder");
		RegistryUtils.registerTileEntity(TileEntityIronOxideFurnace.class, "ironxideFurnace");
		RegistryUtils.registerTileEntity(TileEntityGoldOxideGrinder.class, "goldOxideGrinder");
		RegistryUtils.registerTileEntity(TileEntityGoldOxideFurnace.class, "goldOxideFurnace");
		RegistryUtils.registerTileEntity(TileEntityWasher.class, "washer");
		RegistryUtils.registerTileEntity(TileEntityCable.class, "cable");
		RegistryUtils.registerTileEntity(TileEntityIronOxideAlloy.class, "ironxideAlloy");

	}

}
