package com.professorvennie.core.block;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.tileEntity.TileEntityBronzeGrinder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBronzeGrinder extends BlockBasicMachine {

    public BlockBronzeGrinder(boolean isActive) {
        super(Names.Blocks.BRONZE_GRINDER, isActive);
        guiId = LibGuiIds.BRONZE_GRINDER;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBronze");
        iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeMachines_Top");
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "bronzeGrinder_Front_Active" : "bronzeGrinder_Front_Idle"));
    }

    @Override
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.bronzeGrinderIdle);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if(side == 1)
            return iconTop;
        else if(side == metadata)
            return iconFront;
        else if(metadata  == 0 && side == 3)
            return iconFront;
        else
            return blockIcon;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.bronzeGrinderIdle);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeGrinder();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return super.getEntry(world, x, y, z, player, lexicon);
    }
}
