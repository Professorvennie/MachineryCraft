package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.item.itemblock.ItemBlockMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * Created by ProfessorVennie on 8/5/2014 at 3:40 PM.
 */
public class BlockModStair extends BlockStairs {

    protected IIcon iIcon;
    private Block source;
    private String name;

    public BlockModStair(Block block, String name) {
        super(block, 0);
        this.source = block;
        this.name = name;
        setBlockName(name);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        useNeighborBrightness = true;
        this.setHardness(3.5f);
        this.setHarvestLevel("pickAxe", 2);
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
    public Block setBlockName(String name) {
        GameRegistry.registerBlock(this, ItemBlockMod.class, name);
        return super.setBlockName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return iIcon;
    }
}

