/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.plugins.codechicken.fmp;

import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import com.professorvennie.machinerycraft.block.ModBlocks;
import net.minecraft.block.Block;

/**
 * Created by ProfessorVennie on 8/6/2014 at 6:39 PM.
 */
public class MultiPartHandler {

    public MultiPartHandler(){
        registerMultiPartMetadataLine(ModBlocks.BlockMetals, 7);
        registerMultiPartMetadataLine(ModBlocks.BlockOres, 5);
        registerMultiPart(ModBlocks.plasticLog, 0);
        registerMultiPart(ModBlocks.plasticPlanks, 0);
        registerMultiPart(ModBlocks.plasticDirt, 0);
        registerMultiPart(ModBlocks.plasticGrass, 0);
        registerMultiPart(ModBlocks.plasticLeaf, 0);
    }

    private static void registerMultiPartMetadataLine(Block block, int maxMeta){
        for(int i = 0; i < maxMeta; i++)
            registerMultiPart(block, i);
    }

    private static void registerMultiPart(Block block, int meta) {
        MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block, meta), block.getUnlocalizedName() + (meta == 0 ? "" : "_" + meta));
    }
}
