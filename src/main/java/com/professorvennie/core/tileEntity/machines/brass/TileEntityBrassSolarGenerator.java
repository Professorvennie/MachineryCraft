package com.professorvennie.core.tileEntity.machines.brass;

import com.professorvennie.core.tileEntity.TileEntityMod;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Random;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:09 PM.
 */
public class TileEntityBrassSolarGenerator extends TileEntityMod{

    private int power, maxPower = 5000;

    @Override
    public void updateEntity() {
        super.updateEntity();

        if(!worldObj.isRemote){
            if(worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) && worldObj.isDaytime() && !worldObj.isRaining()){
                int time = (int)worldObj.getWorldTime() % 15;
                if(time == 0 && power + 1 < maxPower){
                    Random random = new Random();
                    switch (random.nextInt(4)){
                        case 0:{
                            power++;
                            break;
                        }

                        case 1:{
                            power +=2;
                            break;
                        }

                        case 2:{
                            power +=3;
                            break;
                        }

                        case 3:{
                            power +=4;
                            break;
                        }
                    }
                    //power += random.nextInt(4);
                    System.out.println(power);
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
    }

    public int getPower(){
        return power;
    }
}
