package com.professorvennie.machinerycraft.machines.brass.charger;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ProfessorVennie on 9/29/2014 at 4:15 PM.
 */
public class GuiBrassCharger extends GuiBase {

    public GuiBrassCharger(InventoryPlayer inventory, TileEntityBrassCharger entity) {
        super(new ContainerBrassCharger(inventory, entity), entity);
        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/brassCharger.png");
    }
}
