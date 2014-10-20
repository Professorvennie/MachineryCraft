package com.professorvennie.machinerycraft.api.steam.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:05 PM.
 */
public interface IMetalTank {

    public int getCapacity();

    public IMetalLiquid getMetal();

    public void setLiquid(IMetalLiquid liquid);

    public int getMetalAmount();

    public boolean canAcceptAmount(int amount);

    public String[] getToolTip();
}
