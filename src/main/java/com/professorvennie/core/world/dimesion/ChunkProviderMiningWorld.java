package com.professorvennie.core.world.dimesion;

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

    public ChunkProviderMiningWorld(World p_i2004_1_, long p_i2004_2_, boolean p_i2004_4_, String p_i2004_5_) {
        super(p_i2004_1_, p_i2004_2_, p_i2004_4_);
    }

    public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] blocks)
    {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; (y <= 255) && (y >= 0); y++)
                {
                    int code = (x * 16 + z) * 256 + y;
                    if (y < 80) {
                        blocks[code] = Blocks.stone;
                    } else {
                        blocks[code] = Blocks.air;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int chunkX, int chunkZ, Block[] blocks, byte[] p_147422_4_, BiomeGenBase[] biomes)
    {
        ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, blocks, biomes);

        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        byte height = (byte)100;
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++)
            {
                BiomeGenBase biome = biomes[(z + x * 16)];
                Block grass = Blocks.grass;
                Block dirt = Blocks.dirt;
                for (int y = 100 + 3; y >= 0; y--)
                {
                    int var17 = (z * 16 + x) * 256 + y;
                    if (y <= 0) {
                        blocks[var17] = Blocks.bedrock;
                    } else if (blocks[var17] == Blocks.air) {
                        if ((y > height - 4) && (y < height - 1)) {
                            blocks[var17] = dirt;
                        } else if (y == height - 1) {
                            blocks[var17] = grass;
                        }
                    }
                }
            }
        }
    }
}
