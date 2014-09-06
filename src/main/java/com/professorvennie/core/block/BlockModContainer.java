package com.professorvennie.core.block;

import com.professorvennie.core.main.MachineryCraft;
import com.professorvennie.core.tileEntity.TileEntityMod;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by ProfessorVennie on 9/2/2014 at 3:39 PM.
 */
public class BlockModContainer extends BlockContainer {

    public BlockModContainer(Material mat, String name) {
        super(mat);
        setCreativeTab(MachineryCraft.tabMachineryCraft);
        setBlockName(name);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack){
        if (world.getTileEntity(x, y, z) instanceof TileEntityMod){
            int direction = 0;
            int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

            if (facing == 0){
                direction = ForgeDirection.NORTH.ordinal();
            }
            else if (facing == 1){
                direction = ForgeDirection.EAST.ordinal();
            }
            else if (facing == 2){
                direction = ForgeDirection.SOUTH.ordinal();
            }
            else if (facing == 3){
                direction = ForgeDirection.WEST.ordinal();
            }

            if (itemStack.hasDisplayName()){
                ((TileEntityMod) world.getTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
            }
               System.out.println(facing);
            ((TileEntityMod) world.getTileEntity(x, y, z)).setOrientation(direction);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
