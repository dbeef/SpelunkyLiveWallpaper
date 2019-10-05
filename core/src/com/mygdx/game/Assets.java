package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.level.MapTile;

import static com.mygdx.game.Consts.getAssetsPrefix;

public class Assets {

    private TextureRegion[] _caveSprites = new TextureRegion[MapTile._END.getValue()];
    private Texture _spritesheet = null;

    public void load() {

        _spritesheet = new Texture(getAssetsPrefix() + "tiles/cave/spritesheet.png");
        _spritesheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        for(int index = 0; index < MapTile._END.getValue() - 1; index++) {

            int column = index % 2;
            int row = (int) Math.floor(index / 2);

            // "NOTHING" value is not rendered, so start from index 1:
            _caveSprites[index + 1] = new TextureRegion(_spritesheet,
                    column * Consts.TILE_WIDTH,
                    row * Consts.TILE_HEIGHT,
                    Consts.TILE_WIDTH, Consts.TILE_HEIGHT);
        }
    }

    public TextureRegion getTextureRegion(MapTile tile) {
        int value = tile.getValue();
        assert(value < _caveSprites.length);
        return _caveSprites[value];
    }
}
