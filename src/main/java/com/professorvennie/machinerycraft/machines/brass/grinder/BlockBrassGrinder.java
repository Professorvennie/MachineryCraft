/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.brass.grinder;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.BookData;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBrassGrinder extends BlockBasicMachine {

    public BlockBrassGrinder(boolean isActive) {
        super(Names.Blocks.BRASS_GRINDER, isActive);
        setHardness(4.5F);
        //setHarvestLevel("pickaxe", 2);
        setStepSound(Block.soundTypeMetal);
        guiId = LibGuiIds.BRASS_GRINDER;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityBrassGrinder();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.brassGrinderIdle);
    }

    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.brassGrinderIdle);
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.secondTierMachines;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random) {

    }
}


