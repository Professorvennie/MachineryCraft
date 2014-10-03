/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.lib.BookData;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import com.professorvennie.machinerycraft.tileEntity.TileEntityGoldOxideFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockGoldoxideFurnace extends BlockBasicMachine {

    public BlockGoldoxideFurnace(boolean isActive) {
        super(Names.Blocks.GOLDOXIDE_FURNACE, isActive);
        setHardness(5.0F);
        setHarvestLevel("pickaxe", 3);
        setStepSound(Block.soundTypeMetal);
        guiId = LibGuiIds.GUIID_GOLDOXIDE_FURNACE;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityGoldOxideFurnace();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iiconRegister) {
        this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "metal_5");
        this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "goldoxide_furnace_Active" : "goldoxide_furnace_idle"));
    }

    public Item getItemDropped(int par1, Random random, int par2) {
        return Item.getItemFromBlock(ModBlocks.goldOxideFurnaceIdle);
    }

    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.goldOxideFurnaceIdle);
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.thridTierMachines;
    }
}
