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

import com.professorvennie.lib.base.items.ItemBase;
import com.professorvennie.machinerycraft.entitys.EntityGrenade;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by ProfessorVennie on 8/4/2014 at 10:52 AM.
 */
public class ItemGrenade extends ItemBase {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemGrenade() {
        super("grenade");
        setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < Names.Items.GERNADES.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName(itemStack) + "." + itemStack.getItemDamage();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[Names.Items.GERNADES.length];
        for (int i = 0; i < Names.Items.GERNADES.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.GERNADES[i] + "Grenade");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return par1 < icons.length ? icons[par1] : icons[0];
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        world.playSoundAtEntity(player, "random.fizz", 0.7f, 0.8f);

        if (!world.isRemote)
            world.spawnEntityInWorld(new EntityGrenade(world, player, itemStack.getItemDamage()));

        return itemStack;
    }
}
