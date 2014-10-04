/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.world;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by ProfessorVennie on 9/1/2014 at 4:08 PM.
 */
public class WorldGenFlowersWithMeta extends WorldGenerator {

    private Block block;
    private int metaData;

    public WorldGenFlowersWithMeta(Block block, int meta) {
        this.block = block;
        this.metaData = meta;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        for (int l = 0; l < 64; ++l) {
            int i1 = x + random.nextInt(16) - random.nextInt(16);
            int j1 = y + random.nextInt(8) - random.nextInt(8);
            int k1 = z + random.nextInt(16) - random.nextInt(16);

            if (world.isAirBlock(i1, j1, k1) && (!world.provider.hasNoSky || j1 < 255) && this.block.canBlockStay(world, i1, j1, k1)) {
                world.setBlock(i1, j1, k1, this.block, this.metaData, 2);
            }
        }

        return true;
    }
}
