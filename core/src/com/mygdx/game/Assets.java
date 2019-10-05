package com.mygdx.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.mygdx.game.Consts.getAssetsPrefix;

public class Assets {

    TextureRegion[] caveSprites = new TextureRegion[MapTileType._END.getValue()];
    Texture spritesheet;

    public void load() {

        spritesheet = new Texture(getAssetsPrefix() + "tiles/cave/spritesheet.png");
        spritesheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        for(int index = 0; index < MapTileType._END.getValue() - 1; index++) {

            int column = index % 2;
            int row = (int) Math.floor(index / 2);

            // "NOTHING" value is not rendered, so start from index 1:
            caveSprites[index + 1] = new TextureRegion(spritesheet,
                    column * Consts.TILE_WIDTH,
                    row * Consts.TILE_HEIGHT,
                    Consts.TILE_WIDTH, Consts.TILE_HEIGHT);
        }
    }

    public void dispose() {
    }
}
