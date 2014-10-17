package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.items.itemblock.ItemBlockMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ProfessorVennie on 8/5/2014 at 3:40 PM.
 */
public class BlockModStair extends BlockStairs {

    private Block source;
    private String name;

    public BlockModStair(Block block, String name) {
        super(block.getDefaultState());
        this.source = block;
        this.name = name;
        setUnlocalizedName(name);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        useNeighborBrightness = true;
        this.setHardness(3.5f);
        //this.setHarvestLevel("pickAxe", 2);
        setResistance(2.0f);
        setStepSound(Block.soundTypeMetal);
    }

    public BlockModStair(Item item, String name) {
        this(Block.getBlockFromItem(item), name);
    }

    public BlockModStair(ItemStack itemStack, String name) {
        this(itemStack.getItem(), name);
    }

    @Override
    public Block setUnlocalizedName(String name) {
        //GameRegistry.registerBlock(this, ItemBlockMod.class, name);
        return super.setUnlocalizedName(name);
    }
}

