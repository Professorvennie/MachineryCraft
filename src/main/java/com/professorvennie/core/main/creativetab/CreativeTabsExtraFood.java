package com.professorvennie.core.main.creativetab;

import com.professorvennie.core.block.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsExtraFood extends CreativeTabs {
	
	public CreativeTabsExtraFood(String TabLabel) {
		super(TabLabel);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.goldOxideFurnaceActive);
	}

}
