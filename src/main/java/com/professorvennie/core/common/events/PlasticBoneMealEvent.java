/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.common.events;


import com.professorvennie.core.block.BlockPlasticSapling;
import com.professorvennie.core.block.ModBlocks;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class PlasticBoneMealEvent {

    @SubscribeEvent
    public void usedBonemeal(BonemealEvent event) {
        if (event.block == ModBlocks.plasticSapling) {
            if (!event.world.isRemote) {
                // Grow tree
                ((BlockPlasticSapling)ModBlocks.plasticSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
                event.setResult(Event.Result.ALLOW);
            }
        }
    }
}
