package com.professorvennie.machinerycraft.core.block.machines.brass;

import com.professorvennie.machinerycraft.core.block.machines.BlockBasicMachine;
import com.professorvennie.machinerycraft.core.lib.LibGuiIds;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.tileEntity.machines.brass.TileEntityBrassGenerator;
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
