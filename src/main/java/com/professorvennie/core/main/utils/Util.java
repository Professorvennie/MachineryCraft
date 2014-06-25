package com.professorvennie.core.main.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidStack;

public class Util {
	
	public static ItemStack getEmptyForFilledContainer(ItemStack filledContainer) {
		for(FluidContainerData data : FluidContainerRegistry.getRegisteredFluidContainerData()) {
			if(data.filledContainer.isItemEqual(filledContainer)) return data.emptyContainer;
		}

		return null;
	}
	
	public static ItemStack getFilledForEmptyContainer(ItemStack emptyContainer, FluidStack fluid) {
		for(FluidContainerData data : FluidContainerRegistry.getRegisteredFluidContainerData()) {
			if(data.emptyContainer.isItemEqual(emptyContainer) && data.fluid.isFluidEqual(fluid)) return data.filledContainer;
		}

		return null;
	}

}
