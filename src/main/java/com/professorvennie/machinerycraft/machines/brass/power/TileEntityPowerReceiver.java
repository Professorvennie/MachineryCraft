package com.professorvennie.machinerycraft.machines.brass.power;

import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;

/**
 * Created by ProfessorVennie on 10/7/2014 at 4:31 PM.
 */
public class TileEntityPowerReceiver extends TileEntityBasicMachine {

    private boolean requestPower;
    private int power, maxPower = 10000;

    public TileEntityPowerReceiver() {
        super("");
        requestPower = true;
    }

    public boolean isRequestingPower() {
        return requestPower;
    }

    public int getPower() {
        return power;
    }

    public int getCapacity() {
        return maxPower;
    }

    public void addPower(int power) {
        if ((this.power += power) <= maxPower)
            this.power = power;
    }

    public boolean canReceivePower(int power) {
        if ((this.power += power) <= maxPower)
            return true;
        else
            return false;
    }
}
