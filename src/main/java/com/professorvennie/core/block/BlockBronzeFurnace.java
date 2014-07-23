package com.professorvennie.core.block;


import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.tileEntity.TileEntityBronzeFurnace;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBronzeFurnace extends BlockBasicMachine {

    public BlockBronzeFurnace(boolean isActive) {
        super(Names.Blocks.BRONZE_FURNACE, isActive);
        guiId = LibGuiIds.BRONZE_FURNACE;
    }

    @Override
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemFromBlock(ModBlocks.bronzeFurnaceIdle);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.bronzeFurnaceIdle);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeFurnace();
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBronze");
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "bronzeFurnace_Front_Active" : "bronzeFurnace_Front_Idle"));
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return super.getEntry(world, x, y, z, player, lexicon);
    }
}
