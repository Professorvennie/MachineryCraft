/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.tileEntity;

import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.basic.TileEntityPortableCobbleGen;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.*;
import com.professorvennie.machinerycraft.core.tileEntity.machines.copper.TileEntityCopperFurnace;
import com.professorvennie.machinerycraft.core.tileEntity.machines.copper.TileEntityCopperGrinder;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeExtractor;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeFurnace;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeGrinder;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeSteamBoiler;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntitys {

    public static void mainRegistry() {
        GameRegistry.registerTileEntity(TileEntityCopperFurnace.class, Reference.MOD_ID + "_tileEntitySaltFurnace");
        GameRegistry.registerTileEntity(TileEntityCopperGrinder.class, Reference.MOD_ID + "_tileEntitySaltGrinder");
        GameRegistry.registerTileEntity(TileEntitywindmillground.class, Reference.MOD_ID + "_tileEntityWindmillGround");
        GameRegistry.registerTileEntity(TileEntitywindmill.class, Reference.MOD_ID + "_tileEntityWindmill");
        GameRegistry.registerTileEntity(TileEntityBrassGrinder.class, Reference.MOD_ID + "_tileEntityIronxideGrinder");
        GameRegistry.registerTileEntity(TileEntityBrassFurnace.class, Reference.MOD_ID + "_tileEntityIronxideFurnace");
        GameRegistry.registerTileEntity(TileEntityGoldOxideGrinder.class, Reference.MOD_ID + "_tileEntityGoldOxideGrinder");
        GameRegistry.registerTileEntity(TileEntityGoldOxideFurnace.class, Reference.MOD_ID + "_tileEntityGoldOxideFurnace");
        GameRegistry.registerTileEntity(TileEntityWasher.class, Reference.MOD_ID + "_tileEntityWasher");
        GameRegistry.registerTileEntity(TileEntityCable.class, Reference.MOD_ID + "_tileEntityCable");
        GameRegistry.registerTileEntity(TileEntityBrassAlloy.class, Reference.MOD_ID + "_tileEntityIronxideAlloy");
        GameRegistry.registerTileEntity(TileEntityPlasticChest.class, Reference.MOD_ID + "_tileEntityPlasticChest");
        GameRegistry.registerTileEntity(TileEntityPortableCobbleGen.class, Reference.MOD_ID + "_tileEntityPortableCobbleGen");
        GameRegistry.registerTileEntity(TileEntityBronzeFurnace.class, Reference.MOD_ID + "_tileEntityBronzeFurnace");
        GameRegistry.registerTileEntity(TileEntityBronzeSteamBoiler.class, Reference.MOD_ID + "_tileEntityBronzeSteamBoiler");
        GameRegistry.registerTileEntity(TileEntityBronzeGrinder.class, Reference.MOD_ID + "_tileEntityBronzeGrinder");
        GameRegistry.registerTileEntity(TileEntityBronzeExtractor.class, Reference.MOD_ID + "_tileEntityBronzeExtractor");
        GameRegistry.registerTileEntity(TileEntityBlockBreaker.class, Reference.MOD_ID + "_tileEntityBlockBreaker");
        GameRegistry.registerTileEntity(TileEntityBlockPlacer.class, Reference.MOD_ID + "_tileEntityBlockPlacer");
        GameRegistry.registerTileEntity(TileEntityBrassGenerator.class, Reference.MOD_ID + "_tileEntityBrassGenerator");
        GameRegistry.registerTileEntity(TileEntityBrassSolarGenerator.class, Reference.MOD_ID + "_tileEntityBrassSolarGenerator");
        GameRegistry.registerTileEntity(TileEntityBrassLavaGenerator.class, Reference.MOD_ID + "_tileEntityBrassLavaGenerator");
    }
}
