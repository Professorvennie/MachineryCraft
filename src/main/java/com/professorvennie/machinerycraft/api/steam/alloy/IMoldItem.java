package com.professorvennie.machinerycraft.api.steam.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:01 PM.
 */
public interface IMoldItem {

    public String getName(int meta);

    public int getAmountPerCast(int meta);

    public EnumMoldType getType(int meta);
}
