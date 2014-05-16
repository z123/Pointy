package com.zee.pointy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import static com.zee.pointy.Constants.*;

public class MainMenuScreen implements Screen {

	// Constants
	private static final String GAME_TITLE = "POINTY";
	
	private Game game;
	private SpriteBatch spriteBatch;
	private OrthographicCamera menuCam;
	private Button playButton;
	private Vector3 touchPoint;

	public MainMenuScreen(Game game) {
		this.game = game;

		menuCam = new OrthographicCamera();
		menuCam.setToOrtho(false);

		spriteBatch = new SpriteBatch();
		// Don't understand what this does, apparently it attaches a camera to the spriteBatch
		spriteBatch.setProjectionMatrix(menuCam.combined);

		touchPoint = new Vector3();

		// Buttons
        // TODO have to create labels to set different font sizes
		playButton = new Button("PLAY", Assets.kenvectorFuture, Assets.greyButton);
	}

	private void update() {
		if (Gdx.input.justTouched()) {
			menuCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			if (playButton.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new GameScreen(game));
			}
		}
	}

	private void draw() {
		// Color in background
        Gdx.gl.glClearColor(237/255.0f, 237/255.0f, 237/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Draw menu items to screen
        spriteBatch.begin();
        drawTitle();
        drawButtons();
        spriteBatch.end();
	}

	/**
	 * Must be called within a SpriteBatch begin and end call
	 */
	private void drawTitle() {
        float titleCenterX = Assets.kenvectorFuture.getBounds(GAME_TITLE).width / 2.0f;
        float titleCenterY = Assets.kenvectorFuture.getBounds(GAME_TITLE).height / 2.0f; 

        /*Added extra 7 because it did not seem like middle even though the 
        calculations were correct*/
        float titleX = SCREEN_WIDTH / 2.0f - titleCenterX + 7; 
        float titleY = SCREEN_HEIGHT * 3 / 4 + titleCenterY;
        Assets.kenvectorFuture.draw(spriteBatch, GAME_TITLE, titleX, titleY);	
	}
	
	public void drawButtons() {
		playButton.setPosition(SCREEN_WIDTH / 2.0f, SCREEN_HEIGHT / 2.0f);
		playButton.draw(spriteBatch);
	}

	@Override
	public void render(float delta) {
		update();
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
