package com.professorvennie.machinerycraft.plugins.codechicken.fmp;


import net.minecraft.item.Item;

/**
 * Created by ProfessorVennie on 9/20/2014 at 2:49 PM.
 */
public class FMPPlugin {

    public static Item copperSaw;
    public static Item tinSaw;
    public static Item silverSaw;
    public static Item leadSaw;
    public static Item zincSaw;
    public static Item bronzeSaw;
    public static Item brassSaw;

    public static void init() {
        copperSaw = new ItemSaw("copperSaw", 1);
        tinSaw = new ItemSaw("tinSaw", 1);
        silverSaw = new ItemSaw("silverSaw", 1);
        leadSaw = new ItemSaw("leadSaw", 2);
        zincSaw = new ItemSaw("zincSaw", 2);
        bronzeSaw = new ItemSaw("bronzeSaw", 3);
        brassSaw = new ItemSaw("brassSaw", 3);
    }
}
