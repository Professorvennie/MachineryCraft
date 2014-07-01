package com.professorvennie.core.block;

import com.professorvennie.core.main.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block{

    private static String Name;

    public BlockMod(Material mat, String name) {
        super(mat);
        setBlockName(name);
        setCreativeTab(MainRegistry.tabMachineryCraft);
        setBlockTextureName(name);
        Name = name;
    }
}
