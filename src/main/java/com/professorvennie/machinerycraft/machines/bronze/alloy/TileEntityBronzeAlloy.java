package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.TileEntityBasicSteamMachine;
import net.minecraft.init.Items;

/**
 * Created by ProfessorVennie on 10/6/2014 at 4:35 PM.
 */
public class TileEntityBronzeAlloy extends TileEntityBasicSteamMachine {

    public final int maxTemp = 1000;
    public int cookTime;
    public MetalTank[] tank;
    public AlloyTank alloyTank;
    public int temp1, temp2;

    public TileEntityBronzeAlloy() {
        super(Names.Containers.BRONZE_ALLOY);
        tank = new MetalTank[2];
        tank[0] = new MetalTank(null, 4000);
        tank[1] = new MetalTank(null, 4000);
        alloyTank = new AlloyTank(null, null, null, 10000);
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
            if (inventory[0] != null) {
                if (inventory[0].getItem() == Items.gold_ingot) {
                    int time = (int) worldObj.getWorldTime() % 100;
                    if (time == 0) {
                        temp1++;
                        System.out.println(temp1);
                    }
                }
            }
        }
    }
}
