/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.block.machines;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.core.main.MachineryCraft;
import com.professorvennie.machinerycraft.core.tileEntity.TileEntityMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBasicMachine extends BlockContainer implements IBookable{

    private static String name;
    @SideOnly(Side.CLIENT)
    public IIcon iconFront, iconTop;
    public boolean isActive;
    public static boolean keepInventory;
    public final Random rand = new Random();
    public int guiId = -1;


    public BlockBasicMachine(String name, boolean isActive) {
        super(Material.iron);
        BlockBasicMachine.name = name;
        this.isActive = isActive;
        if(isActive){
            setLightLevel(0.9F);
            setBlockName(name + "Active");
        }else if(!isActive){
            setCreativeTab(MachineryCraft.tabMachineryCraft);
            setBlockName(name + "Idle");
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
    }

    public TileEntity createNewTileEntity(World world, int i) {
        return null;
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefualtDirection(world, x, y, z);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!world.isRemote){
            player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
        }
        return true;
    }

    private void setDefualtDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block l = world.getBlock(x, y, z - 1);
            Block il = world.getBlock(x, y, z + 1);
            Block jl = world.getBlock(x - 1, y, z);
            Block kl = world.getBlock(x + 1, y, z - 1);
            byte b0 = 3;

            if (l.isNormalCube() && !il.isNormalCube()) {
                b0 = 3;
            }

            if (il.isNormalCube() && !l.isNormalCube()) {
                b0 = 2;
            }

            if (kl.isNormalCube() && !jl.isNormalCube()) {
                b0 = 5;
            }

            if (jl.isNormalCube() && !kl.isNormalCube()) {
                b0 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
        int l = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemstack.hasDisplayName()) {
            ((TileEntityMod) world.getTileEntity(x, y, z)).setCustomName(itemstack.getDisplayName());
        }
    }

    public static void updateBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord, Block blockActive, Block blockIdle) {
        int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;

        if (active) {
            worldObj.setBlock(xCoord, yCoord, zCoord, blockActive);
        } else {
            worldObj.setBlock(xCoord, yCoord, zCoord, blockIdle);
        }

        keepInventory = false;

        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

        if (tileentity != null) {
            tileentity.validate();
            worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (this.isActive) {
            int direction = world.getBlockMetadata(x, y, z);

            float x1 = (float) x + 0.5F;
            float y1 = (float) y + random.nextFloat();
            float z1 = (float) z + 0.5F;


            float f = 0.52F;
            float f1 = random.nextFloat() * 0.6F - 0.3F;

            if (direction == 4) {
                world.spawnParticle("smoke", (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
            } else if (direction == 5) {
                world.spawnParticle("smoke", (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
            } else if (direction == 2) {
                world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0.0D, 0.0D, 0.0D);
            } else if (direction == 3) {
                world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int side){
        if(!keepInventory) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);

            if (!(tileEntity instanceof ISidedInventory)) {
                return;
            }

            ISidedInventory inventory = (ISidedInventory) tileEntity;

            for (int i = 0; i < inventory.getSizeInventory(); i++) {

                ItemStack itemStack = inventory.getStackInSlot(i);

                if (itemStack != null && itemStack.stackSize > 0) {

                    Random rand = new Random();

                    float dX = rand.nextFloat() * 0.8F + 0.1F;
                    float dY = rand.nextFloat() * 0.8F + 0.1F;
                    float dZ = rand.nextFloat() * 0.8F + 0.1F;

                    EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, itemStack.copy());

                    if (itemStack.hasTagCompound()) {
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                    }

                    float factor = 0.05F;
                    entityItem.motionX = rand.nextGaussian() * factor;
                    entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                    entityItem.motionZ = rand.nextGaussian() * factor;
                    world.spawnEntityInWorld(entityItem);
                    itemStack.stackSize = 0;
                }
            }
        }
        super.breakBlock(world, x, y, z, block, side);
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack book) {
        return null;
    }
}
