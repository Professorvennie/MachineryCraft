package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.api.steam.alloy.IMetalLiquid;
import com.professorvennie.machinerycraft.api.steam.alloy.IMetalTank;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:06 PM.
 */
public class MetalTank implements IMetalTank {

    private IMetalLiquid metal;
    private int capacity;

    public MetalTank(IMetalLiquid liquid, int capacity) {
        this.metal = liquid;
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public IMetalLiquid getMetal() {
        return metal;
    }

    @Override
    public void setLiquid(IMetalLiquid liquid) {
        this.metal = liquid;
    }

    @Override
    public int getMetalAmount() {
        return metal.getAmount();
    }

    @Override
    public boolean canAcceptAmount(int amount) {
        if (metal.getAmount() + amount <= capacity)
            return true;
        else
            return false;
    }

    @Override
    public String[] getToolTip() {
        return new String[]{metal.getName(), metal.getAmount() + "/" + capacity + "mb"};
    }
}
