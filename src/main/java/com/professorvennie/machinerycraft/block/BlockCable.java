/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.block;

import com.professorvennie.lib.base.blocks.BlockBase;
import com.professorvennie.machinerycraft.api.book.BookEntry;
import com.professorvennie.machinerycraft.api.book.IBookable;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.tileEntity.TileEntityCable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockCable extends BlockBase implements IBookable, ITileEntityProvider {

    protected BlockCable() {
        super(Material.rock, Names.Blocks.CABLE);
        float pixel = 1F / 16F;
        this.setBlockBounds(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2);
        this.useNeighborBrightness = true;
        setStepSound(Block.soundTypeMetal);
        //setHarvestLevel("pickAxe", 2);
        setHardness(5.0f);
    }

    public AxisAlignedBB getSelectedBoundingBox(World world, BlockPos pos) {
        TileEntityCable cable = (TileEntityCable) world.getTileEntity(pos);

        if (cable != null) {
            float pixel = 1F / 16F;
            float minX = 11 * pixel / 2 - (cable.connections[5] != null ? (11 * pixel / 2) : 0);
            float minY = 11 * pixel / 2 - (cable.connections[1] != null ? (11 * pixel / 2) : 0);
            float minZ = 11 * pixel / 2 - (cable.connections[2] != null ? (11 * pixel / 2) : 0);
            float maxX = 1 - 11 * pixel / 2 + (cable.connections[3] != null ? (11 * pixel / 2) : 0);
            float maxY = 1 - 11 * pixel / 2 + (cable.connections[0] != null ? (11 * pixel / 2) : 0);
            float maxZ = 1 - 11 * pixel / 2 + (cable.connections[4] != null ? (11 * pixel / 2) : 0);

            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);

        }
        return AxisAlignedBB.fromBounds(pos.getX() + this.minX, pos.getY() + this.minY, pos.getZ() + this.minZ, pos.getX() + this.maxX, pos.getY() + this.maxY, pos.getZ() + this.maxZ);
    }

    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
        TileEntityCable cable = (TileEntityCable) world.getTileEntity(pos);

        if (cable != null) {
            float pixel = 1F / 16F;
            float minX = 11 * pixel / 2 - (cable.connections[5] != null ? (11 * pixel / 2) : 0);
            float minY = 11 * pixel / 2 - (cable.connections[1] != null ? (11 * pixel / 2) : 0);
            float minZ = 11 * pixel / 2 - (cable.connections[2] != null ? (11 * pixel / 2) : 0);
            float maxX = 1 - 11 * pixel / 2 + (cable.connections[3] != null ? (11 * pixel / 2) : 0);
            float maxY = 1 - 11 * pixel / 2 + (cable.connections[0] != null ? (11 * pixel / 2) : 0);
            float maxZ = 1 - 11 * pixel / 2 + (cable.connections[4] != null ? (11 * pixel / 2) : 0);

            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);

        }
        return AxisAlignedBB.fromBounds(pos.getX() + this.minX, pos.getY() + this.minY, pos.getZ() + this.minZ, pos.getX() + this.maxX, pos.getY() + this.maxY, pos.getZ() + this.maxZ);    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityCable();
    }

    @Override
    public BookEntry getEntry(World world, int x, int y, int z, EntityPlayer player, ItemStack lexicon) {
        return null;
    }
}
