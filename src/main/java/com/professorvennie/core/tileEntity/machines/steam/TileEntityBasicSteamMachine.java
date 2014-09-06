package com.professorvennie.core.tileEntity.machines.steam;

import com.professorvennie.api.recipes.ExtractorRecipes;
import com.professorvennie.api.recipes.GrinderRecipes;
import com.professorvennie.api.steam.ISteamBoiler;
import com.professorvennie.api.steam.ISteamTank;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.tileEntity.TileEntityBasicSidedInventory;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

/**
 * Created by ProfessorVennie on 9/5/2014 at 6:50 PM.
 */
public class TileEntityBasicSteamMachine extends TileEntityBasicSidedInventory implements ISteamTank, IFluidHandler{

    public FluidTank tank;

    public TileEntityBasicSteamMachine(String name) {
        super(name);
        tank = new FluidTank(ModFuilds.fluidSteam, 0, 10000);
        slots_top = new int[]{2};
        slots_bottom = new int[]{3, 1};
        slots_sides = new int[]{0};
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        TileEntity[] tiles = new TileEntity[6];
        tiles[0] = worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
        tiles[1] = worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
        tiles[2] = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
        tiles[3] = worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
        tiles[4] = worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
        tiles[5] = worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);
        for(TileEntity tile : tiles) {
            if (!worldObj.isRemote) {
                if (tile != null) {
                    if (tile instanceof ISteamTank) {
                        if (tile instanceof ISteamBoiler) {

                        } else {
                            int tankAmount = ((ISteamTank) tile).getSteamAmount();
                            int tankCap = ((ISteamTank) tile).getSteamCapacity();
                            if (tankAmount < getSteamAmount()) {
                                if (tankAmount < tankCap) {
                                    ((ISteamTank) tile).addSteamAmount(5);
                                    addSteamAmount(-5);
                                }
                            }
                        }
                    }
                }
            }
        }

        if(!worldObj.isRemote){
            if (tank.getFluidAmount() > tank.getCapacity())
                tank.getFluid().amount = tank.getCapacity();

            if (inventory[0] != null) {
                if (inventory[0].getItem() == ModItems.steamBucket) {
                    int temp = tank.getCapacity() - tank.getFluidAmount();
                    if (inventory[1] == null) {
                        if (tank.getFluidAmount() < tank.getCapacity()) {
                            if (temp >= 1000)
                                setInventorySlotContents(1, new ItemStack(Items.bucket));
                        }
                        if (tank.getFluid() == null) {
                            if (inventory[1].stackSize < 16)
                                tank.fill(new FluidStack(ModFuilds.fluidSteam, 1000), true);
                        } else if (tank.getFluidAmount() < tank.getCapacity()) {
                            if (tank.getFluidAmount() < tank.getCapacity()) {
                                if (inventory[1].stackSize < 16) {
                                    if (temp >= 1000)
                                        tank.getFluid().amount += 1000;
                                }
                            }
                        }

                        if (tank.getFluidAmount() < tank.getCapacity()) {
                            if (temp >= 1000) {
                                if (inventory[1].stackSize < 16) {
                                    inventory[0].stackSize--;
                                    if (inventory[0].stackSize == 0)
                                        inventory[0] = null;
                                }
                            }
                        }

                    } else if (inventory[1].getItem() == Items.bucket) {
                        if (tank.getFluidAmount() < tank.getCapacity()) {
                            if (temp >= 1000) {
                                if (inventory[1].stackSize < 16) {
                                    inventory[0].stackSize--;
                                    if (inventory[0].stackSize == 0)
                                        inventory[0] = null;
                                    inventory[1].stackSize++;
                                }
                            }
                        }

                        if (tank.getFluid() == null) {
                            if (inventory[1].stackSize < 16) {
                                if (temp >= 1000)
                                    tank.fill(new FluidStack(ModFuilds.fluidSteam, 1000), true);
                            }
                        } else if (tank.getFluidAmount() < tank.getCapacity()) {
                            if (inventory[1].stackSize < 16) {
                                if (temp >= 1000)
                                    tank.getFluid().amount += 1000;
                            }
                        }
                    }

                } else if (inventory[0].getItem() == Items.bucket) {
                    if (inventory[1] == null) {
                        if (tank.getFluidAmount() >= 1000) {
                            tank.drain(1000, true);
                            inventory[0].stackSize--;
                            if (inventory[0].stackSize == 0)
                                inventory[0] = null;
                            setInventorySlotContents(1, new ItemStack(ModItems.steamBucket));
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int i2) {
        if(slot == 3 || slot == 1)
            return true;
        return false;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if(from.equals(ForgeDirection.UP) || from.equals(ForgeDirection.DOWN) || from.equals(ForgeDirection.NORTH) || from.equals(ForgeDirection.SOUTH) || from.equals(ForgeDirection.WEST) || from.equals(ForgeDirection.EAST))
            tank.fill(resource, doFill);
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
        return new FluidTankInfo[]{tank.getInfo()};
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
    public void addSteamAmount(int amount) {
        tank.getFluid().amount += amount;
    }

    protected boolean canGrind() {
        if(this.inventory[2] == null){
            return false;
        }else{
            ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.inventory[2]);

            if (itemstack == null)
                return false;
            if (this.inventory[3] == null)
                return true;
            if (!this.inventory[3].isItemEqual(itemstack))
                return false;

            int result = this.inventory[3].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    protected void grindItem() {
        if (this.canGrind()) {
            ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.inventory[2]);

            if (this.inventory[3] == null) {
                this.inventory[3] = itemstack.copy();
            } else if (this.inventory[3].isItemEqual(itemstack)) {
                this.inventory[3].stackSize += itemstack.stackSize;
            }

            this.inventory[2].stackSize--;

            if (this.inventory[2].stackSize <= 0) {
                this.inventory[2] = null;
            }
        }
    }

    protected boolean canSmelt(){
        if(this.inventory[2] == null){
            return false;
        }else{
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[2]);

            if(itemstack == null) return false;
            if(this.inventory[3] == null) return true;
            if(!this.inventory[3].isItemEqual(itemstack)) return false;

            int result = this.inventory[3].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    protected void smeltItem(){
        if(this.canSmelt()){
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.inventory[2]);

            if(this.inventory[3] == null){
                this.inventory[3] = itemstack.copy();
            }else if(this.inventory[3].isItemEqual(itemstack)){
                this.inventory[3].stackSize += itemstack.stackSize;
            }

            this.inventory[2].stackSize--;

            if(this.inventory[2].stackSize <= 0){
                this.inventory[2] = null;
            }
        }
    }

    protected boolean canExtract(){
        if(this.inventory[2] == null){
            return false;
        }else{
            ItemStack itemstack = ExtractorRecipes.extractoring().getExtractoringResult(this.inventory[2]);

            if(itemstack == null) return false;
            if(this.inventory[3] == null) return true;
            if(!this.inventory[3].isItemEqual(itemstack)) return false;

            int result = this.inventory[3].stackSize + itemstack.stackSize;

            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    protected void extractItem(){
        if(this.canSmelt()){
            ItemStack itemstack = ExtractorRecipes.extractoring().getExtractoringResult(this.inventory[2]);

            if(this.inventory[3] == null){
                this.inventory[3] = itemstack.copy();
            }else if(this.inventory[3].isItemEqual(itemstack)){
                this.inventory[3].stackSize += itemstack.stackSize;
            }

            this.inventory[2].stackSize--;

            if(this.inventory[2].stackSize <= 0){
                this.inventory[2] = null;
            }
        }
    }
}
