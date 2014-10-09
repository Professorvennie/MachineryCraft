package com.professorvennie.machinerycraft.machines.basic.well;

import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/14/2014 at 5:04 PM.
 */
public class BlockWell extends BlockBasicMachine {

    public BlockWell() {
        super(Names.Blocks.WELL, false);
        guiId = LibGuiIds.WELL;
        setUnlocalizedName(Names.Blocks.WELL);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityWell();
    }
}
