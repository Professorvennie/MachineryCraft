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
import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.professorvennie.core.block.tileEntity.TileEntityWasher;
import com.professorvennie.core.lib.LibGuiIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWasher extends BlockContainer implements ITileEntityProvider, IBookable {
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BlockWasher() {
        super(Material.iron);
        setBlockName(BlockNames.washer);
        setHardness(2.0F);
        setResistance(10.0F);
        this.setCreativeTab(MachineryCraft.tabMachineryCraft);
    }
    
    public int getRenderType(){
		return -1;
	}
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
        if (!world.isRemote) {
            if (!player.isSneaking()) {
                TileEntityWasher tile = (TileEntityWasher) world.getTileEntity(x, y, z);
                if (tile != null) {
                    if (tile.hasMaster()) {
                        if (tile.isMaster())
                            player.openGui(MachineryCraft.instance, LibGuiIds.GUIID_WASHER, world, x, y, z);
                        else
                            player.openGui(MachineryCraft.instance, LibGuiIds.GUIID_WASHER, world, tile.getMasterX(), tile.getMasterY(), tile.getMasterZ());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityWasher();
    }


    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
