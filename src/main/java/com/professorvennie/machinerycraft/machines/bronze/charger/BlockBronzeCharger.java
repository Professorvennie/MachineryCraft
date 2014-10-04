package com.professorvennie.machinerycraft.machines.bronze.charger;

import com.professorvennie.machinerycraft.lib.LibGuiIds;
import com.professorvennie.machinerycraft.lib.Names;
import com.professorvennie.machinerycraft.lib.Reference;
import com.professorvennie.machinerycraft.machines.bronze.BlockBasicSteamMachine;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by ProfessorVennie on 10/4/2014 at 4:11 PM.
 */
public class BlockBronzeCharger extends BlockBasicSteamMachine {

    public BlockBronzeCharger() {
        super(Names.Blocks.BRONZE_CHARGER, false);
        guiId = LibGuiIds.BRONZE_CHARGER;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityBronzeCharger();
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":bronzeChargerFront");
    }
}
