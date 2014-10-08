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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockMetals extends BlockBase {

    public static final PropertyEnum METALS = PropertyEnum.create("metal", EnumMetals.class);

    protected BlockMetals() {
        super(Material.iron, "metal");
        this.setDefaultState(this.blockState.getBaseState().withProperty(METALS, EnumMetals.COPPER));
        this.setHardness(3.5f);
        //this.setHarvestLevel("pickAxe", 2);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundTypeMetal);
    }

    @Override
    public Block setUnlocalizedName(String string) {
        return super.setUnlocalizedName(string);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        EnumMetals[] enumMetalses = EnumMetals.values();
        int i = enumMetalses.length;

        for (int j = 0; j < i; ++j){
            EnumMetals enumdyecolor = enumMetalses[j];
            list.add(new ItemStack(item, 1, enumdyecolor.getMeta()));
        }
    }

    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(METALS, EnumMetals.getEnumFromMeta(meta));
    }

    public int getMetaFromState(IBlockState state){
        return ((EnumMetals)state.getValue(METALS)).getMeta();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {METALS});
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumMetals)state.getValue(METALS)).getMeta();
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

    public static enum EnumMetals implements IStringSerializable{

        COPPER(0, "copper"),
        TIN(1, "tin"),
        SILVER(2, "silver"),
        LEAD(3, "lead"),
        ZINC(4, "zinc"),
        BRASS(5, "brass"),
        BRONZE(6, "bronze");

        private int meta;
        private String name;
        private static EnumMetals[] METALS = new EnumMetals[values().length];

        private EnumMetals(int meta, String name){
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

        public static EnumMetals getEnumFromMeta(int meta){
            if (meta < 0 || meta >= METALS.length)
                meta = 0;

            return METALS[meta];
        }

        static{
            EnumMetals[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2) {
                EnumMetals var3 = var0[var2];
                METALS[var3.getMeta()] = var3;
            }
        }
    }
}

