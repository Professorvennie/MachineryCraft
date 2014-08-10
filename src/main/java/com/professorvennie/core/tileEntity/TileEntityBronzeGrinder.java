package com.professorvennie.core.tileEntity;

import com.professorvennie.api.steam.ISteamTank;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.tileEntity.TileEntityMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

/**
 * Created by ProfessorVennie on 7/23/2014 at 11:23 AM at 11:23 AM.
 */
public class TileEntityBronzeGrinder extends TileEntityMod implements ISidedInventory, IFluidHandler, ISteamTank{

    public ItemStack[] inventory;
    public FluidTank tank;

    public int cookTime, grindSpeed = 110;

    public TileEntityBronzeGrinder(){
        inventory = new ItemStack[4];
        tank = new FluidTank(ModFuilds.fluidSteam, 0, 10000);
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
    public ItemStack decrStackSize(int i, int i2) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {

    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
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
        return false;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[0];
    }

    @Override
    public FluidTank getSteamTank() {
        return tank;
    }

    @Override
    public int getSteamAmount() {
        return tank.getFluidAmount();
    }

    @Override
    public int getSteamCapacity() {
        return tank.getCapacity();
    }

    @Override
    public void setSteamAmount(int amount) {
        tank.getFluid().amount += amount;
    }
}
