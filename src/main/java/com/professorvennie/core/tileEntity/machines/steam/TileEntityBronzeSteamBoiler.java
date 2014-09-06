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

import com.professorvennie.api.steam.ISteamBoiler;
import com.professorvennie.api.steam.ISteamTank;
import com.professorvennie.core.block.machines.steam.BlockBronzeSteamBoiler;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.tileEntity.TileEntityBasicSidedInventory;
import com.professorvennie.core.tileEntity.TileEntityMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityBronzeSteamBoiler extends TileEntityBasicSidedInventory implements IFluidHandler, ISteamBoiler{

    public FluidTank[] tanks = new FluidTank[2];

    public int burnTime, currentItemBurnTime, temp = 0, maxTemp = 500;
    public static final int FUELSLOT = 4, WATERSLOT = 0, WATEREMPTYSLOT = 1, STEAMEMPTYSLOT = 2/*, STEAMSLOT = 3*/;

    public TileEntityBronzeSteamBoiler(){
        super(Names.Containers.BRONZE_STEAMBOILER);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        if(side == 6 || side == 1)
            return new int[]{4};
        if(side == 4 || side == 2 || side == 3 || side == 5)
            return new int[]{0};
//        if(side == 2 || side == 3)
//            return new int[]{2};
        if(side == 0)
            return new int[]{1, 3};
        return new int[]{};
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    public boolean isBurning(){
        return this.burnTime > 0;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        BlockBronzeSteamBoiler block = (BlockBronzeSteamBoiler) worldObj.getBlock(xCoord, yCoord, zCoord);
        if(burnTime > 0){
            burnTime--;
            block.isActive = true;
        }else {
            block.isActive = false;
        }

        TileEntity[] tiles = new TileEntity[6];
        tiles[0] = worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
        tiles[1] = worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
        tiles[2] = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
        tiles[3] = worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
        tiles[4] = worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
        tiles[5] = worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);

        if(!worldObj.isRemote){
            for (int i = 0; i < tiles.length; i++){
                if (tiles[i] != null){
                    if (tiles[i] instanceof ISteamTank){
                        int furnaceAmount = ((ISteamTank)tiles[i]).getSteamAmount();
                        int capactiy = ((ISteamTank)tiles[i]).getSteamCapacity();
                        if(furnaceAmount < capactiy){
                            if(tanks[0].getFluidAmount() >= 100){
                                tanks[0].getFluid().amount -= 100;
                                ((ISteamTank)tiles[i]).addSteamAmount(100);
                            }
                        }
                    }
                }
            }
        }

        if(!worldObj.isRemote){
            if(tanks[1].getFluidAmount() > tanks[1].getCapacity())
                tanks[1].getFluid().amount = tanks[1].getCapacity();

            if(tanks[0].getFluidAmount() > tanks[0].getCapacity())
                tanks[0].getFluid().amount = tanks[0].getCapacity();

            if(temp > maxTemp)
                temp = maxTemp;

            if(tanks[1].getFluid() != null){
                if(tanks[1].getFluidAmount() == 0 && temp >= 212){
                    worldObj.createExplosion(worldObj.getClosestPlayer((double) xCoord, (double) yCoord, (double) zCoord, -1), (double) xCoord, (double) yCoord, (double) zCoord, 4.0f,  true);
                }
            }else if(temp >= 212){
                worldObj.createExplosion(worldObj.getClosestPlayer((double) xCoord, (double) yCoord, (double) zCoord, -1), (double) xCoord, (double) yCoord, (double) zCoord, 4.0f,  true);
            }

            int time = (int)worldObj.getWorldTime() % 100;
            if(burnTime > 0){
                if(temp < maxTemp){
                    if(time == 0)
                        temp++;
                    //System.out.println(temp);
                }
            }else
                if(time == 0)
                    if(temp > 0)
                        temp--;

            if(tanks[1].getFluid() != null) {
                if (temp >= 212 && tanks[1].getFluid().amount > 0) {
                    if(tanks[0].getFluid() != null) {
                        if (tanks[0].getFluid().getFluid() != ModFuilds.fluidSteam) {
                            tanks[0].fill(new FluidStack(ModFuilds.fluidSteam, 100), true);
                            tanks[1].getFluid().amount -= 100;
                        } else {
                            tanks[0].getFluid().amount += 10;
                            tanks[1].getFluid().amount -= 10;
                        }
                    }else {
                        tanks[0].fill(new FluidStack(ModFuilds.fluidSteam, 100), true);
                        tanks[1].getFluid().amount -= 100;
                    }
                }
            }

            if(temp < maxTemp){
                if(burnTime == 0){
                    currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) / 2;
                    if(inventory[4] != null) {
                        if (isItemFuel(inventory[4])) {
                            inventory[4].stackSize--;
                            if (inventory[4].stackSize == 0)
                                inventory[4] = inventory[4].getItem().getContainerItem(inventory[4]);
                        }
                    }
                }
            }else if(temp == maxTemp){
                if(burnTime == 0){
                    currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) * 10;
                    if(inventory[4] != null) {
                        if (isItemFuel(inventory[4])) {
                            inventory[4].stackSize--;
                            if (inventory[4].stackSize == 0)
                                inventory[4] = inventory[4].getItem().getContainerItem(inventory[4]);
                        }
                    }
                }
            }

            if(inventory[0] != null) {
                if (inventory[0].getItem() == Items.water_bucket) {
                    int temp = tanks[1].getCapacity() - tanks[1].getFluidAmount();
                    if (inventory[1] == null) {
                        if(tanks[1].getFluidAmount() < tanks[1].getCapacity()) {
                            if(temp >= 1000)
                                setInventorySlotContents(1, new ItemStack(Items.bucket));
                        }
                        if(tanks[1].getFluid() == null) {
                            tanks[1].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        }else if(tanks[1].getFluidAmount() < tanks[1].getCapacity()){
                            if(tanks[1].getFluidAmount() < tanks[1].getCapacity()) {
                                if(temp >= 1000)
                                    tanks[1].getFluid().amount += 1000;
                            }
                        }

                        if(tanks[1].getFluidAmount() < tanks[1].getCapacity()) {
                            if(temp >= 1000) {
                                inventory[0].stackSize--;
                                if (inventory[0].stackSize == 0)
                                    inventory[0] = null;
                            }
                        }

                    } else if(inventory[1].getItem() == Items.bucket){
                        if(tanks[1].getFluidAmount() < tanks[1].getCapacity()) {
                            if(temp >= 1000) {
                                inventory[0].stackSize--;
                                if (inventory[0].stackSize == 0)
                                    inventory[0] = null;
                                inventory[1].stackSize++;
                            }
                        }

                        if(tanks[1].getFluid() == null) {
                            if(temp >= 1000)
                                tanks[1].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        }else if(tanks[1].getFluidAmount() < tanks[1].getCapacity()){
                            if(temp >= 1000)
                                tanks[1].getFluid().amount += 1000;
                        }
                    }

                }else if (inventory[0].getItem() == Items.bucket) {
                    if(inventory[1] == null){
                        if(tanks[1].getFluidAmount() >= 1000){
                            tanks[1].drain(1000, true);
                            inventory[0].stackSize--;
                            if(inventory[0].stackSize == 0)
                                inventory[0] = null;
                            setInventorySlotContents(1, new ItemStack(Items.water_bucket));
                        }
                    }
                }
            }

            if(inventory[2] != null) {
                 if (inventory[2].getItem() == Items.bucket) {
                    if(inventory[3] == null){
                        if(tanks[0].getFluidAmount() >= 1000){
                            tanks[0].drain(1000, true);
                            inventory[2].stackSize--;
                            if(inventory[2].stackSize == 0)
                                inventory[2] = null;
                            setInventorySlotContents(3, new ItemStack(ModItems.steamBucket));
                        }
                    }
                }
            }
        }
    }

    public static int getItemBurnTime(ItemStack itemstack){
        if (itemstack == null){
            return 0;
        }
        else{
            Item item = itemstack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab){
                    return 150;
                }
                if (block.getMaterial() == Material.wood){
                    return 300;
                }
                if (block == Blocks.coal_block){
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    public static boolean isItemFuel(ItemStack itemstack){
        return getItemBurnTime(itemstack) > 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if(from.equals(ForgeDirection.UP) || from.equals(ForgeDirection.DOWN))
            tanks[1].fill(resource, doFill);
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return drain(from, resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        if(from.equals(ForgeDirection.UP) || from.equals(ForgeDirection.DOWN))
            tanks[0].drain(maxDrain, doDrain);
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
        return new FluidTankInfo[]{tanks[0].getInfo(), tanks[1].getInfo()};
    }

    public int getBurnTimeReamingScaled(int i) {
        if(this.currentItemBurnTime == 0){
            this.currentItemBurnTime = 100;
        }

        return this.burnTime * i / this.currentItemBurnTime;
    }

    @Override
    public FluidTank getWaterTank() {
        return tanks[1];
    }

    @Override
    public int getWaterAmount() {
        return tanks[1].getFluidAmount();
    }

    @Override
    public int getWaterCapacity() {
        return tanks[1].getCapacity();
    }

    @Override
    public void setWaterAmount(int amount) {
        tanks[1].getFluid().amount += amount;
    }

    @Override
    public FluidTank getSteamTank() {
        return tanks[0];
    }

    @Override
    public int getSteamAmount() {
        return tanks[0].getFluidAmount();
    }

    @Override
    public int getSteamCapacity() {
        return tanks[0].getCapacity();
    }

    @Override
    public void addSteamAmount(int amount) {
        tanks[0].getFluid().amount += amount;
    }
}
