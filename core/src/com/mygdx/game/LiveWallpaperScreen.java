package com.mygdx.game;

// 1. Generate map in a way that is transparent for renderer (whether using OpenGL directly or via LibGDX wrapper)
// 2. Implement renderer - prototype LibGDX way
// 3. Implement NPC's.

// Trivia:
// Screen scaling. Query for screen dimensions.

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.badlogic.gdx.Gdx.gl;
import static com.mygdx.game.Consts.*;

public class LiveWallpaperScreen implements Screen{

    Game game;

    Level level;
    Assets assets;
    OrthographicCamera camera;
    SpriteBatch batcher;

    public LiveWallpaperScreen(final Game game) {
        this.game = game;

        camera = new OrthographicCamera(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        assets = new Assets();
        assets.load();

        level = new Level(assets);

        batcher = new SpriteBatch();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    private void draw(float delta) {
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        batcher.setProjectionMatrix(camera.combined);
        batcher.begin();
        batcher.draw(level.getTextureForTile(MapTileType.CAVE_ROCK), 0, 0, TILE_WIDTH, TILE_HEIGHT);
        batcher.end();
    }

    private void update(float delta) {
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }
}
