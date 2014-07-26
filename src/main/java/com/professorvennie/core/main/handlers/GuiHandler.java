/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main.handlers;


import com.professorvennie.core.tileEntity.*;
import com.professorvennie.core.common.containers.*;
import com.professorvennie.core.lib.*;
import com.professorvennie.core.client.gui.*;
import com.professorvennie.core.client.gui.book.GuiBook;

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
					
			case LibGuiIds.GUIID_IRONOXIDE_GRINDER:
				if(entity instanceof TileEntityironOxideGrinder){
					return new ContainerIronoxideGrinder(player.inventory, (TileEntityironOxideGrinder) entity);
				}				
			
			case LibGuiIds.GUIID_WINDMILL:
				while(entity instanceof TileEntitywindmill && world.getBlockMetadata(x, y, z) < 8){
					y++;
				}
					return new ContainerWindmill(player.inventory, (TileEntitywindmill) world.getTileEntity(x, y, z));
					
			case LibGuiIds.GUIID_IRONOXIDE_FURNACE:
				if(entity instanceof TileEntityIronOxideFurnace){
					return new ContainerIronoxideFurnace(player.inventory, (TileEntityIronOxideFurnace) entity);
				}
				
			case LibGuiIds.GUIID_GOLDOXIDE_FURNACE:
				if(entity instanceof TileEntityGoldOxideFurnace){
					return new ContainerGoldoxideFurnace(player.inventory, (TileEntityGoldOxideFurnace) entity);
				}
				
			case LibGuiIds.GUIID_GOLDOXIDE_GRINDER:
				if(entity instanceof TileEntityGoldOxideGrinder){
					return new ContainerGoldoxideGrinder(player.inventory, (TileEntityGoldOxideGrinder) entity);
				}
				
			case LibGuiIds.GUIID_IRONOXIDE_ALLOY:
				if(entity instanceof TileEntityIronOxideAlloy){
					return new ContainerIronoxideAlloy(player.inventory, (TileEntityIronOxideAlloy) entity);
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
                    TileEntityPlasticChest entityPlasticChest = (TileEntityPlasticChest)world.getTileEntity(x, y, z);
                    return new ContainerPlasticChest(player.inventory, entityPlasticChest);

            case LibGuiIds.GUIID_PORTABLE_COBBLEGEN:
                TileEntityPortableCobbleGen tileEntityPortableCobbleGen = (TileEntityPortableCobbleGen)world.getTileEntity(x, y, z);
                return new ContainerPortableCobbleGen(player.inventory, tileEntityPortableCobbleGen);

            case LibGuiIds.BRONZE_FURNACE:
                TileEntityBronzeFurnace tileEntityBronzeFurnace = (TileEntityBronzeFurnace)world.getTileEntity(x, y, z);
                return new ContainerBronzeFurnace(player.inventory, tileEntityBronzeFurnace);

            case LibGuiIds.BRONZE_STEAM_BOILER:
                TileEntityBronzeSteamBoiler tileEntityBronzeSteamBoiler = (TileEntityBronzeSteamBoiler)world.getTileEntity(x, y, z);
                return new ContainerBronzeSteamBoiler(player.inventory, tileEntityBronzeSteamBoiler);
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
							
			case LibGuiIds.GUIID_IRONOXIDE_GRINDER:
				if(entity instanceof TileEntityironOxideGrinder){
					return new GuiIronoxideGrinder(player.inventory, (TileEntityironOxideGrinder) entity);
					}
							
			case LibGuiIds.GUIID_WINDMILL:
				while(entity instanceof TileEntitywindmill && world.getBlockMetadata(x, y, z) < 8){
					y++;
				}
					return new GuiWindmilll(player.inventory, (TileEntitywindmill) world.getTileEntity(x, y, z));	
			
			case LibGuiIds.GUIID_IRONOXIDE_FURNACE:
				if(entity instanceof TileEntityIronOxideFurnace){
					return new GuiIronoxideFurnace(player.inventory, (TileEntityIronOxideFurnace) entity);
					}
				
			case LibGuiIds.GUIID_GOLDOXIDE_FURNACE:
				if(entity instanceof TileEntityGoldOxideFurnace){
					return new GuiGoldoxideFurnace(player.inventory, (TileEntityGoldOxideFurnace) entity);
					}
				
			case LibGuiIds.GUIID_GOLDOXIDE_GRINDER:
				if(entity instanceof TileEntityGoldOxideGrinder){
					return new GuiGoldoxideGrinder(player.inventory, (TileEntityGoldOxideGrinder) entity);
					}
				
			case LibGuiIds.GUIID_IRONOXIDE_ALLOY:
				if(entity instanceof TileEntityIronOxideAlloy){
					return new GuiIronoxideAlloy(player.inventory, (TileEntityIronOxideAlloy) entity);
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
            }
        return null;
	}

}
