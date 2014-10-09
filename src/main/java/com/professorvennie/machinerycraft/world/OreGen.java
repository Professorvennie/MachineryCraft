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

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.core.config.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.getDimensionId()) {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
            default:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateEnd(World world, Random random, int x, int z) {

    }

    private void generateSurface(World world, Random random, int x, int z) {
       // if (ConfigHandler.spawnCopper)
           // addOreSpawn(Block.getBlockFromItem(new ItemStack(ModBlocks.BlockOres, 1, 0).getItem()), 0, world, random, x, z, 16, 16, ConfigHandler.copperVienSize, ConfigHandler.copperRate, 15, 160);
        //if (ConfigHandler.spawnTin)
            //addOreSpawn(Block.getBlockFromItem(new ItemStack(ModBlocks.BlockOres, 1, 1).getItem()), 1, world, random, x, z, 16, 16, ConfigHandler.tinVienSize, ConfigHandler.tinRate, 15, 160);
       // if (ConfigHandler.spawnSilver)
           // addOreSpawn(Block.getBlockFromItem(new ItemStack(ModBlocks.BlockOres, 1, 2).getItem()), 2, world, random, x, z, 16, 16, ConfigHandler.silverVienSize, ConfigHandler.silverRate, 15, 160);
        //if (ConfigHandler.spawnLead)
            //addOreSpawn(Block.getBlockFromItem(new ItemStack(ModBlocks.BlockOres, 1, 3).getItem()), 3, world, random, x, z, 16, 16, ConfigHandler.leadVienSize, ConfigHandler.leadRate, 15, 160);
       // if (ConfigHandler.spawnZinc)
            //addOreSpawn(Block.getBlockFromItem(new ItemStack(ModBlocks.BlockOres, 1, 4).getItem()), 4, world, random, x, z, 16, 16, ConfigHandler.zincVienSize, ConfigHandler.zincRate, 15, 160);
    }

    private void generateNether(World world, Random random, int x, int z) {

    }

    /**
     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
     *
     * @param The Block to spawn
     * @param The World to spawn in
     * @param A   Random object for retrieving random positions within the world to spawn the Block
     * @param An  int for passing the X-Coordinate for the Generation method
     * @param An  int for passing the Z-Coordinate for the Generation method
     * @param An  int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
     * @param An  int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
     * @param An  int for setting the maximum size of a vein
     * @param An  int for the Number of chances available for the Block to spawn per-chunk
     * @param An  int for the minimum Y-Coordinate height at which this block may spawn
     * @param An  int for the maximum Y-Coordinate height at which this block may spawn
     */
    public void addOreSpawn(Block block, int meta, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {

        int maxPossY = minY + (maxY - 1);
        assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
        assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
        assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
        assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
        assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

        int diffBtwnMinMaxY = maxY - minY;
        for (int x = 0; x < chancesToSpawn; x++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block.getDefaultState(), meta)).generate(world, random, new BlockPos(posX, posY, posZ));
        }
    }

}


