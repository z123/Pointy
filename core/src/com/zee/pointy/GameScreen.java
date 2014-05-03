package com.zee.pointy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import static com.zee.pointy.Constants.*;

public class GameScreen implements Screen {

	private OrthographicCamera gameCam;
	private SpriteBatch spriteBatch;
	private Sprite greyPanel;

	public GameScreen() {
		
		gameCam = new OrthographicCamera();
		gameCam.setToOrtho(false);
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(gameCam.combined);
		
        greyPanel = new Sprite(Assets.greyPanel);
        float x = SCREEN_WIDTH / 2.0f - greyPanel.getWidth() / 2.0f;
        float y = SCREEN_HEIGHT / 2.0f - greyPanel.getHeight() / 2.0f;
        greyPanel.setPosition(x, y);
	}

	private void draw() {
		// Color in background
        Gdx.gl.glClearColor(237/255.0f, 237/255.0f, 237/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Draw game items
        spriteBatch.begin();
        greyPanel.draw(spriteBatch);
        spriteBatch.end();
	}

	@Override
	public void render(float delta) {
		draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
