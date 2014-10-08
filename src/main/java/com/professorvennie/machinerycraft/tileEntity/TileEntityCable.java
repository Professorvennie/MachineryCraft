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

import com.professorvennie.machinerycraft.api.blocks.IMachine;
import com.professorvennie.machinerycraft.machines.windmill.TileEntityWindmill;
import net.minecraft.util.EnumFacing;

public class TileEntityCable extends TileEntityMod {

    public EnumFacing[] connections = new EnumFacing[6];

    public TileEntityCable() {

    }

    public void updateEntity() {
        this.updateConnections();
    }

    public void updateConnections() {
        if (isCable(pos.getX(), pos.getY() + 1, pos.getZ()) || isMachine(pos.getX(),  pos.getY() + 1, pos.getZ()))
            connections[0] = EnumFacing.UP;
        else connections[0] = null;
        if (isCable(pos.getX(),  pos.getY() - 1, pos.getZ())) connections[1] = EnumFacing.DOWN;
        else connections[1] = null;
        if (isCable(pos.getX(),  pos.getY(), pos.getZ() - 1) || isWindmill(pos.getX(),  pos.getY(), pos.getZ() - 1) || isMachine(pos.getX(),  pos.getY(), pos.getZ() - 1))
            connections[2] = EnumFacing.NORTH;
        else connections[2] = null;
        if (isCable(pos.getX() + 1,  pos.getY(), pos.getZ()) || isWindmill(pos.getX() + 1,  pos.getY(), pos.getZ()) || isMachine(pos.getX() + 1,  pos.getY(), pos.getZ()))
            connections[3] = EnumFacing.EAST;
        else connections[3] = null;
        if (isCable(pos.getX(),  pos.getY(), pos.getZ() + 1) || isWindmill(pos.getX(),  pos.getY(), pos.getZ() + 1) || isMachine(pos.getX(),  pos.getY(), pos.getZ() + 1))
            connections[4] = EnumFacing.SOUTH;
        else connections[4] = null;
        if (isCable(pos.getX() - 1,  pos.getY(), pos.getZ()) || isWindmill(pos.getX() - 1,  pos.getY(), pos.getZ()) || isMachine(pos.getX() - 1,  pos.getY(), pos.getZ()))
            connections[5] = EnumFacing.WEST;
        else connections[5] = null;
    }

    public boolean isCable(int x, int y, int z) {
        return this.worldObj.getTileEntity(pos) instanceof TileEntityCable;
    }

    public boolean isMachine(int x, int y, int z) {
        return this.worldObj.getTileEntity(pos) instanceof IMachine;
    }

    public boolean isWindmill(int x, int y, int z) {                            //todo when windmill has blockstates
        return (this.worldObj.getTileEntity(pos) instanceof TileEntityWindmill)/* && worldObj.getBlockMetadata(x, y, z) == 1*/;
    }


    public boolean onlyOneOppsoite(EnumFacing[] directions) {
        EnumFacing mainDirection = null;
        boolean isOppsoite = false;

        for (int i = 0; i < directions.length; i++) {
            if (mainDirection == null && directions[i] != null) mainDirection = directions[i];

            if (directions[i] != null && mainDirection != directions[i]) {
                if (!isOppsoite(mainDirection, directions[i])) return false;
                else isOppsoite = true;
            }
        }
        return isOppsoite;
    }

    public boolean isOppsoite(EnumFacing first, EnumFacing second) {
        if (first.equals(EnumFacing.NORTH) && second.equals(EnumFacing.SOUTH) || (first.equals(EnumFacing.SOUTH) && second.equals(EnumFacing.NORTH)))
            return true;
        if (first.equals(EnumFacing.EAST) && second.equals(EnumFacing.WEST) || (first.equals(EnumFacing.WEST) && second.equals(EnumFacing.EAST)))
            return true;
        if (first.equals(EnumFacing.UP) && second.equals(EnumFacing.DOWN) || (first.equals(EnumFacing.DOWN) && second.equals(EnumFacing.UP)))
            return true;

        return false;
    }
}
