package com.professorvennie.machinerycraft.core.block;

import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.main.MachineryCraft;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;

/**
 * Created by ProfessorVennie on 7/31/2014 at 10:54 AM.
 */
public class BlockPlasticFenceGate extends BlockFenceGate {

    public BlockPlasticFenceGate(){
        setBlockName(Names.Blocks.PLASTIC_FENCE_GATE);
        setBlockTextureName(Reference.MOD_ID + ":plasticPlanks");
        setCreativeTab(MachineryCraft.tabMachineryCraft);
    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return ModBlocks.plasticPlanks.getBlockTextureFromSide(p_149691_1_);
    }
}
