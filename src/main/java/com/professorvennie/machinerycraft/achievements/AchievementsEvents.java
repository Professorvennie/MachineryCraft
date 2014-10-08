/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.achievements;

import com.professorvennie.machinerycraft.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class AchievementsEvents {

    @SubscribeEvent
    public void whenCrafted(PlayerEvent.ItemCraftedEvent e) {
        if (e.crafting.getItem() != null) {
            if (e.crafting.getItem() == Item.getItemFromBlock(ModBlocks.copperFurnaceIdle))
                e.player.addStat(ModAchievements.copperFurnace, 1);
            if (e.crafting.getItem() == Item.getItemFromBlock(ModBlocks.copperGrinderIdle))
                e.player.addStat(ModAchievements.copperGrinder, 1);
            if (e.crafting.getItem() == Item.getItemFromBlock(ModBlocks.bronzeSteamBoiler))
                e.player.addStat(ModAchievements.bronzeSteamBoiler, 1);
        }
    }
}
