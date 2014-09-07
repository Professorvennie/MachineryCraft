/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.item;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.MachineryCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.lib.LibGuiIds;

public class ItemBook extends ItemBase {
	
	public ItemBook(){
		super(Names.Items.BOOK);
        setTextureName(Reference.MOD_ID + ":manual");
	}

    @Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(player.isSneaking()) {
			Block block = world.getBlock(par4, par5, par6);
			if(block != null && block instanceof IBookable) {
				BookEntry entry = ((IBookable) block).getEntry(world, par4, par5, par6, player, itemStack);
				if(entry != null) {
					MachineryCraft.proxy.setEntryToOpen(entry);
					player.openGui(MachineryCraft.instance, LibGuiIds.GUIID_BOOK, world, 0, 0, 0);
					return true;
				}
			}
		}

		return false;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.openGui(MachineryCraft.instance, LibGuiIds.GUIID_BOOK, world, 0, 0, 0);
		return itemStack;
	}
	
	public EnumRarity getRarity(ItemStack itemstack){
		return EnumRarity.uncommon;
	}

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack){
        return true;
    }
}
