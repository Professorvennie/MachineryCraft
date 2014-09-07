/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.client.gui.pages;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IRecipeKeyProvider;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class BookRecipeMappings {

    private static Map<String, EntryData> mappings = new HashMap();

    /**
     * Maps the given stack to the given page of the entry.
     */
    public static void map(ItemStack stack, BookEntry entry, int page, boolean force) {
        EntryData data = new EntryData(entry, page);
        String str = stackToString(stack);

        if (force || !mappings.containsKey(str))
            mappings.put(str, data);
    }

    public static void map(ItemStack stack, BookEntry entry, int page) {
        map(stack, entry, page, false);
    }


    public static EntryData getDataForStack(ItemStack stack) {
        return mappings.get(stackToString(stack));
    }

    public static String stackToString(ItemStack stack) {
        if (stack.hasTagCompound() && stack.getItem() instanceof IRecipeKeyProvider)
            return ((IRecipeKeyProvider) stack.getItem()).getKey(stack);

        return stack.getUnlocalizedName() + "~" + stack.getItemDamage();
    }

    public static class EntryData {

        public final BookEntry entry;
        public final int page;

        public EntryData(BookEntry entry, int page) {
            this.entry = entry;
            this.page = page;
        }

    }

}
