package com.miningmark48.mininglib.utility;

import org.lwjgl.input.Keyboard;

public class KeyChecker {

    /**
     * Checks to see if the "Shift" key is being held down.
     * @return
     *  Returns true if key is down.
     */
    public static boolean isHoldingShift(){
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)){
            return true;
        }else{
            return false;
        }
    }

}
