/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.block.machines.copper;

import java.util.Random;


import com.professorvennie.machinerycraft.core.block.machines.BlockBasicMachine;
import com.professorvennie.machinerycraft.core.block.ModBlocks;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.copper.TileEntityCopperGrinder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.tileentity.TileEntity;

import net.minecraft.world.World;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.core.lib.BookData;
import com.professorvennie.machinerycraft.core.lib.LibGuiIds;

public class BlockCopperGrinder extends BlockBasicMachine {

	public BlockCopperGrinder(boolean isActive) {
        super(Names.Blocks.COPPER_GRINDER, isActive);
        setHardness(3.5F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(Block.soundTypeMetal);
        guiId = LibGuiIds.COPPER_GRINDER;
    }

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(ModBlocks.copperGrinderIdle);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.copperGrinderIdle);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityCopperGrinder();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iiconRegister) {
        this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockCopper");
        this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "copperGrinder_Front_Active" : "copperGrinder_Front_Idle"));
    }

    public boolean hasComparatorInputOverride() {
        return true;
    }

	@Override
	public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
		return BookData.firstTierMachines;
	}
}
