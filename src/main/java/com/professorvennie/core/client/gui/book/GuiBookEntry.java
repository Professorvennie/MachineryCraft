/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.client.gui.book;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StatCollector;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.api.book.BookPage;
import com.professorvennie.api.book.IAddonEntry;
import com.professorvennie.api.book.IGuiBookEntry;
import com.professorvennie.core.client.gui.buttons.GuiButtonBackWithShift;
import com.professorvennie.core.client.gui.buttons.GuiButtonPage;

public class GuiBookEntry extends GuiBook implements IGuiBookEntry {

	public int page = 0;
	BookEntry entry;
	GuiScreen parent;
	String title;
	String subtitle;

	GuiButton leftButton, rightButton;

	public GuiBookEntry(BookEntry entry, GuiScreen parent) {
		this.entry = entry;
		this.parent = parent;

		title = StatCollector.translateToLocal(entry.getUnlocalizedName());
		if(entry instanceof IAddonEntry)
			subtitle = StatCollector.translateToLocal(((IAddonEntry) entry).getSubtitle());
		else subtitle = null;
	}

	@Override
	public void initGui() {
		super.initGui();

		buttonList.add(new GuiButtonBackWithShift(0, left + guiWidth / 2 - 8, top + guiHeight + 2));
		buttonList.add(leftButton = new GuiButtonPage(1, left, top + guiHeight - 10, false));
		buttonList.add(rightButton = new GuiButtonPage(2, left + guiWidth - 18, top + guiHeight - 10, true));

		updatePageButtons();
	}

	@Override
	public BookEntry getEntry() {
		return entry;
	}

	@Override
	public int getPageOn() {
		return page;
	}

	@Override
	boolean isIndex() {
		return false;
	}

	@Override
	void drawHeader() {
		// NO-OP
	}

	@Override
	String getTitle() {
		return String.format("%s (%s/%s)", title, page + 1, entry.pages.size());
	}

	@Override
	String getSubtitle() {
		return subtitle;
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch(par1GuiButton.id) {
		case 0 :
			mc.displayGuiScreen(GuiScreen.isShiftKeyDown() ? new GuiBook() : parent);
			//ClientTickHandler.notifyPageChange();
			break;
		case 1 :
			page--;
			//ClientTickHandler.notifyPageChange();
			break;
		case 2 :
			page++;
			//ClientTickHandler.notifyPageChange();
			break;
		}
		updatePageButtons();
	}

	public void updatePageButtons() {
		leftButton.enabled = page != 0;
		rightButton.enabled = page + 1 < entry.pages.size();
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);

		BookPage page = entry.pages.get(this.page);
		page.renderScreen(this, par1, par2);
	}

	@Override
	public void updateScreen() {
		BookPage page = entry.pages.get(this.page);
		page.updateScreen();
	}

	@Override
	public int getLeft() {
		return left;
	}

	@Override
	public int getTop() {
		return top;
	}

	@Override
	public int getWidth() {
		return guiWidth;
	}

	@Override
	public int getHeight() {
		return guiHeight;
	}

	@Override
	public float getZLevel() {
		return zLevel;
	}

}

