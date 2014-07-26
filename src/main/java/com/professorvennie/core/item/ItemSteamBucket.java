package com.professorvennie.core.item;

import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

/**
 * Created by ProfessorVennie on 7/25/2014 at 8:38 PM.
 */
public class ItemSteamBucket extends ItemBucket {

    public ItemSteamBucket() {
        super(ModFuilds.blockSteam);
        setFull3D();
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName(Names.Items.STEAM_BUCKET);
        setContainerItem(Items.bucket);
    }
}
