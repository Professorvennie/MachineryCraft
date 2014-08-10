/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.fuilds;

import com.professorvennie.core.main.MachineryCraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFuilds {
	
	public static Fluid fluidSteam;
	public static Block blockSteam;
		
	public static void mainRegistry(){
		init();
	}
	
	private static void init() {
        fluidSteam = new Fluid("steam");
		FluidRegistry.registerFluid(fluidSteam);

        blockSteam = new FluidSteamBlock(fluidSteam, Material.water).setBlockName("steam").setCreativeTab(MachineryCraft.tabMachineryCraft);
		GameRegistry.registerBlock(blockSteam, blockSteam.getUnlocalizedName());
        fluidSteam.setBlock(blockSteam).setGaseous(true).setTemperature(1000).setDensity(450).setUnlocalizedName(blockSteam.getUnlocalizedName());
        fluidSteam = FluidRegistry.getFluid("steam");
	}
}
