package com.professorvennie.machinerycraft.core.network;

import com.professorvennie.machinerycraft.lib.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by ProfessorVennie on 9/27/2014 at 1:46 PM.
 */
public class PacketHandler {

    public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init() {
        INSTANCE.registerMessage(MessageButton.class, MessageButton.class, 0, Side.SERVER);
    }
}
