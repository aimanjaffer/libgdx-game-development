package com.aiman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {
    final Drop game;
    OrthographicCamera camera;
    public MainMenuScreen(final Drop game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,400);
    }

    @Override
    public void show() {

    }

    //Observe that this render method takes a float parameter
    @Override
    public void render(float delta) {
        //clearing the screen
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch,"Welcome to Drop",100,150);
        game.font.draw(game.batch,"Tap anywhere to begin",100,250);
        game.batch.end();

        if(Gdx.input.isTouched()){
            game.setScreen(new GameScreen(game));
            //dispose current instance of MainScreen
            dispose();

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
