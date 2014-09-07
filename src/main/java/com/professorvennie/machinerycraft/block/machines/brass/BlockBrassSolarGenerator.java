package com.professorvennie.machinerycraft.block.machines.brass;

import com.professorvennie.machinerycraft.block.machines.BlockBasicMachine;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.tileEntity.machines.brass.TileEntityBrassSolarGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:04 PM.
 */
public class BlockBrassSolarGenerator extends BlockBasicMachine {

    public BlockBrassSolarGenerator() {
        super(Names.Blocks.BRASS_SOLAR_GEN, false);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(world.getTileEntity(x, y, z) instanceof TileEntityBrassSolarGenerator){
            TileEntityBrassSolarGenerator tile = (TileEntityBrassSolarGenerator)world.getTileEntity(x, y, z);
            if(!world.isRemote)
                player.addChatComponentMessage(new ChatComponentText("Power lever - " + tile.getPower()));
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBrassSolarGenerator();
    }
}
