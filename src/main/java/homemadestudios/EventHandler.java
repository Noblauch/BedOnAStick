package homemadestudios;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class EventHandler {

    @SubscribeEvent
    public void onRightClick(RightClickItem event) {

        EntityPlayer player = event.getEntityPlayer();

        // Only activate on Server-Side
        if (!event.getWorld().isRemote) {
            // Debug:
            player.sendMessage(
                    new TextComponentString("Used: " + player.getHeldItemMainhand().getItem().toString())
            );

            if (player.getHeldItemMainhand().getItem() == Items.BED) {
                sleep((EntityPlayerMP)player);

                /*
                EntityPlayer.SleepResult result = player.trySleep(player.getPosition());
                event.getEntityPlayer().sendMessage(
                        new TextComponentString("SleepResult : " + result )
                );
                */
            }
        }
    }

    public void sleep(EntityPlayerMP player) {
        // Debug
        player.sendMessage(
                new TextComponentString("Sleep Function")
        );

        ObfuscationReflectionHelper.setPrivateValue(EntityPlayer.class, player, true, "sleeping", "field_71083_bS");
        ObfuscationReflectionHelper.setPrivateValue(EntityPlayer.class, player, 0, "sleepTimer", "field_71076_b");
        player.getEntityWorld().updateAllPlayersSleepingFlag();

        SPacketUseBed sleepPacket = new SPacketUseBed(player, player.getPosition());
        //player.getServerWorld().getEntityTracker().sendToTrackingAndSelf(player, sleepPacket);
        player.connection.sendPacket(sleepPacket);
    }
}