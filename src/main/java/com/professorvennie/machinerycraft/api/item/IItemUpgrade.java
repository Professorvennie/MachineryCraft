/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
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
