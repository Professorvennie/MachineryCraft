/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.machines.brass.generators.solar;

import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.BlockBasicMachine;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:04 PM.
 */
public class BlockBrassSolarGenerator extends BlockBasicMachine {

    public BlockBrassSolarGenerator() {
        super(Names.Blocks.BRASS_SOLAR_GEN, false);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityBrassSolarGenerator) {
            TileEntityBrassSolarGenerator tile = (TileEntityBrassSolarGenerator) world.getTileEntity(x, y, z);
            if (!world.isRemote)
                player.addChatComponentMessage(new ChatComponentText("Power lever - " + tile.getPower()));
        }
        return true;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":ores/" + "blockBrass");
        iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":brassSolar_Top");
        iconSide = iconRegister.registerIcon(Reference.MOD_ID + ":brassSolar_Side");
    }

    @Override
    public IIcon getIcon(int side, int metadata) {
        if (side == 1)
            return iconTop;
        if (side == 3 || side == 2 || side == 4 || side == 5)
            return iconSide;

        return blockIcon;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBrassSolarGenerator();
    }
}
