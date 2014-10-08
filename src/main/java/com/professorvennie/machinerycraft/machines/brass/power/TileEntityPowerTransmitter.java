package com.professorvennie.machinerycraft.machines.brass.power;

import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProfessorVennie on 10/7/2014 at 4:32 PM.
 */
public class TileEntityPowerTransmitter extends TileEntityBasicMachine {

    public int range, power, maxPower = 10000;
    //private Map<Integer, TileEntityPowerReceiver> receiverMap = new HashMap<Integer, TileEntityPowerReceiver>();
    private List<TileEntityPowerReceiver> receivers = new ArrayList<TileEntityPowerReceiver>();

    public TileEntityPowerTransmitter() {
        super("");
        range = 10;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (!worldObj.isRemote) {
            for (int i = 0; i < range * 2 + 1; i++) {
                for (int j = 0; j < range * 2 + 1; j++) {
                    for (int k = 0; k < range * 2 + 1; k++) {
                        int x = xCoord + i - range;
                        int y = yCoord + j - range;
                        int z = zCoord + k - range;


                        if (worldObj.getTileEntity(x, y, z) instanceof TileEntityPowerReceiver)
                            receivers.add((TileEntityPowerReceiver) worldObj.getTileEntity(x, y, z));


                    }
                }
            }
            /*for(int i = 0; i < receiverMap.size(); i++){
                if(worldObj.getTileEntity(receiverMap.get(i).xCoord, receiverMap.get(i).yCoord, receiverMap.get(i).zCoord) == null)
                    System.out.println("removing");
                    //receiverMap.remove(i);
                if(receiverMap.get(i) != null){
                    if(receiverMap.get(i).isRequestingPower())
                        System.out.println("True");
                }
            }*/
            for (TileEntityPowerReceiver r : receivers) {
                if (worldObj.getTileEntity(r.xCoord, r.yCoord, r.zCoord) == null)
                    receivers.remove(r);
                if (r != null) {
                    if (r.isRequestingPower()) {
                        System.out.println(r.isRequestingPower());
                        if (power > 0) {
                            if (power >= 100 && r.canReceivePower(100)) {
                                r.addPower(100);
                                this.power -= 100;
                            }
                        }
                    }
                }
            }
        }
    }

    public void addPower(int power) {
        //if(this.power + power <= maxPower)
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getCapacity() {
        return maxPower;
    }
}
