/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.charger;

import com.professorvennie.machinerycraft.api.steam.ISteamPoweredItem;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.TileEntityBasicSteamMachine;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

/**
 * Created by ProfessorVennie on 10/4/2014 at 4:11 PM.
 */
public class TileEntityBronzeCharger extends TileEntityBasicSteamMachine {

    public TileEntityBronzeCharger() {
        super(Names.Containers.BRONZE_CHARGER);
        slots_bottom = new int[]{1, 3};
        slots_sides = new int[]{0};
        slots_top = new int[]{2};
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    @Override
    public void update() {
        super.update();

        if (!worldObj.isRemote) {
            if (inventory[2] != null && inventory[2].getItem() instanceof ISteamPoweredItem) {
                ItemStack itemStack = inventory[2];
                int steam = itemStack.getTagCompound().getInteger("Steam");
                int cap = ((ISteamPoweredItem) itemStack.getItem()).getSteamCapacity();
                if (steam < cap && canWork) {
                   /* if (this.tank.getFluidAmount() >= 10) {
                        itemStack.getTagCompound().setInteger("Steam", steam + 10);
                        tank.getFluid().amount -= 10;
                    }*/
                } else if (steam == cap && canWork) {
                    inventory[3] = inventory[2].copy();
                    inventory[2] = null;
                }
            }
        }
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        if (slot == 2 && itemStack.getItem() instanceof ISteamPoweredItem)
            return true;
        else if (slot == 0 && itemStack.getItem() == ModItems.steamBucket)
            return true;
        else if (slot == 1 && itemStack.getItem() == Items.bucket)
            return true;
        else
            return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, EnumFacing direction) {
        if (slot == 3 || slot == 1)
            return true;
        return false;
    }
}
