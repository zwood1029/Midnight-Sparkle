package com.zwood.MidnightSparkle;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Texture texture2;
	private Sprite sprite;
	private Sprite sprite2;
	private float x_position;
	private float y_position;
	private int move_state;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/midnightsparkle.png"));
		texture2 = new Texture(Gdx.files.internal("data/banner.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		TextureRegion region2 = new TextureRegion(texture2, 0, 0, 512, 512);
		
		sprite = new Sprite(region);
		sprite2 = new Sprite(region2);
		sprite.setSize(0.3f, 0.3f * sprite.getHeight() / sprite.getWidth());
		sprite2.setSize(1, 1);

		//sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setOrigin(0,0);
		sprite2.setOrigin(sprite2.getWidth()/2, sprite2.getHeight()/2);
		x_position = -0.5f;
		y_position = -sprite.getHeight()/2;
		move_state = 0;
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {
		switch(move_state){
		case 0:
			y_position = y_position + 0.01f;
			if (y_position > 0.5f - sprite.getHeight()/2) {
				move_state = 1;
			}
			break;
		case 1:
			x_position = x_position + 0.01f;
			if (x_position > 0.5f - sprite.getWidth()/2) {
				move_state = 2;
			}
			break;
		case 2:
			y_position = y_position - 0.01f;
			if (y_position < -0.5f - sprite.getHeight()/2) {
				move_state = 3;
			}
			break;
		case 3:
			x_position = x_position - 0.01f;
			if (x_position < -0.5f) {
				move_state = 0;
			}
			break;
		}
		
		
		
		sprite.setPosition(x_position,y_position);
		sprite2.setPosition(-0.5f, -0.5f);
		sprite2.rotate(-1f);
		Gdx.gl.glClearColor(12/255, 154/255, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		sprite2.draw(batch);
		batch.end();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
}
