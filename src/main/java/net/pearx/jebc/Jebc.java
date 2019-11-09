package net.pearx.jebc;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Collections;

@Mod(name = Jebc.NAME, modid = Jebc.MODID, version = Jebc.VERSION, acceptedMinecraftVersions = Jebc.ACCEPTED_MINECRAFT_VERSIONS, dependencies = Jebc.DEPENDENCIES)
public class Jebc {
    @Mod.Instance
    public static Jebc INSTANCE;

    public static final String NAME = "Just Enough BrewCraft";
    public static final String MODID = "jebc";
    public static final String VERSION = "";
    public static final String DESCRIPTION = "";
    public static final String ACCEPTED_MINECRAFT_VERSIONS = "";
    public static final String DEPENDENCIES = "";

    private Logger log;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        log = e.getModLog();
        setupMetadata(e.getModMetadata());
    }

    private void setupMetadata(ModMetadata d) {
        d.autogenerated = false;
        d.authorList = Collections.singletonList("mrAppleXZ");
        d.description = DESCRIPTION;
        d.version = VERSION;
        d.modId = MODID;
        d.name = NAME;
    }

    public Logger getLog() {
        return log;
    }
}
