package com.professorvennie.machinerycraft.machines.bronze.alloy;

/**
 * Created by ProfessorVennie on 10/19/2014 at 2:12 PM.
 */
public class MetalRegistry {

    public static MetalLiquid iron, gold, copper, tin;
    public static Alloy bronze;

    public static void init() {
        iron = new MetalLiquid("iron", 1000, 333, 1000);
        gold = new MetalLiquid("gold", 1000, 333, 1000);
        copper = new MetalLiquid("copper", 1000, 333, 1000);
        tin = new MetalLiquid("tin", 1000, 333, 1000);

        bronze = new Alloy("bronze", copper, tin, bronze);
    }
}
