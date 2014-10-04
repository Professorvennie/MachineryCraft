package com.professorvennie.lib.base.items.tools;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.steam.ISteamPoweredItem;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by ProfessorVennie on 10/4/2014 at 12:29 PM.
 */
public class ItemSteamHoe extends ItemHoe implements ISteamPoweredItem {

    private int capacity, steamPerUse;

    public ItemSteamHoe(String name, int capacity, int steamPerUse) {
        super(EnumHelper.addToolMaterial("Steam", 3, 2, 14.0f, 4.0f, 10));
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setUnlocalizedName(name);
        this.capacity = capacity;
        this.steamPerUse = steamPerUse;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
        if (itemStack.stackTagCompound != null) {
            if (itemStack.stackTagCompound.getInteger("Steam") - steamPerUse >= 0) {
                itemStack.stackTagCompound.setInteger("Steam", itemStack.stackTagCompound.getInteger("Steam") - steamPerUse);
                return true;
            } else
                return false;
        } else
            return false;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int i, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!player.canPlayerEdit(x, y, z, i, itemStack)) {
            return false;
        } else {
            if (itemStack.stackTagCompound != null) {
                if (itemStack.stackTagCompound.getInteger("Steam") > 0) {
                    if (itemStack.stackTagCompound.getInteger("Steam") - steamPerUse >= 0) {
                        UseHoeEvent event = new UseHoeEvent(player, itemStack, world, x, y, z);
                        if (MinecraftForge.EVENT_BUS.post(event)) {
                            return false;
                        }

                        if (event.getResult() == Event.Result.ALLOW) {
                            itemStack.stackTagCompound.setInteger("Steam", itemStack.stackTagCompound.getInteger("Steam") - steamPerUse);
                            return true;
                        }

                        Block block = world.getBlock(x, y, z);

                        if (i != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt)) {
                            Block block1 = Blocks.farmland;
                            world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                            if (world.isRemote) {
                                return true;
                            } else {
                                world.setBlock(x, y, z, block1);
                                itemStack.stackTagCompound.setInteger("Steam", itemStack.stackTagCompound.getInteger("Steam") - steamPerUse);
                                return true;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemStack, int X, int Y, int Z, EntityPlayer player) {
        if (itemStack.stackTagCompound != null) {
            if (itemStack.stackTagCompound.getInteger("Steam") > 0) {
                if (itemStack.stackTagCompound.getInteger("Steam") - steamPerUse >= 0) {
                    return false;
                } else
                    return true;
            } else
                return true;
        } else
            return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
        if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) {
            if (itemStack.stackTagCompound != null) {
                if (itemStack.stackTagCompound.getInteger("Steam") - steamPerUse >= 0) {
                    itemStack.stackTagCompound.setInteger("Steam", itemStack.stackTagCompound.getInteger("Steam") - steamPerUse);
                    return true;
                } else
                    return false;
            } else
                return false;
        }
        return false;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            list.add("Steam per use: " + steamPerUse + " mb");
            list.add(itemStack.stackTagCompound.getInteger("Steam") + "/" + capacity + " mb");
        } else
            list.add("Hold " + EnumChatFormatting.BLUE + "Shift" + EnumChatFormatting.GRAY + " for more information");
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack zero = new ItemStack(item, 1, 1);
        if (zero.stackTagCompound == null) {
            zero.setTagCompound(new NBTTagCompound());
            zero.stackTagCompound.setInteger("Steam", 0);
        }
        list.add(zero);

        ItemStack full = new ItemStack(item, 1, capacity);
        if (full.stackTagCompound == null) {
            full.setTagCompound(new NBTTagCompound());
            full.stackTagCompound.setInteger("Steam", capacity);
        }
        list.add(full);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 1 + capacity;
    }

    @Override
    public int getDisplayDamage(ItemStack stack) {
        if (stack.stackTagCompound == null) return 1 + capacity;

        return 1 + capacity - stack.stackTagCompound.getInteger("Steam");
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return true;
    }

    @Override
    public int getSteamCapacity() {
        return capacity;
    }

    @Override
    public void receiveSteam(ItemStack itemStack, int amount) {
        if (itemStack.stackTagCompound != null) {
            if (itemStack.stackTagCompound.getInteger("Steam") + amount <= capacity) {
                itemStack.stackTagCompound.setInteger("Steam", itemStack.stackTagCompound.getInteger("Steam") + amount);
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
