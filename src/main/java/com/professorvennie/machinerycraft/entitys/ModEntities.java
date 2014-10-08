/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.entitys;

import com.professorvennie.machinerycraft.MachineryCraft;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by ProfessorVennie on 8/4/2014 at 10:54 AM.
 */
public class ModEntities {

    private static int id = 1;

    public static void init() {
        EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", id, MachineryCraft.instance, 64, 10, true);
        EntityRegistry.registerModEntity(EntityMCFishHook.class, "FishHoot", 2, MachineryCraft.instance, 80, 3, true);
    }
}
