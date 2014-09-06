/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.core.block.machines.steam;

import com.professorvennie.api.steam.ISteamBoiler;
import com.professorvennie.api.steam.ISteamTank;
import com.professorvennie.core.block.machines.BlockBasicMachine;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by ProfessorVennie on 8/23/2014 at 3:18 PM.
 */
public class BlockBasicSteamMachine extends BlockBasicMachine {

    public BlockBasicSteamMachine(String name, boolean isActive) {
        super(name, isActive);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if(side == 1)
            return iconTop;
        else if(side == metadata)
            return iconFront;
        else if(metadata  == 0 && side == 3)
            return iconFront;
        else
            return blockIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBronze");
        iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeMachines_Top");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity instanceof ISteamTank) {
                if(tileEntity instanceof ISteamBoiler){
                    if(player.getHeldItem() != null){
                        if(player.getHeldItem().getItem() == Items.water_bucket){
                            if(((ISteamBoiler)tileEntity).getWaterAmount() < ((ISteamBoiler)tileEntity).getWaterCapacity()){
                                int temp = ((ISteamBoiler)tileEntity).getWaterCapacity() - ((ISteamBoiler)tileEntity).getWaterAmount();
                                if(temp >= 1000){
                                    ((ISteamBoiler)tileEntity).setWaterAmount(1000);
                                    if (!player.capabilities.isCreativeMode)
                                        player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                                }else
                                    player.addChatComponentMessage(new ChatComponentText("Not enough room for water.  Only" + temp + "mb left of room out of " + ((ISteamBoiler)tileEntity).getWaterCapacity() + "mb."));
                            }else
                                player.addChatComponentMessage(new ChatComponentText("Water tank is full."));
                        }else
                            player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
                    }else
                        player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
                }else if (player.getHeldItem() != null) {
                    if (player.getHeldItem().getItem() == ModItems.steamBucket) {
                        if (((ISteamTank)tileEntity).getSteamAmount() < ((ISteamTank)tileEntity).getSteamCapacity()) {
                            int temp = ((ISteamTank)tileEntity).getSteamCapacity() - ((ISteamTank)tileEntity).getSteamAmount();
                            if (temp >= 1000) {
                                ((ISteamTank)tileEntity).addSteamAmount(1000);
                                if (!player.capabilities.isCreativeMode)
                                    player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                            } else
                                player.addChatComponentMessage(new ChatComponentText("Not enough room for steam.  Only" + temp + "mb left of room out of " + ((ISteamTank)tileEntity).getSteamCapacity() + "mb."));
                        } else
                            player.addChatComponentMessage(new ChatComponentText("Steam tank is full."));
                    } else if (player.getHeldItem().getItem() == Items.bucket) {
                        if (((ISteamTank)tileEntity).getSteamAmount() >= 1000) {
                            ((ISteamTank)tileEntity).addSteamAmount(-1000);
                            if (player.getHeldItem().stackSize == 1)
                                player.setCurrentItemOrArmor(0, new ItemStack(ModItems.steamBucket));
                            else {
                                player.getHeldItem().stackSize--;
                                int slot = player.inventory.getFirstEmptyStack();
                                player.inventory.setInventorySlotContents(slot, new ItemStack(ModItems.steamBucket));
                                player.inventoryContainer.detectAndSendChanges();
                            }
                        } else
                            player.addChatComponentMessage(new ChatComponentText("Not enough steam to drain."));
                    } else
                        player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
                } else
                    player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
            }
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (world.isAirBlock(x, y + 1, z)) {
            if (isActive) {
                float x1 = (float) x + 0.5f;
                float y1 = (float) y + 1.0f;
                float z1 = (float) z + 0.5f;
                float f1 = random.nextFloat() * 0.6F - 0.3F;

                world.spawnParticle("smoke", (double) (x1 + f1), (double) y1, (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("smoke", (double) (x1 - f1), (double) y1, (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("smoke", (double) (x1 + f1), (double) y1, (double) (z1 - f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("smoke", (double) (x1 - f1), (double) y1, (double) (z1 - f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("smoke", (double) x1, (double) (y1 + f1), (double) z1, 0.0D, 0.0D, 0.0D);
                world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1 + f1), (double) z1, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
