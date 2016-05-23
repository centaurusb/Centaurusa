package com.centaurusa.utils;

import android.graphics.drawable.Drawable;

/**
 * Created by Swin on 2016/5/23.
 */
public class DrawableUtils {
    private static final int[] EMPTY_STATE = new int[]{};
    public static void clearState(Drawable drawable){
        if (drawable != null){
            drawable.setState(EMPTY_STATE);
        }
    }
}
