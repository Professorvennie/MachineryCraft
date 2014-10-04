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
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.bronze.TileEntityBasicSteamMachine;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 10/4/2014 at 4:11 PM.
 */
public class TileEntityBronzeCharger extends TileEntityBasicSteamMachine {

    public TileEntityBronzeCharger() {
        super(Names.Containers.BRONZE_CHARGER);
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (!worldObj.isRemote) {
            if (inventory[2] != null && inventory[2].getItem() instanceof ISteamPoweredItem) {
                ItemStack itemStack = inventory[2];
                int steam = itemStack.stackTagCompound.getInteger("Steam");
                int cap = ((ISteamPoweredItem) itemStack.getItem()).getSteamCapacity();
                if (steam < cap && canWork) {
                    if (this.tank.getFluidAmount() >= 10) {
                        itemStack.stackTagCompound.setInteger("Steam", steam + 10);
                        tank.getFluid().amount -= 10;
                    }
                } else if (steam == cap && canWork) {
                    inventory[3] = inventory[2].copy();
                    inventory[2] = null;
                }
            }
        }
    }
}
