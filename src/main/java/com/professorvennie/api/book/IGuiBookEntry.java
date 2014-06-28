/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.api.book;

public interface  IGuiBookEntry {

	/**
	 * Gets the entry currently portrayed in this gui.
	 */
	public BookEntry getEntry();

	/**
	 * Gets the current page the lexicon GUI is browsing.
	 */
	public int getPageOn();

	/**
	 * Gets the leftmost part of the GUI.
	 */
	public int getLeft();

	/**
	 * Gets the topmost part of the GUI.
	 */
	public int getTop();

	/**
	 * Gets the GUI's width.
	 */
	public int getWidth();

	/**
	 * Gets the GUI's height
	 */
	public int getHeight();

	/**
	 * Gets the GUI's Z level for rendering.
	 */
	public float getZLevel();

}
