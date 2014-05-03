package com.zee.pointy;

import com.badlogic.gdx.Gdx;

public class Constants {
	public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
	public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	public static enum PanelType {
		BLUE, GREEN, GREY, RED, YELLLOW;
	}
	
	public static enum ArrowType {
		BLUE_LEFT, BLUE_RIGHT, BLUE_UP, BLUE_DOWN,
		GREEN_LEFT, GREEN_RIGHT, GREEN_UP, GREEN_DOWN,
		GREY_LEFT, GREY_RIGHT, GREY_UP, GREY_DOWN,
		RED_LEFT, RED_RIGHT, RED_UP, RED_DOWN,
		YELLOW_LEFT, YELLOW_RIGHT, YELLOW_UP, YELLOW_DOWN;
	}
}
