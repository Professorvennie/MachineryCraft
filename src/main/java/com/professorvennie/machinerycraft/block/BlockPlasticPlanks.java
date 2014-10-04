/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.lib.base.blocks.BlockBase;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPlasticPlanks extends BlockBase {

    public BlockPlasticPlanks() {
        super(Material.wood, Names.Blocks.BLOCK_PLASTIC_PLANKS);
        this.setHardness(1.5F);
        this.setHarvestLevel("axe", 0);
        setStepSound(Block.soundTypeWood);
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
        return true;
    }

    public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
        return 20;
    }

    public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
        return 5;
    }
}
