package com.professorvennie.machinerycraft.api.steam.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 9:08 PM.
 */
public interface IAlloyTank {

    public IMetalLiquid getFirstMetal();

    public IMetalLiquid getSecondMetal();

    public IAlloy getAlloy();

    public int getCapacity();
}
