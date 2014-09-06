/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.tileEntity.machines.steam;

import com.professorvennie.core.block.machines.steam.BlockBronzeFurnace;
import com.professorvennie.core.lib.Names;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityBronzeFurnace extends TileEntityBasicSteamMachine {

    public int cookTime = 0, furnaceSpeed = 110, fuelEfficiency = 1;
    public static final int INPUTSLOT = 2, WATERSLOT = 0;


    public TileEntityBronzeFurnace(){
        super(Names.Containers.BRONZE_FURNACE);
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        BlockBronzeFurnace block = (BlockBronzeFurnace)worldObj.getBlock(xCoord, yCoord, zCoord);
        if (cookTime > 0)
            block.isActive = true;
        else
            block.isActive = false;

        boolean flag1 = false;

        if(!worldObj.isRemote){
            if(!canSmelt())
                cookTime = 0;

            if(tank.getFluid() != null) {
                if (tank.getFluid().amount >= fuelEfficiency && canSmelt()) {
                    cookTime++;
                    if(cookTime > 0)
                            tank.getFluid().amount -= fuelEfficiency;

                    if (cookTime == furnaceSpeed) {
                        cookTime = 0;
                        smeltItem();
                        flag1 = true;
                    }
                }else
                    cookTime = 0;
            }
        }
        if(flag1) this.markDirty();
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound){
        super.readFromNBT(nbtTagCompound);

        this.tank.readFromNBT(nbtTagCompound);
        this.cookTime = (int)nbtTagCompound.getShort("cookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        this.tank.writeToNBT(nbtTagCompound);
        nbtTagCompound.setShort("cookTime", (short) this.cookTime);
    }

    public int getCookProgressScaled(int i){
        return cookTime * i / furnaceSpeed;
    }
}
