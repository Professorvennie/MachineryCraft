package com.professorvennie.machinerycraft.block.machines.brass;

import com.professorvennie.machinerycraft.block.machines.BlockBasicMachine;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.tileEntity.machines.brass.TileEntityBrassGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:11 PM.
 */
public class BlockBrassGenerator extends BlockBasicMachine {

    public BlockBrassGenerator() {
        super(Names.Blocks.BRASS_GENERATOR, false);
        guiId = LibGuiIds.BRASS_GEN;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBrassGenerator();
    }
}
