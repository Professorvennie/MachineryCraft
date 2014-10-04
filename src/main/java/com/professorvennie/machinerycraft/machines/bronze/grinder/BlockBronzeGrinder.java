/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.bronze.grinder;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.bronze.BlockBasicSteamMachine;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class BlockBronzeGrinder extends BlockBasicSteamMachine {

    public BlockBronzeGrinder() {
        super(Names.Blocks.BRONZE_GRINDER, false);
        guiId = LibGuiIds.BRONZE_GRINDER;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "bronzeGrinder_Front_Active" : "bronzeGrinder_Front_Idle"));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeGrinder();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return super.getEntry(world, x, y, z, player, lexicon);
    }
}
