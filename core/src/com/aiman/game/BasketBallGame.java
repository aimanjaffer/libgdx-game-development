package com.aiman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BasketBallGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture ballTexture;
    Ball ball;
    OrthographicCamera camera;

    @Override
    public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,400);

        batch = new SpriteBatch();
        background = new Texture("background.jpg");

        ballTexture = new Texture("ball.png");
        ballTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        ball = new Ball();
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // don't forget to clear screen

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            ball.velocity.y += 10;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            ball.velocity.y -= 10;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            ball.velocity.x += 10;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            ball.velocity.x -= 10;
        ball.update();

        batch.begin();
        float scaleFactor = 0.4f;
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(ballTexture, ball.position.x, ball.position.y, ballTexture.getWidth() * scaleFactor, ballTexture.getHeight() * scaleFactor);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        background.dispose();
        ballTexture.dispose();
    }

    @Override
    public void resize(int width, int height) {

        // TODO: Calculate the aspect ratio (width / height)
        float aspectRatio = 1.0f * width / height;

        // TODO: Set the camera's viewport height taking into account the ball's movement and radius
        camera.viewportHeight = height;

        // TODO: Set the camera's viewport width to maintain the aspect ratio
        camera.viewportWidth = aspectRatio * camera.viewportHeight;
    }
}
