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

import com.professorvennie.machinerycraft.block.BlockPlasticFlower;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by ProfessorVennie on 9/1/2014 at 4:08 PM.
 */
public class WorldGenFlowersWithMeta extends WorldGenerator {

    private BlockPlasticFlower block;
    private IBlockState state;

    public WorldGenFlowersWithMeta(BlockPlasticFlower block, BlockPlasticFlower.EnumFlowers flowers) {
        this.block = block;
        this.state = block.getDefaultState().withProperty(block.func_176494_l(), flowers);
    }

    @Override
    public boolean generate(World world, Random random, BlockPos pos) {
        for (int l = 0; l < 64; ++l) {
            int i1 = pos.getX() + random.nextInt(16) - random.nextInt(16);
            int j1 = pos.getY() + random.nextInt(8) - random.nextInt(8);
            int k1 = pos.getZ() + random.nextInt(16) - random.nextInt(16);

            if (world.isAirBlock(new BlockPos(i1, j1, k1)) && (!world.provider.getHasNoSky() || j1 < 255) && this.block.canBlockStay(world, new BlockPos(i1, j1, k1), state)) {
                world.setBlockState(new BlockPos(i1, j1, k1), this.state, 2);
            }
        }

        return true;
    }
}
