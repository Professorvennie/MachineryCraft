package com.professorvennie.core.world.biome;

import com.professorvennie.core.main.handlers.ConfigHandler;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

/**
 * Created by ProfessorVennie on 8/16/2014 at 2:36 PM.
 */
public class ModBiomes {

    public static BiomeGenBase biomePlastic = new BiomePlastic(150).setBiomeName("plastic");

    public static void init(){
        if(ConfigHandler.spawnPlasticBiome) {
            BiomeDictionary.registerBiomeType(biomePlastic, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DRY);
            BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(biomePlastic, ConfigHandler.plasticBiomeWeight));
        }
    }
}
