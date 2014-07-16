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


import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.tileEntity.TileEntityGoldOxideAlloy;
import com.professorvennie.core.lib.BookData;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockGoldoxideAlloy extends BlockBasicMachine {
    public BlockGoldoxideAlloy(boolean isActive) {
        super(Names.Blocks.GOLDOXIDE_ALLOY, isActive);
        setHardness(5.5F);
        setHarvestLevel("pickaxe", 3);
        setStepSound(Block.soundTypeMetal);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityGoldOxideAlloy();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return BookData.thridTierMachines;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iiconRegister) {
        this.blockIcon = iiconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "metal_5");
        this.iconFront = iiconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "goldoxide_Alloy_Active" : "goldoxide_Alloy_idle"));
    }

    public Item getItemDropped(int par1, Random random, int par2) {
        return Item.getItemFromBlock(ModBlocks.goldOxideAlloyIdle);
    }

    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(ModBlocks.goldOxideAlloyIdle);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, MachineryCraft.instance, LibGuiIds.GUIID_GOLDOXIDE_ALLOY, world, x, y, z);
        }
        return true;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int side){
        if(!keepInventory) {
            TileEntityGoldOxideAlloy tileEntity = (TileEntityGoldOxideAlloy) world.getTileEntity(x, y, z);
            if (tileEntity != null) {
                for (int i = 0; i < tileEntity.getSizeInventory(); i++) {
                    ItemStack itemStack = tileEntity.getStackInSlot(i);

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
