/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.main.handlers;


import com.professorvennie.machinerycraft.core.tileEntity.*;
import com.professorvennie.machinerycraft.core.common.containers.*;
import com.professorvennie.machinerycraft.core.lib.*;
import com.professorvennie.machinerycraft.core.client.gui.*;
import com.professorvennie.machinerycraft.core.client.gui.book.GuiBook;

import com.professorvennie.machinerycraft.core.tileEntity.machines.basic.TileEntityPortableCobbleGen;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.TileEntityBrassAlloy;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.TileEntityBrassFurnace;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.TileEntityBrassGrinder;
import com.professorvennie.machinerycraft.core.tileEntity.machines.copper.TileEntityCopperFurnace;
import com.professorvennie.machinerycraft.core.tileEntity.machines.copper.TileEntityCopperGrinder;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeExtractor;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeFurnace;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeGrinder;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeSteamBoiler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity entity= world.getTileEntity(x, y, z);
		
			switch(ID){
			case LibGuiIds.CCOPPER_FURNACE:
				if(entity instanceof TileEntityCopperFurnace){
					return new ContainerCopperFurnace(player.inventory, (TileEntityCopperFurnace) entity);
				}
					
			case LibGuiIds.COPPER_GRINDER:
					if(entity instanceof TileEntityCopperGrinder){
						return new ContainerCopperGrinder(player.inventory, (TileEntityCopperGrinder) entity);
				}
					
			case LibGuiIds.BRASS_GRINDER:
				if(entity instanceof TileEntityBrassGrinder){
					return new ContainerBrassGrinder(player.inventory, (TileEntityBrassGrinder) entity);
				}				
			
			case LibGuiIds.GUIID_WINDMILL:
				while(entity instanceof TileEntitywindmill && world.getBlockMetadata(x, y, z) < 8){
					y++;
				}
					return new ContainerWindmill(player.inventory, (TileEntitywindmill) world.getTileEntity(x, y, z));
					
			case LibGuiIds.BRASS_FURNACE:
				if(entity instanceof TileEntityBrassFurnace){
					return new ContainerBrassFurnace(player.inventory, (TileEntityBrassFurnace) entity);
				}
				
			case LibGuiIds.GUIID_GOLDOXIDE_FURNACE:
				if(entity instanceof TileEntityGoldOxideFurnace){
					return new ContainerGoldoxideFurnace(player.inventory, (TileEntityGoldOxideFurnace) entity);
				}
				
			case LibGuiIds.GUIID_GOLDOXIDE_GRINDER:
				if(entity instanceof TileEntityGoldOxideGrinder){
					return new ContainerGoldoxideGrinder(player.inventory, (TileEntityGoldOxideGrinder) entity);
				}
				
			case LibGuiIds.BRASS_ALLOYSMELTER:
				if(entity instanceof TileEntityBrassAlloy){
					return new ContainerBrassAlloy(player.inventory, (TileEntityBrassAlloy) entity);
				}
				
			case LibGuiIds.GUIID_WASHER:
				if(entity instanceof TileEntityWasher ){
					return new ContainerWasher(player.inventory, (TileEntityWasher) entity);
				}

            case LibGuiIds.GUIID_GOLDOXIDE_ALLOY:
                if(entity instanceof TileEntityGoldOxideAlloy){
                    return new ContainerGoldoxideAlloy(player.inventory, (TileEntityGoldOxideAlloy) entity);
                }

            case LibGuiIds.GUIID_PLASTIC_CHEST:
                    if(entity instanceof TileEntityPlasticChest) {
                        return new ContainerPlasticChest(player.inventory, (TileEntityPlasticChest) entity);
                    }

            case LibGuiIds.GUIID_PORTABLE_COBBLEGEN:
                if(entity instanceof TileEntityPortableCobbleGen) {
                    return new ContainerPortableCobbleGen(player.inventory, (TileEntityPortableCobbleGen) entity);
                }

            case LibGuiIds.BRONZE_FURNACE:
                if(entity instanceof TileEntityBronzeFurnace) {
                    return new ContainerBronzeFurnace(player.inventory, (TileEntityBronzeFurnace)entity);
                }

            case LibGuiIds.BRONZE_STEAM_BOILER:
                if(entity instanceof TileEntityBronzeSteamBoiler) {
                    return new ContainerBronzeSteamBoiler(player.inventory, (TileEntityBronzeSteamBoiler)entity);
                }

            case LibGuiIds.BRONZE_GRINDER:
                if(entity instanceof TileEntityBronzeGrinder){
                    return new ContainerBronzeGrinder(player.inventory, (TileEntityBronzeGrinder)entity);
                }

            case LibGuiIds.BRONZE_EXTRACTOR:
                if(entity instanceof TileEntityBronzeExtractor){
                    return new ContainerBronzeExtractor(player.inventory, (TileEntityBronzeExtractor)entity);
                }

            case LibGuiIds.BAGS:
                return new ContainerBag(player, new InventoryBag(player.getHeldItem()));
			}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity= world.getTileEntity(x, y, z);
		
			switch(ID){
			case LibGuiIds.CCOPPER_FURNACE:
				if(entity instanceof TileEntityCopperFurnace){
					return new GuiCopperFurnace(player.inventory, (TileEntityCopperFurnace) entity);
					}
			
			case LibGuiIds.COPPER_GRINDER:
				if(entity instanceof TileEntityCopperGrinder){
					return new GuiCopperGrinder(player.inventory, (TileEntityCopperGrinder) entity);
					}
							
			case LibGuiIds.BRASS_GRINDER:
				if(entity instanceof TileEntityBrassGrinder){
					return new GuiBrassGrinder(player.inventory, (TileEntityBrassGrinder) entity);
					}
							
			case LibGuiIds.GUIID_WINDMILL:
				while(entity instanceof TileEntitywindmill && world.getBlockMetadata(x, y, z) < 8){
					y++;
				}
					return new GuiWindmilll(player.inventory, (TileEntitywindmill) world.getTileEntity(x, y, z));	
			
			case LibGuiIds.BRASS_FURNACE:
				if(entity instanceof TileEntityBrassFurnace){
					return new GuiBrassFurnace(player.inventory, (TileEntityBrassFurnace) entity);
					}
				
			case LibGuiIds.GUIID_GOLDOXIDE_FURNACE:
				if(entity instanceof TileEntityGoldOxideFurnace){
					return new GuiGoldoxideFurnace(player.inventory, (TileEntityGoldOxideFurnace) entity);
					}
				
			case LibGuiIds.GUIID_GOLDOXIDE_GRINDER:
				if(entity instanceof TileEntityGoldOxideGrinder){
					return new GuiGoldoxideGrinder(player.inventory, (TileEntityGoldOxideGrinder) entity);
					}
				
			case LibGuiIds.BRASS_ALLOYSMELTER:
				if(entity instanceof TileEntityBrassAlloy){
					return new GuiBrassAlloy(player.inventory, (TileEntityBrassAlloy) entity);
					}
				
			case LibGuiIds.GUIID_WASHER:
				if(entity instanceof TileEntityWasher){
					return new GuiWasher(player.inventory, (TileEntityWasher) entity);
					}
				
			case LibGuiIds.GUIID_BOOK:
				GuiBook Book = GuiBook.currentOpenLexicon;
				GuiBook.stackUsed = player.getCurrentEquippedItem();
				if(GuiBook.stackUsed == null)
					return null;
				return Book;

            case LibGuiIds.GUIID_GOLDOXIDE_ALLOY:
                if(entity instanceof TileEntityGoldOxideAlloy){
                    return new GuiGoldoxideAlloy(player.inventory, (TileEntityGoldOxideAlloy) entity);
                }

            case LibGuiIds.GUIID_PLASTIC_CHEST:
                 if(entity instanceof TileEntityPlasticChest) {
                     TileEntityPlasticChest entityPlasticChest = (TileEntityPlasticChest) world.getTileEntity(x, y, z);
                     return new GuiPlasticChest(player.inventory, entityPlasticChest);
                 }

            case LibGuiIds.GUIID_PORTABLE_COBBLEGEN:
                if(entity instanceof TileEntityPortableCobbleGen){
                    TileEntityPortableCobbleGen entityPortableCobbleGen = (TileEntityPortableCobbleGen)world.getTileEntity(x, y, z);
                    return new GuiPortableCobbleGen(player.inventory, entityPortableCobbleGen);
                }

            case LibGuiIds.BRONZE_FURNACE:
                if(entity instanceof TileEntityBronzeFurnace){
                    TileEntityBronzeFurnace tileEntityBronzeFurnace = (TileEntityBronzeFurnace)world.getTileEntity(x, y, z);
                    return new GuiBronzeFurnace(player.inventory, tileEntityBronzeFurnace);
                }

            case LibGuiIds.BRONZE_STEAM_BOILER:
                if(entity instanceof TileEntityBronzeSteamBoiler){
                    TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler = (TileEntityBronzeSteamBoiler)world.getTileEntity(x, y, z);
                    return new GuiBronzeSteamBoiler(player.inventory, tileEntityBronzeSteamBoiler);
                }

            case LibGuiIds.BRONZE_GRINDER:
                if(entity instanceof TileEntityBronzeGrinder){
                    return new GuiBronzeGrinder(player.inventory, (TileEntityBronzeGrinder)entity);
                }

            case LibGuiIds.BRONZE_EXTRACTOR:
                if(entity instanceof TileEntityBronzeExtractor){
                    return new GuiBronzeExtractor(player.inventory, (TileEntityBronzeExtractor)entity);
                }

            case LibGuiIds.BAGS:
                return new GuiBag(player, new InventoryBag(player.getHeldItem()));
            }
        return null;
	}

}
