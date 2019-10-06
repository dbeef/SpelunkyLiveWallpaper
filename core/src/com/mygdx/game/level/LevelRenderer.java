package com.mygdx.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;

import java.util.LinkedList;

import static com.mygdx.game.Consts.*;
import static com.mygdx.game.Consts.SCREEN_HEIGHT;
import static com.mygdx.game.level.Level.TILES_X;
import static com.mygdx.game.level.Level.TILES_Y;

public class LevelRenderer {

    public LevelRenderer(Assets assets) {
        this.assets = assets;

        camera = new OrthographicCamera(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        batcher = new SpriteBatch();
        cameraVelocity = new Vector2(0.5f, 0.5f);

        camera.update();
    }

    public void draw(Level level) {
        batcher.setProjectionMatrix(camera.combined);
        batcher.begin();

        for (int x = 0; x < TILES_X; x++) {
            for (int y = 0; y < TILES_Y; y++) {
                // Horizontal flip of map tiles:
                MapTile tile = level.tiles[TILES_X - x - 1][TILES_Y - y - 1];
                if (tile == MapTile.NOTHING) continue;

                TextureRegion region = assets.getTextureRegion(tile);

                if (region != null) {
                    int offset_x = (x * 16);
                    int offset_y = (y * 16);
                    if (!tileInViewport(offset_y, offset_x)) continue;
                    // Draw with x/y flip:
                    batcher.draw(region, offset_y, offset_x, TILE_WIDTH, TILE_HEIGHT);
                }
            }
        }

        for (Loot l : level.loot) {
            TextureRegion region = assets.getTextureRegion(l);

            if (region != null) {
                float x = l.getPosition().x;
                float y = l.getPosition().y;
                // Draw with x/y flip:
                batcher.draw(region, y, x, TILE_WIDTH, TILE_HEIGHT);
            }
        }

        batcher.end();
    }

    private boolean tileInViewport(int x, int y) {
        if (x > camera.position.x - (0.5 * camera.viewportWidth) - TILE_WIDTH &&
                x < camera.position.x + (0.5 * camera.viewportWidth) &&
                y > camera.position.y - (0.5 * camera.viewportHeight) - TILE_HEIGHT &&
                y < camera.position.y + (0.5 * camera.viewportHeight)
        )
            return true;
        else
            return false;
    }

    private boolean viewportXOutOfLevel() {
        return (camera.position.x + (0.5f * camera.viewportWidth) > TILE_WIDTH * TILES_X) ||
                camera.position.x < camera.viewportWidth / 2;
    }

    public boolean viewportYOutOfLevel() {
        return (camera.position.y + (0.5f * camera.viewportHeight) > TILE_HEIGHT * TILES_Y) ||
                camera.position.y < camera.viewportHeight / 2;
    }

    public void floatCamera(float delta) {
        cameraMoveTimer += delta;

        if (cameraMoveTimer > (1.0f / 30.0f)) {
            cameraMoveTimer = 0;
            camera.translate(cameraVelocity);
            if (viewportXOutOfLevel())
                cameraVelocity.x *= -1;
            if (viewportYOutOfLevel())
                cameraVelocity.y *= -1;

            camera.update();
        }
    }

    // For debugging.
    public void takeInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(-2f, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(+2f, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.translate(0, -2, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.translate(0, +2, 0);
        }
    }

    private OrthographicCamera camera;
    private SpriteBatch batcher;
    private Assets assets;
    private float cameraMoveTimer = 0;
    private Vector2 cameraVelocity;
}
