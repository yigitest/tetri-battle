package com.fuzzywave.tetribattle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.fuzzywave.tetribattle.assets.Assets;
import com.fuzzywave.tetribattle.screen.SplashScreen;

public class TetriBattle implements ApplicationListener {

    public static final float WORLD_WIDTH_PIXEL = 720;
    public static final float WORLD_HEIGHT_PIXEL = 1280;

    public static final float BOARD_FRAME_PADDING = 4;

    public static final float WORLD_WIDTH = 9;
    public static final float WORLD_HEIGHT = 16;

    public static final int BLOCKS_WIDTH = 6;
    public static final int BLOCKS_HEIGHT = 13;
    public static final int BLOCK_SPAWN_X = 3;
    public static final int BLOCK_SPAWN_Y = 12;
    public static final float BLOCK_SPAWN_PROBABILITY = 0.1875f;
    public static final float BREAKER_SPAWN_PROBABILITY = 0.0625f;

    public static final float PIECE_DROP_TIMEOUT = 1f;
    public static final float PIECE_FAST_DROP_TIMEOUT = 0.1f;
    public static final float BLOCK_FAST_DROP_TIMEOUT = 0.1f;
    public static final float DESTRUCTION_TIMEOUT = 0.7f;

    // create a new game and set the initial screen
    public static Game game = new Game() {
        @Override
        public void create() {
            setScreen(new SplashScreen());
        }
    };

    public static SpriteBatch spriteBatch;

    public static Color batchColor;
    public static Color batchAlphaColor;

    public static ShapeRenderer shapeRenderer;

    public static IAnalytics analytics;

    public static ILogger logger;

    public static Assets assets;

    public TetriBattle(ILogger logger, IAnalytics analytics) {
        TetriBattle.logger = logger;
        TetriBattle.analytics = analytics;
    }

    @Override
    public void create() {
        try {
            logger.setLevel(Logger.DEBUG);

            analytics.init();

            spriteBatch = new SpriteBatch();
            batchColor = TetriBattle.spriteBatch.getColor().cpy();
            batchAlphaColor = new Color(batchColor.r, batchColor.g, batchColor.b, 0); // full alpha.

            shapeRenderer = new ShapeRenderer();

            assets = new Assets();

            game.create();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
        try {
            game.resize(width, height);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Gdx.app.exit();
        }
    }

    @Override
    public void render() {
        try {
            game.render();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Gdx.app.exit();
        }
    }

    @Override
    public void pause() {
        try {
            game.pause();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Gdx.app.exit();
        }
    }

    @Override
    public void resume() {
        try {
            game.resume();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
        game.dispose();
        assets.dispose();

        if (spriteBatch != null) {
            spriteBatch.dispose();
        }
    }
}
