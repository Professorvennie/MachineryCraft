package com.professorvennie.machinerycraft.world.dimesion;

import com.professorvennie.machinerycraft.world.OreGen;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;

import java.util.Random;

/**
 * Created by ProfessorVennie on 9/3/2014 at 1:59 PM.
 */
public class ChunkProviderMiningWorld extends ChunkProviderGenerate implements IChunkProvider {

    private Random random = new Random();
    private World world;
    private int height = 100;

    public ChunkProviderMiningWorld(World world, long p_i2004_2_, boolean p_i2004_4_, String p_i2004_5_) {
        super(world, p_i2004_2_, p_i2004_4_);
        this.world = world;
    }

    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] blocks) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; (y <= 255) && (y >= 0); y++) {
                    int code = (x * 16 + z) * 256 + y;
                    if (y < height) {
                        blocks[code] = Blocks.stone;
                    } else {
                        blocks[code] = Blocks.air;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int chunkX, int chunkZ, Block[] blocks, byte[] p_147422_4_, BiomeGenBase[] biomes) {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, blocks, biomes);

        OreGen oreGen = new OreGen();
        oreGen.generate(random, chunkX, chunkZ, world, this, this);

        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = height; y >= 0; y--) {
                    int var17 = (z * 16 + x) * 256 + y;
                    if (y <= 0) {
                        blocks[var17] = Blocks.bedrock;
                    }
                }
            }
        }
    }
}
