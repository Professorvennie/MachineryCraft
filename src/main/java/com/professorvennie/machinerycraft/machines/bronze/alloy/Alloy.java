package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.api.steam.alloy.IAlloy;
import com.professorvennie.machinerycraft.api.steam.alloy.IMetalLiquid;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:20 PM.
 */
public class Alloy implements IAlloy {

    private IMetalLiquid firstMetal, secoundMetal;
    private IAlloy output;
    private String name;
    private int amount;

    public Alloy(String name, IMetalLiquid firstMetal, IMetalLiquid secoundMetal, IAlloy output) {
        this.name = name;
        this.firstMetal = firstMetal;
        this.secoundMetal = secoundMetal;
        this.output = output;
    }

    @Override
    public IMetalLiquid getFirstRequiredMetal() {
        return firstMetal;
    }

    @Override
    public IMetalLiquid getSecondRequiredMetal() {
        return secoundMetal;
    }

    @Override
    public IAlloy getOutput() {
        return output;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount += amount;
    }
}
