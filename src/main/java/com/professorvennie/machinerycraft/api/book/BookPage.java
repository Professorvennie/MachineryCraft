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
