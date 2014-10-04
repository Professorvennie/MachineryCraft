/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.handlers;


import com.professorvennie.machinerycraft.client.gui.GuiBag;
import com.professorvennie.machinerycraft.client.gui.GuiPlasticChest;
import com.professorvennie.machinerycraft.client.gui.book.GuiBook;
import com.professorvennie.machinerycraft.common.containers.ContainerBag;
import com.professorvennie.machinerycraft.common.containers.ContainerPlasticChest;
import com.professorvennie.machinerycraft.common.containers.InventoryBag;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.machines.basic.campfire.ContainerCampFire;
import com.professorvennie.machinerycraft.machines.basic.campfire.GuiCampFire;
import com.professorvennie.machinerycraft.machines.basic.campfire.TileEntityCampFire;
import com.professorvennie.machinerycraft.machines.basic.portablecobblegen.ContainerPortableCobbleGen;
import com.professorvennie.machinerycraft.machines.basic.portablecobblegen.GuiPortableCobbleGen;
import com.professorvennie.machinerycraft.machines.basic.portablecobblegen.TileEntityPortableCobbleGen;
import com.professorvennie.machinerycraft.machines.basic.well.ContainerWell;
import com.professorvennie.machinerycraft.machines.basic.well.GuiWell;
import com.professorvennie.machinerycraft.machines.basic.well.TileEntityWell;
import com.professorvennie.machinerycraft.machines.brass.alloy.GuiBrassAlloy;
import com.professorvennie.machinerycraft.machines.brass.alloy.TileEntityBrassAlloy;
import com.professorvennie.machinerycraft.machines.brass.charger.ContainerBrassCharger;
import com.professorvennie.machinerycraft.machines.brass.charger.GuiBrassCharger;
import com.professorvennie.machinerycraft.machines.brass.charger.TileEntityBrassCharger;
import com.professorvennie.machinerycraft.machines.brass.furnace.ContainerBrassFurnace;
import com.professorvennie.machinerycraft.machines.brass.furnace.GuiBrassFurnace;
import com.professorvennie.machinerycraft.machines.brass.furnace.TileEntityBrassFurnace;
import com.professorvennie.machinerycraft.machines.brass.grinder.ContainerBrassGrinder;
import com.professorvennie.machinerycraft.machines.brass.grinder.GuiBrassGrinder;
import com.professorvennie.machinerycraft.machines.brass.grinder.TileEntityBrassGrinder;
import com.professorvennie.machinerycraft.machines.bronze.boiler.ContainerBronzeSteamBoiler;
import com.professorvennie.machinerycraft.machines.bronze.boiler.GuiBronzeSteamBoiler;
import com.professorvennie.machinerycraft.machines.bronze.boiler.TileEntityBronzeSteamBoiler;
import com.professorvennie.machinerycraft.machines.bronze.charger.ContainerCharger;
import com.professorvennie.machinerycraft.machines.bronze.charger.GuiBronzeCharger;
import com.professorvennie.machinerycraft.machines.bronze.charger.TileEntityBronzeCharger;
import com.professorvennie.machinerycraft.machines.bronze.extractor.ContainerBronzeExtractor;
import com.professorvennie.machinerycraft.machines.bronze.extractor.GuiBronzeExtractor;
import com.professorvennie.machinerycraft.machines.bronze.extractor.TileEntityBronzeExtractor;
import com.professorvennie.machinerycraft.machines.bronze.furnace.ContainerBronzeFurnace;
import com.professorvennie.machinerycraft.machines.bronze.furnace.GuiBronzeFurnace;
import com.professorvennie.machinerycraft.machines.bronze.furnace.TileEntityBronzeFurnace;
import com.professorvennie.machinerycraft.machines.bronze.grinder.ContainerBronzeGrinder;
import com.professorvennie.machinerycraft.machines.bronze.grinder.GuiBronzeGrinder;
import com.professorvennie.machinerycraft.machines.bronze.grinder.TileEntityBronzeGrinder;
import com.professorvennie.machinerycraft.machines.copper.furnace.ContainerCopperFurnace;
import com.professorvennie.machinerycraft.machines.copper.furnace.GuiCopperFurnace;
import com.professorvennie.machinerycraft.machines.copper.furnace.TileEntityCopperFurnace;
import com.professorvennie.machinerycraft.machines.copper.grinder.ContainerCopperGrinder;
import com.professorvennie.machinerycraft.machines.copper.grinder.GuiCopperGrinder;
import com.professorvennie.machinerycraft.machines.copper.grinder.TileEntityCopperGrinder;
import com.professorvennie.machinerycraft.machines.washer.GuiWasher;
import com.professorvennie.machinerycraft.machines.washer.TileEntityWasher;
import com.professorvennie.machinerycraft.machines.windmill.ContainerWindmill;
import com.professorvennie.machinerycraft.machines.windmill.GuiWindmilll;
import com.professorvennie.machinerycraft.machines.windmill.TileEntityWindmill;
import com.professorvennie.machinerycraft.tileEntity.TileEntityPlasticChest;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (ID) {
            case LibGuiIds.CCOPPER_FURNACE:
                if (entity instanceof TileEntityCopperFurnace) {
                    return new ContainerCopperFurnace(player.inventory, (TileEntityCopperFurnace) entity);
                }

            case LibGuiIds.COPPER_GRINDER:
                if (entity instanceof TileEntityCopperGrinder) {
                    return new ContainerCopperGrinder(player.inventory, (TileEntityCopperGrinder) entity);
                }

            case LibGuiIds.BRASS_GRINDER:
                if (entity instanceof TileEntityBrassGrinder) {
                    return new ContainerBrassGrinder(player.inventory, (TileEntityBrassGrinder) entity);
                }

            case LibGuiIds.GUIID_WINDMILL:
                while (entity instanceof TileEntityWindmill && world.getBlockMetadata(x, y, z) < 8) {
                    y++;
                }
                return new ContainerWindmill(player.inventory, (TileEntityWindmill) world.getTileEntity(x, y, z));

            case LibGuiIds.BRASS_FURNACE:
                if (entity instanceof TileEntityBrassFurnace) {
                    return new ContainerBrassFurnace(player.inventory, (TileEntityBrassFurnace) entity);
                }

            case LibGuiIds.GUIID_PLASTIC_CHEST:
                if (entity instanceof TileEntityPlasticChest) {
                    return new ContainerPlasticChest(player.inventory, (TileEntityPlasticChest) entity);
                }

            case LibGuiIds.GUIID_PORTABLE_COBBLEGEN:
                if (entity instanceof TileEntityPortableCobbleGen) {
                    return new ContainerPortableCobbleGen(player.inventory, (TileEntityPortableCobbleGen) entity);
                }

            case LibGuiIds.BRONZE_FURNACE:
                if (entity instanceof TileEntityBronzeFurnace) {
                    return new ContainerBronzeFurnace(player.inventory, (TileEntityBronzeFurnace) entity);
                }

            case LibGuiIds.BRONZE_STEAM_BOILER:
                if (entity instanceof TileEntityBronzeSteamBoiler) {
                    return new ContainerBronzeSteamBoiler(player.inventory, (TileEntityBronzeSteamBoiler) entity);
                }

            case LibGuiIds.BRONZE_GRINDER:
                if (entity instanceof TileEntityBronzeGrinder) {
                    return new ContainerBronzeGrinder(player.inventory, (TileEntityBronzeGrinder) entity);
                }

            case LibGuiIds.BRONZE_EXTRACTOR:
                if (entity instanceof TileEntityBronzeExtractor) {
                    return new ContainerBronzeExtractor(player.inventory, (TileEntityBronzeExtractor) entity);
                }

            case LibGuiIds.BAGS:
                return new ContainerBag(player, new InventoryBag(player.getHeldItem()));

            case LibGuiIds.WELL:
                if (entity instanceof TileEntityWell) {
                    return new ContainerWell(player.inventory, (TileEntityWell) entity);
                }

            case LibGuiIds.CAMPFIRE:
                if (entity instanceof TileEntityCampFire) {
                    return new ContainerCampFire(player.inventory, (TileEntityCampFire) entity);
                }

            case LibGuiIds.BRASS_CHARGER:
                if (entity instanceof TileEntityBrassCharger) {
                    return new ContainerBrassCharger(player.inventory, (TileEntityBrassCharger) entity);
                }

            case LibGuiIds.BRONZE_CHARGER:
                if (entity instanceof TileEntityBronzeCharger) {
                    return new ContainerCharger(player.inventory, (TileEntityBronzeCharger) entity);
                }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (ID) {
            case LibGuiIds.CCOPPER_FURNACE:
                if (entity instanceof TileEntityCopperFurnace) {
                    return new GuiCopperFurnace(player.inventory, (TileEntityCopperFurnace) entity);
                }

            case LibGuiIds.COPPER_GRINDER:
                if (entity instanceof TileEntityCopperGrinder) {
                    return new GuiCopperGrinder(player.inventory, (TileEntityCopperGrinder) entity);
                }

            case LibGuiIds.BRASS_GRINDER:
                if (entity instanceof TileEntityBrassGrinder) {
                    return new GuiBrassGrinder(player.inventory, (TileEntityBrassGrinder) entity);
                }

            case LibGuiIds.GUIID_WINDMILL:
                while (entity instanceof TileEntityWindmill && world.getBlockMetadata(x, y, z) < 8) {
                    y++;
                }
                return new GuiWindmilll(player.inventory, (TileEntityWindmill) world.getTileEntity(x, y, z));

            case LibGuiIds.BRASS_FURNACE:
                if (entity instanceof TileEntityBrassFurnace) {
                    return new GuiBrassFurnace(player.inventory, (TileEntityBrassFurnace) entity);
                }

            case LibGuiIds.BRASS_ALLOYSMELTER:
                if (entity instanceof TileEntityBrassAlloy) {
                    return new GuiBrassAlloy(player.inventory, (TileEntityBrassAlloy) entity);
                }

            case LibGuiIds.GUIID_WASHER:
                if (entity instanceof TileEntityWasher) {
                    return new GuiWasher(player.inventory, (TileEntityWasher) entity);
                }

            case LibGuiIds.GUIID_BOOK:
                GuiBook Book = GuiBook.currentOpenLexicon;
                GuiBook.stackUsed = player.getCurrentEquippedItem();
                if (GuiBook.stackUsed == null)
                    return null;
                return Book;

            case LibGuiIds.GUIID_PLASTIC_CHEST:
                if (entity instanceof TileEntityPlasticChest) {
                    TileEntityPlasticChest entityPlasticChest = (TileEntityPlasticChest) world.getTileEntity(x, y, z);
                    return new GuiPlasticChest(player.inventory, entityPlasticChest);
                }

            case LibGuiIds.GUIID_PORTABLE_COBBLEGEN:
                if (entity instanceof TileEntityPortableCobbleGen) {
                    TileEntityPortableCobbleGen entityPortableCobbleGen = (TileEntityPortableCobbleGen) world.getTileEntity(x, y, z);
                    return new GuiPortableCobbleGen(player.inventory, entityPortableCobbleGen);
                }

            case LibGuiIds.BRONZE_FURNACE:
                if (entity instanceof TileEntityBronzeFurnace) {
                    TileEntityBronzeFurnace tileEntityBronzeFurnace = (TileEntityBronzeFurnace) world.getTileEntity(x, y, z);
                    return new GuiBronzeFurnace(player.inventory, tileEntityBronzeFurnace);
                }

            case LibGuiIds.BRONZE_STEAM_BOILER:
                if (entity instanceof TileEntityBronzeSteamBoiler) {
                    TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler = (TileEntityBronzeSteamBoiler) world.getTileEntity(x, y, z);
                    return new GuiBronzeSteamBoiler(player.inventory, tileEntityBronzeSteamBoiler);
                }

            case LibGuiIds.BRONZE_GRINDER:
                if (entity instanceof TileEntityBronzeGrinder) {
                    return new GuiBronzeGrinder(player.inventory, (TileEntityBronzeGrinder) entity);
                }

            case LibGuiIds.BRONZE_EXTRACTOR:
                if (entity instanceof TileEntityBronzeExtractor) {
                    return new GuiBronzeExtractor(player.inventory, (TileEntityBronzeExtractor) entity);
                }

            case LibGuiIds.BAGS:
                return new GuiBag(player, new InventoryBag(player.getHeldItem()));

            case LibGuiIds.WELL:
                if (entity instanceof TileEntityWell) {
                    return new GuiWell(player.inventory, (TileEntityWell) entity);
                }

            case LibGuiIds.CAMPFIRE:
                if (entity instanceof TileEntityCampFire) {
                    return new GuiCampFire(player.inventory, (TileEntityCampFire) entity);
                }

            case LibGuiIds.BRASS_CHARGER:
                if (entity instanceof TileEntityBrassCharger) {
                    return new GuiBrassCharger(player.inventory, (TileEntityBrassCharger) entity);
                }

            case LibGuiIds.BRONZE_CHARGER:
                if (entity instanceof TileEntityBronzeCharger) {
                    return new GuiBronzeCharger(player.inventory, (TileEntityBronzeCharger) entity);
                }
        }
        return null;
    }

}
