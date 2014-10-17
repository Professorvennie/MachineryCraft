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

import com.professorvennie.lib.base.blocks.BlockBase;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BlockPlasticLog extends BlockRotatedPillar {

    public static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", BlockPlasticLog.EnumAxis.class);

    public BlockPlasticLog() {
        super(Material.wood);
        this.setHardness(1.5F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS_PROP, BlockPlasticLog.EnumAxis.Y));
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName(Names.Blocks.BLOCK_LOG);
        //this.setHarvestLevel("axe", 0);
        this.setStepSound(Block.soundTypeWood);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{AXIS_PROP});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        int axis = meta % 3;

        return this.getDefaultState().withProperty(AXIS_PROP, EnumAxis.values()[axis]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        /*switch (SwitchAxis.field_180167_a[((BlockPlasticLog.EnumAxis)state.getValue(AXIS_PROP)).ordinal()]){
            default:
                return 1;
        }*/
        return ((EnumAxis)state.getValue(AXIS_PROP)).ordinal();
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(AXIS_PROP, BlockPlasticLog.EnumAxis.func_176870_a(facing.getAxis()));
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
        byte b0 = 4;
        int i = b0 + 1;

        if (worldIn.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i)))
        {
            Iterator iterator = BlockPos.getAllInBox(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)).iterator();

            while (iterator.hasNext())
            {
                BlockPos blockpos1 = (BlockPos)iterator.next();
                IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

                if (iblockstate1.getBlock().getMaterial() == Material.leaves && !((Boolean)iblockstate1.getValue(BlockLeaves.field_176236_b)).booleanValue())
                {
                    worldIn.setBlockState(blockpos1, iblockstate1.withProperty(BlockLeaves.field_176236_b, Boolean.valueOf(true)), 4);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List blockList) {
        blockList.add(new ItemStack(item, 1, 0));
    }

    public static enum EnumAxis implements IStringSerializable{
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");
        private final String field_176874_e;

        private static final String __OBFID = "CL_00002100";

        private EnumAxis(String p_i45708_3_)
        {
            this.field_176874_e = p_i45708_3_;
        }

        public String toString()
        {
            return this.field_176874_e;
        }

        public static BlockPlasticLog.EnumAxis func_176870_a(EnumFacing.Axis p_176870_0_) {
            switch (BlockPlasticLog.SwitchAxis.field_180167_a[p_176870_0_.ordinal()]){
                case 1:
                    return X;
                case 2:
                    return Y;
                case 3:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String getName()
        {
            return this.field_176874_e;
        }
    }

    static final class SwitchAxis {
        static final int[] field_180167_a = new int[EnumFacing.Axis.values().length + 1];
        private static final String __OBFID = "CL_00002101";

        static{
            try{
                field_180167_a[EnumFacing.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3) {
                ;
            }

            try{
                field_180167_a[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2){
                ;
            }

            try {
                field_180167_a[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1) {
                ;
            }
        }
    }
}