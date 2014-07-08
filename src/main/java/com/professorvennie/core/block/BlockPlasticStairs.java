/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block;

import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockPlasticStairs extends BlockStairs {

    protected BlockPlasticStairs(Block block) {
        super(block, 0);
        setBlockName("plasticStairs");
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        useNeighborBrightness = true;
        setBlockTextureName(Reference.MOD_ID + ":plasticPlanks");
    }
}
