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

import com.professorvennie.machinerycraft.api.MachineryCraftAPI;
import com.professorvennie.machinerycraft.api.book.BookCategory;
import com.professorvennie.machinerycraft.client.gui.buttons.GuiButtonInvisible;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class GuiBook extends GuiScreen {

    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/Book.png");
    public static GuiBook currentOpenLexicon = new GuiBook();
    public static ItemStack stackUsed;
    String title;
    int guiWidth = 146;
    int guiHeight = 180;
    int left, top;

    @Override
    public void initGui() {
        super.initGui();

        title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();
        currentOpenLexicon = this;

        left = width / 2 - guiWidth / 2;
        top = height / 2 - guiHeight / 2;

        buttonList.clear();
        if (isIndex()) {
            int x = 18;
            for (int i = 0; i < 12; i++) {
                int y = 16 + i * 12;
                buttonList.add(new GuiButtonInvisible(i, left + x, top + y, 110, 10, ""));
            }
            populateIndex();
        }
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
        drawCenteredString(fontRendererObj, getTitle(), left + guiWidth / 2, top - getTitleHeight(), 0xFF5A28);
        String subtitle = getSubtitle();
        if (subtitle != null) {
            GL11.glScalef(0.5F, 0.5F, 1F);
            drawCenteredString(fontRendererObj, subtitle, left * 2 + guiWidth, (top - getTitleHeight() + 10) * 2, 0xFF5A28);
            GL11.glScalef(2F, 2F, 1F);
        }

        drawHeader();

        super.drawScreen(par1, par2, par3);
    }

    void drawHeader() {
        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        fontRendererObj.drawSplitString(String.format(StatCollector.translateToLocal("mc.book.header"), "0"), left + 18, top + 14, 110, 0);
        fontRendererObj.setUnicodeFlag(unicode);
    }

    @Override
    protected void actionPerformed(GuiButton par1GuiButton) {
        int i = par1GuiButton.id - 3;
        if (i < 0)
            return;

        List<BookCategory> categoryList = MachineryCraftAPI.getAllCategories();
        BookCategory category = i >= categoryList.size() ? null : categoryList.get(i);

        if (category != null) {
            mc.displayGuiScreen(new GuiBookIndex(category));
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    String getTitle() {
        return title;
    }

    String getSubtitle() {
        return null;
    }

    int getTitleHeight() {
        return getSubtitle() == null ? 12 : 16;
    }

    boolean isIndex() {
        return true;
    }

    void populateIndex() {
        List<BookCategory> categoryList = MachineryCraftAPI.getAllCategories();
        for (int i = 3; i < 12; i++) {
            int i_ = i - 3;
            GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i);
            BookCategory category = i_ >= categoryList.size() ? null : categoryList.get(i_);
            if (category != null)
                button.displayString = StatCollector.translateToLocal(category.getUnlocalizedName());
            else button.displayString = "";
        }
    }

}

