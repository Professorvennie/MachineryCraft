/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.world.biome;

import com.professorvennie.machinerycraft.core.config.ConfigHandler;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

/**
 * Created by ProfessorVennie on 8/16/2014 at 2:36 PM.
 */
public class ModBiomes {

    public static BiomeGenBase biomePlastic = new BiomePlastic(150).setBiomeName("plastic");

    public static void init() {
        if (ConfigHandler.spawnPlasticBiome) {
            BiomeDictionary.registerBiomeType(biomePlastic, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DRY);
            BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(biomePlastic, ConfigHandler.plasticBiomeWeight));
        }
    }
}
