package com.professorvennie.lib.base.items;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.entitys.EntityMCFishHook;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/22/2014 at 5:02 PM.
 */
public class ItemModFishingPole extends ItemFishingRod {

    private ToolMaterial toolMaterial;
    private String name;

    @SideOnly(Side.CLIENT)
    private IIcon cast;

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
            int i = player.fishEntity.func_146034_e();
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
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_cast");
        cast = iconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_unCast");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if(player.inventory.getCurrentItem() == stack && player.fishEntity != null){
            return cast;
        }
        System.out.println(player.fishEntity);
        return itemIcon;
    }

/*    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_94597_g() {
        return cast;
    }*/

    @Override
    public int getItemEnchantability() {
        return toolMaterial.getEnchantability();
    }
}
