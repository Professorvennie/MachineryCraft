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

import com.professorvennie.core.lib.ItemNames;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;

public class ItemDusts extends Item {

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

	public ItemDusts(){
		this.setUnlocalizedName("dust");
		this.setHasSubtypes(true);
		this.setCreativeTab(MachineryCraft.tabMachineryCraft);
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

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register){
        iconArray = new IIcon[ItemNames.Dusts.length];
        for (int i = 0; i < iconArray.length; i++) {
            iconArray[i] = register.registerIcon(Reference.MOD_ID + ":" + "dust" + "_" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return par1 < iconArray.length ? iconArray[par1] : iconArray[0];
    }
}
