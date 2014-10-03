package com.professorvennie.machinerycraft.core.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

/**
 * Created by ProfessorVennie on 9/27/2014 at 1:54 PM.
 */
public class MessageCoords implements IMessage {

    public int x;
    public int y;
    public int z;

    public MessageCoords() {
    }

    public MessageCoords(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }
}
