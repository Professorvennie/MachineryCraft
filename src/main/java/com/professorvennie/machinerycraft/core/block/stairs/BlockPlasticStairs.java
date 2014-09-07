/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.block.stairs;

import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockPlasticStairs extends BlockModStair {

    public BlockPlasticStairs(Block block) {
        super(block, Names.Blocks.BLOCK_PLASTIC_STAIRS);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = iconRegister.registerIcon(Reference.MOD_ID + ":plasticPlanks");
    }
}
