package com.professorvennie.core.item;

import java.util.List;

import com.professorvennie.core.lib.LibNames;
import com.professorvennie.core.lib.LibStrings;
import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemIngots extends Item {
	
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public ItemIngots(){
		this.setUnlocalizedName("ingot");
		this.setHasSubtypes(true);
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < LibNames.Ingots.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack){
		return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register){
		 iconArray = new IIcon[LibNames.Ingots.length];
	        for (int i = 0; i < iconArray.length; i++) {
	        	  iconArray[i] = register.registerIcon(LibStrings.MODID + ":ingots/" + "ingot" + "_" + i);
	        }
	}
	
	 @Override
	 @SideOnly(Side.CLIENT)
	  public IIcon getIconFromDamage(int par1) {
	       return par1 < iconArray.length ? iconArray[par1] : iconArray[0];
	  }

}
