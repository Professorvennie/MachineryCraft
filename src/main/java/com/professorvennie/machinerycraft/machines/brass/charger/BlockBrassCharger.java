package com.professorvennie.machinerycraft.machines.brass.charger;

import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/27/2014 at 5:19 PM.
 */
public class BlockBrassCharger extends BlockBasicMachine {

    public BlockBrassCharger() {
        super(Names.Blocks.BRASS_CHARGER, false);
        guiId = LibGuiIds.BRASS_CHARGER;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBrassCharger();
    }
}
