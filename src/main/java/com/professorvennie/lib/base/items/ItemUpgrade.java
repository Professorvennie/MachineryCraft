package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.api.item.IItemUpgrade;
import net.minecraft.item.Item;

/**
 * Created by ProfessorVennie on 9/29/2014 at 4:11 PM.
 */
public class ItemUpgrade extends ItemBase implements IItemUpgrade {

    private int speedModifier;
    private boolean isEjectorUpgrade;

    public ItemUpgrade(String name) {
        super(name);
    }

    @Override
    public int getSpeedModifier() {
        return speedModifier;
    }

    @Override
    public boolean isEjectorUpgrade() {
        return isEjectorUpgrade;
    }

    public Item setEjectorUpgrade(boolean isEjectorUpgrade) {
        this.isEjectorUpgrade = isEjectorUpgrade;
        return this;
    }

    public Item setSpeedModifier(int speedModifier) {
        this.speedModifier = speedModifier;
        return this;
    }
}
