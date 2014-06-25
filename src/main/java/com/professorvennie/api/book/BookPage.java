package com.professorvennie.api.book;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BookPage {
	
	public String unlocalizedName;

	public BookPage(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	/**
	 * Does the rendering for this page.
	 * @param gui The active GuiScreen
	 * @param mx The mouse's relative X position.
	 * @param my The mouse's relative Y position.
	 */
	@SideOnly(Side.CLIENT)
	public abstract void renderScreen(IGuiBookEntry gui, int mx, int my);

	/**
	 * Called per update tick.
	 */
	@SideOnly(Side.CLIENT)
	public void updateScreen() {
		// NO-OP
	}

	public void onPageAdded(BookEntry entry, int index) {
		// NO-OP
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

}
