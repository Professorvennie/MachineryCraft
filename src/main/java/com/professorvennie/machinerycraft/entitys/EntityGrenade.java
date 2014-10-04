/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.entitys;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 8/4/2014 at 10:54 AM.
 */
public class EntityGrenade extends EntityThrowable {

    int meta;

    public EntityGrenade(World world) {
        super(world);
    }

    public EntityGrenade(World world, EntityLivingBase entity, int meta) {
        super(world, entity);
        this.meta = meta;
    }

    @Override
    protected void onImpact(MovingObjectPosition mop) {

        switch (meta) {
            case 0: {
                if (!worldObj.isRemote) {
                    setDead();
                    if (!worldObj.isRemote) {
                        worldObj.createExplosion(this, posX, posY, posZ, 4.0F, true);
                    }
                }
                break;
            }
            case 1: {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        for (int z = 0; z < 4; z++) {
                            if (!worldObj.isRemote) {
                                setDead();
                                int x2 = (int) posX + x;
                                int y2 = (int) posY + y;
                                int z2 = (int) posZ + z;
                                if (worldObj.getBlock(x2, y2, z2) == Blocks.air)
                                    worldObj.setBlock(x2, y2, z2, Blocks.fire);
                            }
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 1; y++) {
                        for (int z = 0; z < 5; z++) {
                            if (!worldObj.isRemote) {
                                setDead();
                                int x2 = (int) posX + x;
                                int y2 = (int) posY + y;
                                int z2 = (int) posZ + z;
                                if (worldObj.getBlock(x2, y2, z2) == Blocks.air)
                                    worldObj.setBlock(x2, y2, z2, Blocks.flowing_water);
                            }
                        }
                    }
                }
                break;
            }
            case 3: {
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 1; y++) {
                        for (int z = 0; z < 5; z++) {
                            if (!worldObj.isRemote) {
                                setDead();
                                int x2 = (int) posX + x;
                                int y2 = (int) posY + y;
                                int z2 = (int) posZ + z;
                                if (worldObj.getBlock(x2, y2, z2) == Blocks.air)
                                    worldObj.setBlock(x2, y2, z2, Blocks.flowing_lava);
                            }
                        }
                    }
                }
                break;
            }
            case 4: {
                if (!worldObj.isRemote) {
                    setDead();
                    if (!worldObj.isRemote) {
                        worldObj.createExplosion(this, posX, posY, posZ, 16.0F, true);
                    }
                }
                break;
            }
            default: {
                if (!worldObj.isRemote)
                    setDead();
            }
        }
    }
}
