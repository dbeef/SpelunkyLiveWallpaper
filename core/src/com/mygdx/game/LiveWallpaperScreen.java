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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.level.Level;
import com.mygdx.game.level.LevelGenerator;
import com.mygdx.game.level.LevelRenderer;
import com.mygdx.game.level.MapTile;

import static com.badlogic.gdx.Gdx.gl;
import static com.mygdx.game.Consts.*;

public class LiveWallpaperScreen implements Screen{

    Game game;

    LevelGenerator levelGenerator;
    LevelRenderer levelRenderer;

    Assets assets;

    public LiveWallpaperScreen(final Game game) {
        this.game = game;

        assets = new Assets();
        assets.load();

        levelGenerator = new LevelGenerator();
        levelRenderer = new LevelRenderer(assets);

        levelGenerator.generate_new_level_layout();
        levelGenerator.generate_frame();
        levelGenerator.initialise_tiles_from_room_layout();
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
        levelRenderer.draw(levelGenerator.getLevel());
        levelRenderer.takeInput();
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
