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
import com.professorvennie.machinerycraft.world.tree.WorldGenPlasticTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockPlasticSapling extends BlockSapling {

    public static final String[] typesSapling = new String[]{"PlasticSapling"};

    public BlockPlasticSapling() {
        super();
        this.stepSound = soundTypeGrass;
        this.setHardness(0.0F);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(MachineryCraft.tabMachineryCraft);
        this.setUnlocalizedName(Names.Blocks.BLOCK_SAPLING);
    }

    protected boolean canPlaceBlockOn(Block block) {
        return block == ModBlocks.plasticDirt || block == ModBlocks.plasticGrass || block == Blocks.dirt || block == Blocks.glass;
    }

    public int damageDropped(int par1) {
        return par1 & 3;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List listSaplings) {
        listSaplings.add(new ItemStack(item, 1, 0));
    }

    public void func_176478_d(World world, BlockPos pos, IBlockState p_176478_3_, Random random) {
        //if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
        Object object;
        int i1 = 0;
        int j1 = 0;

        object = new WorldGenPlasticTree(true, (1 + random.nextInt(3)) * 2, 0, 0, false);

        world.setBlockState(pos, Blocks.air.getDefaultState());

        if (!((WorldGenerator) object).generate(world, random, new BlockPos(pos.getX() + i1, pos.getY(), pos.getZ() + j1))) {
            world.setBlockState(pos, this.getDefaultState());
        }
    }
}
