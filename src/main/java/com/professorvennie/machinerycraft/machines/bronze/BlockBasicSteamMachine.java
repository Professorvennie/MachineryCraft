/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.api.steam.ISteamBoiler;
import com.professorvennie.machinerycraft.api.steam.ISteamTank;
import com.professorvennie.machinerycraft.items.ModItems;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by ProfessorVennie on 8/23/2014 at 3:18 PM.
 */
public class BlockBasicSteamMachine extends BlockBasicMachine {

    public BlockBasicSteamMachine(String name, boolean isActive) {
        super(name, isActive);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof ISteamTank) {
                if (tileEntity instanceof ISteamBoiler) {
                    if (player.getHeldItem() != null) {
                        if (player.getHeldItem().getItem() == Items.water_bucket) {
                            if (((ISteamBoiler) tileEntity).getWaterAmount() < ((ISteamBoiler) tileEntity).getWaterCapacity()) {
                                int temp = ((ISteamBoiler) tileEntity).getWaterCapacity() - ((ISteamBoiler) tileEntity).getWaterAmount();
                                if (temp >= 1000) {
                                    ((ISteamBoiler) tileEntity).setWaterAmount(1000);
                                    if (!player.capabilities.isCreativeMode)
                                        player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                                } else
                                    player.addChatComponentMessage(new ChatComponentText("Not enough room for water.  Only" + temp + "mb left of room out of " + ((ISteamBoiler) tileEntity).getWaterCapacity() + "mb."));
                            } else
                                player.addChatComponentMessage(new ChatComponentText("Water tank is full."));
                        } else
                            player.openGui(MachineryCraft.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
                    } else
                        player.openGui(MachineryCraft.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
                } else if (player.getHeldItem() != null) {
                    if (player.getHeldItem().getItem() == ModItems.steamBucket) {
                        if (((ISteamTank) tileEntity).getSteamAmount() < ((ISteamTank) tileEntity).getSteamCapacity()) {
                            int temp = ((ISteamTank) tileEntity).getSteamCapacity() - ((ISteamTank) tileEntity).getSteamAmount();
                            if (temp >= 1000) {
                                ((ISteamTank) tileEntity).addSteamAmount(1000);
                                if (!player.capabilities.isCreativeMode)
                                    player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                            } else
                                player.addChatComponentMessage(new ChatComponentText("Not enough room for steam.  Only" + temp + "mb left of room out of " + ((ISteamTank) tileEntity).getSteamCapacity() + "mb."));
                        } else
                            player.addChatComponentMessage(new ChatComponentText("Steam tank is full."));
                    } else if (player.getHeldItem().getItem() == Items.bucket) {
                        if (((ISteamTank) tileEntity).getSteamAmount() >= 1000) {
                            ((ISteamTank) tileEntity).addSteamAmount(-1000);
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
                        player.openGui(MachineryCraft.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
                } else
                    player.openGui(MachineryCraft.instance, guiId, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (world.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()))) {
            if (isActive) {
                float x1 = (float) pos.getX() + 0.5f;
                float y1 = (float) pos.getY() + 1.0f;
                float z1 = (float) pos.getZ() + 0.5f;
                float f1 = random.nextFloat() * 0.6F - 0.3F;

                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 + f1), (double) y1, (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 - f1), (double) y1, (double) (z1 + f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 + f1), (double) y1, (double) (z1 - f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 - f1), (double) y1, (double) (z1 - f1), 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) x1, (double) (y1 + f1), (double) z1, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) (x1 + f1), (double) (y1 + f1), (double) z1, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
