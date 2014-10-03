package com.professorvennie.machinerycraft.machines.brass.generators.lava;

import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:13 PM.
 */
public class BlockBrassLavaGenerator extends BlockBasicMachine {

    public BlockBrassLavaGenerator() {
        super(Names.Blocks.BRASS_LAVA_GEN, false);
        guiId = LibGuiIds.BRASS_LAVA_GEN;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBrassLavaGenerator();
    }
}
