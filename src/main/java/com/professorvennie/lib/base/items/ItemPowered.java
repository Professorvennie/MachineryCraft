package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.api.item.IPowerdItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by ProfessorVennie on 9/23/2014 at 4:45 PM.
 */
public class ItemPowered extends ItemBase implements IPowerdItem {

    private int capacity;
    private boolean canExtract = true, canReceive = true;

    public ItemPowered(String name, int capacity) {
        super(name);
        this.capacity = capacity;
        hasSubtypes = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            list.add(itemStack.getTagCompound().getInteger("Power") + "/" + capacity + " Jewels");
        } else
            list.add("Hold " + EnumChatFormatting.BLUE + "Shift" + EnumChatFormatting.GRAY + " for more information");
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack zero = new ItemStack(item, 1, 1);
        if (zero.getTagCompound() == null) {
            zero.setTagCompound(new NBTTagCompound());
            zero.getTagCompound().setInteger("Power", 0);
        }
        list.add(zero);

        ItemStack full = new ItemStack(item, 1, capacity);
        if (full.getTagCompound() == null) {
            full.setTagCompound(new NBTTagCompound());
            full.getTagCompound().setInteger("Power", capacity);
        }
        list.add(full);
    }

    @Override
    public int getMaxDamage() {
        return 1 + capacity;
    }

   /* @Override
    public int getDisplayDamage(ItemStack stack) {
        if (stack.getTagCompound() == null) return 1 + capacity;

        return 1 + capacity - stack.getTagCompound().getInteger("Power");
    }*/

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return canExtract;
    }

    @Override
    public boolean canReceive() {
        return canReceive;
    }

    @Override
    public void transferPower() {

    }

    public Item setCanExtract(boolean canExtract) {
        this.canExtract = canExtract;
        return this;
    }

    public Item setCanReceive(boolean canReceive) {
        this.canReceive = canReceive;
        return this;
    }
}