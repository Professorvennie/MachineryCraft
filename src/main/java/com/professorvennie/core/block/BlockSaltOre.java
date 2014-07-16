/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block;

import java.util.Random;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.api.book.IBookable;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockSaltOre extends Block implements IBookable{

	protected BlockSaltOre() {
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setBlockName(Names.Blocks.SALTORE);
		this.setCreativeTab(MachineryCraft.tabMachineryCraft);
		setHardness(2.0f);
		setResistance(2.0f);
		setStepSound(Block.soundTypeStone);
		setBlockTextureName(Reference.MOD_ID + ":saltore");
	}
	
    public int quantityDropped(Random random)
    {
    	int random1 = new Random().nextInt(6);
        return random1;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_){
        return (ModItems.saltcyrstals);
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
