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

import com.professorvennie.api.blocks.IMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCable extends TileEntity {
	
	public ForgeDirection[] connections = new ForgeDirection[6];
	
	public TileEntityCable(){
		
	}
	
	public void updateEntity(){
		this.updateConnections();
	}
	
	public void updateConnections(){
		if(isCable(xCoord, yCoord+1, zCoord)) connections[0] = ForgeDirection.UP;
			else connections[0] = null;
		if(isCable(xCoord, yCoord-1, zCoord)) connections[1] = ForgeDirection.DOWN;
			else connections[1] = null;
		if(isCable(xCoord, yCoord, zCoord-1) || isWindmill(xCoord, yCoord, zCoord-1)) connections[2] = ForgeDirection.NORTH;
			else connections[2] = null;
		if(isCable(xCoord+1, yCoord, zCoord) || isWindmill(xCoord+1, yCoord, zCoord)) connections[3] = ForgeDirection.EAST;
			else connections[3] = null;
		if(isCable(xCoord, yCoord, zCoord+1) || isWindmill(xCoord, yCoord, zCoord+1)) connections[4] = ForgeDirection.SOUTH;
			else connections[4] = null;
		if(isCable(xCoord-1, yCoord, zCoord) || isWindmill(xCoord-1, yCoord, zCoord)) connections[5] = ForgeDirection.WEST;
			else connections[5] = null;
	}

    public boolean isCable(int x, int y, int z){
       return this.worldObj.getTileEntity(x, y, z) instanceof TileEntityCable;
    }

    public boolean isMachine(int x, int y, int z){
        return this.worldObj.getTileEntity(x, y, z) instanceof IMachine;
    }
    public boolean isWindmill(int x, int y, int z){
        return (this.worldObj.getTileEntity(x, y, z) instanceof IMachine) && worldObj.getBlockMetadata(x, y, z) == 1;
    }

	
	public boolean onlyOneOppsoite(ForgeDirection[] directions){
		ForgeDirection mainDirection = null;
		boolean isOppsoite = false;
		
		for(int i = 0; i < directions.length; i++){
			if(mainDirection == null && directions[i] != null) mainDirection = directions[i];

			if (directions[i] != null && mainDirection!= directions[i]) {
				if(!isOppsoite(mainDirection, directions[i])) return false;
				else isOppsoite = true;
			}
		}
		return isOppsoite;
	}

	public boolean isOppsoite(ForgeDirection first, ForgeDirection second) {
		if (first.equals(ForgeDirection.NORTH) && second.equals(ForgeDirection.SOUTH) || (first.equals(ForgeDirection.SOUTH) && second.equals(ForgeDirection.NORTH)))
			return true;
		if (first.equals(ForgeDirection.EAST) && second.equals(ForgeDirection.WEST) || (first.equals(ForgeDirection.WEST) && second.equals(ForgeDirection.EAST)))
			return true;
		if (first.equals(ForgeDirection.UP) && second.equals(ForgeDirection.DOWN) || (first.equals(ForgeDirection.DOWN) && second.equals(ForgeDirection.UP)))
			return true;

		return false;
	}
}
