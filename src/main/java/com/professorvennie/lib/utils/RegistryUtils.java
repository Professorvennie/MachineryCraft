/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.lib.utils;

import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryUtils {

    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
        ModBlocks.blocks.add(block);
    }

    public static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
        ModItems.items.add(item);
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass) {
        GameRegistry.registerBlock(block, itemclass, block.getUnlocalizedName());
        ModBlocks.blocks.add(block);

    }
}
