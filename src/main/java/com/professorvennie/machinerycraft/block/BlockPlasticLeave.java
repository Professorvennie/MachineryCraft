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

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.item.ModItems;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.Random;


public class BlockPlasticLeave extends BlockLeaves {

    public static final String[] textureNames = new String[]{Reference.MOD_ID + ":PlasticLeaf", Reference.MOD_ID + ":PlasticLeaf_Opaque"};
    public static final String[] trees = new String[]{"plastic"};
    @SideOnly(Side.CLIENT)
    protected IIcon[] textures = new IIcon[2];

    public BlockPlasticLeave() {
        super();
        this.setHardness(0.1F);
        this.setTickRandomly(true);
        this.setLightOpacity(1);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(MachineryCraft.tabMachineryCraft);
        this.setBlockName(Names.Blocks.BLOCK_LEAVES);
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
        return true;
    }

    public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
        return 40;
    }


    public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
        return 10;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int damageDropped(int meta) {
        return meta & 3;
    }

    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(Item.getItemFromBlock(this), 1, par1 & 3);
    }

    @Override
    public String[] func_150125_e() {
        return trees;
    }

    public int quantityDropped(Random parRandom1) {
        return parRandom1.nextInt(40) == 0 ? 1 : 0;
    }

    public Item getItemDropped(int x, Random yRandom, int z) {
        return Item.getItemFromBlock(ModBlocks.plasticSapling);
    }

    protected void func_150124_c(World world, int x, int y, int z, int meta, int par1) {
        if ((meta & 3) == 0 && world.rand.nextInt(par1) == 0) {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.itemPlasticApple, 1, 0));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (field_150121_P)
            return textures[1];
        else
            return textures[0];
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List listLeaves) {
        listLeaves.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg) {
        textures[0] = iconReg.registerIcon(textureNames[0]);
        textures[1] = iconReg.registerIcon(textureNames[1]);
    }

    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float par1, int par2) {
        if (!world.isRemote) {
            int j1 = this.func_150123_b(meta);

            if (par2 > 0) {
                j1 -= 2 << par2;

                if (j1 < 10) {
                    j1 = 10;
                }
            }

            if (j1 <= 0) j1 = 20;

            if (world.rand.nextInt(j1) == 0) {
                Item item = this.getItemDropped(meta, world.rand, par2);
                this.dropBlockAsItem(world, x, y, z, new ItemStack(item, 1,
                        this.damageDropped(meta)));
            }

            j1 = 20;

            if (par2 > 0) {
                j1 -= 10 << par2;

                if (j1 < 10) {
                    j1 = 10;
                }
            }

            this.func_150124_c(world, x, y, z, meta, j1);
        }
    }
}
