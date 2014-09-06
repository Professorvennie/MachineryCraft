/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block.machines.brass;

import java.util.Random;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.block.machines.BlockBasicMachine;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.tileEntity.machines.brass.TileEntityBrassFurnace;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.professorvennie.core.lib.LibGuiIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBrassFurnace extends BlockBasicMachine {

	public BlockBrassFurnace(boolean isActive) {
		super(Names.Blocks.BRASS_FURNACE, isActive);
        setHardness(4.5F);
        setHarvestLevel("pickaxe", 2);
        setStepSound(Block.soundTypeMetal);
        guiId = LibGuiIds.BRASS_FURNACE;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityBrassFurnace();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iiconRegister) {
		this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBrass");
		this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "brassFurnace_Active" : "brassFurnace_Idle"));
	}

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(ModBlocks.brassFurnaceIdle);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.brassFurnaceIdle);
	}

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.secondTierMachines;
    }
}


