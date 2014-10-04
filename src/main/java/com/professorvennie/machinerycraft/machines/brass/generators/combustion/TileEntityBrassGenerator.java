/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.brass.generators.combustion;

import com.professorvennie.lib.base.tileentitys.TileEntityBasicSidedInventory;
import com.professorvennie.machinerycraft.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:14 PM.
 */
public class TileEntityBrassGenerator extends TileEntityBasicSidedInventory {

    private int burnTime = 0, currentItemBurnTime = 0, power = 0, maxPower = 10000;

    public TileEntityBrassGenerator() {
        super(Names.Containers.CONTAINER_BRASS_GENERATOR);
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
            if (item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        if (burnTime > 0)
            burnTime--;

        if (!worldObj.isRemote) {
            if (burnTime == 0) {
                System.out.println(power);
                this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.inventory[0]);

                if (isBurning()) {
                    if (power < maxPower)
                        power++;
                    if (inventory[0] != null) {
                        inventory[0].stackSize--;

                        if (inventory[0].stackSize == 0)
                            inventory[0] = null;
                    }
                }
            }
        }
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    public boolean isItemFuel(ItemStack itemStack) {
        return getItemBurnTime(itemStack) > 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }
}
