package com.professorvennie.core.block;

import com.professorvennie.api.book.BookEntry;
import com.professorvennie.core.fuilds.ModFuilds;
import com.professorvennie.core.item.ModItems;
import com.professorvennie.core.lib.LibGuiIds;
import com.professorvennie.core.lib.Names;
import com.professorvennie.core.lib.Reference;
import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.tileEntity.TileEntityBronzeSteamBoiler;
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
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockBronzeSteamBoiler extends BlockBasicMachine {

    public BlockBronzeSteamBoiler() {
        super(Names.Blocks.BRONZE_STEAM_BOILER, false);
        guiId = LibGuiIds.BRONZE_STEAM_BOILER;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBronze");
        iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeMachines_Top");
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeSteamBoiler_Front");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if(side == 1)
            return iconTop;
        else if(side == metadata)
            return iconFront;
        else if(metadata == 0 && side == 3)
            return iconFront;
        else
            return blockIcon;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!world.isRemote){
            TileEntityBronzeSteamBoiler entity = (TileEntityBronzeSteamBoiler)world.getTileEntity(x, y, z);
            if(player.getHeldItem() != null){
                if(player.getHeldItem().getItem() == Items.water_bucket){
                    if(entity.tanks[1].getFluidAmount() < entity.tanks[1].getCapacity()){
                        int temp = entity.tanks[1].getCapacity() - entity.tanks[1].getFluidAmount();
                        if(temp >= 1000){
                            entity.tanks[1].fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                            if(!player.capabilities.isCreativeMode)
                                player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
                        }else
                            player.addChatComponentMessage(new ChatComponentText("Not enough room for water.  Only " + temp + "mb left of room."));
                    }else
                        player.addChatComponentMessage(new ChatComponentText("Water tank is full."));
                }else if(player.getHeldItem().getItem() == Items.bucket){
                    if(entity.tanks[0].getFluidAmount() >= 1000){
                        entity.tanks[0].drain(1000, true);
                        if(player.getHeldItem().stackSize == 1)
                             player.setCurrentItemOrArmor(0, new ItemStack(ModItems.steamBucket));
                        else {
                            player.getHeldItem().stackSize--;
                            int slot = player.inventory.getFirstEmptyStack();
                            player.inventory.setInventorySlotContents(slot, new ItemStack(ModItems.steamBucket));
                            player.inventoryContainer.detectAndSendChanges();
                        }
                    }else
                        player.addChatComponentMessage(new ChatComponentText("Not a full bucket of steam to drain."));
                }else
                    player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
            }else
                player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeSteamBoiler();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return super.getEntry(world, x, y, z, player, lexicon);
    }
}
