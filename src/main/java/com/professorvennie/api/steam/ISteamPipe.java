package com.professorvennie.api.steam;

/**
 * Created by ProfessorVennie on 8/9/2014 at 4:21 PM.
 */
public interface ISteamPipe {

    public int getSteamAmount();

    public int getSteamCapacity();

    public void useSteam(int amount);

    public void addSteam(int amount);
}
