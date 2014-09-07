/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.main.helpers;

import com.professorvennie.machinerycraft.core.lib.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

/**
 * @author Pahimar
 */
public class NBTHelper {

    public static boolean hasTag(ItemStack itemStack, String keyName){
        return itemStack != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(keyName);
    }

    public static boolean hasUUID(ItemStack itemStack){
        return hasTag(itemStack, Names.NBT.UUID_MOST_SIG) && hasTag(itemStack, Names.NBT.UUID_LEAST_SIG);
    }

    public static void setUUID(ItemStack itemStack){
        initNBT(itemStack);

        if(!hasTag(itemStack, Names.NBT.UUID_MOST_SIG) && !hasTag(itemStack, Names.NBT.UUID_LEAST_SIG)){
            UUID uuid = UUID.randomUUID();
            setLong(itemStack, Names.NBT.UUID_MOST_SIG, uuid.getMostSignificantBits());
            setLong(itemStack, Names.NBT.UUID_LEAST_SIG, uuid.getLeastSignificantBits());
        }
    }

    public static void initNBT(ItemStack itemStack){
        if(itemStack.stackTagCompound == null){
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static void setLong(ItemStack itemStack, String keyName, long keyValue){
        initNBT(itemStack);

        itemStack.stackTagCompound.setLong(keyName, keyValue);
    }
}
