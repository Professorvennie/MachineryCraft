package com.professorvennie.machinerycraft.api.item;

/**
 * Created by ProfessorVennie on 9/8/2014 at 8:38 PM.
 */
public interface IItemUpgrade {

    public int getSpeedModifier();

    public boolean isEjectorUpgrade();

    public int getPowerBoost();

    public int getFuelEfficiency();
}
