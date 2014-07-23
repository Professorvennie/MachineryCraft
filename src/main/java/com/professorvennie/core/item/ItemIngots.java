/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item;

import java.util.List;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;

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
		this.setCreativeTab(MachineryCraft.tabMachineryCraft);
        setFull3D();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < Names.Items.INGOTS.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack){
		return super.getUnlocalizedName() + "." + par1ItemStack.getItemDamage();
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register){
		 iconArray = new IIcon[Names.Items.INGOTS.length];
	        for (int i = 0; i < iconArray.length; i++) {
	        	  iconArray[i] = register.registerIcon(Reference.MOD_ID + ":ingots/" + Names.Items.INGOTS[i]);
	        }
	}
	
	 @Override
	 @SideOnly(Side.CLIENT)
	  public IIcon getIconFromDamage(int par1) {
	       return par1 < iconArray.length ? iconArray[par1] : iconArray[0];
	  }

}
