package com.professorvennie.machinerycraft.core.block;

import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.main.MachineryCraft;
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
