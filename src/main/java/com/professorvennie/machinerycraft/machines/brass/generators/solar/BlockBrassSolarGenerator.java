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
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 9/3/2014 at 6:04 PM.
 */
public class BlockBrassSolarGenerator extends BlockBasicMachine {

    public BlockBrassSolarGenerator() {
        super(Names.Blocks.BRASS_SOLAR_GEN, false);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (world.getTileEntity(pos) instanceof TileEntityBrassSolarGenerator) {
            TileEntityBrassSolarGenerator tile = (TileEntityBrassSolarGenerator) world.getTileEntity(pos);
            if (!world.isRemote)
                player.addChatComponentMessage(new ChatComponentText("Power lever - " + tile.getPower()));
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBrassSolarGenerator();
    }
}
