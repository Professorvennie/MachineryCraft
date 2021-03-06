/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.lib.base.blocks.BlockModContainer;
import com.professorvennie.machinerycraft.world.dimesion.TeleporterMiningWorld;
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
        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) player;
            if (thePlayer.dimension != 12) {
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 12, new TeleporterMiningWorld(thePlayer.getServerForPlayer()));
            } else
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterMiningWorld(thePlayer.getServerForPlayer()));
        }
        return true;
    }
}
