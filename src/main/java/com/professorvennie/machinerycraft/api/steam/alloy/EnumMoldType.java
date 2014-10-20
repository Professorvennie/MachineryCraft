package com.professorvennie.machinerycraft.api.steam.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:02 PM.
 */
public enum EnumMoldType {

    INGOT("ingot", 1000),
    NUGGET("nugget", 333),
    PLATE("plate", 1000);

    private String unlocalizedName;
    private int amountPerMold;

    private EnumMoldType(String name, int amountPerMold) {
        this.unlocalizedName = name;
        this.amountPerMold = amountPerMold;
    }
}
