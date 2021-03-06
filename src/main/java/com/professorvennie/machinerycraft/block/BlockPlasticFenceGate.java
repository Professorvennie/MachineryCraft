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

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;

/**
 * Created by ProfessorVennie on 7/31/2014 at 10:54 AM.
 */
public class BlockPlasticFenceGate extends BlockFenceGate {

    public BlockPlasticFenceGate() {
        setBlockName(Names.Blocks.PLASTIC_FENCE_GATE);
        setBlockTextureName(Reference.MOD_ID + ":plasticPlanks");
        setCreativeTab(MachineryCraft.tabMachineryCraft);
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return ModBlocks.plasticPlanks.getBlockTextureFromSide(p_149691_1_);
    }
}
