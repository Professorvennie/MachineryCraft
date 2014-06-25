package com.professorvennie.api.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.StatCollector;

public class BookEntry implements Comparable<BookEntry> {

	public final String unlocalizedName;
	public final BookCategory category;

	public List<BookPage> pages = new ArrayList<BookPage>();
	private boolean priority = false;

	/**
	 * @param unlocalizedName The unlocalized name of this entry. This will be localized by the client display.
	 */
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
