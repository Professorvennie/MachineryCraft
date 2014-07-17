/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.tileEntity;


import com.professorvennie.core.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;


public class TileEntityWasher extends TileEntity implements ISidedInventory, IFluidHandler{
	
	private String localizedName;
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_sides = new int[]{1};
	
	private ItemStack[] slots;
	public FluidTank[] tanks;
	
	public int furnaceSpeed = 70;
	
	public int power;
	public final int  maxpower = 10000;
	
	public int currentItemBurnTime;
	
	public int cookTime;

	private int smeltItem;

    
    private boolean hasMaster, isMaster;
    private int masterX, masterY, masterZ;
 

    public TileEntityWasher() {
    	slots  = new ItemStack[4];
    	tanks  = new FluidTank[1];
    	for(int i =0; i < tanks.length; i++){
    		tanks[i] = new FluidTank(1000);
    	}
    	
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!worldObj.isRemote) {
            if (hasMaster()) {
                if (isMaster()) {
                    if (!checkMultiBlockForm())
                        resetMultiBlockStructure();

                   
                    for (int i = 0; i < 1; i++) {
                        if (tanks[i].getFluid() != null && tanks[i].getFluid().getFluid() != null) {
                            if (tanks[i].getFluidAmount() <= 0)
                                tanks[i].setFluid(null);
                        }
                    }
                    	this.tanks[0].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                    
                   
                } else {
                    if (!checkForMaster())
                        resetMultiBlockStructure(masterX, masterY, masterZ);
                }
            } else {
                if (checkMultiBlockForm()) {
                    setupMultiBlockStructure();
                    setMetaForBlocks();
                }
            }
        }
    }

    public boolean checkMultiBlockForm() {
        int i = 0;
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityWasher))
                        i++;
                }

        return i > 25 && worldObj.isAirBlock(xCoord, yCoord + 1, zCoord);
    }

    public boolean checkForMaster() {
        TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
        return (tile != null && (tile instanceof TileEntityWasher));
    }

    public void resetMultiBlockStructure(int par1, int par2, int par3) {
        for (int x = par1 - 1; x < par1 + 2; x++)
            for (int y = par2; y < par2 + 3; y++)
                for (int z = par3 - 1; z < par3 + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityWasher)) {
                        ((TileEntityWasher) tile).reset();
                        worldObj.setBlockMetadataWithNotify(x, y, z, 0, 2);
                    }
                }
    }

    public void resetMultiBlockStructure() {
        resetMultiBlockStructure(xCoord, yCoord, zCoord);
    }

    public void setupMultiBlockStructure() {
        for (int x = xCoord - 1; x < xCoord + 2; x++)
            for (int y = yCoord; y < yCoord + 3; y++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof TileEntityWasher))
                        ((TileEntityWasher) tile).setMaster(xCoord, yCoord, zCoord, master);
                }
    }

    public void setMetaForBlocks() {
        // Master
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 2);
        
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord+2, zCoord, 8, 2);

        // Centers
        //worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 2, zCoord, 5, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 1, zCoord, 7, 2);
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 1, zCoord, 7, 2);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 1, zCoord + 1, 5, 2);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 1, zCoord - 1, 5, 2);

        // Horizontal
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord, 6, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord, 6, 2);
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 2, zCoord, 6, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 2, zCoord, 6, 2);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord - 1, 4, 2);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord + 1, 4, 2);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 2, zCoord - 1, 4, 2);
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord + 2, zCoord + 1, 4, 2);

        // Vertical
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 1, zCoord - 1, 3, 2);
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 1, zCoord + 1, 3, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 1, zCoord - 1, 3, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 1, zCoord + 1, 3, 2);

        // Corners
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord - 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord + 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord - 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord + 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 2, zCoord - 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord + 2, zCoord + 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 2, zCoord - 1, 1, 2);
        worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord + 2, zCoord + 1, 1, 2);
    }

    public boolean hasMaster() {
        return hasMaster;
    }

    public int getMasterX() {
        return masterX;
    }

    public int getMasterY() {
        return masterY;
    }

    public int getMasterZ() {
        return masterZ;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public void reset() {
        masterX = 0;
        masterY = 0;
        masterZ = 0;
        hasMaster = false;
        isMaster = false;
    }

    public void setMaster(int x, int y, int z, boolean isMaster) {
        TileEntity tile = worldObj.getTileEntity(x, y, z);
        if (tile != null && (tile instanceof TileEntityWasher)) {
            masterX = x;
            masterY = y;
            masterZ = z;
            hasMaster = true;
            this.isMaster = isMaster;
        }
    }

    @Override
    public int getSizeInventory() {
        return this.slots.length;
    }

    @Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if(this.slots[var1] != null){
			ItemStack itemstack;
			if(this.slots[var1].stackSize <= var2){
				itemstack = this.slots[var1];
				this.slots[var1] = null;
				return itemstack;
			}else{
				itemstack = this.slots[var1].splitStack(var2);
				if(this.slots[var1].stackSize == 0){
					this.slots[var1] = null;
				}
				return itemstack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		if(this.slots[var1] != null){
			ItemStack itemstack = this.slots[var1];
			this.slots[var1] = null;
			return itemstack;
		}
		
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		this.slots[var1]= var2;
		
		if(var2 != null && var2.stackSize > this.getInventoryStackLimit()){
			var2.stackSize = this.getInventoryStackLimit();
		}
	}
		
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return hasMaster();
    }

    public void readFromNBT(NBTTagCompound data) {
    	super.readFromNBT(data);

    	this.masterX = data.getInteger("masterX");
    	this.masterY = data.getInteger("masterY");
    	this.masterZ = data.getInteger("masterZ");
    	this.hasMaster = data.getBoolean("hasMaster");
    	this.isMaster = data.getBoolean("isMaster");
    }

   

    public void writeToNBT(NBTTagCompound data) {
    	super.writeToNBT(data);
        data.setInteger("masterX", this.masterX);
        data.setInteger("masterY", this.masterY);
        data.setInteger("masterZ", this.masterZ);
        data.setBoolean("hasMaster", this.hasMaster);
        data.setBoolean("isMaster", this.isMaster);
    
    }
    
	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom  : (var1 == 1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		return this.isItemValidForSlot(var1, var2);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
	}

	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getInvName() {
		// TODO Auto-generated method stub
		return Names.Containers.CONTAINER_WASHER;
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		 if (hasMaster()) {
	            if (!isMaster()) {
	                TileEntityWasher tile = (TileEntityWasher) worldObj.getTileEntity(masterX, masterY, masterZ);
	                return tile != null ? tile.fill(from, resource, doFill) : 0;
	            } else {
	                if (from.equals(ForgeDirection.UP))
	                    return tanks[0].fill(resource, doFill);
	            }
	        }
	        return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (hasMaster()) {
            if (!isMaster()) {
            	TileEntityWasher tile = (TileEntityWasher) worldObj.getTileEntity(masterX, masterY, masterZ);
                return tile != null ? tile.drain(from, maxDrain, doDrain) : null;
            } else {
                if (from.equals(ForgeDirection.UP))
                    return tanks[0].drain(maxDrain, doDrain);
            }
        }
        return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return this.hasMaster();
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return this.hasMaster();
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tanks[0].getInfo()};
	}
	 public int getTank1Amount() {
	        return tanks[0].getFluidAmount();
    }
}
