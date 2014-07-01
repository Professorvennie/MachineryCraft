package com.professorvennie.core.block;

import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockPlasticFlower extends BlockFlower{

    @SideOnly(Side.CLIENT)
    private IIcon field_149861_N;

    public BlockPlasticFlower() {
        super(0);
        setBlockName(BlockNames.BLOCK_PLASTIC_FLOWER);
        setCreativeTab(MainRegistry.tabMachineryCraft);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        field_149861_N = iconRegister.registerIcon(Reference.MOD_ID + ":plasticFlower");
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        list.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_){
        return this.field_149861_N;
    }
}
