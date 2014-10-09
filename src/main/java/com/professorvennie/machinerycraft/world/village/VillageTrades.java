/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.world.village;

import com.professorvennie.machinerycraft.block.ModBlocks;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.Random;

public class VillageTrades/* implements VillagerRegistry.IVillageTradeHandler */{

    //@Override
    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
        /*if (villager.getProfession() == 78906) {
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.emerald, 0, 4), null, new ItemStack(ModBlocks.copperFurnaceIdle)));
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(ModBlocks.copperGrinderIdle), null, new ItemStack(Items.emerald, 0, 5)));
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.emerald, 0, 5), null, new ItemStack(ModBlocks.copperGrinderIdle)));
        }*/
    }
}
