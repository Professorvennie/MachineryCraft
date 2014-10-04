/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.brass.charger;

import com.professorvennie.machinerycraft.api.item.IPowerdItem;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by ProfessorVennie on 9/27/2014 at 5:23 PM.
 */
public class TileEntityBrassCharger extends TileEntityBasicMachine {

    public int power, maxPower = 10000;

    public TileEntityBrassCharger() {
        super(Names.Containers.BRASS_CHARGER);
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (!worldObj.isRemote) {
            if (inventory[0] != null && canWork) {
                if (inventory[0].getItem() instanceof IPowerdItem) {
                    int power = inventory[0].stackTagCompound.getInteger("Power");
                    int capacity = ((IPowerdItem) inventory[0].getItem()).getCapacity();
                    if (power < capacity) {
                        if (this.power > 0) {
                            //transfer power
                        }
                    }
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        power = nbtTagCompound.getInteger("Power");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setInteger("Power", power);
    }
}
