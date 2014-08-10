package com.professorvennie.core.block.stairs;

import com.professorvennie.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by ProfessorVennie on 8/5/2014 at 4:46 PM.
 */
public class BlockZincStairs extends BlockModStair {

    public BlockZincStairs(Block blockMetals, String zincStairs) {
        super(blockMetals, zincStairs);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "ores/" + "blockZinc");
    }
}
