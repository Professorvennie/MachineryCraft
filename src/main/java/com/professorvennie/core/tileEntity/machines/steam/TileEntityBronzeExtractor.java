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

import com.professorvennie.api.recipes.ExtractorRecipes;
import com.professorvennie.api.steam.ISteamBoiler;
import com.professorvennie.api.steam.ISteamTank;
import com.professorvennie.core.block.machines.steam.BlockBronzeExtractor;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.tileEntity.TileEntityBasicSidedInventory;
import com.professorvennie.core.tileEntity.TileEntityMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;


/**
 * Created by ProfessorVennie on 7/23/2014 at 11:24 AM.
 */
public class TileEntityBronzeExtractor extends TileEntityBasicSteamMachine{

    public int cookTime = 0, furnaceSpeed = 110, fuelEfficiency = 1;
    public static final int INPUTSLOT = 2, WATERSLOT = 0;

    public TileEntityBronzeExtractor(){
        super(Names.Containers.BRONZE_EXTRACTOR);
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        BlockBronzeExtractor block = (BlockBronzeExtractor)worldObj.getBlock(xCoord, yCoord, zCoord);
        if (cookTime > 0)
            block.isActive = true;
        else
            block.isActive = false;

        boolean flag1 = false;

        if(!worldObj.isRemote) {
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

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        this.cookTime = (int)nbtTagCompound.getShort("cookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setShort("cookTime", (short)cookTime);
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    public int getCookProgressScaled(int i){
        return cookTime * i / furnaceSpeed;
    }
}
