/**
 * This class was created by <Professorvennie>. It's distributed as
 * part of the Machinery Craft Mod. Get the Source Code in github:
 * https://github.com/Professorvennie/MachineryCraft
 *
 * Machinery Craft is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * */
package com.professorvennie.machinerycraft.core.network;

import com.professorvennie.machinerycraft.api.tileentity.IHasButton;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by ProfessorVennie on 9/27/2014 at 1:47 PM.
 */
public class MessageButton extends MessageCoords implements IMessageHandler<MessageButton, IMessage> {

    int id;

    public MessageButton() {
    }

    public MessageButton(int x, int y, int z, int id) {
        super(x, y, z);
        this.id = id;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        super.fromBytes(buf);
        id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        super.toBytes(buf);
        buf.writeInt(id);
    }

    @Override
    public IMessage onMessage(MessageButton message, MessageContext ctx) {
        TileEntity tile = ctx.getServerHandler().playerEntity.worldObj.getTileEntity(message.x, message.y, message.z);
        if (tile != null && tile instanceof IHasButton) {
            ((IHasButton) tile).handleClick(message.id);
        }
        return null;
    }
}
