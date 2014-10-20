package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.api.steam.alloy.IMetalLiquid;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:09 PM.
 */
public class MetalLiquid implements IMetalLiquid {

    private String name;
    private int amountPerIngot, amountPerNugget, amountPerPlate, amount;

    public MetalLiquid(String name, int amountPerIngot, int amountPerNugget, int amountPerPlate) {
        this.name = name;
        this.amountPerIngot = amountPerIngot;
        this.amountPerNugget = amountPerNugget;
        this.amountPerPlate = amountPerPlate;
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

    @Override
    public int getAmountPerIngot() {
        return amountPerIngot;
    }

    @Override
    public int getAmountPerNugget() {
        return amountPerNugget;
    }

    @Override
    public int getAmountPerPlate() {
        return amountPerPlate;
    }
}
