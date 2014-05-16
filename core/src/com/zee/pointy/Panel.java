package com.zee.pointy;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Panel {

	private PanelType panelType;
	private Arrow arrow;
	private TextureRegion panelImage;
	private Vector2 position;

	public Panel(PanelType panelType, ArrowType arrowType) {
		this.panelType = panelType;
		arrow = new Arrow(arrowType);
		
		// Refactor this lol maybe a hashmap idk
		switch (panelType) {
			case BLUE:
				this.panelImage = Assets.bluePanel;
				break;
			case GREEN:
				this.panelImage = Assets.greenPanel;
				break;
			case GREY:
				this.panelImage = Assets.greyPanel;
				break;
			case RED:
				this.panelImage = Assets.redPanel;
				break;
			case YELLOW:
				this.panelImage = Assets.yellowPanel;
				break;
		}
		position = new Vector2();
	}
	
	public void draw(Batch batch) {
		batch.draw(panelImage, position.x, position.y);
		arrow.draw(batch);
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}

	public void setPosition(float x, float y) {
		float panelWidth = panelImage.getRegionWidth();
		float panelHeight = panelImage.getRegionHeight();
		x -= panelWidth / 2;
		y -= panelHeight / 2;
		position.set(x, y);
		
		// Set arrow position to updated panel position
		arrow.setPositionCenter(this);
	}

	public float getWidth() {
		return panelImage.getRegionWidth();
	}
	
	public float getHeight() {
		return panelImage.getRegionHeight();
	}
	
	public PanelType getPanelType() {
		return panelType;
	}

	public ArrowType getArrowType() {
		return arrow.getArrowType();
	}
}
