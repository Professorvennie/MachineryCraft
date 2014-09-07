package com.professorvennie.machinerycraft.core.item;

import com.professorvennie.machinerycraft.core.fuilds.ModFuilds;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.main.MachineryCraft;
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
        setFull3D();
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName(Names.Items.STEAM_BUCKET);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public Item setContainerItem(Item item) {
        return Items.bucket;
    }
}
