/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.boiler;

import com.professorvennie.machinerycraft.api.steam.ISteamBoiler;
import com.professorvennie.machinerycraft.api.steam.ISteamTank;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.TileEntityBasicMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityBronzeSteamBoiler extends TileEntityBasicMachine implements /*IFluidHandler,*/ ISteamBoiler {

    public static final int FUELSLOT = 4, WATERSLOT = 2, STEAMEMPTYSLOT = 0;
    public final int steamCapacity = 10000, waterCapacity = 10000;
    //public FluidTank[] tanks = new FluidTank[2];
    public int burnTime, currentItemBurnTime, temp = 0, maxTemp = 500, steamAmount, waterAmount;

    public TileEntityBronzeSteamBoiler() {
        super(Names.Containers.BRONZE_STEAMBOILER);
        //tanks[0] = new FluidTank(FluidRegistry.WATER, 0, 10000);
        //tanks[1] = new FluidTank(ModFuilds.fluidSteam, 0, 10000);
    }

    public static int getItemBurnTime(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        } else {
            Item item = itemstack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab) {
                    return 150;
                }
                if (block.getMaterial() == Material.wood) {
                    return 300;
                }
                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    public static boolean isItemFuel(ItemStack itemstack) {
        return getItemBurnTime(itemstack) > 0;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        if (side == EnumFacing.UP || side == EnumFacing.DOWN)
            return new int[]{4};
        if (side == EnumFacing.EAST || side == EnumFacing.WEST || side == EnumFacing.NORTH || side == EnumFacing.SOUTH)
            return new int[]{2};
        if (side == EnumFacing.DOWN)
            return new int[]{1, 3};
        return new int[]{};
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 1:
                return burnTime;
            case 2:
                return currentItemBurnTime;
            case 3:
                return temp;
            case 4:
                return steamAmount;
            case 5:
                return waterAmount;
            default:
                return super.getField(id);
        }
    }

    @Override
    public int getFieldCount() {
        return super.getFieldCount() + 5;
    }

    @Override
    public void setField(int id, int value) {
        super.setField(id, value);
        switch (id) {
            case 1:
                burnTime = value;
                break;
            case 2:
                currentItemBurnTime = value;
                break;
            case 3:
                temp = value;
                break;
            case 4:
                steamAmount = value;
                break;
            case 5:
                waterAmount = value;
                break;
        }
    }

    @Override
    public void update() {
        super.update();
        BlockBronzeSteamBoiler block = (BlockBronzeSteamBoiler) worldObj.getBlockState(pos).getBlock();
        if (burnTime > 0) {
            burnTime--;
            block.isActive = true;
        } else {
            block.isActive = false;
        }

        TileEntity[] tiles = new TileEntity[6];
        tiles[0] = worldObj.getTileEntity(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
        tiles[1] = worldObj.getTileEntity(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
        tiles[2] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
        tiles[3] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
        tiles[4] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
        tiles[5] = worldObj.getTileEntity(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));

        if (!worldObj.isRemote) {
            for (int i = 0; i < tiles.length; i++) {
                if (tiles[i] != null) {
                    if (tiles[i] instanceof ISteamTank) {
                        int furnaceAmount = ((ISteamTank) tiles[i]).getSteamAmount();
                        int capactiy = ((ISteamTank) tiles[i]).getSteamCapacity();
                        if (furnaceAmount < capactiy) {
                            if (steamAmount >= 1000) {
                                steamAmount -= 100;
                                ((ISteamTank) tiles[i]).addSteamAmount(100);
                            }
                        }
                    }
                }
            }
        }

        if (!worldObj.isRemote) {
            if (steamAmount > steamCapacity)
                steamAmount = steamCapacity;

            if (waterAmount > waterCapacity)
                waterAmount = waterCapacity;

            if (temp > maxTemp)
                temp = maxTemp;

            if (canWork) {
                if (waterAmount == 0 && temp >= 212) {
                    worldObj.createExplosion(worldObj.getClosestPlayer((double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), -1), (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), 4.0f, true);
                }


                int time = (int) worldObj.getWorldTime() % 100;
                if (burnTime > 0) {
                    if (temp < maxTemp) {
                        if (time == 0)
                            temp++;
                    }
                } else if (time == 0)
                    if (temp > 0)
                        temp--;

                if (temp >= 212 && waterAmount > 0) {
                    steamAmount += 100;
                    waterAmount -= 100;

                }

                if (temp < maxTemp) {
                    if (burnTime == 0) {
                        currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) / 2;
                        if (inventory[4] != null) {
                            if (isItemFuel(inventory[4])) {
                                inventory[4].stackSize--;
                                if (inventory[4].stackSize == 0)
                                    inventory[4] = new ItemStack(inventory[4].getItem().getContainerItem());
                            }
                        }
                    }
                } else if (temp == maxTemp) {
                    if (burnTime == 0) {
                        currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) * 10;
                        if (inventory[4] != null) {
                            if (isItemFuel(inventory[4])) {
                                inventory[4].stackSize--;
                                if (inventory[4].stackSize == 0)
                                    inventory[4] = new ItemStack(inventory[4].getItem().getContainerItem());
                            }
                        }
                    }
                }
            }

            if (inventory[2] != null) {
                if (inventory[2].getItem() == Items.water_bucket) {
                    int temp = waterCapacity - waterAmount;
                    if (inventory[3] == null) {
                        if (waterAmount < waterCapacity) {
                            if (temp >= 1000) {
                                setInventorySlotContents(3, new ItemStack(Items.bucket));
                            }
                        }
                        if (waterAmount < waterCapacity) {
                            if (waterAmount < waterCapacity) {
                                if (temp >= 1000)
                                    waterAmount += 1000;
                            }
                        }

                        if (waterAmount < waterCapacity) {
                            if (temp >= 1000) {
                                inventory[2].stackSize--;
                                if (inventory[2].stackSize == 0)
                                    inventory[2] = null;
                            }
                        }

                    } else if (inventory[3].getItem() == Items.bucket) {
                        if (waterAmount < waterCapacity) {
                            if (temp >= 1000) {
                                inventory[2].stackSize--;
                                if (inventory[2].stackSize == 0)
                                    inventory[2] = null;
                                inventory[3].stackSize++;
                            }
                        }

                        if (waterAmount < waterCapacity) {
                            if (temp >= 1000)
                                waterAmount += 1000;
                        }
                    }

                } else if (inventory[2].getItem() == Items.bucket) {
                    if (inventory[3] == null) {
                        if (waterAmount >= 1000) {
                            waterAmount -= 1000;
                            inventory[2].stackSize--;
                            if (inventory[2].stackSize == 0)
                                inventory[2] = null;
                            setInventorySlotContents(3, new ItemStack(Items.water_bucket));
                        }
                    }
                }
            }

            if (inventory[0] != null) {
                if (inventory[0].getItem() == Items.bucket) {
                    if (inventory[1] == null) {
                        if (steamAmount >= 1000) {
                            steamAmount -= 1000;
                            inventory[0].stackSize--;
                            if (inventory[0].stackSize == 0)
                                inventory[0] = null;
                            setInventorySlotContents(1, new ItemStack(ModItems.steamBucket));
                        }
                    }
                }
            }
        }

       /* if (!worldObj.isRemote) {
            for (int i = 0; i < tiles.length; i++) {
                if (tiles[i] != null) {
                    if (tiles[i] instanceof ISteamTank) {
                        int furnaceAmount = ((ISteamTank) tiles[i]).getSteamAmount();
                        int capactiy = ((ISteamTank) tiles[i]).getSteamCapacity();
                        if (furnaceAmount < capactiy) {
                            if (tanks[1].getFluidAmount() >= 1000) {
                                tanks[1].getFluid().amount -= 100;
                                ((ISteamTank) tiles[i]).addSteamAmount(100);
                            }
                        }
                    }
                }
            }
        }*/

        /*if (!worldObj.isRemote) {
            if (tanks[1].getFluidAmount() > tanks[1].getCapacity())
                tanks[1].getFluid().amount = tanks[1].getCapacity();

            if (tanks[0].getFluidAmount() > tanks[0].getCapacity())
                tanks[0].getFluid().amount = tanks[0].getCapacity();

            if (temp > maxTemp)
                temp = maxTemp;

            if (canWork) {
                if (tanks[0].getFluid() != null) {
                    if (tanks[0].getFluidAmount() == 0 && temp >= 212) {
                        worldObj.createExplosion(worldObj.getClosestPlayer((double) xCoord, (double) yCoord, (double) zCoord, -1), (double) xCoord, (double) yCoord, (double) zCoord, 4.0f, true);
                    }
                } else if (temp >= 212) {
                    worldObj.createExplosion(worldObj.getClosestPlayer((double) xCoord, (double) yCoord, (double) zCoord, -1), (double) xCoord, (double) yCoord, (double) zCoord, 4.0f, true);
                }

                int time = (int) worldObj.getWorldTime() % 100;
                if (burnTime > 0) {
                    if (temp < maxTemp) {
                        if (time == 0)
                            temp++;
                    }
                } else if (time == 0)
                    if (temp > 0)
                        temp--;

                if (tanks[0].getFluid() != null) {
                    if (temp >= 212 && tanks[0].getFluid().amount > 0) {
                        if (tanks[1].getFluid() != null) {
                            if (tanks[1].getFluid().getFluid() != ModFuilds.fluidSteam) {
                                tanks[1].fill(new FluidStack(ModFuilds.fluidSteam, 100), true);
                                tanks[0].getFluid().amount -= 100;
                            } else {
                                tanks[1].getFluid().amount += 10;
                                tanks[0].getFluid().amount -= 10;
                            }
                        } else {
                            tanks[1].fill(new FluidStack(ModFuilds.fluidSteam, 100), true);
                            tanks[0].getFluid().amount -= 100;
                        }
                    }
                }

                if (temp < maxTemp) {
                    if (burnTime == 0) {
                        currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) / 2;
                        if (inventory[4] != null) {
                            if (isItemFuel(inventory[4])) {
                                inventory[4].stackSize--;
                                if (inventory[4].stackSize == 0)
                                    inventory[4] = inventory[4].getItem().getContainerItem(inventory[4]);
                            }
                        }
                    }
                } else if (temp == maxTemp) {
                    if (burnTime == 0) {
                        currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) * 10;
                        if (inventory[4] != null) {
                            if (isItemFuel(inventory[4])) {
                                inventory[4].stackSize--;
                                if (inventory[4].stackSize == 0)
                                    inventory[4] = inventory[4].getItem().getContainerItem(inventory[4]);
                            }
                        }
                    }
                }
            }

            if (inventory[2] != null) {
                if (inventory[2].getItem() == Items.water_bucket) {
                    int temp = tanks[0].getCapacity() - tanks[0].getFluidAmount();
                    if (inventory[3] == null) {
                        if (tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if (temp >= 1000)
                                setInventorySlotContents(3, new ItemStack(Items.bucket));
                        }
                        if (tanks[0].getFluid() == null) {
                            tanks[0].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        } else if (tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if (tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                                if (temp >= 1000)
                                    tanks[0].getFluid().amount += 1000;
                            }
                        }

                        if (tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if (temp >= 1000) {
                                inventory[2].stackSize--;
                                if (inventory[2].stackSize == 0)
                                    inventory[2] = null;
                            }
                        }

                    } else if (inventory[3].getItem() == Items.bucket) {
                        if (tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if (temp >= 1000) {
                                inventory[2].stackSize--;
                                if (inventory[2].stackSize == 0)
                                    inventory[2] = null;
                                inventory[3].stackSize++;
                            }
                        }

                        if (tanks[0].getFluid() == null) {
                            if (temp >= 1000)
                                tanks[0].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        } else if (tanks[0].getFluidAmount() < tanks[1].getCapacity()) {
                            if (temp >= 1000)
                                tanks[0].getFluid().amount += 1000;
                        }
                    }

                } else if (inventory[2].getItem() == Items.bucket) {
                    if (inventory[3] == null) {
                        if (tanks[0].getFluidAmount() >= 1000) {
                            tanks[0].drain(1000, true);
                            inventory[2].stackSize--;
                            if (inventory[2].stackSize == 0)
                                inventory[2] = null;
                            setInventorySlotContents(3, new ItemStack(Items.water_bucket));
                        }
                    }
                }
            }

            if (inventory[0] != null) {
                if (inventory[0].getItem() == Items.bucket) {
                    if (inventory[1] == null) {
                        if (tanks[1].getFluidAmount() >= 1000) {
                            tanks[1].drain(1000, true);
                            inventory[0].stackSize--;
                            if (inventory[0].stackSize == 0)
                                inventory[0] = null;
                            setInventorySlotContents(1, new ItemStack(ModItems.steamBucket));
                        }
                    }
                }
            }
        }*/
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        burnTime = nbt.getInteger("burnTime");
        currentItemBurnTime = nbt.getInteger("currentItemBurnTime");
        temp = nbt.getInteger("temp");
        steamAmount = nbt.getInteger("Steam");
        waterAmount = nbt.getInteger("Water");

        NBTTagList list = nbt.getTagList("water", 10);
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound nbtTagCompound = list.getCompoundTagAt(i);
            //tanks[0].readFromNBT(nbtTagCompound);
        }

        //tanks[1].readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setInteger("burnTime", burnTime);
        nbt.setInteger("currentItemBurnTime", currentItemBurnTime);
        nbt.setInteger("temp", temp);
        nbt.setInteger("Steam", steamAmount);
        nbt.setInteger("Water", waterAmount);

        /*NBTTagList list = new NBTTagList();
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        tanks[0].writeToNBT(nbtTagCompound);
        list.appendTag(nbtTagCompound);
        nbt.setTag("water", list);

        tanks[1].writeToNBT(nbt);*/
    }

    /*@Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if (from.equals(ForgeDirection.UP) || from.equals(ForgeDirection.DOWN))
            tanks[0].fill(resource, doFill);
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return drain(from, resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        if (from.equals(ForgeDirection.EAST) || from.equals(ForgeDirection.WEST) || from.equals(ForgeDirection.NORTH) || from.equals(ForgeDirection.SOUTH))
            tanks[1].drain(maxDrain, doDrain);
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
    }*/

    public int getBurnTimeReamingScaled(int i) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 100;
        }
        return this.burnTime * i / this.currentItemBurnTime;
    }

    /*@Override
    public FluidTank getWaterTank() {
        return tanks[0];
    }*/

    @Override
    public int getWaterAmount() {
        //return tanks[0].getFluidAmount();
        return waterAmount;
    }

    @Override
    public void setWaterAmount(int amount) {
        //tanks[0].getFluid().amount += amount;
        if (waterAmount + amount < amount)
            waterAmount += amount;
    }

    @Override
    public int getWaterCapacity() {
        //return tanks[0].getCapacity();
        return waterCapacity;
    }

    /*@Override
    public FluidTank getSteamTank() {
        return tanks[1];
    }*/

    @Override
    public int getSteamAmount() {
        //return tanks[1].getFluidAmount();
        return steamAmount;
    }

    @Override
    public int getSteamCapacity() {
        //return tanks[1].getCapacity();
        return steamCapacity;
    }

    @Override
    public void addSteamAmount(int amount) {
        // tanks[1].getFluid().amount += amount;
        if (steamAmount + amount < amount)
            steamAmount += amount;
    }
}
