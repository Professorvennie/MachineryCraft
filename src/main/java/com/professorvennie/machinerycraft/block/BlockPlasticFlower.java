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
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockPlasticFlower extends BlockBush {

    public static final PropertyEnum FLOWERS = PropertyEnum.create("variant", EnumFlowers.class);

    public BlockPlasticFlower() {
        setUnlocalizedName("plasticFlower");
        this.setDefaultState(this.blockState.getBaseState().withProperty(FLOWERS, EnumFlowers.ROSE));
        setStepSound(Block.soundTypeGrass);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        EnumFlowers[] enumMetalses = EnumFlowers.values();
        int i = enumMetalses.length;

        for (int j = 0; j < i; ++j){
            EnumFlowers enumdyecolor = enumMetalses[j];
            list.add(new ItemStack(item, 1, enumdyecolor.getMeta()));
        }
    }

    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(FLOWERS, EnumFlowers.getEnumFromMeta(meta));
    }

    public int getMetaFromState(IBlockState state){
        return ((EnumFlowers)state.getValue(FLOWERS)).getMeta();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {FLOWERS});
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumFlowers)state.getValue(FLOWERS)).getMeta();
    }

    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == ModBlocks.plasticDirt || block == ModBlocks.plasticGrass || block == Blocks.dirt || block == Blocks.grass;
    }

    public static class ItemBlockFlowers extends ItemBlock {

        public ItemBlockFlowers(Block block) {
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
        public void getSubItems(Item item, CreativeTabs tab, List list) {
            for (int i = 0; i < Names.Blocks.BLOCK_PLASTIC_FLOWERS.length; i++) {
                list.add(new ItemStack(item, 1, i));
            }
        }

        @Override
        public String getUnlocalizedName(ItemStack stack) {
            return this.getUnlocalizedName() + "." + stack.getItemDamage();
        }
    }

    public static enum EnumFlowers implements IStringSerializable {

        ROSE(0, "rose"),
        DANDELION(1, "dandelion"),
        REDTULIP(2, "redTulip"),
        ORANGETULIP(3, "orangeTulip"),
        WHILTTULIP(4, "whiteTulip"),
        BLUEORCHID(5, "blueOrchid"),
        ALLIUM(6, "allium"),
        DAISY(7, "daisy");

        private int meta;
        private String name;
        private static EnumFlowers[] flowerses = new EnumFlowers[values().length];

        private EnumFlowers(int meta, String name){
            this.meta = meta;
            this.name = name;
        }

        public int getMeta() {
            return meta;
        }

        @Override
        public String getName() {
            return name;
        }

        public static EnumFlowers getEnumFromMeta(int meta){
            if (meta < 0 || meta >= flowerses.length)
                meta = 0;

            return flowerses[meta];
        }

        static{
            EnumFlowers[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2) {
                EnumFlowers var3 = var0[var2];
                flowerses[var3.getMeta()] = var3;
            }
        }
    }
}
