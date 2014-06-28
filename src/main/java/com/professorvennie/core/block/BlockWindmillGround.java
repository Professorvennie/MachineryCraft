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

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.api.book.IBookable;
import com.professorvennie.core.block.tileEntity.TileEntitywindmillground;
import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWindmillGround extends BlockContainer implements IBookable{

	protected BlockWindmillGround(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setBlockBounds(0, 0, 0, 1, (1F / 16f) * 14, 1);
		setBlockName(BlockNames.windmillground);
		setCreativeTab(MainRegistry.tabMachineryCraft);
		setBlockTextureName(Reference.MOD_ID + ":windmillground");
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block neighborblock) {
		updateMultiBlockStructure(world, x, y, z);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		updateMultiBlockStructure(world, x, y, z);
	}

	public void updateMultiBlockStructure(World world, int x, int y, int z) {
		isMultiBlockSturcture(world, x, y, z);
	}

	public boolean isMultiBlockSturcture(World world, int x1, int y1, int z1) {
		boolean mStructure = false;
		boolean currentCheckStrucre = true;

		for (int x2 = 0; x2 < 3; x2++) {
			for (int z2 = 0; z2 < 3; z2++) {
				if (!mStructure) {
					currentCheckStrucre = true;

					for (int x3 = 0; x3 < 3; x3++) {
						for (int z3 = 0; z3 < 3; z3++) {
							if (currentCheckStrucre
									&& !world.getBlock(x1 + x2 - x3, y1,
											z1 + z2 - z3).equals(
											ModBlocks.windmillground)) {
								currentCheckStrucre = false;
							}
						}
					}
					if (currentCheckStrucre) {
						for (int x3 = 0; x3 < 3; x3++) {
							for (int z3 = 0; z3 < 3; z3++) {
								world.setBlockMetadataWithNotify(x1 + x2 - x3,
										y1, z1 + z2 - z3, x3 * 3 + z3 + 1, 2);
							}
						}
					}
				}
				mStructure = currentCheckStrucre;
			}
		}
		if (mStructure)
			return true;

		if (world.getBlockMetadata(x1, y1, z1) > 0)
			world.setBlockMetadataWithNotify(x1, y1, z1, 0, 3);

		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitywindmillground();
	}

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
