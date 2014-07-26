package com.professorvennie.core.fuilds;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


/**
 * Created by ProfessorVennie on 7/23/2014 at 1:04 PM.
 */
public class FluidSteamBlock extends BlockFluidClassic{

    public FluidSteamBlock(Fluid fluidSteam, Material lava) {
        super(fluidSteam, lava);
    }
}
