/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.item;

import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.main.helpers.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by ProfessorVennie on 8/28/2014 at 6:47 PM.
 */
public class ItemBags extends Item {

    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public ItemBags(){
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setUnlocalizedName("bag");
        setFull3D();
        setHasSubtypes(true);
        setMaxStackSize(1);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < Names.Items.BAGS.length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[Names.Items.BAGS.length];
        for(int i = 0; i < Names.Items.BAGS.length; i++){
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.BAGS[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return par1 < icons.length ? icons[par1] : icons[0];
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote){
            if(!player.isSneaking()){
                NBTHelper.setUUID(itemStack);
                player.openGui(MachineryCraft.instance, LibGuiIds.BAGS, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
            }
        }
        return itemStack;
    }
}
