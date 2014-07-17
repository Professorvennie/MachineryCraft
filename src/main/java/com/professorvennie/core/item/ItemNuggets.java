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

public class ItemNuggets extends Item {

    public IIcon[] textures;

    public ItemNuggets(){
        setUnlocalizedName("nugget");
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setFull3D();
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        textures = new IIcon[Names.Items.NUGGETS.length];
        for(int i = 0; i < Names.Items.NUGGETS.length; i++){
            textures[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "nugget" + i);
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < Names.Items.NUGGETS.length; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public IIcon getIconFromDamage(int par1) {
        return par1 < textures.length ? textures[par1] : textures[0];
    }
}
