package com.professorvennie.machinerycraft.tileEntity;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by ProfessorVennie on 9/3/2014 at 2:14 PM.
 */
public class TileEntityBlockPlacer extends TileEntityBasicInventory {

    public TileEntityBlockPlacer() {
        super("container.BlockPlacer");
    }

    @Override
    public void updateEntity() {
        super.updateEntity();

        ForgeDirection direction = getOrientation();

        if(direction == ForgeDirection.NORTH){
            placeBlock(ForgeDirection.NORTH);
        }else if(direction == ForgeDirection.SOUTH){
            placeBlock(ForgeDirection.SOUTH);
        }else if(direction == ForgeDirection.WEST){
            placeBlock(ForgeDirection.WEST);
        }else if(direction == ForgeDirection.EAST){
            placeBlock(ForgeDirection.EAST);
        }else if(direction == ForgeDirection.UP){
            placeBlock(ForgeDirection.UP);
        }else if(direction == ForgeDirection.DOWN){
            placeBlock(ForgeDirection.DOWN);
        }
    }

    public void placeBlock(ForgeDirection direction){
        Block block;
        if(direction == ForgeDirection.NORTH){
            block = worldObj.getBlock(xCoord, yCoord, zCoord - 1);
            if(block == Blocks.air){
                for(ItemStack itemStack : inventory){
                    if(itemStack != null){
                        worldObj.setBlock(xCoord, yCoord, zCoord - 1, Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage(), 2);
                    }
                }
            }
        }else if(direction == ForgeDirection.SOUTH){
            block = worldObj.getBlock(xCoord, yCoord, zCoord + 1);
            if(block == Blocks.air){
                for(ItemStack itemStack : inventory){
                    if(itemStack != null){
                        worldObj.setBlock(xCoord, yCoord, zCoord + 1, Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage(), 2);
                    }
                }
            }
        }else if(direction == ForgeDirection.WEST){
            block = worldObj.getBlock(xCoord - 1, yCoord, zCoord);
            if(block == Blocks.air){
                for(ItemStack itemStack : inventory){
                    if(itemStack != null){
                        worldObj.setBlock(xCoord - 1, yCoord , zCoord, Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage(), 2);
                    }
                }
            }
        }else if(direction == ForgeDirection.EAST){
            block = worldObj.getBlock(xCoord + 1, yCoord, zCoord);
            if(block == Blocks.air){
                for(ItemStack itemStack : inventory){
                    if(itemStack != null){
                        worldObj.setBlock(xCoord + 1, yCoord, zCoord, Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage(), 2);
                    }
                }
            }
        }else if(direction == ForgeDirection.UP){
            block = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
            if(block == Blocks.air){
                for(ItemStack itemStack : inventory){
                    if(itemStack != null){
                        worldObj.setBlock(xCoord, yCoord + 1, zCoord, Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage(), 2);
                    }
                }
            }
        }else if(direction == ForgeDirection.DOWN){
            block = worldObj.getBlock(xCoord, yCoord - 1, zCoord);
            if(block == Blocks.air){
                for(ItemStack itemStack : inventory){
                    if(itemStack != null){
                        worldObj.setBlock(xCoord, yCoord - 1, zCoord, Block.getBlockFromItem(itemStack.getItem()), itemStack.getItemDamage(), 2);
                    }
                }
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }
}
