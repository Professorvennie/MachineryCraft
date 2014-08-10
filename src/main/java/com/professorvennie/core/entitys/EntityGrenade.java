package com.professorvennie.core.entitys;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by ProfessorVennie on 8/4/2014 at 10:54 AM.
 */
public class EntityGrenade extends EntityThrowable{

    public EntityGrenade(World world) {
        super(world);
    }

    public EntityGrenade(World world, EntityLivingBase entity){
        super(world, entity);
    }

    @Override
    protected void onImpact(MovingObjectPosition mop) {
        //nuke grenade
        if(!worldObj.isRemote) {
            setDead();
            if(!worldObj.isRemote) {
                worldObj.createExplosion(this, posX, posY, posZ, 16.0F, true);
            }
        }

        //normal grenade
//        if(!worldObj.isRemote) {
//            setDead();
//            if(!worldObj.isRemote) {
//                worldObj.createExplosion(this, posX, posY, posZ, 4.0F, true);
//            }
//        }

        //fire grenade
//        for(int x = 0; x < 6; x++){
//            for(int y = 0; y < 6; y++) {
//                for (int z = 0; z < 6; z++) {
//                     if(!worldObj.isRemote) {
//                         setDead();
//                         int x2 = (int) posX + x;
//                         int y2 = (int) posY + y;
//                         int z2 = (int) posZ + z;
//                         if (worldObj.getBlock(x2, y2, z2) == Blocks.air)
//                             worldObj.setBlock(x2, y2, z2, Blocks.fire);
//                     }
//                }
//            }
//        }

        //lava/water grenade
//        for(int x = 0; x < 5; x++){
//            for(int y = 0; y < 1; y++) {
//                for (int z = 0; z < 5; z++) {
//                    if(!worldObj.isRemote) {
//                        setDead();
//                        int x2 = (int) posX + x;
//                        int y2 = (int) posY + y;
//                        int z2 = (int) posZ + z;
//                        if (worldObj.getBlock(x2, y2, z2) == Blocks.air)
//                            worldObj.setBlock(x2, y2, z2, Blocks.flowing_lava);
//                    }
//                }
//            }
//        }
    }
}
