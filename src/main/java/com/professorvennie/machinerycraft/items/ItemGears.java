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
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemGears extends ItemBase {

    @SideOnly(Side.CLIENT)
    public IIcon[] textures;

    public ItemGears() {
        super("gear");
        setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        textures = new IIcon[Names.Items.GEARS.length];
        for (int i = 0; i < Names.Items.GEARS.length; i++) {
            textures[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.GEARS[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return par1 < textures.length ? textures[par1] : textures[0];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < Names.Items.GEARS.length; i++)
            list.add(new ItemStack(this, 1, i));
    }
}
