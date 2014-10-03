package com.professorvennie.machinerycraft.machines;

import com.professorvennie.lib.base.tileentitys.TileEntityBasicSidedInventory;
import com.professorvennie.machinerycraft.api.item.IItemUpgrade;
import com.professorvennie.machinerycraft.api.tileentity.IHasButton;
import com.professorvennie.machinerycraft.api.tileentity.IRedstoneControlable;
import com.professorvennie.machinerycraft.client.gui.buttons.enums.EjectorMode;
import com.professorvennie.machinerycraft.client.gui.buttons.enums.RedStoneMode;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by ProfessorVennie on 9/27/2014 at 1:25 PM.
 */
public class TileEntityBasicMachine extends TileEntityBasicSidedInventory implements IRedstoneControlable, IHasButton {

    public boolean canWork;
    public int[] upgradeSlots;
    //upgrades
    public boolean hasEjectorUpgrade;
    public int speedModifier;
    private int machineSpeed;
    private RedStoneMode redStoneMode;
    private EjectorMode ejectorMode;

    public TileEntityBasicMachine(String name) {
        super(name);
        redStoneMode = RedStoneMode.low;
        ejectorMode = EjectorMode.north;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        switch (redStoneMode) {
            case low:
                if (!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
                    canWork = true;
                else
                    canWork = false;
                break;
            case high:
                if (worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
                    canWork = true;
                else
                    canWork = false;
                break;
            case disabled:
                canWork = true;
                break;
            default:
                canWork = false;
                break;
        }

        checkUpgrades();
    }

    public void checkUpgrades() {
        if (upgradeSlots != null) {
            if ((inventory[upgradeSlots[0]] != null && (inventory[upgradeSlots[0]].getItem() instanceof IItemUpgrade && ((IItemUpgrade) inventory[upgradeSlots[0]].getItem()).isEjectorUpgrade()))
                    || (inventory[upgradeSlots[1]] != null && (inventory[upgradeSlots[1]].getItem() instanceof IItemUpgrade && ((IItemUpgrade) inventory[upgradeSlots[1]].getItem()).isEjectorUpgrade()))
                    || (inventory[upgradeSlots[2]] != null && (inventory[upgradeSlots[2]].getItem() instanceof IItemUpgrade && ((IItemUpgrade) inventory[upgradeSlots[2]].getItem()).isEjectorUpgrade()))) {

                hasEjectorUpgrade = true;
            } else
                hasEjectorUpgrade = false;

            int mod1, mod2, mod3;
            if ((inventory[upgradeSlots[0]] != null && (inventory[upgradeSlots[0]].getItem() instanceof IItemUpgrade && ((IItemUpgrade) inventory[upgradeSlots[0]].getItem()).getSpeedModifier() > 0))) {
                mod1 = ((IItemUpgrade) inventory[upgradeSlots[0]].getItem()).getSpeedModifier() * inventory[upgradeSlots[0]].stackSize;
            } else
                mod1 = 0;

            if ((inventory[upgradeSlots[1]] != null && (inventory[upgradeSlots[1]].getItem() instanceof IItemUpgrade && ((IItemUpgrade) inventory[upgradeSlots[1]].getItem()).getSpeedModifier() > 0))) {
                mod2 = ((IItemUpgrade) inventory[upgradeSlots[1]].getItem()).getSpeedModifier() * inventory[upgradeSlots[1]].stackSize;
            } else
                mod2 = 0;

            if ((inventory[upgradeSlots[2]] != null && (inventory[upgradeSlots[2]].getItem() instanceof IItemUpgrade && ((IItemUpgrade) inventory[upgradeSlots[2]].getItem()).getSpeedModifier() > 0))) {
                mod3 = ((IItemUpgrade) inventory[upgradeSlots[2]].getItem()).getSpeedModifier() * inventory[upgradeSlots[2]].stackSize;
            } else
                mod3 = 0;

            speedModifier = (mod1 + mod2 + mod3);
        }
    }

    public void eject(EjectorMode mode, int outPutSlot) {
        int tile = 0;
        switch (mode) {
            case north:
                tile = 5;
                break;
            case south:
                tile = 4;
                break;
            case east:
                tile = 0;
                break;
            case west:
                tile = 1;
                break;
            case up:
                tile = 2;
                break;
            case down:
                tile = 3;
                break;
            case disabled:
                tile = -1;
                break;
        }

        TileEntity[] tiles = new TileEntity[6];
        tiles[0] = worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
        tiles[1] = worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
        tiles[2] = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
        tiles[3] = worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
        tiles[4] = worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
        tiles[5] = worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);

        if (!worldObj.isRemote) {
            if (hasEjectorUpgrade) {
                if (tile != -1) {
                    if (tiles[tile] != null) {
                        if (tiles[tile] instanceof IInventory) {
                            IInventory inventory = (IInventory) tiles[tile];
                            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                                if (inventory.getStackInSlot(i) == null) {
                                    inventory.setInventorySlotContents(i, this.inventory[outPutSlot]);
                                    this.inventory[outPutSlot] = null;
                                } else if (inventory.getStackInSlot(i) == getStackInSlot(outPutSlot)) {
                                    inventory.getStackInSlot(i).stackSize++;
                                    getStackInSlot(outPutSlot).stackSize--;
                                }
                            }
                        } else if (tiles[tile] instanceof ISidedInventory) {
                            ISidedInventory inventory = (ISidedInventory) tiles[tile];
                            int side[] = inventory.getAccessibleSlotsFromSide(tile);
                            for (int i = 0; i < side.length; i++) {
                                if (inventory.getStackInSlot(i) == null) {

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        redStoneMode = RedStoneMode.values()[nbtTagCompound.getInteger("Mode")];
        ejectorMode = EjectorMode.values()[nbtTagCompound.getInteger("EjectorMode")];
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setInteger("Mode", redStoneMode.ordinal());
        nbtTagCompound.setInteger("EjectorMode", ejectorMode.ordinal());
    }

    @Override
    public RedStoneMode getRedStoneMode() {
        return redStoneMode;
    }

    @Override
    public void setRedstoneMode(RedStoneMode mode) {
        this.redStoneMode = mode;
    }

    public EjectorMode getEjectorMode() {
        return ejectorMode;
    }

    public void setEjectorMode(EjectorMode ejectorMode) {
        this.ejectorMode = ejectorMode;
    }

    public int getMachineSpeed() {
        return machineSpeed;
    }

    public void setMachineSpeed(int machineSpeed) {
        this.machineSpeed = machineSpeed;
    }

    @Override
    public void handleClick(int id) {
        switch (id) {
            case 0:
                setRedstoneMode(RedStoneMode.high);
                //System.out.println(redStoneMode);
                break;
            case 1:
                setRedstoneMode(RedStoneMode.disabled);
                //System.out.println(redStoneMode);
                break;
            case 2:
                setRedstoneMode(RedStoneMode.low);
                //System.out.println(redStoneMode);
                break;
            case 3:
                setEjectorMode(EjectorMode.south);
                //System.out.println(ejectorMode);
                break;
            case 4:
                setEjectorMode(EjectorMode.east);
                //System.out.println(ejectorMode);
                break;
            case 5:
                setEjectorMode(EjectorMode.west);
                //System.out.println(ejectorMode);
                break;
            case 6:
                setEjectorMode(EjectorMode.up);
                //System.out.println(ejectorMode);
                break;
            case 7:
                setEjectorMode(EjectorMode.down);
                //System.out.println(ejectorMode);
                break;
            case 8:
                setEjectorMode(EjectorMode.disabled);
                //System.out.println(ejectorMode);
                break;
            case 9:
                setEjectorMode(EjectorMode.north);
                //System.out.println(ejectorMode);
                break;
        }
    }
}
