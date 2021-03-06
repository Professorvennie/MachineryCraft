package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.api.steam.ISteamPoweredItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by ProfessorVennie on 10/3/2014 at 9:53 PM.
 */
public class ItemSteamPowered extends ItemBase implements ISteamPoweredItem {

    private int capacity;
    private boolean canExtract = true, canReceive;

    public ItemSteamPowered(String name, int capacity) {
        super(name);
        this.hasSubtypes = true;
        this.capacity = capacity;
    }

    @Override
    public int getSteamCapacity() {
        return capacity;
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
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            list.add(itemStack.stackTagCompound.getInteger("Steam") + "/" + capacity + " mb");
        } else
            list.add("Hold " + EnumChatFormatting.BLUE + "Shift" + EnumChatFormatting.GRAY + " for more information");
    }

    public Item setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
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
    public void receiveSteam(ItemStack itemStack, int amount) {

    }

    @Override
    public void extractSteam(ItemStack itemStack, int amount) {

    }

    @Override
    public boolean canExtract() {
        return canExtract;
    }

    @Override
    public boolean canReceive() {
        return canReceive;
    }

    public Item setCanReceive(boolean canReceive) {
        this.canReceive = canReceive;
        return this;
    }

    public Item setCanExtract(boolean canExtract) {
        this.canExtract = canExtract;
        return this;
    }
}
