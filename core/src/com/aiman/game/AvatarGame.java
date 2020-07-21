package com.aiman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class AvatarGame extends ApplicationAdapter {
	/*
	SpriteBatch batch;
	Texture img;
	ScreenViewport viewport;
	public static float PPM = 16;
	 */
	private ShapeRenderer shapeRenderer;
	Array<Vector2> stars;
	public static final String tag = "AvatarGame";
	public static final float STAR_DENSITY = 0.01f;
	@Override
	public void create () {
		Gdx.app.log(tag,"Entered create method");
		shapeRenderer = new ShapeRenderer();
		initStars(STAR_DENSITY);
		/*
		viewport = new ScreenViewport();
		viewport.setUnitsPerPixel(1/PPM);
		viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		*/

	}
	public void initStars(float density){
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		int starCount = (int) (screenHeight * screenWidth * density);
		stars = new Array<Vector2>(starCount);
		Random random = new Random();
		for(int i=0;i<starCount;i++){
			int x = random.nextInt(screenWidth);
			int y = random.nextInt(screenHeight);
			stars.add(new Vector2(x,y));
		}
	}
	@Override
	public void render () {
		//Gdx.app.log(tag,"Entered render method");
		Gdx.gl.glClearColor(0,0,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Point);
		for(Vector2 star : stars){
			shapeRenderer.point(star.x,star.y,0);
		}
		shapeRenderer.end();
		/*
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		batch.draw(img, 0, 0, img.getWidth()/PPM,img.getHeight()/PPM);
		batch.end();
		 */
	}
	
	@Override
	public void dispose () {
		Gdx.app.log(tag,"Entered dispose method");
		/*
		batch.dispose();
		img.dispose();
		*/
		shapeRenderer.dispose();
	}
}
