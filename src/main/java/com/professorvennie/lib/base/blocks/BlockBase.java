package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    private static String Name;

    public BlockBase(Material mat, String name) {
        super(mat);
        setBlockName(name);
        if (shouldRegisterInTab(0))
            setCreativeTab(MachineryCraft.tabMachineryCraft);
        setBlockTextureName(Reference.MOD_ID + ":" + name);
        Name = name;
    }

    public boolean shouldRegisterInTab(int meta) {
        return true;
    }
}
