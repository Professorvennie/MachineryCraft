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

import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 9/23/2014 at 8:45 PM.
 */
public interface ISteamPoweredItem {

    public int getSteamCapacity();

    public void receiveSteam(ItemStack itemStack, int amount);

    public void extractSteam(ItemStack itemStack, int amount);

    public boolean canExtract();

    public boolean canReceive();
}
