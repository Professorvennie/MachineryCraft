package com.professorvennie.machinerycraft.core.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;

/**
 * Created by ProfessorVennie on 8/22/2014 at 12:29 AM.
 */
public class EventHandlerClient {

    @SubscribeEvent
    public void renderCustomArmor(RenderPlayerEvent.Specials.Post event){
        for (ItemStack itemStack : event.entityPlayer.inventory.armorInventory) {
            if(itemStack != null){
                if(itemStack.getItem() == Items.diamond_helmet)
                    System.out.println("Diamond");
            }
        }
    }
}
