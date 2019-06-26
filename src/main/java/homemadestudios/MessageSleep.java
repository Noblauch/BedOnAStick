package homemadestudios;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketUseBed;

public class MessageSleep extends MessageBase<MessageSleep> {

    @Override
    public void handleClientSide(MessageSleep message, EntityPlayer player) {

    }

    @Override
    public void handleServerSide(MessageSleep message, EntityPlayer player) {

    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {

    }

    @Override
    public void toBytes(ByteBuf byteBuf) {

    }
}
