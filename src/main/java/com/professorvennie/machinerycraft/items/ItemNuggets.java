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

public class ItemNuggets extends ItemBase {

    @SideOnly(Side.CLIENT)
    public IIcon[] textures;

    public ItemNuggets() {
        super("nugget");
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        textures = new IIcon[Names.Items.NUGGETS.length];
        for (int i = 0; i < Names.Items.NUGGETS.length; i++) {
            textures[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.NUGGETS[i]);
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < Names.Items.NUGGETS.length; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public IIcon getIconFromDamage(int par1) {
        return par1 < textures.length ? textures[par1] : textures[0];
    }
}
