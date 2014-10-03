/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.api.book;

import java.util.ArrayList;
import java.util.List;

public class BookCategory {

    public final String unlocalizedName;
    public final List<BookEntry> entries = new ArrayList<BookEntry>();

    /**
     * @param unlocalizedName
     */
    public BookCategory(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public String getUnlocalizedName() {
        return unlocalizedName;
    }

}
