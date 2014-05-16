package com.zee.pointy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	// Constants
	private static final String blueSheet = "blueSheet.txt";
	private static final String greenSheet = "greenSheet.txt";
	private static final String greySheet = "greySheet.txt";
	private static final String redSheet = "redSheet.txt";
	private static final String yellowSheet = "yellowSheet.txt";
	private static final String arrowSheet = "arrowSheet.atlas";
	
	// Variables 
	private static TextureAtlas atlas;

	public static TextureRegion bluePanel;
	public static TextureRegion blueArrowLeft;
	public static TextureRegion blueArrowRight;
	public static TextureRegion blueArrowUp;
	public static TextureRegion blueArrowDown;
	
	public static TextureRegion greenPanel;
	public static TextureRegion greenArrowLeft;
	public static TextureRegion greenArrowRight;
	public static TextureRegion greenArrowUp;
	public static TextureRegion greenArrowDown;
	
	public static TextureRegion greyButton;
	public static TextureRegion greyPanel;
	public static TextureRegion greyArrowLeft;
	public static TextureRegion greyArrowRight;
	public static TextureRegion greyArrowUp;
	public static TextureRegion greyArrowDown;
	
	public static TextureRegion redPanel;
	public static TextureRegion redArrowLeft;
	public static TextureRegion redArrowRight;
	public static TextureRegion redArrowUp;
	public static TextureRegion redArrowDown;

	public static TextureRegion yellowPanel;
	public static TextureRegion yellowArrowLeft;
	public static TextureRegion yellowArrowRight;
	public static TextureRegion yellowArrowUp;
	public static TextureRegion yellowArrowDown;

	public static BitmapFont kenvectorFuture;
	
	public static void load() {
		loadTextures();
		loadFonts();
	}
	
	private static void loadTextures() {
		atlas = new TextureAtlas(Gdx.files.internal(blueSheet));
		bluePanel = atlas.findRegion("blue_panel");
		atlas = new TextureAtlas(Gdx.files.internal(arrowSheet));
		blueArrowLeft = atlas.findRegion("blue_sliderLeft");
		blueArrowRight = atlas.findRegion("blue_sliderRight");
		blueArrowUp = atlas.findRegion("blue_sliderUp");
		blueArrowDown = atlas.findRegion("blue_sliderDown");

		atlas = new TextureAtlas(Gdx.files.internal(greenSheet));
		greenPanel = atlas.findRegion("green_panel");
		atlas = new TextureAtlas(Gdx.files.internal(arrowSheet));
		greenArrowLeft = atlas.findRegion("green_sliderLeft");
		greenArrowRight = atlas.findRegion("green_sliderRight");
		greenArrowUp = atlas.findRegion("green_sliderUp");
		greenArrowDown = atlas.findRegion("green_sliderDown");

		atlas = new TextureAtlas(Gdx.files.internal(greySheet));
		greyButton = atlas.findRegion("grey_button01");
		greyPanel = atlas.findRegion("grey_panel");
		atlas = new TextureAtlas(Gdx.files.internal(arrowSheet));
		greyArrowLeft = atlas.findRegion("grey_sliderLeft");
		greyArrowRight = atlas.findRegion("grey_sliderRight");
		greyArrowUp = atlas.findRegion("grey_sliderUp");
		greyArrowDown = atlas.findRegion("grey_sliderDown");

        atlas = new TextureAtlas(Gdx.files.internal(redSheet));
		redPanel = atlas.findRegion("red_panel");	
		atlas = new TextureAtlas(Gdx.files.internal(arrowSheet));
        redArrowLeft = atlas.findRegion("red_sliderLeft");
		redArrowRight = atlas.findRegion("red_sliderRight");
		redArrowUp = atlas.findRegion("red_sliderUp");
		redArrowDown = atlas.findRegion("red_sliderDown");

        atlas = new TextureAtlas(Gdx.files.internal(yellowSheet));
		yellowPanel = atlas.findRegion("yellow_panel");
		atlas = new TextureAtlas(Gdx.files.internal(arrowSheet));
        yellowArrowLeft = atlas.findRegion("yellow_sliderLeft");
		yellowArrowRight = atlas.findRegion("yellow_sliderRight");
		yellowArrowUp = atlas.findRegion("yellow_sliderUp");
		yellowArrowDown = atlas.findRegion("yellow_sliderDown");
	}
	
	private static void loadFonts() {
		kenvectorFuture = new BitmapFont(Gdx.files.internal("kenvector_future.fnt"));
		kenvectorFuture.setColor(153/255.0f, 153/255.0f, 153/255.0f, 1.0f);
	}
}
