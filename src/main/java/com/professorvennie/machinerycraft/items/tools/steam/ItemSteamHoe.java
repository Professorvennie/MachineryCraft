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
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by ProfessorVennie on 10/4/2014 at 12:29 PM.
 */
public class ItemSteamHoe extends ItemHoe implements ISteamPoweredItem {

    private int capacity, steamPerUse;

    public ItemSteamHoe(String name, int capacity, int steamPerUse) {
        super(/*EnumHelper.addToolMaterial("SteamHoe", 3, 2, 14.0f, -1.0f, 10)*/ToolMaterial.EMERALD);
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setUnlocalizedName(name);
        this.capacity = capacity;
        this.steamPerUse = steamPerUse;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
        return true;
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_175151_a(pos.offset(side), side, stack)){
            return false;
        }
        else {
            if (stack.getTagCompound().getInteger("Steam") > 0) {
                if (stack.getTagCompound().getInteger("Steam") - steamPerUse >= 0) {
                    IBlockState iblockstate = worldIn.getBlockState(pos);
                    Block block = iblockstate.getBlock();

                    if (side != EnumFacing.DOWN && worldIn.getBlockState(pos.offsetUp()).getBlock().getMaterial() == Material.air) {
                        if (block == Blocks.grass) {
                            return this.func_179232_a(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                        }

                        if (block == Blocks.dirt) {
                            switch (SwitchDirtType.field_179590_a[((BlockDirt.DirtType) iblockstate.getValue(BlockDirt.VARIANT)).ordinal()]) {
                                case 1:
                                    return this.func_179232_a(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                                case 2:
                                    return this.func_179232_a(stack, playerIn, worldIn, pos, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return false;
    }

    protected boolean func_179232_a(ItemStack itemStack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), state.getBlock().stepSound.getStepSound(), (state.getBlock().stepSound.getVolume() + 1.0F) / 2.0F, state.getBlock().stepSound.getFrequency() * 0.8F);

        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(pos, state);
            itemStack.getTagCompound().setInteger("Steam", itemStack.getTagCompound().getInteger("Steam") - steamPerUse);
            return true;
        }
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

    static final class SwitchDirtType{
        static final int[] field_179590_a = new int[BlockDirt.DirtType.values().length];
        private static final String __OBFID = "CL_00002179";

        static
        {
            try
            {
                field_179590_a[BlockDirt.DirtType.DIRT.ordinal()] = 1;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_179590_a[BlockDirt.DirtType.COARSE_DIRT.ordinal()] = 2;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
