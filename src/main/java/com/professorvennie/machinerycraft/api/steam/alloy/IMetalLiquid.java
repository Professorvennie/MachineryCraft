package com.professorvennie.machinerycraft.api.steam.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:00 PM.
 */
public interface IMetalLiquid {

    public String getName();

    public int getAmount();

    public void setAmount(int amount);

    public int getAmountPerIngot();

    public int getAmountPerNugget();

    public int getAmountPerPlate();
}
