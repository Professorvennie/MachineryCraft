package com.professorvennie.core.item;

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemGears extends Item {

    public IIcon[] textures;

    public ItemGears(){
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName("gear");
        setFull3D();
        setHasSubtypes(true);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        textures = new IIcon[Names.Items.GEARS.length];
        for(int i = 0; i < Names.Items.GEARS.length; i++){
            textures[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.GEARS[i]);
        }
    }

    @Override
    public IIcon getIconFromDamage(int par1) {
        return par1 < textures.length ? textures[par1] : textures[0];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < Names.Items.GEARS.length; i++)
            list.add(new ItemStack(this, 1, i));
    }
}
