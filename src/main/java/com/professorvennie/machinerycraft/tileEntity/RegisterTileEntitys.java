/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.tileEntity;

import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.basic.campfire.TileEntityCampFire;
import com.professorvennie.machinerycraft.machines.basic.portablecobblegen.TileEntityPortableCobbleGen;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityWell;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityWoodenWellPipe;
import com.professorvennie.machinerycraft.machines.brass.alloy.TileEntityBrassAlloy;
import com.professorvennie.machinerycraft.machines.brass.charger.TileEntityBrassCharger;
import com.professorvennie.machinerycraft.machines.brass.furnace.TileEntityBrassFurnace;
import com.professorvennie.machinerycraft.machines.brass.generators.combustion.TileEntityBrassGenerator;
import com.professorvennie.machinerycraft.machines.brass.generators.lava.TileEntityBrassLavaGenerator;
import com.professorvennie.machinerycraft.machines.brass.generators.solar.TileEntityBrassSolarGenerator;
import com.professorvennie.machinerycraft.machines.brass.grinder.TileEntityBrassGrinder;
import com.professorvennie.machinerycraft.machines.bronze.boiler.TileEntityBronzeSteamBoiler;
import com.professorvennie.machinerycraft.machines.bronze.extractor.TileEntityBronzeExtractor;
import com.professorvennie.machinerycraft.machines.bronze.furnace.TileEntityBronzeFurnace;
import com.professorvennie.machinerycraft.machines.bronze.grinder.TileEntityBronzeGrinder;
import com.professorvennie.machinerycraft.machines.copper.furnace.TileEntityCopperFurnace;
import com.professorvennie.machinerycraft.machines.copper.grinder.TileEntityCopperGrinder;
import com.professorvennie.machinerycraft.machines.washer.TileEntityWasher;
import com.professorvennie.machinerycraft.machines.windmill.TileEntityWindmill;
import com.professorvennie.machinerycraft.machines.windmill.TileEntitywindmillground;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterTileEntitys {

    public static void mainRegistry() {
        GameRegistry.registerTileEntity(TileEntityCopperFurnace.class, Reference.MOD_ID + "_tileEntitySaltFurnace");
        GameRegistry.registerTileEntity(TileEntityCopperGrinder.class, Reference.MOD_ID + "_tileEntitySaltGrinder");
        GameRegistry.registerTileEntity(TileEntitywindmillground.class, Reference.MOD_ID + "_tileEntityWindmillGround");
        GameRegistry.registerTileEntity(TileEntityWindmill.class, Reference.MOD_ID + "_tileEntityWindmill");
        GameRegistry.registerTileEntity(TileEntityBrassGrinder.class, Reference.MOD_ID + "_tileEntityIronxideGrinder");
        GameRegistry.registerTileEntity(TileEntityBrassFurnace.class, Reference.MOD_ID + "_tileEntityIronxideFurnace");
        GameRegistry.registerTileEntity(TileEntityWasher.class, Reference.MOD_ID + "_tileEntityWasher");
        GameRegistry.registerTileEntity(TileEntityCable.class, Reference.MOD_ID + "_tileEntityCable");
        GameRegistry.registerTileEntity(TileEntityBrassAlloy.class, Reference.MOD_ID + "_tileEntityIronxideAlloy");
        GameRegistry.registerTileEntity(TileEntityPlasticChest.class, Reference.MOD_ID + "_tileEntityPlasticChest");
        GameRegistry.registerTileEntity(TileEntityPortableCobbleGen.class, Reference.MOD_ID + "_tileEntityPortableCobbleGen");
        GameRegistry.registerTileEntity(TileEntityBronzeFurnace.class, Reference.MOD_ID + "_tileEntityBronzeFurnace");
        GameRegistry.registerTileEntity(TileEntityBronzeSteamBoiler.class, Reference.MOD_ID + "_tileEntityBronzeSteamBoiler");
        GameRegistry.registerTileEntity(TileEntityBronzeGrinder.class, Reference.MOD_ID + "_tileEntityBronzeGrinder");
        GameRegistry.registerTileEntity(TileEntityBronzeExtractor.class, Reference.MOD_ID + "_tileEntityBronzeExtractor");
        GameRegistry.registerTileEntity(TileEntityBrassGenerator.class, Reference.MOD_ID + "_tileEntityBrassGenerator");
        GameRegistry.registerTileEntity(TileEntityBrassSolarGenerator.class, Reference.MOD_ID + "_tileEntityBrassSolarGenerator");
        GameRegistry.registerTileEntity(TileEntityBrassLavaGenerator.class, Reference.MOD_ID + "_tileEntityBrassLavaGenerator");
        GameRegistry.registerTileEntity(TileEntityWell.class, Reference.MOD_ID + "_tileEntityWell");
        GameRegistry.registerTileEntity(TileEntityWoodenWellPipe.class, Reference.MOD_ID + "_tileEntityWoodenWellPipe");
        GameRegistry.registerTileEntity(TileEntityCampFire.class, Reference.MOD_ID + "_tileEntityCampFire");
        GameRegistry.registerTileEntity(TileEntityBrassCharger.class, Reference.MOD_ID + "_tileEntityBrassCharger");
    }
}
