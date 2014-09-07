package com.professorvennie.machinerycraft.tileEntity.machines.brass;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.tileEntity.TileEntityBasicSidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:14 PM.
 */
public class TileEntityBrassLavaGenerator extends TileEntityBasicSidedInventory {

    public TileEntityBrassLavaGenerator() {
        super(Names.Containers.CONTAINER_BRASS_LAVA_GEN);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return false;
    }
}
