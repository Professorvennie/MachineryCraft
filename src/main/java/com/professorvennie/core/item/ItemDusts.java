package com.professorvennie.core.item;

import java.util.List;

import com.professorvennie.core.lib.ItemNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDusts extends Item {

	public ItemDusts(){
		this.setUnlocalizedName("dust");
		this.setHasSubtypes(true);
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < ItemNames.Dusts.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack){
		return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}
}
