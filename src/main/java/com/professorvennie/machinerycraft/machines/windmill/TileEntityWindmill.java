/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.windmill;

import com.professorvennie.lib.base.tileentitys.TileEntityBasicSidedInventory;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityWindmill extends TileEntityBasicSidedInventory {

    public float rotaion = 0;
    public int maxPower = 10000;
    public float power = 0;
    public float powerPerRoation = 0.1F;

    public TileEntityWindmill() {
        super(Names.Blocks.WINDMILL);
    }

    public void updateEntity() {
        int height = yCoord;
        if (this.getWorldObj().getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) > 6) {
            //todo proper values and heights
            if (height < 100) {
                power += powerPerRoation;
                rotaion++;
            }
            if (height > 100 && height < 200) {
                power += (powerPerRoation * 2);
                rotaion += 2;
            }
            if (height > 200) {
                power += (powerPerRoation * 4);
                rotaion += 4;
            }

            if (power > maxPower) power = maxPower;
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        this.power = nbt.getShort("power");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("power", (short) this.power);
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return true;
    }

    public int getPowerScaled(int i) {
        return (int) (this.power * i / this.maxPower);
    }
}
