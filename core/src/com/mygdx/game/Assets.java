package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.level.MapTile;

import static com.mygdx.game.Consts.getAssetsPrefix;

public class Assets {

    private TextureRegion[] _caveSprites = new TextureRegion[MapTile._END.getValue()];

    public void load() {

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(getAssetsPrefix() + "tiles/cave/Cave.atlas"));

        _caveSprites[MapTile.CAVE_ROCK.getValue()] = atlas.findRegion("caveWithRock");
        _caveSprites[MapTile.CAVE_REGULAR.getValue()] = atlas.findRegion("cave");
        _caveSprites[MapTile.STONE_BLOCK.getValue()] = atlas.findRegion("block");
        _caveSprites[MapTile.CAVE_DOWN_ORIENTED.getValue()] = atlas.findRegion("caveDown");
        _caveSprites[MapTile.CAVE_SOME_GOLD.getValue()] = atlas.findRegion("smallGold");
        _caveSprites[MapTile.CAVE_MUCH_GOLD.getValue()] = atlas.findRegion("muchGold");
        _caveSprites[MapTile.CAVE_UP_ORIENTED.getValue()] = atlas.findRegion("caveUp");
        _caveSprites[MapTile.CAVE_UP_DOWN_ORIENTED.getValue()] = atlas.findRegion("caveUpDown");
        _caveSprites[MapTile.LADDER.getValue()] = atlas.findRegion("ladder");
        _caveSprites[MapTile.LADDER_DECK.getValue()] = atlas.findRegion("ladderTop");
        _caveSprites[MapTile.ARROW_TRAP_LEFT.getValue()] = atlas.findRegion("arrowTrapLeft");
        _caveSprites[MapTile.ARROW_TRAP_RIGHT.getValue()] = atlas.findRegion("arrowTrapRight");
        _caveSprites[MapTile.ENTRANCE.getValue()] = atlas.findRegion("entrance");
        _caveSprites[MapTile.EXIT.getValue()] = atlas.findRegion("exit");
        _caveSprites[MapTile.BGR_1.getValue()] = atlas.findRegion("caveBg1");
        _caveSprites[MapTile.BGR_2.getValue()] = atlas.findRegion("caveBg2");
        _caveSprites[MapTile.BGR_3.getValue()] = atlas.findRegion("caveBg3");
        _caveSprites[MapTile.BGR_4.getValue()] = atlas.findRegion("caveBg4");
        _caveSprites[MapTile.BGR_5.getValue()] = atlas.findRegion("caveBg5");
        _caveSprites[MapTile.BGR_6.getValue()] = atlas.findRegion("caveBg6");
        _caveSprites[MapTile.BGR_7.getValue()] = atlas.findRegion("caveBg7");
        _caveSprites[MapTile.BGR_8.getValue()] = atlas.findRegion("caveBg8");
        _caveSprites[MapTile.BGR_9.getValue()] = atlas.findRegion("caveBg9");
        _caveSprites[MapTile.BGR_10.getValue()] = atlas.findRegion("caveBg10");
        _caveSprites[MapTile.BGR_11.getValue()] = atlas.findRegion("caveBg11");
        _caveSprites[MapTile.BGR_12.getValue()] = atlas.findRegion("caveBg12");
        _caveSprites[MapTile.BGR_13.getValue()] = atlas.findRegion("caveBg13");
        _caveSprites[MapTile.BGR_14.getValue()] = atlas.findRegion("caveBg14");
        _caveSprites[MapTile.BGR_15.getValue()] = atlas.findRegion("caveBg15");
        _caveSprites[MapTile.BGR_16.getValue()] = atlas.findRegion("caveBg16");
    }

    public TextureRegion getTextureRegion(MapTile tile) {
        int value = tile.getValue();
        return _caveSprites[value];
    }
}
