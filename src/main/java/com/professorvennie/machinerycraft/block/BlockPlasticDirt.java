/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockPlasticDirt extends BlockDirt {

    public BlockPlasticDirt() {
        super();
        setBlockName(Names.Blocks.BLOCK_PLASTIC_DIRT);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setStepSound(Block.soundTypeGravel);
        setHarvestLevel("shovel", 0);
        setHardness(1.0f);
    }

    @Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName().replaceAll("tile.", "tile.machineryCraft:");
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":plasticDirt");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.blockIcon;

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int meta) {
        Material material = iBlockAccess.getBlock(x, y + 1, z).getMaterial();

        if (material == Material.snow || material == Material.craftedSnow) {
            return ModBlocks.plasticGrass.getIcon(iBlockAccess, x, y, z, meta);
        }

        Block block = iBlockAccess.getBlock(x, y + 1, z);

        if (block != ModBlocks.plasticDirt && block != ModBlocks.plasticGrass) {
            return this.blockIcon;
        }

        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(this, 1, 0));
    }
}
