package com.professorvennie.core.main.plugins.fmp;

import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import com.professorvennie.core.block.ModBlocks;
import net.minecraft.block.Block;

/**
 * Created by ProfessorVennie on 8/6/2014 at 6:39 PM.
 */
public class MultiPartHandler {

    public MultiPartHandler(){
        registerMultiPartMetadataLine(ModBlocks.BlockMetals, 6);
        registerMultiPartMetadataLine(ModBlocks.BlockOres, 4);
        registerMultiPart(ModBlocks.plasticLog, 0);
        registerMultiPart(ModBlocks.plasticPlanks, 0);
        registerMultiPart(ModBlocks.plasticDirt, 0);
        registerMultiPart(ModBlocks.plasticGrass, 0);
    }

    private static void registerMultiPartMetadataLine(Block block, int maxMeta){
        for(int i = 0; i < maxMeta; i++)
            registerMultiPart(block, i);
    }

    private static void registerMultiPart(Block block, int meta) {
        MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block, meta), block.getUnlocalizedName() + (meta == 0 ? "" : "_" + meta));
    }
}
