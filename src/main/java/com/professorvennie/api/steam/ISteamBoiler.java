package com.professorvennie.api.steam;

import net.minecraftforge.fluids.FluidTank;

/**
 * Created by ProfessorVennie on 8/10/2014 at 8:29 PM.
 */
public interface ISteamBoiler extends ISteamTank{

    public FluidTank getWaterTank();

    public int getWaterAmount();

    public int getWaterCapacity();

    public void setWaterAmount(int amount);
}
