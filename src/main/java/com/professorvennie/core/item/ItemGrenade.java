package com.professorvennie.core.item;

import com.professorvennie.core.entitys.EntityGrenade;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 8/4/2014 at 10:52 AM.
 */
public class ItemGrenade extends Item {

    public ItemGrenade(){
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName("grenade");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        world.playSoundAtEntity(player, "random.fizz", 0.7f, 0.8f);

        if(!world.isRemote)
            world.spawnEntityInWorld(new EntityGrenade(world, player));

        return itemStack;
    }
}
