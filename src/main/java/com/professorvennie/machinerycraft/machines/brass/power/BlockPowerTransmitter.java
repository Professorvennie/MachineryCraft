package com.professorvennie.machinerycraft.machines.brass.power;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 10/7/2014 at 4:26 PM.
 */
public class BlockPowerTransmitter extends BlockBasicMachine {

    public BlockPowerTransmitter() {
        super(Names.Blocks.POWER_TRANSMITTER, false);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityPowerTransmitter) {
            TileEntityPowerTransmitter tile = (TileEntityPowerTransmitter) world.getTileEntity(x, y, z);
            if (!world.isRemote) {
                if (!player.isSneaking())
                    player.addChatComponentMessage(new ChatComponentText("Transmitter: " + tile.getPower() + "/" + tile.getCapacity() + " Jewels"));
                else
                    tile.addPower(100);
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityPowerTransmitter();
    }
}
