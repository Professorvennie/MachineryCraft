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
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockWindmill extends BlockModContainer implements IBookable {

    public BlockWindmill() {
        super(Material.rock, Names.Blocks.WINDMILL);
        this.setHardness(3.0f);
        this.setHarvestLevel("Pickaxe", 2);
        setBlockTextureName(Reference.MOD_ID + ":windmillground");
        setStepSound(Block.soundTypeMetal);
    }

    @Override
    public boolean shouldRegisterInTab(int meta) {
        return false;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
        float pixel = 1F / 16F;
        if (block.getBlockMetadata(x, y, z) < 7)
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

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        if (world.getBlock(x, y + 1, z).equals(ModBlocks.windmill)) world.setBlockToAir(x, y + 1, z);
        if (world.getBlock(x, y - 1, z).equals(ModBlocks.windmill)) world.setBlockToAir(x, y - 1, z);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, MachineryCraft.instance, LibGuiIds.GUIID_WINDMILL, world, x, y, z);
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
