/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.furnace;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.TileEntityBasicSteamMachine;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityBronzeFurnace extends TileEntityBasicSteamMachine {

    public static final int INPUTSLOT = 2, WATERSLOT = 0;
    public int cookTime = 0, fuelEfficiency = 1;

    public TileEntityBronzeFurnace() {
        super(Names.Containers.BRONZE_FURNACE);
        setMachineSpeed(110);
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    @Override
    public void update() {
        super.update();

        //attempt to fix wried crash
        BlockBronzeFurnace block = null;
        if (worldObj.getBlockState(pos).getBlock() instanceof BlockBronzeFurnace) {
            block = (BlockBronzeFurnace) worldObj.getBlockState(pos).getBlock();
        }
        if (cookTime > 0) {
            if (block != null)
                block.isActive = true;
        } else {
            if (block != null)
                block.isActive = false;
        }

        boolean flag1 = false;

        if (!worldObj.isRemote) {
            if (!canSmelt())
                cookTime = 0;

            /*if (tank.getFluid() != null) {
                if (tank.getFluid().amount >= fuelEfficiency && canSmelt() && canWork) {
                    cookTime++;
                    if (cookTime > 0)
                        tank.getFluid().amount -= fuelEfficiency;

                    if (cookTime == getMachineSpeed()) {
                        cookTime = 0;
                        smeltItem();
                        flag1 = true;
                    }
                } else
                    cookTime = 0;
            }*/

            if (steamAmount >= fuelEfficiency && canSmelt() && canWork) {
                cookTime++;
                if (cookTime > 0)
                    steamAmount -= fuelEfficiency;

                if (cookTime == getMachineSpeed()) {
                    cookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            } else
                cookTime = 0;
        }
        if (flag1) this.markDirty();
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        this.cookTime = (int) nbtTagCompound.getShort("cookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setShort("cookTime", (short) this.cookTime);
    }

    public int getCookProgressScaled(int i) {
        return cookTime * i / getMachineSpeed();
    }

    @Override
    public int getField(int id) {
        super.getField(id);
        if (id == 1)
            return cookTime;
        return super.getField(id);
    }

    @Override
    public int getFieldCount() {
        return super.getFieldCount() + 1;
    }

    @Override
    public void setField(int id, int value) {
        super.setField(id, value);
        if (id == 1)
            cookTime = value;
    }
}
