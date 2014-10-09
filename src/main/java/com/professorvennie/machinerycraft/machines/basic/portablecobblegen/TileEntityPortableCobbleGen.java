package com.professorvennie.machinerycraft.machines.basic.portablecobblegen;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public class TileEntityPortableCobbleGen extends TileEntityBasicMachine {

    public int cookTime = 0, cookSpeed = 100;

    public TileEntityPortableCobbleGen() {
        super(Names.Containers.CONTAINER_PORTABLE_COBBLEGEN);
        slots_bottom = new int[]{2};
    }

    @Override
    public void update() {
        super.update();
        if (!worldObj.isRemote) {
            if (inventory[0] != null && inventory[1] != null && canWork) {
                if (inventory[0].getItem() == Items.lava_bucket && inventory[1].getItem() == Items.water_bucket) {
                    cookTime++;
                    if (cookTime == cookSpeed) {
                        cookTime = 0;
                        if (inventory[2] == null)
                            setInventorySlotContents(2, new ItemStack(Blocks.cobblestone));
                        else if (inventory[2].stackSize < getInventoryStackLimit())
                            inventory[2].stackSize++;
                        else inventory[2].stackSize = getInventoryStackLimit();
                    }
                }
            } else
                cookTime = 0;
        }
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        cookTime = nbt.getInteger("cookTime");
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setInteger("cookTime", cookTime);
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack itemStack, EnumFacing direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int slotId, ItemStack itemStack, EnumFacing direction) {
        return itemStack.getItem() == Item.getItemFromBlock(Blocks.cobblestone);
    }

    @Override
    public int getSizeInventory() {
        return 3;
    }

    public int getCookProgressScaled(int i) {
        return this.cookTime * i / this.cookSpeed;
    }

    @Override
    public int getField(int id) {
        super.getField(id);
        if(id == 1)
            return cookTime;
        return 0;
    }

    @Override
    public int getFieldCount() {
        return super.getFieldCount() + 1;
    }

    @Override
    public void setField(int id, int value) {
        super.setField(id, value);
        if(id == 1)
            cookTime = value;
    }
}
