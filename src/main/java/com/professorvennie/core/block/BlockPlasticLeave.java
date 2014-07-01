/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block;

import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.BlockNames;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BlockPlasticLeave extends BlockLeavesBase implements IShearable {

    public static final String[][] textureNames = new String[][] {	{ Reference.MOD_ID + ":PlasticLeaf" }, { Reference.MOD_ID + ":PlasticLeaf_Opaque" } };
    public static final String[] trees = new String[] { "plastic" };
    int[] intarray;
    @SideOnly(Side.CLIENT)
    protected int anInt;
    protected IIcon[][] textures = new IIcon[2][];

    public BlockPlasticLeave() {
        super(Material.leaves, true);

        // Propiedades
        this.setHardness(0.1F);
        this.setTickRandomly(true);
        this.setLightOpacity(1);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(MainRegistry.tabMachineryCraft);
        this.setBlockName(BlockNames.BLOCK_LEAVES);
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
        return true;
    }


    public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        return 40;
    }


    public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        return 10;
    }


    @Override
    public int damageDropped(int meta) {
        return meta & 3;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }

    @Override
    public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    public boolean isOpaqueCube() {
        return !this.field_150121_P;
    }

    @SideOnly(Side.CLIENT)
    public void setGraphicsLevel(boolean par1) {
        this.field_150121_P = par1;
        this.anInt = par1 ? 0 : 1;
    }

    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(Item.getItemFromBlock(this), 1, par1 & 3);
    }

    private void removeLeaves(World world, int x, int y, int z) {
        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
        world.setBlockToAir(x, y, z);
    }

    public int quantityDropped(Random parRandom1) {
        return parRandom1.nextInt(40) == 0 ? 1 : 0;
    }

    public Item getItemDropped(int x, Random yRandom, int z) {
        return Item.getItemFromBlock(ModBlocks.plasticSapling);
    }

    protected void func_150124_c(World world, int x, int y, int z, int meta, int par1) {
        if ((meta & 3) == 0 && world.rand.nextInt(par1) == 0) {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.itemPlasticApple,	1, 0));
        }
    }

    protected int func_150123_b(int par1) {
        int j = par1;

        if ((par1 & 8) == 8) {
            j = 20;
        }

        return j;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (meta & 3) == 1 ? this.textures[this.anInt][1]
                : ((meta & 3) == 3 ? this.textures[this.anInt][3]
                : ((meta & 3) == 2 ? this.textures[this.anInt][2]
                : this.textures[this.anInt][0]));
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List listLeaves) {
        listLeaves.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg) {
        for (int i = 0; i < textureNames.length; ++i) {
            this.textures[i] = new IIcon[textureNames[i].length];

            for (int j = 0; j < textureNames[i].length; ++j) {
                this.textures[i][j] = iconReg.registerIcon(textureNames[i][j]);
            }
        }
    }

    public String[] func_150125_e() {
        return trees;
    }

    @Override
    public void beginLeavesDecay(World world, int x, int y, int z) {
       // LogHelper.debug("[Alca] beginLeavesDecay:BlockCherryLeaf.java");
        int i2 = world.getBlockMetadata(x, y, z);

        if ((i2 & 8) == 0) {
            world.setBlockMetadataWithNotify(x, y, z, i2 | 8, 4);
        }
        world.setBlockMetadataWithNotify(x, y, z,
                world.getBlockMetadata(x, y, z) | 8, 4);
    }

    public void dropBlockAsItemWithChance(World world, int x, int y, int z,	int meta, float par1, int par2) {
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


    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
        super.harvestBlock(world, player, x, y, z, meta);
    }

    public void breakBlock(World world, int x, int y, int z, Block bloque, int meta) {
        byte b0 = 1;
        int i1 = b0 + 1;

        if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z
                + i1)) {
            for (int j1 = -b0; j1 <= b0; ++j1) {
                for (int k1 = -b0; k1 <= b0; ++k1) {
                    for (int l1 = -b0; l1 <= b0; ++l1) {
                        Block block = world.getBlock(x + j1, y + k1, z + l1);
                        if (block.isLeaves(world, x + j1, y + k1, z + l1)) {
                            block.beginLeavesDecay(world, x + j1, y + k1, z
                                    + l1);
                        }
                    }
                }
            }
        }
    }

    public void updateTick(World world, int x, int y, int z, Random parRandom1) {
        if (!world.isRemote) {
            int l = world.getBlockMetadata(x, y, z);

            if ((l & 8) != 0 && (l & 4) == 0) {
                byte b0 = 4;
                int i1 = b0 + 1;
                byte b1 = 32;
                int j1 = b1 * b1;
                int k1 = b1 / 2;

                if (this.intarray == null) {
                    this.intarray = new int[b1 * b1 * b1];
                }

                int l1;

                if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y
                        + i1, z + i1)) {
                    int i2;
                    int j2;

                    for (l1 = -b0; l1 <= b0; ++l1) {
                        for (i2 = -b0; i2 <= b0; ++i2) {
                            for (j2 = -b0; j2 <= b0; ++j2) {
                                Block block = world.getBlock(x + l1, y + i2, z
                                        + j2);

                                if (!block.canSustainLeaves(world, x + l1, y
                                        + i2, z + j2)) {
                                    if (block.isLeaves(world, x + l1, y + i2, z
                                            + j2)) {
                                        this.intarray[(l1 + k1) * j1
                                                + (i2 + k1) * b1 + j2 + k1] = -2;
                                    } else {
                                        this.intarray[(l1 + k1) * j1
                                                + (i2 + k1) * b1 + j2 + k1] = -1;
                                    }
                                } else {
                                    this.intarray[(l1 + k1) * j1
                                            + (i2 + k1) * b1 + j2 + k1] = 0;
                                }
                            }
                        }
                    }

                    for (l1 = 1; l1 <= 4; ++l1) {
                        for (i2 = -b0; i2 <= b0; ++i2) {
                            for (j2 = -b0; j2 <= b0; ++j2) {
                                for (int k2 = -b0; k2 <= b0; ++k2) {
                                    if (this.intarray[(i2 + k1) * j1
                                            + (j2 + k1) * b1 + k2 + k1] == l1 - 1) {
                                        if (this.intarray[(i2 + k1 - 1)
                                                * j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
                                            this.intarray[(i2 + k1 - 1)
                                                    * j1 + (j2 + k1) * b1 + k2
                                                    + k1] = l1;
                                        }

                                        if (this.intarray[(i2 + k1 + 1)
                                                * j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
                                            this.intarray[(i2 + k1 + 1)
                                                    * j1 + (j2 + k1) * b1 + k2
                                                    + k1] = l1;
                                        }

                                        if (this.intarray[(i2 + k1) * j1
                                                + (j2 + k1 - 1) * b1 + k2 + k1] == -2) {
                                            this.intarray[(i2 + k1) * j1
                                                    + (j2 + k1 - 1) * b1 + k2
                                                    + k1] = l1;
                                        }

                                        if (this.intarray[(i2 + k1) * j1
                                                + (j2 + k1 + 1) * b1 + k2 + k1] == -2) {
                                            this.intarray[(i2 + k1) * j1
                                                    + (j2 + k1 + 1) * b1 + k2
                                                    + k1] = l1;
                                        }

                                        if (this.intarray[(i2 + k1) * j1
                                                + (j2 + k1) * b1
                                                + (k2 + k1 - 1)] == -2) {
                                            this.intarray[(i2 + k1) * j1
                                                    + (j2 + k1) * b1
                                                    + (k2 + k1 - 1)] = l1;
                                        }

                                        if (this.intarray[(i2 + k1) * j1
                                                + (j2 + k1) * b1 + k2 + k1 + 1] == -2) {
                                            this.intarray[(i2 + k1) * j1
                                                    + (j2 + k1) * b1 + k2 + k1
                                                    + 1] = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                l1 = this.intarray[k1 * j1 + k1 * b1 + k1];

                if (l1 >= 0) {
                    world.setBlockMetadataWithNotify(x, y, z, l & -9, 4);
                } else {
                    this.removeLeaves(world, x, y, z);
                }
            }
        }
    }
    /**
     * A randomly called display update to be able to add particles or other
     * items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z,	Random parRandom1) {
        if (world.canLightningStrikeAt(x, y + 1, z)
                && !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
                && parRandom1.nextInt(15) == 1) {
            double d0 = (double) ((float) x + parRandom1.nextFloat());
            double d1 = (double) y - 0.05D;
            double d2 = (double) ((float) z + parRandom1.nextFloat());
            world.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
	

}
