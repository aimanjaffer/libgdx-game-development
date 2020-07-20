package com.aiman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class AvatarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ScreenViewport viewport;
	public static float PPM = 16;
	@Override
	public void create () {
		viewport = new ScreenViewport();
		viewport.setUnitsPerPixel(1/PPM);
		viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,0,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		batch.draw(img, 0, 0, img.getWidth()/PPM,img.getHeight()/PPM);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
