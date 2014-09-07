package com.professorvennie.machinerycraft.block.stairs;

import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by ProfessorVennie on 8/5/2014 at 4:46 PM.
 */
public class BlockBrassStairs extends BlockModStair {

    public BlockBrassStairs(Block blockMetals, String brassStairs) {
        super(blockMetals, brassStairs);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "ores/" + "blockBrass");
    }
}
