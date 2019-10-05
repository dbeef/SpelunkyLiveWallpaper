package com.mygdx.game;

import static com.badlogic.gdx.Application.ApplicationType.*;
import static com.badlogic.gdx.Gdx.*;

public class Consts {

    private static int RATIO_BASE = 50;

    public static int SCREEN_HEIGHT = 16 * RATIO_BASE;
    public static int SCREEN_WIDTH = 9 * RATIO_BASE;

    public static int TILE_WIDTH = 16;
    public static int TILE_HEIGHT = 16;

    static String getAssetsPrefix()
    {
        if (app.getType() == Desktop) {
            return "android/assets/";
        }
        return "";
    }
}
