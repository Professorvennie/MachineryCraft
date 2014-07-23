package com.professorvennie.core.block;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.tileEntity.TileEntityBronzeExtractor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBronzeExtractor extends BlockBasicMachine {

    public BlockBronzeExtractor() {
        super(Names.Blocks.BRONZE_EXTRACTOR, false);
        guiId = LibGuiIds.BRONZE_EXTRACTOR;
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeExtractor();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return super.getEntry(world, x, y, z, player, lexicon);
    }
}
