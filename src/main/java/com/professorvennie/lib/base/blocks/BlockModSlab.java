package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.items.itemblock.ItemModSlab;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by ProfessorVennie on 8/5/2014 at 5:03 PM.
 */
public abstract class BlockModSlab extends BlockSlab {

    private boolean isFull;
    private String name;

    public BlockModSlab(String name, boolean isFull) {
        super(isFull, Material.gourd);
        this.isFull = isFull;
        this.name = name;
        useNeighborBrightness = true;
        if (!isFull) {
            setBlockName(name + "Half");
            setCreativeTab(MachineryCraft.tabMachineryCraft);
        } else
            setBlockName(name + "Double");
    }

    public void register() {
        GameRegistry.registerBlock(this, ItemModSlab.class, getUnlocalizedName());
    }

    @Override
    public String func_150002_b(int p_150002_1_) {
        return name;
    }

    @Override
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemFromBlock(getBlockHalf());
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(getBlockHalf());
    }

    public abstract BlockSlab getBlockHalf();

    public abstract BlockSlab getBlockDouble();
}
