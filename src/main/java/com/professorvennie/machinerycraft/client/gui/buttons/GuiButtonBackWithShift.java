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

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.Arrays;
import java.util.List;

public class GuiButtonBackWithShift extends GuiButtonBack {

    public GuiButtonBackWithShift(int par1, int par2, int par3) {
        super(par1, par2, par3);
    }

    @Override
    public List<String> getTooltip() {
        return Arrays.asList(StatCollector.translateToLocal("mc.book.backbutton"), EnumChatFormatting.GRAY + StatCollector.translateToLocal("mc.book.clickToIndex"));
    }

}
