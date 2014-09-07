/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.MachineryCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by ProfessorVennie on 8/5/2014 at 9:03 PM.
 */
public class BlockMetalWalls extends BlockWall {

    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BlockMetalWalls() {
        super(ModBlocks.BlockMetals);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setBlockName("wall");
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < Names.Blocks.METAL_WALLS.length; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public Block setBlockName(String name) {
        return super.setBlockName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.iconArray[meta % this.iconArray.length];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        iconArray = new IIcon[Names.Blocks.METAL_WALLS.length];
        for(int i = 0; i < Names.Blocks.METAL_WALLS.length; i++){
            iconArray[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "ores/" + Names.Blocks.METAL_BLOCKS[i]);
        }
    }

    @Override
    public int damageDropped(int meta) {
        return super.damageDropped(meta);
    }

    @Override
    public int getDamageValue(World world, int x, int y, int z) {
        return super.getDamageValue(world, x, y, z);
    }
}
