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

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.professorvennie.core.block.tileEntity.TileEntitySaltFurnace;
import com.professorvennie.core.lib.LibGuiIds;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSaltFurnace extends BlockBasicMachine{

	public BlockSaltFurnace(boolean isActive) {
		super(BlockNames.SaltFurnace, isActive);
	}

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(ModBlocks.SaltFurnaceIdle);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntitySaltFurnace();
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iiconRegister) {
        this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":" + "saltFurnace_side");
        this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "saltFurnace_front_on" : "saltFurnace_front_off"));
    }

    public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, MachineryCraft.instance, LibGuiIds.GUIID_SALTFURNACE, world, x, y, z);
        }
        return true;
    }

	public boolean hasComparatorInputOverride() {
		return true;
	}

	@Override
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.SaltFurnaceIdle);
	}

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.firstTierMachines;
    }
}
