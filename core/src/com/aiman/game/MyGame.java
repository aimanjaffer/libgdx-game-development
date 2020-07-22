package com.aiman.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGame extends Game {
    private Stage stage;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
	    MyActor myActor = new MyActor();
        stage.addActor(myActor);

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,true);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
