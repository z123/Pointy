package com.zee.pointy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import static com.zee.pointy.Constants.*;

public class GameScreen implements Screen {

	// Constants
	private final int NUM_ARROWS = 4;

	private Game game;

	private OrthographicCamera gameCam;
	private SpriteBatch spriteBatch;
	// Holds the possible combinations of panels
	Array<Panel> allPanels;
	// Holds the possible combinations of arrows
	Array<Arrow> allArrows;

	private Panel panel;

	Array<Arrow> arrows;

	private Timer timer;
	private Task task;
	private int clock;
	private int score;
	
	private Vector3 touchPoint;
	
	GameState gameState = GameState.Start;

	public GameScreen(Game game) {
		this.game = game;

		gameCam = new OrthographicCamera();
		gameCam.setToOrtho(false);
		gameCam.update();
		
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(gameCam.combined);
		
		allPanels = new Array<Panel>();
		allArrows = new Array<Arrow>();
		for (ArrowType at : ArrowType.values()) {
			Arrow a = new Arrow(at);
			allArrows.add(a);
			for (PanelType pt: PanelType.values()) {
				if (pt.getColor() != at.getColor()) {
					Panel p = new Panel(pt, at);
					allPanels.add(p);
				}
			}
		}
		
		arrows = new Array<Arrow>(NUM_ARROWS);

		updatePanelAndArrows();

		touchPoint = new Vector3();	
		clock = 3;
		score = 0;

		timer = new Timer();
		task = new Task() {
			@Override
			public void run() {
				countDown();
			}
		};
		timer.scheduleTask(task, .5f, .5f);
	}
	
	private void draw() {
		// Color in background
        Gdx.gl.glClearColor(237/255.0f, 237/255.0f, 237/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        spriteBatch.begin();
        if (gameState == GameState.Start) {
        	drawInitalCountDown();
        } else if (gameState == GameState.Running) {
        	drawClock();
        	drawPanel();
        	drawArrows();	
        } else if (gameState == GameState.GameOver) {
        	
        }
        spriteBatch.end();
        
	}
	
	private void drawInitalCountDown() {
		if (clock > 0) {
			Assets.kenvectorFuture.drawWrapped(spriteBatch, String.valueOf(clock),
					0, SCREEN_HEIGHT / 2.0f, SCREEN_WIDTH, HAlignment.CENTER);
		} else {
			Assets.kenvectorFuture.drawWrapped(spriteBatch, "START",
					0, SCREEN_HEIGHT / 2.0f, SCREEN_WIDTH, HAlignment.CENTER);
		}
	}

	private void drawPanel() {
        panel.draw(spriteBatch);
	}

	private void drawArrows() {
        for (Arrow a: arrows) {
        	a.draw(spriteBatch);
        }		
	}
	
	private void drawClock() {
		float x = (SCREEN_WIDTH / 2.0f)
				- Assets.kenvectorFuture.getBounds(String.valueOf(clock)).width / 3.0f;
		Assets.kenvectorFuture.draw(spriteBatch, String.valueOf(clock), x, SCREEN_HEIGHT - 20);
	}

	private void update() {
		if (Gdx.input.justTouched()) {
			for (Arrow a : arrows) {
				float x = Gdx.input.getX();
				float y = Gdx.input.getY();
				gameCam.unproject(touchPoint.set(x, y, 0));
				x = touchPoint.x;
				y = touchPoint.y;
				if (a.contains(x, y) && a.getArrowType() == panel.getArrowType()) {
					clock = 3;
					timer.clear();
					updatePanelAndArrows();
					timer.scheduleTask(task, 1.0f, 1.0f);
					return;
				} else if (a.contains(x, y)) {
					gameOver();
				}
			}
		}
	}
	
	private void updatePanelAndArrows() {
        panel = allPanels.random();
		panel.setPosition(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);

		arrows.clear();
		// VERY BAD, why does it let you do this lol should just use an arraylist
		arrows.size = NUM_ARROWS;	

		// Finds and adds the arrow corresponding to arrow on the panel
		for (int i = 0; i < allArrows.size; i++) {
			Arrow a = allArrows.get(i);
			if (a.getArrowType() == panel.getArrowType()) {
				int index = MathUtils.random(NUM_ARROWS - 1);
				arrows.set(index, allArrows.removeIndex(i));
				break;
			}
		}
		
		// Adds the rest of the arrows to arrows
		for (int i = 0; i < NUM_ARROWS; i++) {
			Arrow a = allArrows.random();
			if (arrows.get(i) == null) {
				arrows.set(i, a);
				allArrows.removeValue(a, true);
			}
		}
		
		// Sets the position of arrows and readds them back to allArrows
		for (int i = 0; i < NUM_ARROWS; i++) {
			Arrow a = arrows.get(i);
			switch (i) {
				case 0:
					a.setPositionLeft(panel);
					break;
				case 1:
					a.setPositionRight(panel);
					break;
				case 2:
					a.setPositionUp(panel);
					break;
				case 3:
					a.setPositionDown(panel);
					break;
			}
			allArrows.add(a);
		}

	}
	
	private void countDown() {
		clock--;
		if (clock == 0 && gameState == GameState.Running) {
			gameOver();
		} else if (clock < 0 && gameState == GameState.Start) {
			clock = 3;
			gameState = GameState.Running;
			timer.delay(500);
		}
	}

	private void gameOver() {
		game.setScreen(new MainMenuScreen(game));
		dispose();
	}
	
	static enum GameState {
		Start, Running, GameOver
	}
	
	@Override
	public void render(float delta) {
		update();
		draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		timer.stop();
		timer.clear();
		timer = null;
	}

}
