package com.example.hasee.spinner;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by hasee on 2018/3/25.
 * 计算屏幕的宽高的
 */

public class ScreenSize {
    private static ScreenSize instance = null;
    private int screenWidth,screenHeight;
    static ScreenSize getInstance(Context contexts){
        if (instance==null){
            synchronized (ScreenSize.class){
                if (instance==null){
                    instance = new ScreenSize(contexts);
                }
            }
        }
        return instance;
    }

    private ScreenSize(Context context){
        WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.widthPixels;
        screenWidth = dm.widthPixels;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }
}
