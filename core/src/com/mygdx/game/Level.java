package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Level {

    public Level(Assets assets) {
        _assets = assets;
    }

    public TextureRegion getTextureForTile(MapTileType type) {
        int value = type.getValue();
        return _assets.caveSprites[value];
    }

    private Assets _assets;
}