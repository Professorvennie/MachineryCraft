package com.professorvennie.machinerycraft.machines.brass.power;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 10/7/2014 at 4:27 PM.
 */
public class BlockPowerReceiver extends BlockBasicMachine {

    public BlockPowerReceiver() {
        super(Names.Blocks.POWER_RECEIVER, false);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityPowerReceiver) {
            TileEntityPowerReceiver tile = (TileEntityPowerReceiver) world.getTileEntity(x, y, z);
            if (!world.isRemote) {
                //tile.addPower(0);
                player.addChatComponentMessage(new ChatComponentText("Receiver: " + tile.getPower() + "/" + tile.getCapacity() + " Jewels"));
            }
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityPowerReceiver();
    }
}
