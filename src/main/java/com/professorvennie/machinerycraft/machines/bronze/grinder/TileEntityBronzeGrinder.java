/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.grinder;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.TileEntityBasicSteamMachine;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:23 AM at 11:23 AM.
 */
public class TileEntityBronzeGrinder extends TileEntityBasicSteamMachine {

    public static final int INPUTSLOT = 2, WATERSLOT = 0;
    public int cookTime, grindSpeed = 110;

    public TileEntityBronzeGrinder() {
        super(Names.Containers.BRONZE_GRINDER);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        boolean flag1 = false;

        if (!worldObj.isRemote) {
            if (!canGrind())
                cookTime = 0;

            if (tank.getFluid() != null) {
                if (getSteamAmount() >= 1 && canGrind() && canWork) {
                    cookTime++;
                    if (cookTime > 0) {
                        if (canGrind())
                            tank.getFluid().amount--;
                    }
                    if (cookTime == grindSpeed) {
                        cookTime = 0;
                        grindItem();
                        flag1 = true;
                    }
                } else
                    cookTime = 0;
            }
        }
        BlockBronzeGrinder block = (BlockBronzeGrinder) worldObj.getBlock(xCoord, yCoord, zCoord);
        if (cookTime > 0)
            block.isActive = true;
        else
            block.isActive = false;

        if (flag1) this.markDirty();
    }


    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        this.cookTime = (int) nbtTagCompound.getShort("cookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setShort("cookTime", (short) cookTime);
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    public int getCookProgressScaled(int i) {
        return cookTime * i / grindSpeed;
    }
}
