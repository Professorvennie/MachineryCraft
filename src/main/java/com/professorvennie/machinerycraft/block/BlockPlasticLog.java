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
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockPlasticLog extends BlockLog {

    public BlockPlasticLog() {
        super();
        this.setHardness(1.5F);
        //this.setHarvestLevel("axe", 0);
        this.setStepSound(Block.soundTypeWood);
        this.setCreativeTab(MachineryCraft.tabMachineryCraft);
        this.setUnlocalizedName(Names.Blocks.BLOCK_LOG);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 1;
    }



    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List blockList) {
        blockList.add(new ItemStack(item, 1, 0));
    }
}