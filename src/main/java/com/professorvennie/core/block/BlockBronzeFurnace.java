package com.professorvennie.core.block;


import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.tileEntity.TileEntityBronzeFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import java.util.Random;

public class BlockBronzeFurnace extends BlockBasicMachine {

    public BlockBronzeFurnace(boolean isActive) {
        super(Names.Blocks.BRONZE_FURNACE, isActive);
        guiId = LibGuiIds.BRONZE_FURNACE;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!world.isRemote){
            TileEntityBronzeFurnace tileEntity = (TileEntityBronzeFurnace) world.getTileEntity(x, y, z);
            if(player.getHeldItem() != null){
                if(player.getHeldItem().getItem() == ModItems.steamBucket) {
                    if (tileEntity.tank.getFluidAmount() < tileEntity.tank.getCapacity()) {
                        int temp = tileEntity.tank.getCapacity() - tileEntity.tank.getFluidAmount();
                        if(temp >= 1000) {
                            tileEntity.tank.fill(new FluidStack(ModFuilds.fluidSteam, 1000), true);
                            if(!player.capabilities.isCreativeMode)
                                player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                        }else
                            player.addChatComponentMessage(new ChatComponentText("Not enough room for steam.  Only" + temp + "mb left of room out of " + tileEntity.tank.getCapacity() + "mb."));
                    }else
                        player.addChatComponentMessage(new ChatComponentText("Steam tank is full."));
                }else if(player.getHeldItem().getItem() == Items.bucket ){
                    if(tileEntity.tank.getFluidAmount() >= 1000){
                        tileEntity.tank.drain(1000, true);
                        if(player.getHeldItem().stackSize == 1)
                            player.setCurrentItemOrArmor(0, new ItemStack(ModItems.steamBucket));
                        else {
                            player.getHeldItem().stackSize--;
                            int slot = player.inventory.getFirstEmptyStack();
                            player.inventory.setInventorySlotContents(slot, new ItemStack(ModItems.steamBucket));
                            player.inventoryContainer.detectAndSendChanges();
                        }
                    }else
                        player.addChatComponentMessage(new ChatComponentText("Not enough steam to drain."));
                }else
                    player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
            }else
                player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeFurnace();
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBronze");
        iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeMachines_Top");
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeFurnace_Front_Idle");
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
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return super.getEntry(world, x, y, z, player, lexicon);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        TileEntityBronzeFurnace entityBronzeFurnace = (TileEntityBronzeFurnace)world.getTileEntity(x, y, z);
        if(entityBronzeFurnace.cookTime > 0) {
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
