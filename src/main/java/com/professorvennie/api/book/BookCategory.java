package com.professorvennie.api.book;

import java.util.ArrayList;
import java.util.List;

public class BookCategory {
	
	public final String unlocalizedName;
	public final List<BookEntry> entries = new ArrayList<BookEntry>();

	/**
	 * @param unlocalizedName The unlocalized name of this category. This will be localized by the client display.
	 */
	public BookCategory(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

}
