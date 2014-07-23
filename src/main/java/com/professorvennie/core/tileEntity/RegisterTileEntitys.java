/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.tileEntity;

import com.professorvennie.core.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;


public class RegisterTileEntitys {
	
	public static void mainRegistry(){
		GameRegistry.registerTileEntity(TileEntityCopperFurnace.class, Reference.MOD_ID + "_tileEntitySaltFurnace");
        GameRegistry.registerTileEntity(TileEntityCopperGrinder.class, Reference.MOD_ID + "_tileEntitySaltGrinder");
        GameRegistry.registerTileEntity(TileEntitywindmillground.class, Reference.MOD_ID + "_tileEntityWindmillGround");
        GameRegistry.registerTileEntity(TileEntitywindmill.class, Reference.MOD_ID + "_tileEntityWindmill");
        GameRegistry.registerTileEntity(TileEntityironOxideGrinder.class, Reference.MOD_ID + "_tileEntityIronxideGrinder");
        GameRegistry.registerTileEntity(TileEntityIronOxideFurnace.class, Reference.MOD_ID + "_tileEntityIronxideFurnace");
        GameRegistry.registerTileEntity(TileEntityGoldOxideGrinder.class, Reference.MOD_ID + "_tileEntityGoldOxideGrinder");
        GameRegistry.registerTileEntity(TileEntityGoldOxideFurnace.class, Reference.MOD_ID + "_tileEntityGoldOxideFurnace");
        GameRegistry.registerTileEntity(TileEntityWasher.class, Reference.MOD_ID + "_tileEntityWasher");
        GameRegistry.registerTileEntity(TileEntityCable.class, Reference.MOD_ID + "_tileEntityCable");
        GameRegistry.registerTileEntity(TileEntityIronOxideAlloy.class, Reference.MOD_ID + "_tileEntityIronxideAlloy");
        GameRegistry.registerTileEntity(TileEntityPlasticChest.class, Reference.MOD_ID + "_tileEntityPlasticChest");
        GameRegistry.registerTileEntity(TileEntityPortableCobbleGen.class, Reference.MOD_ID + "_tileEntityPortableCobbleGen");
    }
}
