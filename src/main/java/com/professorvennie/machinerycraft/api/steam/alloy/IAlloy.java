package com.professorvennie.machinerycraft.api.steam.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:17 PM.
 */
public interface IAlloy {

    public IMetalLiquid getFirstRequiredMetal();

    public IMetalLiquid getSecondRequiredMetal();

    public IAlloy getOutput();

    public String getName();

    public int getAmount();

    public void setAmount(int amount);
}
