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
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class ModAchievements {

    public static Achievement copperFurnace;
    public static Achievement copperGrinder;
    public static Achievement bronzeSteamBoiler;

    // public static AchievementPage page;


    public static void registerAchievements() {

        copperFurnace = new Achievement("achievement.copperFurnace", "copperFurnace", 0, 0, ModBlocks.copperFurnaceActive, AchievementList.buildFurnace).registerStat();
        copperGrinder = new Achievement("achievement.copperGrinder", "copperGrinder", 1, 1, ModBlocks.copperGrinderActive, copperFurnace).registerStat();

        bronzeSteamBoiler = new Achievement("achievement.bronzeSteamBoiler", "bronzeSteamBoiler", 2, 2, ModBlocks.bronzeSteamBoiler, copperGrinder).registerStat();

        //page = new AchievementPage("MachineryCraft", copperFurnace, copperGrinder, bronzeSteamBoiler);
        AchievementPage.registerAchievementPage(new AchievementPage("MachineryCraft", new Achievement[]{copperFurnace, copperGrinder, bronzeSteamBoiler}));
    }
}
