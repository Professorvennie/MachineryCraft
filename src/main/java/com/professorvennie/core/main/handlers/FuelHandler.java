package com.professorvennie.core.main.handlers;

import com.professorvennie.core.block.ModBlocks;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 9/5/2014 at 11:40 PM.
 */
public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel == null)
            return 0;
        else{
            Item item = fuel.getItem();
            if(item == Item.getItemFromBlock(ModBlocks.plasticSlabHalf)){
                return 100;
            }
        }
        return 0;
    }
}
