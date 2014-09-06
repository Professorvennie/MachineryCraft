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

import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPlasticGrass extends BlockGrass {

    @SideOnly(Side.CLIENT)
    private IIcon field_149991_b;
    @SideOnly(Side.CLIENT)

    public BlockPlasticGrass(){
        super();
        setTickRandomly(true);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setBlockName(Names.Blocks.BLOCK_PLASTIC_GRASS);
        setStepSound(Block.soundTypeGravel);
        setHarvestLevel("shovel", 0);
        setHardness(1.0f);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int p_149691_2_){
        return side == 1 ? this.field_149991_b : (side == 0 ? ModBlocks.plasticDirt.getBlockTextureFromSide(side) : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":plasticGrass_side");
        this.field_149991_b = iconRegister.registerIcon(Reference.MOD_ID + ":plasticGrass_top");
    }

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_){
        return ModBlocks.plasticDirt.getItemDropped(0, random, p_149650_3_);
    }


    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side){
        if (side == 1){
            return this.field_149991_b;
        }
        else if (side == 0){
            return ModBlocks.plasticDirt.getBlockTextureFromSide(side);
        }
        else{
            Material material = iBlockAccess.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.field_149991_b;
        }
    }

    public void updateTick(World world, int x, int y, int z, Random random){
        if (!world.isRemote){
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2){
                world.setBlock(x, y, z, ModBlocks.plasticDirt);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9){
                for (int l = 0; l < 4; ++l){
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);

                    if (world.getBlock(i1, j1, k1) == ModBlocks.plasticDirt && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2){
                        world.setBlock(i1, j1, k1, ModBlocks.plasticGrass);
                    }
                }
            }
        }
    }

//    @SideOnly(Side.CLIENT)
//    public int getBlockColor() {
//        return 1;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int getRenderColor(int p_149741_1_) {
//        return 0;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
//        return 0;
//    }
}
