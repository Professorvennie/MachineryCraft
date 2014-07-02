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
import com.professorvennie.core.block.tileEntity.TileEntityGoldOxideGrinder;
import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGoldoxideGrinder extends BlockBasicMachine{

	public BlockGoldoxideGrinder(boolean isActive) {
		super(BlockNames.goldOxideGrinder,isActive);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityGoldOxideGrinder();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iiconRegister) {
		this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "metal_5");
		this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "goldoxide_grinder_Active" : "goldoxide_grinder_idle"));
	}

	public Item getItemDropped(int par1, Random random, int par2) {
		return Item.getItemFromBlock(ModBlocks.goldOxideGrinderIdle);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.goldOxideGrinderIdle);
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitx, float hity, float hitz) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, MachineryCraft.instance, LibGuiIds.GUIID_GOLDOXIDE_GRINDER, world, x, y, z);
		}
		return true;
	}

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.thridTierMachines;
    }
}
