package com.professorvennie.machinerycraft.machines.bronze.alloy;

import com.professorvennie.machinerycraft.client.gui.GuiBase;
import com.professorvennie.machinerycraft.lib.Reference;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ProfessorVennie on 10/6/2014 at 4:35 PM.
 */
public class GuiBronzeAlloy extends GuiBase {

    private TileEntityBronzeAlloy tile;

    public GuiBronzeAlloy(InventoryPlayer inventory, TileEntityBronzeAlloy tile) {
        super(new ContainerBronzeAlloy(inventory, tile), tile);
        this.tile = tile;

        backGround = new ResourceLocation(Reference.MOD_ID, "textures/gui/BronzeAlloy");
    }
}
