/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.windmill;

import com.professorvennie.lib.base.blocks.BlockModContainer;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockWindmill extends BlockModContainer implements IBookable {

    public BlockWindmill() {
        super(Material.rock, Names.Blocks.WINDMILL);
        this.setHardness(3.0f);
        //this.setHarvestLevel("Pickaxe", 2);
        setStepSound(Block.soundTypeMetal);
    }

    @Override
    public boolean shouldRegisterInTab(int meta) {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess block, BlockPos pos) {
        float pixel = 1F / 16F;
        if (block.getBlockState(pos).getBlock().getMetaFromState(block.getBlockState(pos)) < 7)
            this.setBlockBounds(pixel * 4, 0, pixel * 4, 1 - pixel * 4, 1, 1 - pixel * 4);
        else this.setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityWindmill();
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if (world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).equals(ModBlocks.windmill)) world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
        if (world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).equals(ModBlocks.windmill)) world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitx, float hity, float hitz) {
        if (!world.isRemote) {
            player.openGui(MachineryCraft.instance, LibGuiIds.GUIID_WINDMILL, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    public Item getItemDropped(int par1, Random random, int par2) {
        return (ModItems.Itemwindmill);
    }

    public Item getItem(World world, int x, int y, int z) {
        return ModItems.Itemwindmill;
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
