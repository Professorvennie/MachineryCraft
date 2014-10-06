package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.BlockBasicSteamMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 10/6/2014 at 4:34 PM.
 */
public class BlockBronzeAlloy extends BlockBasicSteamMachine {

    public BlockBronzeAlloy() {
        super(Names.Blocks.BRONZE_ALLOY, false);
        guiId = LibGuiIds.BRONZE_ALLOY;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeAlloy();
    }
}
