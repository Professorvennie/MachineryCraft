package com.professorvennie.core.gui.buttons;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class GuiButtonBackWithShift extends GuiButtonBack {
	
	public GuiButtonBackWithShift(int par1, int par2, int par3) {
		super(par1, par2, par3);
	}

	@Override
	public List<String> getTooltip() {
		return Arrays.asList(StatCollector.translateToLocal("mc.book.backbutton"), EnumChatFormatting.GRAY + StatCollector.translateToLocal("mc.book.clickToIndex"));
	}

}
