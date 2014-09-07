package com.professorvennie.machinerycraft.block;

import com.professorvennie.machinerycraft.MachineryCraft;
import com.professorvennie.machinerycraft.core.utils.ForgeDirectionUtils;
import com.professorvennie.machinerycraft.tileEntity.TileEntityMod;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by ProfessorVennie on 9/2/2014 at 3:39 PM.
 */
public class BlockModContainer extends BlockContainer {

    public int guiId;

    public BlockModContainer(Material mat, String name) {
        super(mat);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setBlockName(name);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote){
            player.openGui(MachineryCraft.instance, guiId, world, x, y, z);
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack){
        TileEntityMod tile = (TileEntityMod)world.getTileEntity(x, y, z);
        tile.setOrientation(ForgeDirectionUtils.getDirectionFacing(entityLiving, true).getOpposite());
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
