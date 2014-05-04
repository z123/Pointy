package com.zee.pointy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import static com.zee.pointy.Constants.*;

public class GameScreen implements Screen {

	private OrthographicCamera gameCam;
	private SpriteBatch spriteBatch;
	private Panel greyPanel;
	private Arrow greenArrow;

	public GameScreen() {
		
		gameCam = new OrthographicCamera();
		gameCam.setToOrtho(false);
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(gameCam.combined);
		
		greyPanel = new Panel(PanelType.GREY, ArrowType.BLUE_UP);
		greyPanel.setPosition(SCREEN_WIDTH / 2.0f, SCREEN_HEIGHT / 2.0f);
		
	}

	private void draw() {
		// Color in background
        Gdx.gl.glClearColor(237/255.0f, 237/255.0f, 237/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Draw game items
        spriteBatch.begin();
        greyPanel.draw(spriteBatch);
        Arrow temp = new Arrow(ArrowType.BLUE_DOWN);
        temp.setPositionCenter(greyPanel);
        temp.draw(spriteBatch);
		greenArrow = new Arrow(ArrowType.GREEN_LEFT);
		greenArrow.setPositionLeft(greyPanel);
        greenArrow.draw(spriteBatch);
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
