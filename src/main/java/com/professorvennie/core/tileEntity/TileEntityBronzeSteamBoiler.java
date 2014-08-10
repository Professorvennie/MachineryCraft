package com.professorvennie.core.tileEntity;

import com.professorvennie.api.steam.ISteamPipe;
import com.professorvennie.api.steam.ISteamTank;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityBronzeSteamBoiler extends TileEntityMod implements ISidedInventory, IFluidHandler {

    private ItemStack[] inventory;
    public FluidTank[] tanks = new FluidTank[2];

    public int burnTime, currentItemBurnTime, temp = 0, maxTemp = 500;

    public TileEntityBronzeSteamBoiler(){
        inventory = new ItemStack[5];
        tanks = new FluidTank[2];
        tanks[0] = new FluidTank(ModFuilds.fluidSteam, 0, 10000);
        tanks[1] = new FluidTank(FluidRegistry.WATER, 0, 10000);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[]{4};
    }

    @Override
    public boolean canInsertItem(int var1, ItemStack itemStack, int i2) {
        return isItemValidForSlot(var1, itemStack);
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

    public boolean isBurning(){
        return this.burnTime > 0;
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
        if(burnTime > 0) burnTime--;

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
                                ((ISteamTank)tiles[i]).setSteamAmount(100);
                            }
                        }
                    }else if(tiles[i] instanceof ISteamPipe){
                        if(((ISteamPipe)tiles[i]).getSteamAmount() < ((ISteamPipe)tiles[i]).getSteamCapacity()){
                            int left =((ISteamPipe)tiles[i]).getSteamCapacity() -  ((ISteamPipe)tiles[i]).getSteamAmount();
                            if(left > 100){
                                if(tanks[0].getFluidAmount() > 100){
                                    ((ISteamPipe)tiles[i]).addSteam(100);
                                    tanks[0].getFluid().amount -= 100;
                                }
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
                    currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]);
                    if(inventory[4] != null) {
                        inventory[4].stackSize--;
                        if (inventory[4].stackSize == 0)
                            inventory[4] = inventory[4].getItem().getContainerItem(inventory[4]);
                    }
                }
            }else if(temp == maxTemp){
                if(burnTime == 0){
                    currentItemBurnTime = burnTime = getItemBurnTime(inventory[4]) * 10;
                    if(inventory[4] != null) {
                        inventory[4].stackSize--;
                        if (inventory[4].stackSize == 0)
                            inventory[4] = inventory[4].getItem().getContainerItem(inventory[4]);
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

        NBTTagList list = nbt.getTagList("items", Constants.NBT.TAG_COMPOUND);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < list.tagCount(); i ++){
            NBTTagCompound compound = list.getCompoundTagAt(i);
            int j = compound.getByte("slot") & 0xff;

            if(j >= 0 && j < this.inventory.length){
                this.inventory[j] = ItemStack.loadItemStackFromNBT(compound);
            }
        }
//        tanks[0].readFromNBT(nbt);
//        tanks[1].readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();

        for(int i = 0; i < this.inventory.length; i ++){
            if(this.inventory[i] != null){
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("slot", (byte) i);
                this.inventory[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }
//        tanks[0].writeToNBT(nbt);
//        tanks[1].writeToNBT(nbt);

        nbt.setTag("items", list);
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
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.BRONZE_STEAMBOILER;

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
}
