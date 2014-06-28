/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item;

import com.professorvennie.core.lib.ItemNames;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.api.book.IBookable;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.main.MainRegistry;

public class ItemBook extends Item {
	
	public ItemBook(){
		this.setCreativeTab(MainRegistry.tabMachineryCraft);
		this.setUnlocalizedName(ItemNames.BOOK);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par2EntityPlayer.isSneaking()) {
			Block block = par3World.getBlock(par4, par5, par6);

			if(block != null && block instanceof IBookable) {
				BookEntry entry = ((IBookable) block).getEntry(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
				if(entry != null) {
					MainRegistry.proxy.setEntryToOpen(entry);
					par2EntityPlayer.openGui(MainRegistry.instance, LibGuiIds.GUIID_BOOK, par3World, 0, 0, 0);
					return true;
				}
			}
		}

		return false;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(isMessageForced(par1ItemStack)) {
			MainRegistry.proxy.setEntryToOpen(BookData.basics);
		}
		par3EntityPlayer.openGui(MainRegistry.instance, LibGuiIds.GUIID_BOOK, par2World, 0, 0, 0);
		return par1ItemStack;
	}
	private static final String TAG_FORCED_MESSAGE = "forcedMessage";
	public static boolean isMessageForced(ItemStack stack) {
		return getBoolean(stack, TAG_FORCED_MESSAGE, false);
	}
	
	public static boolean verifyExistance(ItemStack stack, String tag) {
		return getNBT(stack).hasKey(tag);
	}

	public static boolean getBoolean(ItemStack stack, String tag, boolean defaultExpected) {
		return verifyExistance(stack, tag) ? getNBT(stack).getBoolean(tag) : defaultExpected;
	}
	
	public static void injectNBT(ItemStack stack, NBTTagCompound nbt) {
		stack.setTagCompound(nbt);
	}

	/** Gets the NBTTagCompound in an ItemStack. Tries to init it
	 * previously in case there isn't one present **/
	public static NBTTagCompound getNBT(ItemStack stack) {
		initNBT(stack);
		return stack.getTagCompound();
	}
	
	public static boolean detectNBT(ItemStack stack) {
		return stack.hasTagCompound();
	}

	/** Tries to initialize an NBT Tag Compound in an ItemStack,
	 * this will not do anything if the stack already has a tag
	 * compound **/
	public static void initNBT(ItemStack stack) {
		if(!detectNBT(stack))
			injectNBT(stack, new NBTTagCompound());
	}
	
	public EnumRarity getRarity(ItemStack itemstack){
		return EnumRarity.uncommon;
	}

    @SideOnly(Side.CLIENT)
    @Deprecated
    public boolean hasEffect(ItemStack itemStack)
    {
        return true;
    }

}
