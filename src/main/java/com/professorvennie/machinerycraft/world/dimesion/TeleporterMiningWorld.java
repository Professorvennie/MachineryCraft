/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.world.dimesion;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

/**
 * Created by ProfessorVennie on 9/3/2014 at 1:49 PM.
 */
public class TeleporterMiningWorld extends Teleporter {

    public TeleporterMiningWorld(WorldServer p_i1963_1_) {
        super(p_i1963_1_);
    }

    @Override
    public boolean makePortal(Entity p_85188_1_) {
        return false;
    }

    @Override
    public boolean placeInExistingPortal(Entity p_77184_1_, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_) {
        return false;
    }

    @Override
    public void placeInPortal(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_) {

    }
}
