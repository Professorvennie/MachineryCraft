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
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by ProfessorVennie on 8/5/2014 at 9:03 PM.
 */
public class BlockMetalWalls extends BlockWall {

    public static final PropertyEnum METALS = PropertyEnum.create("metal", BlockMetals.EnumMetals.class);

    public BlockMetalWalls() {
        super(ModBlocks.BlockMetals);
        this.setDefaultState(this.blockState.getBaseState().withProperty(METALS, BlockMetals.EnumMetals.COPPER));
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName("wall");
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        BlockMetals.EnumMetals[] enumMetalses = BlockMetals.EnumMetals.values();
        int i = enumMetalses.length;

        for (int j = 0; j < i; ++j){
            BlockMetals.EnumMetals enumdyecolor = enumMetalses[j];
            list.add(new ItemStack(item, 1, enumdyecolor.getMeta()));
        }
    }

    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(METALS, BlockMetals.EnumMetals.getEnumFromMeta(meta));
    }

    public int getMetaFromState(IBlockState state){
        return ((BlockMetals.EnumMetals)state.getValue(METALS)).getMeta();
    }

    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {METALS});
    }

    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockMetals.EnumMetals)state.getValue(METALS)).getMeta();
    }
}
