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

import com.professorvennie.lib.base.blocks.BlockBase;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockMetals extends BlockBase {

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    protected BlockMetals() {
        super(Material.iron, "metal");
        this.setHardness(3.5f);
        this.setHarvestLevel("pickAxe", 2);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundTypeMetal);
    }

    @Override
    public Block setBlockName(String string) {
        return super.setBlockName(string);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        iconArray = new IIcon[Names.Blocks.METAL_BLOCKS.length];
        for (int i = 0; i < iconArray.length; i++) {
            iconArray[i] = register.registerIcon(Reference.MOD_ID + ":ores/" + Names.Blocks.METAL_BLOCKS[i]);
        }
    }

    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < Names.Blocks.METAL_BLOCKS.length; i++) {
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

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
    }

    public static class ItemBlockMetals extends ItemBlock {

        public ItemBlockMetals(Block block) {
            super(block);
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

        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(Item item, CreativeTabs tab, List list) {
            for (int i = 0; i < Names.Blocks.METAL_BLOCKS.length; i++) {
                list.add(new ItemStack(item, 1, i));
            }
        }

        @Override
        public String getUnlocalizedName(ItemStack stack) {
            return this.getUnlocalizedName() + "." + stack.getItemDamage();
        }
    }
}

