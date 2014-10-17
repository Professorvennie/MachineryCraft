package com.professorvennie.lib.base.blocks;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

    public BlockBase(Material mat, String name) {
        super(mat);
        setUnlocalizedName(name);
            if (shouldRegisterInTab(0))
            setCreativeTab(MachineryCraft.tabMachineryCraft);
    }

    public boolean shouldRegisterInTab(int meta) {
        return true;
    }
}
