package com.mygdx.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.Consts;

import static com.badlogic.gdx.Gdx.gl;
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
    }

    public boolean viewportXOutOfLevel() {
        return (camera.position.x + (0.5f * camera.viewportWidth) > TILE_WIDTH * TILES_X) ||
                camera.position.x < camera.viewportWidth / 2;
    }

    public boolean viewportYOutOfLevel() {
        return (camera.position.y + (0.5f * camera.viewportHeight) > TILE_HEIGHT * TILES_Y) ||
                camera.position.y < camera.viewportHeight / 2;
    }

    public void floatCamera(float delta) {
        cameraMoveTimer += delta;

        if(cameraMoveTimer > (1.0f / 60.0f))
        {
            cameraMoveTimer = 0;
            camera.translate(cameraVelocity);
            if(viewportXOutOfLevel())
                cameraVelocity.x *= -1;
            if(viewportYOutOfLevel())
                cameraVelocity.y *= -1;
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

    public void draw(Level level) {
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batcher.setProjectionMatrix(camera.combined);
        batcher.begin();

        for (int x = 0; x < TILES_X; x++) {
            for (int y = 0; y < TILES_Y; y++) {
                // Horizontal flip of map tiles:
                MapTile tile = level.tiles[TILES_X - x - 1][TILES_Y - y - 1];
                if (tile == MapTile.NOTHING) continue;

                int offset_x = (x * 16);
                int offset_y = (y * 16);

                // Draw with x/y flip:
                TextureRegion region = assets.getTextureRegion(tile);
                if(region != null)
                    batcher.draw(region, offset_y, offset_x, TILE_WIDTH, TILE_HEIGHT);
            }
        }

        batcher.end();
    }

    OrthographicCamera camera;
    SpriteBatch batcher;
    Assets assets;
    float cameraMoveTimer = 0;
    Vector2 cameraVelocity;
}
