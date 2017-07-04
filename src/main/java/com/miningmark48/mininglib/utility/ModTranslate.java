package com.miningmark48.mininglib.utility;

public class ModTranslate {

    /**
     * Takes a key and translates it in the language file and returns back the value.
     *      EX: -tile.block.name=Block- takes a key and returns back "Block"
     * @param key
     *  Key that is used in translation in the language file.
     * @return
     *  Value returned after translation.
     */
    public static String toLocal(String key){
        return net.minecraft.util.text.translation.I18n.translateToLocal(key);
    }

}
