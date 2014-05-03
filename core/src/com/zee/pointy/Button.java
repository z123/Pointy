package com.zee.pointy;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Button {

	private HAlignment alignment;
	private String text;
	private boolean wasPressed;
	private float x;
	private float y;
	private float w;
	private float h;
	private boolean activated;
	private boolean down;
	private BitmapFont font;
	private float textHeight;
	private TextureRegion texture;
	
	public Button(String text, BitmapFont font, TextureRegion texture) {
		this.text = text;
		this.wasPressed = false;
		this.activated = false;
		this.down = false;
		this.font = font;
		this.texture = texture;
		TextBounds bounds = font.getBounds(text);
		textHeight = bounds.height;
		w = texture.getRegionWidth();
		h = texture.getRegionHeight();
		alignment = HAlignment.CENTER;
	}

	public void setWidth (float width) {
		w = width;
	}

	public void setHeight (float height) {
		h = height;
	}

	public void setAlignment (HAlignment alignment) {
		this.alignment = alignment;
	}

	public void update (float delta, boolean justTouched, boolean isTouched, boolean justReleased, float x, float y) {
		wasPressed = false;
		if (justTouched && inBounds(x, y)) {
			activated = true;
			down = true;
		} else if (isTouched) {
			down = activated && inBounds(x, y);
		} else if (justReleased) {
			wasPressed = activated && inBounds(x, y);
			activated = false;
			down = false;
		} else {
			activated = false;
		}
	}

	private boolean inBounds (float x, float y) {
		return x >= this.x && x < this.x + this.w && y >= this.y && y < this.y + this.h;
	}
	
	public boolean contains(float x, float y) {
		return x >= this.x && x < this.x + this.w && y >= this.y && y < this.y + this.h;
	}

	public void draw (SpriteBatch spriteBatch) {
		spriteBatch.draw(texture, x, y);
		float textX = x;
		float textY = y + h;
		textY -= (h - textHeight) / 2;
		font.drawWrapped(spriteBatch, text, textX, textY, w, alignment);
	}

	public boolean wasPressed () {
		return this.wasPressed;
	}

	public void rightOn (float right) {
		x = right - w;
	}

	public void leftOn (float left) {
		x = left;
	}

	public void centerHorizontallyOn (float centerX) {
		x = centerX - w / 2;
	}

	public void bottomOn (float bottom) {
		y = bottom;
	}

	public void topOn (float top) {
		y = top - h;
	}

	public void centerVerticallyOn (float centerY) {
		y = centerY - h / 2;
	}	
}
