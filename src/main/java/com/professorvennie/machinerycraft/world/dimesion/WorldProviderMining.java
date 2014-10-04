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

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * Created by ProfessorVennie on 9/3/2014 at 1:52 PM.
 */
public class WorldProviderMining extends WorldProvider {

    public WorldProviderMining() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desert, 0);
        dimensionId = 12;
    }

    @Override
    public String getDimensionName() {
        return "Mining World";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderMiningWorld(worldObj, worldObj.getSeed(), true, "");
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome To The Mining World.";
    }
}
