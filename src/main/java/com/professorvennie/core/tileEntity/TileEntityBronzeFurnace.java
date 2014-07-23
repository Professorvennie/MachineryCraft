package com.professorvennie.core.tileEntity;


import com.professorvennie.core.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityBronzeFurnace extends TileEntityMod implements ISidedInventory, IFluidHandler {

    public int cookTime = 0, furnaceSpeed = 65;

    private ItemStack[] inventory;

    public static FluidTank[] tanks;

    public TileEntityBronzeFurnace(){
        tanks = new FluidTank[1];
        for(int i = 0; i < tanks.length; i++){
            tanks[i] = new FluidTank(10000);
        }
        inventory = new ItemStack[4];
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int i) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemStack, int i2) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if(this.inventory[slot] != null){
            ItemStack itemstack;
            if(this.inventory[slot].stackSize <= amount){
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;
                return itemstack;
            }else{
                itemstack = this.inventory[slot].splitStack(amount);
                if(this.inventory[slot].stackSize == 0){
                    this.inventory[slot] = null;
                }
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if(!worldObj.isRemote){
            if(inventory[0] != null) {

                //todo change for steam bucket when i make that
                if (inventory[0].getItem() == Items.water_bucket) {
                    if (inventory[1] == null) {
                        if(tanks[0].getFluidAmount() < tanks[0].getCapacity())
                            setInventorySlotContents(1, new ItemStack(Items.bucket));
                        if(tanks[0].getFluid() == null) {
                            tanks[0].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        }else if(tanks[0].getFluidAmount() < tanks[0].getCapacity()){
                            if(tanks[0].getFluidAmount() < tanks[0].getCapacity())
                                tanks[0].getFluid().amount += 1000;
                        }
                        if(tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            inventory[0].stackSize--;
                            if (inventory[0].stackSize == 0)
                                inventory[0] = null;
                        }


                    } else {
                        if(tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            inventory[0].stackSize--;
                            if (inventory[0].stackSize == 0)
                                inventory[0] = null;
                            inventory[1].stackSize++;
                        }

                        if(tanks[0].getFluid() == null) {
                            tanks[0].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        }else if(tanks[0].getFluidAmount() < tanks[0].getCapacity()){
                            tanks[0].getFluid().amount += 1000;
                            System.out.println(tanks[0].getFluidAmount());
                        }
                    }
                }
            }
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if(this.inventory[slot] != null){
            ItemStack itemstack = this.inventory[slot];
            this.inventory[slot] = null;
            return itemstack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.inventory[slot]= itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()){
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.BRONZE_FURNACE;
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
    public boolean hasCustomInventoryName() {
        return hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if(from.equals(ForgeDirection.UP) || from.equals(ForgeDirection.DOWN) || from.equals(ForgeDirection.NORTH) || from.equals(ForgeDirection.SOUTH) || from.equals(ForgeDirection.WEST) || from.equals(ForgeDirection.EAST))
            tanks[0].fill(resource, doFill);
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return drain(from, resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[]{tanks[0].getInfo()};
    }

    public int getCookProgressScaled(int i){
        return cookTime * i / furnaceSpeed;
    }
}
