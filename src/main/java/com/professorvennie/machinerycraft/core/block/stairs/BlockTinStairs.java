package com.professorvennie.machinerycraft.core.block.stairs;


import com.professorvennie.machinerycraft.core.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by ProfessorVennie on 8/5/2014 at 3:50 PM.
 */
public class BlockTinStairs extends BlockModStair {

    public BlockTinStairs(Block block , String tinStairs) {
        super(block, tinStairs);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "ores/" + "blockTin");
    }
}
