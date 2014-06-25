package com.professorvennie.core.fuilds;

import com.professorvennie.core.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFuilds {
	
	public static Fluid saltFluid;
	public static Block salt;
		
	public static void mainRegistry(){
		init();
	}
	
	private static void init() {
		saltFluid = new Fluid("saltFluid");
		if(!FluidRegistry.registerFluid(saltFluid)){
			saltFluid = FluidRegistry.getFluid("saltFluid");
		}
		
		salt = new FuildSaltWaterBlock(saltFluid, Material.lava).setBlockName("saltFluid").setCreativeTab(MainRegistry.tabMachineryCraft);
		GameRegistry.registerBlock(salt, salt.getUnlocalizedName());
		saltFluid.setBlock(salt).setDensity(3000).setViscosity(6000).setTemperature(1300);
	}
}
