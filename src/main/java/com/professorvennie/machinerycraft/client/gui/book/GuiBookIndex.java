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

import com.professorvennie.machinerycraft.api.book.BookCategory;
import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.client.gui.buttons.GuiButtonBack;
import com.professorvennie.machinerycraft.client.gui.buttons.GuiButtonInvisible;
import com.professorvennie.machinerycraft.client.gui.buttons.GuiButtonPage;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuiBookIndex extends GuiBook {

    BookCategory category;
    String title;
    int page = 0;

    GuiButton leftButton, rightButton;

    List<BookEntry> entriesToDisplay = new ArrayList();

    public GuiBookIndex(BookCategory category) {
        this.category = category;
        title = StatCollector.translateToLocal(category.getUnlocalizedName());
    }

    @Override
    void drawHeader() {
    }

    @Override
    String getTitle() {
        return title;
    }

    @Override
    public void initGui() {
        super.initGui();
        buttonList.add(new GuiButtonBack(12, left + guiWidth / 2 - 8, top + guiHeight + 2));
        buttonList.add(leftButton = new GuiButtonPage(13, left, top + guiHeight - 10, false));
        buttonList.add(rightButton = new GuiButtonPage(14, left + guiWidth - 18, top + guiHeight - 10, true));

        entriesToDisplay.clear();
        entriesToDisplay.addAll(category.entries);
        Collections.sort(entriesToDisplay);

        updatePageButtons();
        populateIndex();
    }

    @Override
    void populateIndex() {
        for (int i = page * 12; i < (page + 1) * 12; i++) {
            GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i - page * 12);
            BookEntry entry = i >= entriesToDisplay.size() ? null : entriesToDisplay.get(i);
            if (entry != null)
                button.displayString = (entry.isPriority() ? EnumChatFormatting.ITALIC : "") + StatCollector.translateToLocal(entry.getUnlocalizedName());
            else button.displayString = "";
        }
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton) {
        switch (par1GuiButton.id) {
            case 12:
                mc.displayGuiScreen(new GuiBook());
                break;
            case 13:
                page--;
                updatePageButtons();
                populateIndex();
                break;
            case 14:
                page++;
                updatePageButtons();
                populateIndex();
                break;
            default:
                int index = par1GuiButton.id + page * 12;
                if (index >= entriesToDisplay.size())
                    return;

                BookEntry entry = entriesToDisplay.get(index);
                mc.displayGuiScreen(new GuiBookEntry(entry, this));
        }
    }

    public void updatePageButtons() {
        leftButton.enabled = page != 0;
        rightButton.enabled = page < (entriesToDisplay.size() - 1) / 12;
    }
}
