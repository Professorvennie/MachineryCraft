package com.professorvennie.machinerycraft.core.entitys;

import com.professorvennie.machinerycraft.core.main.MachineryCraft;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Created by ProfessorVennie on 8/4/2014 at 10:54 AM.
 */
public class ModEntities {

    private static int id = 1;

    public static void init(){
        EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", id, MachineryCraft.instance, 64, 10, true);
    }
}
