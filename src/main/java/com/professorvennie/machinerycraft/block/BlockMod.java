package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.MachineryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMod extends Block{

    private static String Name;

    public BlockMod(Material mat, String name) {
        super(mat);
        setBlockName(name);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setBlockTextureName(Reference.MOD_ID + ":" + name);
        Name = name;
    }
}
