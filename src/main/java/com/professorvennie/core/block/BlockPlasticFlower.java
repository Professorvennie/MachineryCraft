/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockPlasticFlower extends BlockFlower{

    @SideOnly(Side.CLIENT)
    private IIcon field_149861_N;

    public BlockPlasticFlower() {
        super(0);
        setBlockName(Names.Blocks.BLOCK_PLASTIC_FLOWER);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
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

    protected boolean canPlaceBlockOn(Block block){
        return block == ModBlocks.plasticDirt || block == ModBlocks.plasticGrass || block == Blocks.dirt || block == Blocks.glass;
    }
}
