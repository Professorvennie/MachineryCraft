/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block;

import java.util.Random;


import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import net.minecraft.world.World;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.tileEntity.TileEntitySaltGrinder;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.LibGuiIds;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class BlockSaltGrinder extends BlockBasicMachine{

	public BlockSaltGrinder(boolean isActive) {
        super(Names.Blocks.SALT_GRINDER, isActive);
        setHardness(3.5F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(Block.soundTypeMetal);
        guiId = LibGuiIds.GUIID_SALTGRINDER;
    }

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(ModBlocks.SaltGrinderIdle);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.SaltGrinderIdle);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {

		return new TileEntitySaltGrinder();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iiconRegister) {
        this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":" + "saltGrinder_side");
        this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "saltGrinder_front_on" : "saltGrinder_front_off"));
    }

    public boolean hasComparatorInputOverride() {
        return true;
    }

	@Override
	public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
		return BookData.firstTierMachines;
	}
}
