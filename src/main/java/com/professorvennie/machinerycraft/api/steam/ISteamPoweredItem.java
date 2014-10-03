package com.professorvennie.machinerycraft.api.steam;

import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 9/23/2014 at 8:45 PM.
 */
public interface ISteamPoweredItem {

    public int getSteamCapacity();

    public void setCapacity(int capacity);

    public void receiveSteam(ItemStack itemStack, int amount);

    public void extractSteam(ItemStack itemStack, int amount);
}
