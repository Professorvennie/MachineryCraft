package com.professorvennie.machinerycraft.api.steam;

import net.minecraftforge.fluids.FluidTank;

/**
 * Created by ProfessorVennie on 8/9/2014 at 1:30 PM.
 */
public interface ISteamTank {

    public FluidTank getSteamTank();

    public int getSteamAmount();

    public int getSteamCapacity();

    public void addSteamAmount(int amount);
}
