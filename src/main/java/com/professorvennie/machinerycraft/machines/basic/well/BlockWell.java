package com.professorvennie.machinerycraft.machines.basic.well;

import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/14/2014 at 5:04 PM.
 */
public class BlockWell extends BlockBasicMachine {

    public BlockWell() {
        super(Names.Blocks.WELL, false);
        guiId = LibGuiIds.WELL;
        setBlockName(Names.Blocks.WELL);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {

    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityWell();
    }
}
