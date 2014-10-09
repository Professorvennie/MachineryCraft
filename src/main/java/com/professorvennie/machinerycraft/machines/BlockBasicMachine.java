/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.tileEntity.TileEntityMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockBasicMachine extends BlockContainer implements IBookable {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static boolean keepInventory;
    public final Random rand = new Random();
    public boolean isActive;
    public int guiId = -1;


    public BlockBasicMachine(String name, boolean isActive) {
        super(Material.iron);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.isActive = isActive;
        if (isActive) {
            setLightLevel(0.9F);
            setUnlocalizedName(name + "Active");
        } else if (!isActive) {
            setCreativeTab(MachineryCraft.tabMachineryCraft);
            setUnlocalizedName(name + "Idle");
        }
    }

    private void func_176445_e(World worldIn, BlockPos p_176445_2_, IBlockState p_176445_3_)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(p_176445_2_.offsetNorth()).getBlock();
            Block block1 = worldIn.getBlockState(p_176445_2_.offsetSouth()).getBlock();
            Block block2 = worldIn.getBlockState(p_176445_2_.offsetWest()).getBlock();
            Block block3 = worldIn.getBlockState(p_176445_2_.offsetEast()).getBlock();
            EnumFacing enumfacing = (EnumFacing)p_176445_3_.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(p_176445_2_, p_176445_3_.withProperty(FACING, enumfacing), 2);
        }
    }

    public static void updateBlockState(boolean active, World world, BlockPos pos, Block blockActive, Block blockIdle) {
        IBlockState iblockstate = world.getBlockState(pos);
        TileEntity tileentity = world.getTileEntity(pos);
        keepInventory = true;

        if (active){
            world.setBlockState(pos, blockActive.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, blockActive.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else{
            world.setBlockState(pos, blockIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, blockIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepInventory = false;

        if (tileentity != null){
            tileentity.validate();
            world.setTileEntity(pos, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){
        this.func_176445_e(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote) {
            player.openGui(MachineryCraft.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.func_174811_aO().getOpposite());
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.func_174811_aO().getOpposite()), 2);

        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityMod)
                ((TileEntityMod)tileentity).setCustomName(stack.getDisplayName());
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (this.isActive) {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            float x1 = (float) pos.getX() + 0.5F;
            float y1 = (float) pos.getY() + random.nextFloat();
            float z1 = (float) pos.getZ() + 0.5F;


            float f = 0.52F;
            float f1 = random.nextFloat() * 0.6F - 0.3F;

            switch (SwitchEnumFacing.DIRECTIONS[enumfacing.ordinal()]){
                case 1:
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                    world.spawnParticle(EnumParticleTypes.FLAME, (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                    break;
                case 2:
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                    world.spawnParticle(EnumParticleTypes.FLAME, (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                    break;
                case 3:
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0.0D, 0.0D, 0.0D);
                    world.spawnParticle(EnumParticleTypes.FLAME, (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0.0D, 0.0D, 0.0D);
                    break;
                case 4:
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0.0D, 0.0D, 0.0D);
                    world.spawnParticle(EnumParticleTypes.FLAME, (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0.0D, 0.0D, 0.0D);
                    break;
            }
        }
    }

    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if (!keepInventory) {
            TileEntity tileEntity = world.getTileEntity(pos);

            if(tileEntity instanceof ISidedInventory)
            InventoryHelper.dropInventoryItems(world, pos, (ISidedInventory) tileEntity);
            world.updateComparatorOutputLevel(pos, this);
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack book) {
        return null;
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state){
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
            enumfacing = EnumFacing.NORTH;

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {FACING});
    }

    static final class SwitchEnumFacing{
        static final int[] DIRECTIONS = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00002111";

        static{
            try{
                DIRECTIONS[EnumFacing.WEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError ignored) {
                ;
            }

            try {
                DIRECTIONS[EnumFacing.EAST.ordinal()] = 2;
            }
            catch (NoSuchFieldError ignored) {
                ;
            }

            try{
                DIRECTIONS[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError ignored){
                ;
            }

            try{
                DIRECTIONS[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError ignored)
            {
                ;
            }
        }
    }
}
