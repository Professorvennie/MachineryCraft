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
import net.minecraft.world.biome.BiomeGenBase;

public class BiomePlastic extends BiomeGenBase {

    public BiomePlastic(int id) {
        super(id);
        setDisableRain();
        addFlower(ModBlocks.plasticFlower, 0, 4);
        topBlock = ModBlocks.plasticGrass;
        fillerBlock = ModBlocks.plasticDirt;
    }
}
