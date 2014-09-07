/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.block.machines.steam;

import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.core.lib.LibGuiIds;
import com.professorvennie.machinerycraft.core.lib.Names;
import com.professorvennie.machinerycraft.core.lib.Reference;
import com.professorvennie.machinerycraft.core.tileEntity.machines.steam.TileEntityBronzeSteamBoiler;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBronzeSteamBoiler extends BlockBasicSteamMachine {

    public BlockBronzeSteamBoiler() {
        super(Names.Blocks.BRONZE_STEAM_BOILER, false);
        guiId = LibGuiIds.BRONZE_STEAM_BOILER;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + "bronzeSteamBoiler_Front");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
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
