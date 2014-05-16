package com.zee.pointy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Button {

	private String text;
	private BitmapFont font;
	private TextureRegion texture;
	private Vector2 position;
	
	public Button(String text, BitmapFont font, TextureRegion texture) {
		this.text = text;
		this.font = font;
		this.texture = texture;
		position = new Vector2();
	}

	public boolean contains(float x, float y) {
		float width = texture.getRegionWidth();
		float height = texture.getRegionHeight();
		return x >= position.x && x < position.x + width
				&& y >= position.y && y < position.y + height;
	}

	public void draw (Batch batch) {
		batch.draw(texture, position.x, position.y);
		float textX = position.x;
		float textY = position.y + texture.getRegionHeight();
		textX += (texture.getRegionWidth() - font.getBounds(text).width) / 2.0f;
		textY -= (texture.getRegionHeight() -font.getBounds(text).height) / 2.0f;
		font.draw(batch, text, textX, textY);
	}
	
	public void setPosition(float x, float y) {
        float buttonWidth = texture.getRegionWidth();
		float buttonHeight = texture.getRegionHeight();
		x -= buttonWidth / 2;
		y -= buttonHeight / 2;
		position.set(x, y);
	}
}
