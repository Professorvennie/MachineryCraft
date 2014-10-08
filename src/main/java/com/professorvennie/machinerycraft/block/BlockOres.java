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
import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.lib.Names;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockOres extends BlockBase implements IBookable {

    public static final PropertyEnum ORES = PropertyEnum.create("ore", EnumOres.class);

    protected BlockOres() {
        super(Material.rock, "ore");
        this.setHardness(3.5f);
        //this.setHarvestLevel("pickAxe", 2);
        setStepSound(Block.soundTypeStone);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        EnumOres[] enumOreses = EnumOres.values();
        int i = enumOreses.length;

        for (int j = 0; j < i; ++j){
            EnumOres enumdyecolor = enumOreses[j];
            list.add(new ItemStack(item, 1, enumdyecolor.getMeta()));
        }
    }

    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(ORES, EnumOres.getEnumFromMeta(meta));
    }

    public int getMetaFromState(IBlockState state){
        return ((EnumOres)state.getValue(ORES)).getMeta();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {ORES});
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumOres)state.getValue(ORES)).getMeta();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
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


        @SuppressWarnings({"unchecked", "rawtypes"})
        @Override
        @SideOnly(Side.CLIENT)
        public void getSubItems(Item item, CreativeTabs tab, List list) {
            for (int i = 0; i < Names.Blocks.ORES.length; i++) {
                list.add(new ItemStack(item, 1, i));
            }
        }

        @Override
        public String getUnlocalizedName(ItemStack stack) {
            return this.getUnlocalizedName() + "." + stack.getItemDamage();
        }
    }

    public static enum EnumOres implements IStringSerializable {

        COPPER(0, "copper"),
        TIN(1, "tin"),
        SILVER(2, "silver"),
        LEAD(3, "lead"),
        ZINC(4, "zinc");

        private int meta;
        private String name;
        private static EnumOres[] ORES = new EnumOres[values().length];

        private EnumOres(int meta, String name){
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

        public static EnumOres getEnumFromMeta(int meta){
            if (meta < 0 || meta >= ORES.length)
                meta = 0;

            return ORES[meta];
        }

        static{
            EnumOres[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2) {
                EnumOres var3 = var0[var2];
                ORES[var3.getMeta()] = var3;
            }
        }
    }
}
