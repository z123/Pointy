package com.zee.pointy;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import static com.zee.pointy.Constants.*;

public class Arrow {
	private ArrowType arrowType;
	private TextureRegion arrowImage;
	private Vector2 position;
	
	public Arrow(ArrowType arrowType) {
		this.arrowType  = arrowType;

		// Holy fuck dude organize this shit 
		switch (arrowType) {
			case BLUE_LEFT:
				this.arrowImage = Assets.blueArrowLeft;
				break;
			case BLUE_RIGHT:
				this.arrowImage = Assets.blueArrowRight;
				break;
			case BLUE_UP:
				this.arrowImage = Assets.blueArrowUp;
				break;
			case BLUE_DOWN:
				this.arrowImage = Assets.blueArrowDown;
				break;
			case GREEN_LEFT:
				this.arrowImage = Assets.greenArrowLeft;
				break;
			case GREEN_RIGHT:
				this.arrowImage = Assets.greenArrowRight;
				break;
			case GREEN_UP:
				this.arrowImage = Assets.greenArrowUp;
				break;
			case GREEN_DOWN:
				this.arrowImage = Assets.greenArrowDown;
				break;
            case RED_LEFT:
				this.arrowImage = Assets.redArrowLeft;
				break;
			case RED_RIGHT:
				this.arrowImage = Assets.redArrowRight;
				break;
			case RED_UP:
				this.arrowImage = Assets.redArrowUp;
				break;
			case RED_DOWN:
				this.arrowImage = Assets.redArrowDown;
				break;
			case YELLOW_LEFT:
				this.arrowImage = Assets.yellowArrowLeft;
				break;
			case YELLOW_RIGHT:
				this.arrowImage = Assets.yellowArrowRight;
				break;
			case YELLOW_UP:
				this.arrowImage = Assets.yellowArrowUp;
				break;
			case YELLOW_DOWN:
				this.arrowImage = Assets.yellowArrowDown;
				break;
		}
		
		position = new Vector2();
	}
	
	public void draw(Batch batch) {
		batch.draw(arrowImage, position.x, position.y);
	}

	public boolean contains(float x, float y) {
		float width = arrowImage.getRegionWidth();
		float height = arrowImage.getRegionHeight();
		return x >= position.x && x < position.x + width
				&& y >= position.y && y < position.y + height;
	}

	public ArrowType getArrowType() {
		return arrowType;
	}

	public void setPosition(float x, float y) {
        float arrowWidth = arrowImage.getRegionWidth();
		float arrowHeight = arrowImage.getRegionHeight();
		x -= arrowWidth / 2;
		y -= arrowHeight / 2;
		position.set(x, y);
	}
	
	public void setPositionCenter(Panel panel) {
		float x = panel.getX() + panel.getWidth() / 2.0f;
		float y = panel.getY() + panel.getHeight() / 2.0f;
		setPosition(x, y);
	}

	public void setPositionLeft(Panel panel) {
        float x = panel.getX() / 2.0f;
		float y = panel.getY() + panel.getHeight() / 2.0f;
		setPosition(x, y);
	}

	public void setPositionRight(Panel panel) {
        float x = SCREEN_WIDTH - panel.getX() / 2.0f;
		float y = panel.getY() + panel.getHeight() / 2.0f;
		setPosition(x, y);
	}
	
	public void setPositionUp(Panel panel) {
		float x = panel.getX() + panel.getWidth() / 2;
		float y = panel.getY() + panel.getHeight() * 3 / 2;
		setPosition(x, y);
	}

	public void setPositionDown(Panel panel) {
		float x = panel.getX() + panel.getWidth() / 2;
		float y = panel.getY() - panel.getHeight() / 2;
		setPosition(x, y);
	}
}
