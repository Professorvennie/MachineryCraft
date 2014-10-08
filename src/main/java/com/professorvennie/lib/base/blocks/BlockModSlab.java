package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.items.itemblock.ItemModSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:03 PM.
 */
public abstract class BlockModSlab extends BlockSlab {

    public boolean isFull;
    public String name;

    public BlockModSlab(String name, boolean isFull) {
        super(Material.gourd);
        this.isFull = isFull;
        this.name = name;
        useNeighborBrightness = true;
        if (!isFull) {
            setUnlocalizedName(name + "Half");
            setCreativeTab(MachineryCraft.tabMachineryCraft);
        } else
            setUnlocalizedName(name + "Double");
    }

    public void register() {
        GameRegistry.registerBlock(this, ItemModSlab.class, getUnlocalizedName());
    }

    @Override
    public Item getItem(World worldIn, BlockPos pos) {
        return Item.getItemFromBlock(getBlockHalf());
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(getBlockHalf());
    }

    @Override
    public String getFullSlabName(int p_150002_1_) {
        return name;
    }

    @Override
    public boolean isDouble() {
        return isFull;
    }

    public abstract BlockSlab getBlockHalf();

    public abstract BlockSlab getBlockDouble();
}
