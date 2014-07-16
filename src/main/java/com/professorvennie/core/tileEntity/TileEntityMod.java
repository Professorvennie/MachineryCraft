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

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMod extends TileEntity {
    protected ForgeDirection orientation;
    protected String customName;

    public TileEntityMod() {
        orientation = ForgeDirection.SOUTH;
        customName = "";
    }

    public ForgeDirection getOrientation() {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = ForgeDirection.getOrientation(orientation);
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

        if (nbtTagCompound.hasKey("direction")) {
            this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte("direction"));
            //System.out.println("readFromNBT- orientation:" + orientation);
        }

        if (nbtTagCompound.hasKey("customName")) {
            this.customName = nbtTagCompound.getString("customName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte("direction", (byte) orientation.ordinal());
       //System.out.println("writeToNBT - orientation:" + orientation);

        if (this.hasCustomName()) {
            nbtTagCompound.setString("customName", customName);
        }
    }

    public boolean hasCustomName() {
        return customName != null && customName.length() > 0;
    }
}
