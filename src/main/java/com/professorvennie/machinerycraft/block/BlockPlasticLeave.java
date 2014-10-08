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
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockPlasticLeave extends BlockLeaves {

    public static final String[] textureNames = new String[]{Reference.MOD_ID + ":PlasticLeaf", Reference.MOD_ID + ":PlasticLeaf_Opaque"};
    public static final String[] trees = new String[]{"plastic"};

    public BlockPlasticLeave() {
        super();
        this.setHardness(0.1F);
        this.setTickRandomly(true);
        this.setLightOpacity(1);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(MachineryCraft.tabMachineryCraft);
        this.setUnlocalizedName(Names.Blocks.BLOCK_LEAVES);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public BlockPlanks.EnumType func_176233_b(int p_176233_1_) {
        return null;
    }

    public int quantityDropped(Random parRandom1) {
        return parRandom1.nextInt(40) == 0 ? 1 : 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.plasticSapling);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List listLeaves) {
        listLeaves.add(new ItemStack(item, 1, 0));
    }

    @Override
    protected void func_176234_a(World worldIn, BlockPos pos, IBlockState state, int p_17i6234_4_) {
        spawnAsEntity(worldIn, pos, new ItemStack(ModItems.itemPlasticApple, 1, 0));
    }
}
