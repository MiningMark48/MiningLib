package com.miningmark48.mininglib.utility;

import com.miningmark48.mininglib.MiningLib;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class ModLogger {

    /**
     *
     * @param logLevel
     *  Level the log message is rated at using the Level class.
     *      ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN
     * @param object
     *  Message to be displayed in console.
     */
    public static void log(Level logLevel, Object object){
        FMLLog.log(MiningLib.MOD_NAME, logLevel, String.valueOf(object));
    }

    public static void all(Object object) { log(Level.ALL, object); }

    public static void debug(Object object) { log(Level.DEBUG, object); }

    public static void error(Object object) { log(Level.ERROR, object); }

    public static void fatal(Object object) { log(Level.FATAL, object); }

    public static void info(Object object) { log(Level.INFO, object); }

    public static void off(Object object) { log(Level.OFF, object); }

    public static void trace(Object object) { log(Level.TRACE, object); }

    public static void warn(Object object) { log(Level.WARN, object); }

}
