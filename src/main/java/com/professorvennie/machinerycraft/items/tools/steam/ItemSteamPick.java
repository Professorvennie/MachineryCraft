/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.items.tools.steam;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.steam.ISteamPoweredItem;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by ProfessorVennie on 10/4/2014 at 11:33 AM.
 */
public class ItemSteamPick extends ItemPickaxe implements ISteamPoweredItem {

    private int capacity, steamPerUse;

    public ItemSteamPick(String name, int capacity, int steamPerUse) {
        super(/*EnumHelper.addToolMaterial("SteamPick", 3, 2, 14.0f, -1.0f, 10)*/ToolMaterial.EMERALD);
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setUnlocalizedName(name);
        this.capacity = capacity;
        this.steamPerUse = steamPerUse;
    }

    public ItemSteamPick(ToolMaterial material, String name, int capacity, int steamPerUse) {
        super(material);
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setUnlocalizedName(name);
        this.capacity = capacity;
        this.steamPerUse = steamPerUse;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
        return true;
    }

   /* @Override
    public boolean onBlockStartBreak(ItemStack itemStack, int X, int Y, int Z, EntityPlayer player) {
        if (itemStack.getTagCompound() != null) {
            if (itemStack.getTagCompound().getInteger("Steam") > 0) {
                if (itemStack.getTagCompound().getInteger("Steam") - steamPerUse >= 0) {
                    return false;
                } else
                    return true;
            } else
                return true;
        } else
            return true;
    }*/

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, BlockPos pos, EntityLivingBase entityLivingBase) {
        if ((double) block.getBlockHardness(world, pos) != 0.0D) {
            if (itemStack.getTagCompound() != null) {
                if (itemStack.getTagCompound().getInteger("Steam") - steamPerUse >= 0) {
                    itemStack.getTagCompound().setInteger("Steam", itemStack.getTagCompound().getInteger("Steam") - steamPerUse);
                    return true;
                } else
                    return false;
            } else
                return false;
        }
        return false;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            list.add("Steam per use: " + steamPerUse + " mb");
            list.add(itemStack.getTagCompound().getInteger("Steam") + "/" + capacity + " mb");
        } else
            list.add("Hold " + EnumChatFormatting.BLUE + "Shift" + EnumChatFormatting.GRAY + " for more information");
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack zero = new ItemStack(item, 1, 1);
        if (zero.getTagCompound() == null) {
            zero.setTagCompound(new NBTTagCompound());
            zero.getTagCompound().setInteger("Steam", 0);
        }
        list.add(zero);

        ItemStack full = new ItemStack(item, 1, capacity);
        if (full.getTagCompound() == null) {
            full.setTagCompound(new NBTTagCompound());
            full.getTagCompound().setInteger("Steam", capacity);
        }
        list.add(full);
    }

    @Override
    public int getMaxDamage() {
        return 1 + capacity;
    }

    /*@Override
    public int getDisplayDamage(ItemStack stack) {
        if (stack.getTagCompound() == null) return 1 + capacity;

        return 1 + capacity - stack.getTagCompound().getInteger("Steam");
    }*/

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public int getSteamCapacity() {
        return capacity;
    }

    @Override
    public void receiveSteam(ItemStack itemStack, int amount) {
        if (itemStack.getTagCompound() != null) {
            if (itemStack.getTagCompound().getInteger("Steam") + amount <= capacity) {
                itemStack.getTagCompound().setInteger("Steam", itemStack.getTagCompound().getInteger("Steam") + amount);
            }
        }
    }

    @Override
    public void extractSteam(ItemStack itemStack, int amount) {
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
