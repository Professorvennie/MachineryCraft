package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.TileEntityBasicSteamMachine;

/**
 * Created by ProfessorVennie on 10/6/2014 at 4:35 PM.
 */
public class TileEntityBronzeAlloy extends TileEntityBasicSteamMachine {

    public int cookTime;

    public TileEntityBronzeAlloy() {
        super(Names.Containers.BRONZE_ALLOY);
        setMachineSpeed(50);
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    @Override
    public void update() {
        super.update();
        if (!worldObj.isRemote) {

        }
    }
}
