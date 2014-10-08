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

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityMod extends TileEntity {

    protected EnumFacing orientation;
    protected String customName;

    public TileEntityMod() {
        orientation = EnumFacing.SOUTH;
        customName = "";
    }

    public EnumFacing getOrientation() {
        return orientation;
    }

    /*public void setOrientation(int orientation) {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }*/

    public void setOrientation(EnumFacing orientation) {
        this.orientation = orientation;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        /*if (nbtTagCompound.hasKey("direction")) {
            this.orientation = EnumFacing.getOrientation(nbtTagCompound.getByte("direction"));
        }*/

        if (nbtTagCompound.hasKey("customName")) {
            this.customName = nbtTagCompound.getString("customName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte("direction", (byte) orientation.ordinal());

        if (this.hasCustomInvName()) {
            nbtTagCompound.setString("customName", customName);
        }
    }

    public boolean hasCustomInvName() {
        return customName != null && customName.length() > 0;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tileTag = new NBTTagCompound();
        this.writeToNBT(tileTag);
        return new S35PacketUpdateTileEntity(pos, 0, tileTag);
    }
}
