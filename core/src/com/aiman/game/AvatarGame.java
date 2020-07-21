package com.aiman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class AvatarGame extends ApplicationAdapter {
    //private static final float DOT_RADIUS = 3.0f;
    //private SpriteBatch spriteBatch;
    //private BitmapFont bitmapFont;
    //private final Array<Vector2> dots = Dots.dots();
    //private float[] floatDots;
    private ShapeRenderer shapeRenderer;


    @Override
    public void create () {
		/*
		spriteBatch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		 */

        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render () {
        // Make the background black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
/*
		// Draw the dots
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (Vector2 dot : dots){
			shapeRenderer.circle(dot.x, dot.y, DOT_RADIUS);
		}
		shapeRenderer.end();

		// Draw the numbers
		spriteBatch.begin();
		Integer i = 1;
		for (Vector2 dot : dots){
			bitmapFont.draw(spriteBatch,i.toString(),dot.x+DOT_RADIUS, dot.y-DOT_RADIUS);
			i++;
		}
		spriteBatch.end();
*/

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(10,20,500,500,Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN);
        shapeRenderer.rectLine(20,30,40,50,10);
        // Two overlapping objects. The one drawn later is placed on top of the ones drawn earlier
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.circle(100,200,60);
        shapeRenderer.end();
    }
}
