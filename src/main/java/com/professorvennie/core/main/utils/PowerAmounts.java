/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.main.utils;

import com.professorvennie.core.block.ModBlocks;
import com.professorvennie.core.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PowerAmounts {


    public static int getItemPower(ItemStack itemstack){
        if(itemstack == null){
            return 0;
        }else{
            Item item = itemstack.getItem();
            if(item == new ItemStack(ModBlocks.BlockMetals, 1, 4).getItem()) return 910;
            if(item == Items.redstone) return 150;
            if(item == Item.getItemFromBlock(Blocks.redstone_block)) return 150 * 9 + 10;
            return 0;
        }
    }

    public static boolean isItemPower(ItemStack itemstack){
        return getItemPower(itemstack) > 0;
    }

}
