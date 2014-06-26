package com.professorvennie.api.book;

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
