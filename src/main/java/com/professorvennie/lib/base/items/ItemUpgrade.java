package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.api.item.IItemUpgrade;
import net.minecraft.item.Item;

/**
 * Created by ProfessorVennie on 9/29/2014 at 4:11 PM.
 */
public class ItemUpgrade extends ItemBase implements IItemUpgrade {

    private int speedModifier, powerBoost, fuelEff;
    private boolean isEjectorUpgrade;

    public ItemUpgrade(String name, int maxStackSize) {
        super(name);
        if (maxStackSize > 0)
            setMaxStackSize(maxStackSize);
    }

    @Override
    public int getSpeedModifier() {
        return speedModifier;
    }

    @Override
    public boolean isEjectorUpgrade() {
        return isEjectorUpgrade;
    }

    @Override
    public int getPowerBoost() {
        return powerBoost;
    }

    @Override
    public int getFuelEfficiency() {
        return fuelEff;
    }

    public Item setEjectorUpgrade(boolean isEjectorUpgrade) {
        this.isEjectorUpgrade = isEjectorUpgrade;
        return this;
    }

    public Item setSpeedModifier(int speedModifier) {
        this.speedModifier = speedModifier;
        return this;
    }

    public Item setPowerBoost(int powerBoost) {
        this.powerBoost = powerBoost;
        return this;
    }

    public Item setFuelEff(int fuelEff) {
        this.fuelEff = fuelEff;
        return this;
    }
}
