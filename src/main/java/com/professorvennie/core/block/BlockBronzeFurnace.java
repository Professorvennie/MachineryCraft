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

import java.util.Random;

public class BlockBronzeFurnace extends BlockBasicMachine {

    public BlockBronzeFurnace(boolean isActive) {
        super(Names.Blocks.BRONZE_FURNACE, isActive);
        guiId = LibGuiIds.BRONZE_FURNACE;
    }

    @Override
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemFromBlock(ModBlocks.bronzeFurnaceIdle);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(ModBlocks.bronzeFurnaceIdle);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!world.isRemote){
            TileEntityBronzeFurnace tileEntity = (TileEntityBronzeFurnace) world.getTileEntity(x, y, z);
            if(player.getHeldItem() != null){
                if(player.getHeldItem().getItem() == ModItems.steamBucket) {
                    if (tileEntity.tanks[0].getFluidAmount() < tileEntity.tanks[0].getCapacity()) {
                        int temp = tileEntity.tanks[0].getCapacity() - tileEntity.tanks[0].getFluidAmount();
                        if(temp >= 1000) {
                            tileEntity.tanks[0].fill(new FluidStack(ModFuilds.fluidSteam, 1000), true);
                            if(!player.capabilities.isCreativeMode)
                                player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                        }else
                            player.addChatComponentMessage(new ChatComponentText("Not enough room for steam.  Only" + temp + "mb left of room out of " + tileEntity.tanks[0].getCapacity() + "mb."));
                    }else
                        player.addChatComponentMessage(new ChatComponentText("Steam tank is full."));
                }else if(player.getHeldItem().getItem() == Items.bucket ){
                    if(tileEntity.tanks[0].getFluidAmount() >= 1000){
                        tileEntity.tanks[0].drain(1000, true);
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
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "bronzeFurnace_Front_Active" : "bronzeFurnace_Front_Idle"));
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
}
