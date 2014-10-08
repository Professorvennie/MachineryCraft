/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.client.gui.buttons;

import com.professorvennie.machinerycraft.client.gui.book.GuiBook;
import com.professorvennie.machinerycraft.core.helpers.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;

public class GuiButtonPage extends GuiButton {

    boolean right;

    public GuiButtonPage(int par1, int par2, int par3, boolean right) {
        super(par1, par2, par3, 18, 10, "");
        this.right = right;
    }

    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
        if (enabled) {
            hovered = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
            int k = getHoverState(hovered);

            par1Minecraft.renderEngine.bindTexture(GuiBook.texture);
            GL11.glColor4f(1F, 1F, 1F, 1F);
            drawTexturedModalRect(xPosition, yPosition, k == 2 ? 18 : 0, right ? 180 : 190, 18, 10);

            if (k == 2)
                RenderHelper.renderTooltip(par2, par3, Arrays.asList(StatCollector.translateToLocal(right ? "mc.book.nextPage" : "mc.book.prevPage")));
        }
    }
}
