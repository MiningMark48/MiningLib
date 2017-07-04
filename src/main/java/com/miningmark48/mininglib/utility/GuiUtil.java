package com.miningmark48.mininglib.utility;

import net.minecraft.client.gui.FontRenderer;

public class GuiUtil {

    /**
     * Centers text between two values based on given width
     * @param text
     *  Text to center
     * @param renderer
     *  Font renderer to use
     * @param width
     *  Width of space to center between
     * @return
     *  Returns back value to where the text should be placed to be centered along 'x' axis.
     */
    public static int getXCenter(String text, FontRenderer renderer, int width){
        int x = (width / 2) - (renderer.getStringWidth(text) / 2);
        return x;
    }

}
