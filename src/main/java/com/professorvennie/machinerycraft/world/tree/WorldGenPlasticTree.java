/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.world.tree;

import com.professorvennie.machinerycraft.block.BlockPlasticSapling;
import com.professorvennie.machinerycraft.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;


public class WorldGenPlasticTree extends WorldGenAbstractTree {

    private static Random rand = new Random();
    /**
     * The minimum height of a generated tree.
     */
    private final int minTreeHeight;
    /**
     * True if this tree should grow Vines.
     */
    private final boolean vinesGrow;
    /**
     * The metadata value of the wood to use in tree generation.
     */
    private final int metaWood;
    /**
     * The metadata value of the leaves to use in tree generation.
     */
    private final int metaLeaves;

    public WorldGenPlasticTree(boolean par1) {
        this(par1, (2 + rand.nextInt(4)) * 2, 0, 0, false);
    }

    /**
     * Constructor
     *
     * @param par1: boolean
     * @param par2: minTreeHeight
     * @param par3: metaWood
     * @param par4: metaLeaves
     * @param par5: vinesGrow
     */
    public WorldGenPlasticTree(boolean par1, int par2, int par3, int par4, boolean par5) {
        super(par1);
        this.minTreeHeight = par2;
        this.metaWood = par3;
        this.metaLeaves = par4;
        this.vinesGrow = par5;
    }

