/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockPlasticGrass extends BlockGrass {

    public BlockPlasticGrass() {
        super();
        setTickRandomly(true);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName(Names.Blocks.BLOCK_PLASTIC_GRASS);
        setStepSound(Block.soundTypeGravel);
        //setHarvestLevel("shovel", 0);
        setHardness(1.0f);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModBlocks.plasticDirt.getItemDropped(state, rand, fortune);
    }

    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            if (world.getLight(new BlockPos(x, y + 1, z)) < 4 && world.getLight(new BlockPos(x, y + 1, z)) > 2) {
                world.setBlockState(pos, ModBlocks.plasticDirt.getDefaultState());
            } else if (world.getLight(new BlockPos(x, y + 1, z)) >= 9) {
                for (int l = 0; l < 4; ++l) {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlockState(new BlockPos(i1, j1 + 1, k1)).getBlock();

                    if (world.getBlockState(new BlockPos(i1, j1, k1)).getBlock() == ModBlocks.plasticDirt && world.getLight(new BlockPos(i1, j1 + 1, k1)) >= 4 && world.getLight(new BlockPos(i1, j1 + 1, k1)) <= 2) {
                        world.setBlockState(new BlockPos(i1, j1, k1), ModBlocks.plasticGrass.getDefaultState());
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state) {
        return 16777215;
    }

    @Override
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
        return 16777215;
    }
}
