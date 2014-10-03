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

import com.professorvennie.lib.base.blocks.BlockModContainer;
import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.tileEntity.TileEntityMod;
import com.professorvennie.machinerycraft.tileEntity.TileEntityPlasticChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BlockPlasticChest extends BlockModContainer {

    public static boolean keepInventory;
    private Random rand = new Random();

    protected BlockPlasticChest() {
        super(Material.wood, Names.Blocks.BLOCK_PLASTIC_CHEST);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        keepInventory = false;
        setBlockTextureName(Reference.MOD_ID + ":plastic_Chest");
        setHardness(2.0F);
        setHarvestLevel("axe", 0);
        setStepSound(Block.soundTypeWood);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0f / 360.0f) + 0.5D) & 3;
        TileEntityMod tile = (TileEntityMod)world.getTileEntity(x, y, z);

        if (l == 0) {
            tile.setOrientation(ForgeDirection.NORTH);
        }

        if (l == 1) {
            tile.setOrientation(ForgeDirection.EAST);
        }

        if (l == 2) {
            tile.setOrientation(ForgeDirection.SOUTH);
        }

        if (l == 3) {
            tile.setOrientation(ForgeDirection.WEST);
        }

        if (itemStack.hasDisplayName()) {
            ((TileEntityMod) world.getTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 22;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!player.isSneaking() && !world.isSideSolid(x, y + 1, z, ForgeDirection.SOUTH)) {
            if (!world.isRemote) {
                player.openGui(MachineryCraft.instance, LibGuiIds.GUIID_PLASTIC_CHEST, world, x, y, z);
            }
        }
        return true;
    }

    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventData) {
        super.onBlockEventReceived(world, x, y, z, eventId, eventData);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(eventId, eventData);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityPlasticChest();
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int side) {
        if (!keepInventory) {
            TileEntityPlasticChest tileEntityPlasticChest = (TileEntityPlasticChest) world.getTileEntity(x, y, z);
            if (tileEntityPlasticChest != null) {
                for (int i = 0; i < tileEntityPlasticChest.getSizeInventory(); i++) {
                    ItemStack itemStack = tileEntityPlasticChest.getStackInSlot(i);

                    if (itemStack != null) {
                        float f = this.rand.nextFloat() * 0.6F + 01F;//x
                        float f1 = this.rand.nextFloat() * 0.6F + 01F;//y
                        float f2 = this.rand.nextFloat() * 0.6F + 01F;//z

                        while (itemStack.stackSize > 0) {
                            int j = this.rand.nextInt(21) + 10;

                            if (j > itemStack.stackSize)
                                j = itemStack.stackSize;

                            itemStack.stackSize -= j;
                            EntityItem entityItem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));

                            if (itemStack.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                            }

                            float f3 = 0.025F;
                            entityItem.motionX = (double) ((float) this.rand.nextGaussian() * f3);
                            entityItem.motionY = (double) ((float) this.rand.nextGaussian() * f3 + 0.1F);
                            entityItem.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

                            world.spawnEntityInWorld(entityItem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.breakBlock(world, x, y, z, block, side);
    }
}
