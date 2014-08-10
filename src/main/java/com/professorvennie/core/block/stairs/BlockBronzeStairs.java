package com.professorvennie.core.block.stairs;

import com.professorvennie.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by ProfessorVennie on 8/5/2014 at 4:42 PM.
 */
public class BlockBronzeStairs extends BlockModStair {

    public BlockBronzeStairs(Block blockMetals, String name) {
        super(blockMetals, name);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "ores/" + "blockBronze");
    }
}
