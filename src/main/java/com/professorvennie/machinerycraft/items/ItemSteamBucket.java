/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.items;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.fuilds.ModFuilds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

/**
 * Created by ProfessorVennie on 7/25/2014 at 8:38 PM.
 */
public class ItemSteamBucket extends ItemBucket {

    public ItemSteamBucket() {
        super(ModFuilds.blockSteam);
        setCreativeTab(MachineryCraft.tabMachineryCraftItems);
        setUnlocalizedName(Names.Items.STEAM_BUCKET);
        setTextureName(Reference.MOD_ID + ":steamBucket");
    }

    @Override
    public Item setUnlocalizedName(String name) {
        GameRegistry.registerItem(this, name);
        return super.setUnlocalizedName(name);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public Item setContainerItem(Item item) {
        return Items.bucket;
    }
}
