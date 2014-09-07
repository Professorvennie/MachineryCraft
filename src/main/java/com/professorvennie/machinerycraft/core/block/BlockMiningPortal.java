package com.professorvennie.machinerycraft.core.block;

import com.professorvennie.machinerycraft.core.world.dimesion.TeleporterMiningWorld;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/3/2014 at 1:43 PM.
 */
public class BlockMiningPortal extends BlockModContainer {

    public BlockMiningPortal() {
        super(Material.rock, "miningPortal");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(player instanceof EntityPlayerMP){
            EntityPlayerMP thePlayer = (EntityPlayerMP)player;
            if(thePlayer.dimension != 12){
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 12, new TeleporterMiningWorld(thePlayer.getServerForPlayer()));
            }else
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterMiningWorld(thePlayer.getServerForPlayer()));
        }
        return true;
    }
}
