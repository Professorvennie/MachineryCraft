package com.professorvennie.machinerycraft.machines.basic.portablecobblegen;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.lib.BookData;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
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
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.basicMachines;
    }
}
