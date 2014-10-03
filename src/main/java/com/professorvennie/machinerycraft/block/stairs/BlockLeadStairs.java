package com.professorvennie.machinerycraft.block.stairs;

import com.professorvennie.lib.base.blocks.BlockModStair;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by ProfessorVennie on 8/5/2014 at 4:44 PM.
 */
public class BlockLeadStairs extends BlockModStair {

    public BlockLeadStairs(Block blockMetals, String leadStairs) {
        super(blockMetals, leadStairs);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "ores/" + "blockLead");
    }
}
