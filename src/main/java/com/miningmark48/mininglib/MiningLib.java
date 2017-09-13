package com.miningmark48.mininglib;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = MiningLib.MOD_ID,
        name = MiningLib.MOD_NAME,
        version = MiningLib.VERSION
)
public class MiningLib {

    public static final String MOD_ID = "mininglib";
    public static final String MOD_NAME = "MiningLib";
    public static final String VERSION = "1.1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