    public boolean generate(World worldIn, Random random, BlockPos pos)
    {
        int i = random.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (pos.getY() >= 1 && pos.getY() + i + 1 <= 256)
        {
            byte b0;
            int l;

            for (int j = pos.getY(); j <= pos.getY() + 1 + i; ++j)
            {
                b0 = 1;

                if (j == pos.getY())
                {
                    b0 = 0;
                }

                if (j >= pos.getY() + 1 + i - 2)
                {
                    b0 = 2;
                }

                for (int k = pos.getX() - b0; k <= pos.getX() + b0 && flag; ++k)
                {
                    for (l = pos.getZ() - b0; l <= pos.getZ() + b0 && flag; ++l)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.func_150523_a(worldIn.getBlockState(new BlockPos(k, j, l)).getBlock()))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block1 = worldIn.getBlockState(pos.offsetDown()).getBlock();

                if ((block1 == Blocks.grass || block1 == Blocks.dirt || block1 == ModBlocks.plasticDirt || block1 == ModBlocks.plasticGrass) && pos.getY() < 256 - i - 1)
                {
                    this.func_175921_a(worldIn, pos.offsetDown());
                    b0 = 3;
                    byte b1 = 0;
                    int i1;
                    int j1;
                    int k1;
                    int l1;
                    BlockPos blockpos1;

                    for (l = pos.getY() - b0 + i; l <= pos.getY() + i; ++l)
                    {
                        i1 = l - (pos.getY() + i);
                        j1 = b1 + 1 - i1 / 2;

                        for (k1 = pos.getX() - j1; k1 <= pos.getX() + j1; ++k1)
                        {
                            l1 = k1 - pos.getX();

                            for (int i2 = pos.getZ() - j1; i2 <= pos.getZ() + j1; ++i2)
                            {
                                int j2 = i2 - pos.getZ();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || random.nextInt(2) != 0 && i1 != 0)
                                {
                                    blockpos1 = new BlockPos(k1, l, i2);
                                    Block block = worldIn.getBlockState(blockpos1).getBlock();

                                    if (block.getMaterial() == Material.air || block.getMaterial() == Material.leaves || block.getMaterial() == Material.vine)
                                    {
                                        this.func_175905_a(worldIn, blockpos1, ModBlocks.plasticLeaf, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (l = 0; l < i; ++l)
                    {
                        Block block2 = worldIn.getBlockState(pos.offsetUp(l)).getBlock();

                        if (block2.getMaterial() == Material.air || block2.getMaterial() == Material.leaves || block2.getMaterial() == Material.vine)
                        {
                            this.func_175905_a(worldIn, pos.offsetUp(l), ModBlocks.plasticLog, this.metaWood);

                            if (this.vinesGrow && l > 0)
                            {
                                if (random.nextInt(3) > 0 && worldIn.isAirBlock(pos.add(-1, l, 0)))
                                {
                                    this.func_175905_a(worldIn, pos.add(-1, l, 0), Blocks.vine, BlockVine.field_176275_S);
                                }

                                if (random.nextInt(3) > 0 && worldIn.isAirBlock(pos.add(1, l, 0)))
                                {
                                    this.func_175905_a(worldIn, pos.add(1, l, 0), Blocks.vine, BlockVine.field_176271_T);
                                }

                                if (random.nextInt(3) > 0 && worldIn.isAirBlock(pos.add(0, l, -1)))
                                {
                                    this.func_175905_a(worldIn, pos.add(0, l, -1), Blocks.vine, BlockVine.field_176272_Q);
                                }

                                if (random.nextInt(3) > 0 && worldIn.isAirBlock(pos.add(0, l, 1)))
                                {
                                    this.func_175905_a(worldIn, pos.add(0, l, 1), Blocks.vine, BlockVine.field_176276_R);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (l = pos.getY() - 3 + i; l <= pos.getY() + i; ++l)
                        {
                            i1 = l - (pos.getY() + i);
                            j1 = 2 - i1 / 2;

                            for (k1 = pos.getX() - j1; k1 <= pos.getX() + j1; ++k1)
                            {
                                for (l1 = pos.getZ() - j1; l1 <= pos.getZ() + j1; ++l1)
                                {
                                    BlockPos blockpos3 = new BlockPos(k1, l, l1);

                                    if (worldIn.getBlockState(blockpos3).getBlock().getMaterial() == Material.leaves)
                                    {
                                        BlockPos blockpos4 = blockpos3.offsetWest();
                                        blockpos1 = blockpos3.offsetEast();
                                        BlockPos blockpos5 = blockpos3.offsetNorth();
                                        BlockPos blockpos2 = blockpos3.offsetSouth();

                                        if (random.nextInt(4) == 0 && worldIn.getBlockState(blockpos4).getBlock().getMaterial() == Material.air)
                                        {
                                            this.func_175923_a(worldIn, blockpos4, BlockVine.field_176275_S);
                                        }

                                        if (random.nextInt(4) == 0 && worldIn.getBlockState(blockpos1).getBlock().getMaterial() == Material.air)
                                        {
                                            this.func_175923_a(worldIn, blockpos1, BlockVine.field_176271_T);
                                        }

                                        if (random.nextInt(4) == 0 && worldIn.getBlockState(blockpos5).getBlock().getMaterial() == Material.air)
                                        {
                                            this.func_175923_a(worldIn, blockpos5, BlockVine.field_176272_Q);
                                        }

                                        if (random.nextInt(4) == 0 && worldIn.getBlockState(blockpos2).getBlock().getMaterial() == Material.air)
                                        {
                                            this.func_175923_a(worldIn, blockpos2, BlockVine.field_176276_R);
                                        }
                                    }
                                }
                            }
                        }

                        if (random.nextInt(5) == 0 && i > 5)
                        {
                            for (l = 0; l < 2; ++l)
                            {
                                for (i1 = 0; i1 < 4; ++i1)
                                {
                                    if (random.nextInt(4 - l) == 0)
                                    {
                                        j1 = random.nextInt(3);
                                        EnumFacing enumfacing = EnumFacing.getHorizontal(i1).getOpposite();
                                        this.func_175905_a(worldIn, pos.add(enumfacing.getFrontOffsetX(), i - 5 + l, enumfacing.getFrontOffsetZ()), Blocks.cocoa, j1 << 2 | EnumFacing.getHorizontal(i1).getHorizontalIndex());
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void func_175923_a(World worldIn, BlockPos p_175923_2_, int p_175923_3_)
    {
        this.func_175905_a(worldIn, p_175923_2_, Blocks.vine, p_175923_3_);
        int j = 4;

        for (p_175923_2_ = p_175923_2_.offsetDown(); worldIn.getBlockState(p_175923_2_).getBlock().getMaterial() == Material.air && j > 0; --j)
        {
            this.func_175905_a(worldIn, p_175923_2_, Blocks.vine, p_175923_3_);
            p_175923_2_ = p_175923_2_.offsetDown();
        }
    }
}
