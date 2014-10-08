package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/22/2014 at 4:54 PM.
 */
public class ItemModBow extends ItemBow {

    private ToolMaterial toolMaterial;
    private Item customArrow;
    private String name;

    public ItemModBow(ToolMaterial toolMaterial, String name) {
        this.toolMaterial = toolMaterial;
        this.name = name;
        setMaxStackSize(toolMaterial.getMaxUses());
        setCreativeTab(MachineryCraft.tabMachineryCraftEquipment);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        if (customArrow == null) customArrow = Items.arrow;
    }

    public ItemModBow(ToolMaterial toolMaterial, String name, Item customArrow) {
        this(toolMaterial, name);
        this.customArrow = customArrow;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        /*ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }*/

        if (player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0 || player.inventory.hasItem(customArrow)) {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
    }

    @Override
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
    }
}
