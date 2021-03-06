/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
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
