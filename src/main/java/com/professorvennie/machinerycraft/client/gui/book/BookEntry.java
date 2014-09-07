/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client.gui.book;

import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.api.book.BookCategory;
import com.professorvennie.machinerycraft.api.book.BookPage;

public class BookEntry extends com.professorvennie.machinerycraft.api.book.BookEntry {

    public BookEntry(String unlocalizedName, BookCategory category) {
        super(unlocalizedName, category);
        MachineryCraftAPI.addEntry(this, category);
    }

    @Override
    public com.professorvennie.machinerycraft.api.book.BookEntry setBookPages(BookPage... pages) {
        for (BookPage page : pages)
            page.unlocalizedName = "mc.page." + getLazyUnlocalizedName() + page.unlocalizedName;

        return super.setBookPages(pages);
    }

    @Override
    public String getUnlocalizedName() {
        return "mc.entry." + super.getUnlocalizedName();
    }

    public String getLazyUnlocalizedName() {
        return super.getUnlocalizedName();
    }
}
