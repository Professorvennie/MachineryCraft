package com.professorvennie.core.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.professorvennie.core.lib.*;
import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOres extends Block {
	
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

	protected BlockOres(Material mat) {
		super(mat);
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
		this.setBlockName("ore");
		this.setHardness(3.5f);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
    public Block setBlockName(String string) {
        return super.setBlockName(string);
    }
	
	 	@Override
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister register) {
	        iconArray = new IIcon[LibNames.BlockOres.length];
	        for (int i = 0; i < iconArray.length; i++) {
	            iconArray[i] = register.registerIcon(LibStrings.MODID + ":ores/" + "ore" + "_" + i);
	        }
	    }
	
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
    	for(int i = 0; i < 4; i++){
            list.add(new ItemStack(item, 1, i));
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.iconArray[meta % this.iconArray.length];
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public int getDamageValue(World world, int x, int y, int z) {
        return this.damageDropped(world.getBlockMetadata(x, y, z));
    }


public static class ItemBlockOres extends ItemBlock {

    public ItemBlockOres(Block p_i45328_1_) {
        super(p_i45328_1_);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int par1) {
        return par1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return this.field_150939_a.getIcon(0, par1);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < LibNames.BlockOres.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "." + stack.getItemDamage();
    }

	}
}
