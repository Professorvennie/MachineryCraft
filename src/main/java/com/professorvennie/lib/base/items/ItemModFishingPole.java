package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.entitys.EntityMCFishHook;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/22/2014 at 5:02 PM.
 */
public class ItemModFishingPole extends ItemFishingRod {

    private ToolMaterial toolMaterial;
    private String name;

    public ItemModFishingPole(ToolMaterial toolMaterial, String name) {
        this.toolMaterial = toolMaterial;
        this.name = name;
        setMaxDamage(toolMaterial.getMaxUses());
        setUnlocalizedName(name);
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (player.fishEntity != null) {
            int i = player.fishEntity.handleHookRetraction();
            itemStack.damageItem(i, player);
            player.swingItem();
        } else {
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote) {
                world.spawnEntityInWorld(new EntityMCFishHook(world, player));
            }
            player.swingItem();
        }

        return itemStack;
    }

    @Override
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
    }
}
