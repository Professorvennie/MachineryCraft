/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.world.biome;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.world.WorldGenFlowersWithMeta;
import com.professorvennie.core.world.tree.WorldGenPlasticTree;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomePlastic extends BiomeGenBase {

    public BiomePlastic(int id) {
        super(id);
        setDisableRain();
        for(int i = 0; i < Names.Blocks.BLOCK_PLASTIC_FLOWERS.length; i++){
            addFlower(ModBlocks.plasticFlower, i, 20);
        }
        topBlock = ModBlocks.plasticGrass;
        fillerBlock = ModBlocks.plasticDirt;
        theBiomeDecorator.treesPerChunk = 3;
        theBiomeDecorator.flowersPerChunk = 15;
        theBiomeDecorator.generateLakes = false;
    }

    @Override
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
        return 0xFFFFFF;
    }

    @Override
    public int getModdedBiomeGrassColor(int original) {
        return 0xFFFFFF;
    }

    public WorldGenAbstractTree func_150567_a(Random random){
        return new WorldGenPlasticTree(false);
    }

    @Override
    public void decorate(World world, Random random, int chunkX, int chunkZ) {
        super.decorate(world, random, chunkX, chunkZ);
        int x = chunkX + random.nextInt(16);
        int z = chunkZ + random.nextInt(16);
        int y = world.getHeightValue(chunkX, chunkZ);
        WorldGenFlowersWithMeta worldGenFlowers;
        for(int i = 0; i < Names.Blocks.BLOCK_PLASTIC_FLOWERS.length; i++) {
            worldGenFlowers = new WorldGenFlowersWithMeta(ModBlocks.plasticFlower, i);
            worldGenFlowers.generate(world, random, x, y, z);
        }

    }
}
