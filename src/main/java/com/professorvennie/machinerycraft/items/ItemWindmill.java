/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.items;

import com.professorvennie.lib.base.items.ItemBase;
import com.professorvennie.machinerycraft.block.ModBlocks;
import com.professorvennie.machinerycraft.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWindmill extends ItemBase {

    public ItemWindmill() {
        super(Names.Items.WINDMILL);
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float x2, float y2, float z2) {
        if (!world.isRemote) {
            if (side == EnumFacing.UP && world.getBlockState(pos).equals(ModBlocks.windmillground)/* && world.getBlockMetadata(x, y, z) == 5*/) {
                boolean notEnoughspace = false;
                for (int x1 = -1; x1 < 1; x1++) {
                    for (int z1 = -1; z1 < 1; z1++) {
                        for (int y1 = 0; y1 < 7; y1++) {
                            if (!world.isAirBlock(new BlockPos(pos.getX() + x1, pos.getY() + y1 + 1, pos.getZ() + z1))) notEnoughspace = true;
                        }

                    }
                }
                if (!notEnoughspace) {
                    int direction = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
                    int meta = 0;
                    if (direction == 0) meta = EnumFacing.WEST.ordinal();
                    if (direction == 1) meta = EnumFacing.SOUTH.ordinal();
                    if (direction == 2) meta = EnumFacing.NORTH.ordinal();
                    if (direction == 3) meta = EnumFacing.EAST.ordinal();
                    if (itemstack.stackSize > 0)
                        itemstack.stackSize -= 1;
                    for (int y1 = 0; y1 < 7; y1++) {
                        world.setBlockState(new BlockPos(pos.getX(), pos.getY() + y1 + 1, pos.getZ()), ModBlocks.windmill.getDefaultState(), (y1 + 1) == 7 ? (y1 + 1 + meta) : (y1 + 1));
                    }
                    return true;
                }
            }

        }
        return false;
    }
}
