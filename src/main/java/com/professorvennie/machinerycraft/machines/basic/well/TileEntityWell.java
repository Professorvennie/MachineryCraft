package com.professorvennie.machinerycraft.machines.basic.well;

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;

/**
 * Created by ProfessorVennie on 9/14/2014 at 5:08 PM.
 */
public class TileEntityWell extends TileEntityBasicMachine /*implements IFluidHandler*/ {

    //public FluidTank tank;
    private int bottom, amountOfPipes = 0;

    public TileEntityWell() {
        super(Names.Containers.WELL);
        //tank = new FluidTank(FluidRegistry.WATER, 0, 10000);
        slots_sides = new int[]{0};
    }

    @Override
    public void update() {
        super.update();
        TileEntity[] tiles = new TileEntity[6];
        tiles[0] = worldObj.getTileEntity(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
        tiles[1] = worldObj.getTileEntity(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
        tiles[2] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
        tiles[3] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
        tiles[4] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
        tiles[5] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));

        for (TileEntity tile : tiles) {
            if (!worldObj.isRemote) {
                /*if (tile instanceof IFluidHandler) {
                    for (int i = 0; i < ((IFluidHandler) tile).getTankInfo(ForgeDirection.UP).length; i++) {
                        FluidTankInfo info = ((IFluidHandler) tile).getTankInfo(ForgeDirection.UP)[i];
                        int amount = info.fluid.amount;
                        int cap = info.capacity;
                        if (info.fluid.getFluid() == FluidRegistry.WATER) {
                            if (amount + 100 <= cap) {
                                if (tank.getFluidAmount() >= 100) {
                                    tank.getFluid().amount -= 100;
                                    ((IFluidHandler) tile).fill(ForgeDirection.UP, new FluidStack(FluidRegistry.WATER, 100), true);
                                }
                            }
                        }
                    }
                }*/
            }
        }

        if (!worldObj.isRemote) {
            if (canWork) {
                if (inventory[2] != null && inventory[2].getItem() == Item.getItemFromBlock(ModBlocks.woodenWellPipe)) {
                    bottom = inventory[2].stackSize;
                    for (int i = 1; i < pos.getY(); i++) {
                        if (inventory[2] != null) {
                            if (inventory[2].stackSize > 0) {
                                if (worldObj.getBlockState(new BlockPos(pos.getX(), pos.getY() - i, pos.getZ())) != ModBlocks.woodenWellPipe && worldObj.getBlockState(new BlockPos(pos.getX(), pos.getY() - i, pos.getZ())) != Blocks.water) {
                                    worldObj.setBlockState(new BlockPos(pos.getX(), pos.getY() - i, pos.getZ()), ModBlocks.woodenWellPipe.getDefaultState());
                                    amountOfPipes++;
                                    decrStackSize(2, 1);
                                }
                            } else {
                                worldObj.setBlockState(new BlockPos(pos.getX(), pos.getY() - i, pos.getZ()), Blocks.water.getDefaultState());
                            }

                            if (worldObj.getBlockState(new BlockPos(pos.getX(), pos.getY() - i - 1, pos.getZ())) == Blocks.bedrock) {
                                worldObj.setBlockState(new BlockPos(pos.getX(), pos.getY() - i, pos.getZ()), Blocks.water.getDefaultState());
                            }
                        }
                    }
                }
                /*if (tank.getFluidAmount() < tank.getCapacity()) {
                    if (amountOfPipes > 0 && amountOfPipes <= 16) {
                        tank.getFluid().amount += amountOfPipes;
                    } else if (amountOfPipes > 16 && amountOfPipes <= 32) {
                        tank.getFluid().amount += amountOfPipes + 10;
                    } else if (amountOfPipes > 32 && amountOfPipes <= 48) {
                        tank.getFluid().amount += amountOfPipes + 20;
                    } else if (amountOfPipes > 48 && amountOfPipes <= 64) {
                        tank.getFluid().amount += amountOfPipes + 30;
                    }
                }

                if (tank.getFluidAmount() > tank.getCapacity())
                    tank.getFluid().amount = tank.getCapacity();*/
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        //tank.readFromNBT(nbtTagCompound);
        bottom = nbtTagCompound.getInteger("bottom");
        amountOfPipes = nbtTagCompound.getInteger("numOfPipes");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        //tank.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("bottom", bottom);
        nbtTagCompound.setInteger("numOfPipes", amountOfPipes);
    }

    @Override
    public int getSizeInventory() {
        return 3;
    }

    /*@Override
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
        return new FluidTankInfo[]{tank.getInfo()};
    }*/
}
