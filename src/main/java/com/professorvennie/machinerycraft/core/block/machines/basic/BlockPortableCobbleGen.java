package com.professorvennie.machinerycraft.core.block.machines.basic;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.core.block.machines.BlockBasicMachine;
import com.professorvennie.machinerycraft.core.lib.LibGuiIds;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.tileEntity.machines.basic.TileEntityPortableCobbleGen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPortableCobbleGen extends BlockBasicMachine {

    public BlockPortableCobbleGen() {
        super(Names.Blocks.BLOCK_PORTABLE_COBBLEGEN, false);
        guiId = LibGuiIds.GUIID_PORTABLE_COBBLEGEN;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityPortableCobbleGen();
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        //todo
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        //todo
        return super.getEntry(world, x, y, z, player, lexicon);
    }
}
