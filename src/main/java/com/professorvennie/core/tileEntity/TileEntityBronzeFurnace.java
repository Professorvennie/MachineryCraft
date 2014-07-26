package com.professorvennie.core.tileEntity;


import com.professorvennie.core.block.BlockBronzeFurnace;
import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityBronzeFurnace extends TileEntityMod implements ISidedInventory, IFluidHandler {

    public int cookTime = 0, furnaceSpeed = 110;

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
        boolean flag = this.cookTime > 0;
        boolean flag1 = false;

        if(!worldObj.isRemote){
            if(tanks[0].getFluidAmount() > tanks[0].getCapacity())
                tanks[0].getFluid().amount = tanks[0].getCapacity();

            if(inventory[0] != null) {
                if (inventory[0].getItem() == ModItems.steamBucket) {
                    int temp = tanks[0].getCapacity() - tanks[0].getFluidAmount();
                    if (inventory[1] == null) {
                        if(tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if(temp >= 1000)
                                setInventorySlotContents(1, new ItemStack(Items.bucket));
                        }
                        if(tanks[0].getFluid() == null) {
                            tanks[0].fill(new FluidStack(ModFuilds.fluidSteam, 1000), true);
                        }else if(tanks[0].getFluidAmount() < tanks[0].getCapacity()){
                            if(tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                                if(temp >= 1000)
                                    tanks[0].getFluid().amount += 1000;
                            }
                        }

                        if(tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if(temp >= 1000) {
                                inventory[0].stackSize--;
                                if (inventory[0].stackSize == 0)
                                    inventory[0] = null;
                            }
                        }

                    } else if(inventory[1].getItem() == Items.bucket){
                        if(tanks[0].getFluidAmount() < tanks[0].getCapacity()) {
                            if(temp >= 1000) {
                                inventory[0].stackSize--;
                                if (inventory[0].stackSize == 0)
                                    inventory[0] = null;
                                inventory[1].stackSize++;
                            }
                        }

                        if(tanks[0].getFluid() == null) {
                            if(temp >= 1000)
                                tanks[0].fill(new FluidStack(ModFuilds.fluidSteam, 1000), true);
                        }else if(tanks[0].getFluidAmount() < tanks[0].getCapacity()){
                            if(temp >= 1000)
                                tanks[0].getFluid().amount += 1000;
                        }
                    }

                }else if (inventory[0].getItem() == Items.bucket) {
                    if(inventory[1] == null){
                        if(tanks[0].getFluidAmount() >= 1000){
                            tanks[0].drain(1000, true);
                            inventory[0].stackSize--;
                            if(inventory[0].stackSize == 0)
                                inventory[0] = null;
                            setInventorySlotContents(1, new ItemStack(ModItems.steamBucket));
                        }
                    }
                }
            }
            if(tanks[0].getFluid() != null) {
                if (tanks[0].getFluid().amount >= 1 && canSmelt()) {
                    cookTime++;
                    tanks[0].getFluid().amount--;
                    if (cookTime == furnaceSpeed) {
                        cookTime = 0;
                        smeltItem();
                        flag1 = true;
                    }
                }else
                    cookTime = 0;
            }

            if(flag != cookTime > 0) {
                flag1 = true;
                //BlockBronzeFurnace.updateBlockState(cookTime > 0, worldObj, xCoord, yCoord, zCoord, ModBlocks.bronzeFurnaceActive, ModBlocks.bronzeFurnaceIdle);
            }
        }
        if(flag1) this.markDirty();
    }

    private boolean canSmelt(){
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

    private void smeltItem(){
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

    public void readFromNBT(NBTTagCompound nbt){
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
        this.cookTime = (int)nbt.getShort("cookTime");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setShort("cookTime", (short) this.cookTime);

        NBTTagList list = new NBTTagList();

        for(int i = 0; i < this.inventory.length; i ++){
            if(this.inventory[i] != null){
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("slot", (byte) i);
                this.inventory[i].writeToNBT(compound);
                list.appendTag(compound);
            }
        }
        nbt.setTag("items", list);
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
