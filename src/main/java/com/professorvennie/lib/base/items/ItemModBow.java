package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

/**
 * Created by ProfessorVennie on 9/22/2014 at 4:54 PM.
 */
public class ItemModBow extends ItemBow {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

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

        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0 || player.inventory.hasItem(customArrow)) {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_standby");
        icons = new IIcon[3];
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_pulling_0");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_pulling_1");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_pulling_2");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass) {
        return itemIcon;
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        if(useRemaining > 0){
            int draw = stack.getMaxItemUseDuration() - useRemaining;
            if(draw > 17)
                return icons[2];
            else if(draw > 13)
                return icons[1];
            else if(draw > 0)
                return icons[0];
        }
        return itemIcon;
    }

    @Override
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
    }
}
