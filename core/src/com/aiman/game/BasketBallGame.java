package com.aiman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
public class BasketBallGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture background;
    Texture ballTexture;
    Ball ball;
    //private Music backgroundMusic;
    @Override
    public void create () {
        batch = new SpriteBatch();
        background = new Texture("background.jpg");

        ballTexture = new Texture("ball.png");
        ballTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        ball = new Ball();
        //backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("basketball.mp3"));
        //backgroundMusic.setLooping(true);
        //backgroundMusic.play();
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // don't forget to clear screen

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
}
