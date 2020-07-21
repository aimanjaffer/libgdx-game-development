package com.aiman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class AvatarGame extends ApplicationAdapter {

    // Declare
    ShapeRenderer renderer;

    @Override
    public void create() {
        // Initialize
        renderer = new ShapeRenderer();
    }

    @Override
    public void dispose() {
        // Dispose
        renderer.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeType.Filled);

        // Head
        renderer.circle(100, 100, 10);
        renderer.end();

        renderer.begin(ShapeType.Line);

        // Torso
        renderer.line(100, 50, 100, 100);

        // Legs
        renderer.line(85, 35, 100, 50);
        renderer.line(115, 35, 100, 50);

        // Arms
        renderer.line(85, 70, 100, 85);
        renderer.line(115, 70, 100, 85);
        renderer.end();
    }
}