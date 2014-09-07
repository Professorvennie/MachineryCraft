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
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.StatCollector;

public class BookEntry implements Comparable<BookEntry> {

	public final String unlocalizedName;
	public final BookCategory category;

	public List<BookPage> pages = new ArrayList<BookPage>();
	private boolean priority = false;

	
	public BookEntry(String unlocalizedName, BookCategory category) {
		this.unlocalizedName = unlocalizedName;
		this.category = category;
	}

	/**
	 * Sets this page as prioritized, as in, will appear before others in the lexicon.
	 */
	public BookEntry setPriority() {
		priority = true;
		return this;
	}

	public boolean isPriority() {
		return priority;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	/**
	 * Sets what pages you want this entry to have.
	 */
	public BookEntry setBookPages(BookPage... pages) {
		this.pages.addAll(Arrays.asList(pages));

		for(int i = 0; i < this.pages.size(); i++)
			this.pages.get(i).onPageAdded(this, i);

		return this;
	}

	/**
	 * Adds a page to the list of pages.
	 */
	public void addPage(BookPage page) {
		pages.add(page);
	}

	public final String getNameForSorting() {
		return (priority ? 0 : 1) + StatCollector.translateToLocal(getUnlocalizedName());
	}

	@Override
	public int compareTo(BookEntry o) {
		return getNameForSorting().compareTo(o.getNameForSorting());
	}

}
