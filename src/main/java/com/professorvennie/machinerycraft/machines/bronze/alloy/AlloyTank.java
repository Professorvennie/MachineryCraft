package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.api.steam.alloy.IAlloy;
import com.professorvennie.machinerycraft.api.steam.alloy.IAlloyTank;
import com.professorvennie.machinerycraft.api.steam.alloy.IMetalLiquid;

/**
 * Created by ProfessorVennie on 10/19/2014 at 9:09 PM.
 */
public class AlloyTank implements IAlloyTank {

    private IMetalLiquid first, second;
    private IAlloy alloy;
    private int capacity;

    public AlloyTank(IMetalLiquid firstMetal, IMetalLiquid second, IAlloy alloy, int capacity) {
        this.first = firstMetal;
        this.second = second;
        this.alloy = alloy;
        this.capacity = capacity;
    }

    @Override
    public IMetalLiquid getFirstMetal() {
        return first;
    }

    @Override
    public IMetalLiquid getSecondMetal() {
        return second;
    }

    @Override
    public IAlloy getAlloy() {
        return alloy;
    }

    public void setAlloy(IAlloy alloy) {
        this.alloy = alloy;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setFirst(IMetalLiquid first) {
        this.first = first;
    }

    public void setSecond(IMetalLiquid second) {
        this.second = second;
    }

    public void addToFirst(int amount) {
        first.setAmount(amount);
    }

    public void addToSecond(int amount) {
        second.setAmount(amount);
    }

    public void addToOutput(int amount) {
        alloy.setAmount(amount);
    }
}
