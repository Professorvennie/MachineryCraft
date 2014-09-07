package com.professorvennie.machinerycraft.world.dimesion;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * Created by ProfessorVennie on 9/3/2014 at 1:52 PM.
 */
public class WorldProviderMining extends WorldProvider {

    public WorldProviderMining(){
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
