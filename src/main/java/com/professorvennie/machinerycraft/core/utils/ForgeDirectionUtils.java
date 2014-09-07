package com.professorvennie.machinerycraft.core.utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by ProfessorVennie on 9/7/2014 at 12:25 PM.
 */
public class ForgeDirectionUtils {

    public static int getSide(ForgeDirection direction){
        for(int i =0; i < ForgeDirection.VALID_DIRECTIONS.length; i++){
            if(ForgeDirection.VALID_DIRECTIONS[i] == direction)return i;
        }
        return -1;
    }

    public static ForgeDirection getDirectionFacing(EntityLivingBase entity, boolean includeUpAndDown){
        double yaw = entity.rotationYaw;
        while(yaw < 0)
            yaw += 360;
        yaw = yaw % 360;
        if(includeUpAndDown) {
            if (entity.rotationPitch > 45) return ForgeDirection.DOWN;
            else if (entity.rotationPitch < -45) return ForgeDirection.UP;
        }
            if(yaw < 45) return ForgeDirection.SOUTH;
            else if(yaw < 135) return ForgeDirection.WEST;
            else if(yaw < 225) return ForgeDirection.NORTH;
            else if(yaw < 315) return ForgeDirection.EAST;

            else return ForgeDirection.SOUTH;
    }
}
