package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.core.helpers.NBTHelper;
import com.professorvennie.lib.base.items.ItemBase;
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
 * Created by ProfessorVennie on 9/23/2014 at 4:45 PM.
 */
public class ItemPowered extends ItemBase {

    private int capacity;

    public ItemPowered(String name, int capacity) {
        super(name);
        this.capacity = capacity;
        hasSubtypes = true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b) {
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)){
            list.add(itemStack.stackTagCompound.getInteger("Power") + "/" + capacity + " Jewels");
        }else
            list.add("Hold " + EnumChatFormatting.BLUE + "Shift" + EnumChatFormatting.GRAY + " for more information");
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack zero = new ItemStack(item, 1, 1);
        if(zero.stackTagCompound == null){
            zero.setTagCompound(new NBTTagCompound());
            zero.stackTagCompound.setInteger("Power", 0);
        }
        list.add(zero);

        ItemStack full = new ItemStack(item, 1, capacity);
        if(full.stackTagCompound == null){
            full.setTagCompound(new NBTTagCompound());
            full.stackTagCompound.setInteger("Power", capacity);
        }
        list.add(full);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 1 + capacity;
    }

    @Override
    public int getDisplayDamage(ItemStack stack) {
        if(stack.stackTagCompound == null) return 1 + capacity;

        return 1 + capacity - stack.stackTagCompound.getInteger("Power");
    }

    @Override
    public boolean isDamaged(ItemStack stack) {
        return true;
    }
}