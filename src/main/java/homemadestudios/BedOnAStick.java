package homemadestudios;

import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = BedOnAStick.MODID, name = BedOnAStick.NAME, version = BedOnAStick.VERSION)
public class BedOnAStick {

    public static final String MODID = "bedonastick";
    public static final String NAME = "Bed on a Stick";
    public static final String VERSION = "1.0.0";

    private static Logger logger;
    public static SimpleNetworkWrapper network;
    /*
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    */

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        //network.registerMessage(PacketSleep.class, PacketSleep.class, 0, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Mod initialised :" + NAME);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
