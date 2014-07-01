package com.professorvennie.core.block;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.api.book.IBookable;
import com.professorvennie.core.block.tileEntity.TileEntitySaltFurnace;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MainRegistry;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBasicMachine extends BlockContainer implements IBookable{

    private static String Name;
    @SideOnly(Side.CLIENT)
    public IIcon iconFront;
    public boolean isActive;
    private static boolean keepInventory;
    private final Random rand = new Random();


    public BlockBasicMachine(String name, boolean isActive) {
        super(Material.iron);
        Name = name;
        this.isActive = isActive;
        if(isActive){
            setLightLevel(0.9F);
            setBlockName(name + "Active");
        }else if(!isActive){
            setCreativeTab(MainRegistry.tabMachineryCraft);
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

    public void onBlockPlacedBy(World world, int x, int y, int z,
        EntityLivingBase entityLivingBase, ItemStack itemstack) {
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
            ((TileEntitySaltFurnace) world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
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
    public void randomDisplayTick(World world, int x, int y, int z,
                                  Random random) {
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
        //todo
//        if (!keepInventory)
//        {
//            TileEntitySaltFurnace TileEntitySaltFurnace = (TileEntitySaltFurnace)world.getTileEntity(x, y, z);
//
//            if (TileEntitySaltFurnace != null)
//            {
//                for (int i1 = 0; i1 < TileEntitySaltFurnace.getSizeInventory(); ++i1)
//                {
//                    ItemStack itemstack = TileEntitySaltFurnace.getStackInSlot(i1);
//
//                    if (itemstack != null)
//                    {
//                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
//                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
//                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
//
//                        while (itemstack.stackSize > 0)
//                        {
//                            int j1 = this.rand.nextInt(21) + 10;
//
//                            if (j1 > itemstack.stackSize)
//                            {
//                                j1 = itemstack.stackSize;
//                            }
//
//                            itemstack.stackSize -= j1;
//                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
//
//                            if (itemstack.hasTagCompound())
//                            {
//                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
//                            }
//
//                            float f3 = 0.05F;
//                            entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
//                            entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
//                            entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
//                            world.spawnEntityInWorld(entityitem);
//                        }
//                    }
//                }
//
//                world.func_147453_f(x, y, z, block);
//            }
//        }
//
//        super.breakBlock(world, x, y, z, block, side);
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
