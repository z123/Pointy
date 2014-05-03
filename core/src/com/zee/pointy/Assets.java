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
	
	// Variables 
	private static TextureAtlas atlas;

	public static TextureRegion bluePanel;
	
	public static TextureRegion greenPanel;

	public static TextureRegion greyButton;
	public static TextureRegion greyPanel;

	public static TextureRegion redPanel;

	public static TextureRegion yellowPanel;

	public static BitmapFont kenvectorFuture;
	
	public static void load() {
		loadTextures();
		loadFonts();
	}
	
	private static void loadTextures() {
		atlas = new TextureAtlas(Gdx.files.internal(blueSheet));
		bluePanel = atlas.findRegion("blue_panel");

		atlas = new TextureAtlas(Gdx.files.internal(greenSheet));
		greenPanel = atlas.findRegion("green_panel");
		
		atlas = new TextureAtlas(Gdx.files.internal(greySheet));
		greyButton = atlas.findRegion("grey_button01");
		greyPanel = atlas.findRegion("grey_panel");
		
        atlas = new TextureAtlas(Gdx.files.internal(redSheet));
		redPanel = atlas.findRegion("red_panel");	

        atlas = new TextureAtlas(Gdx.files.internal(yellowSheet));
		yellowPanel = atlas.findRegion("yellow_panel");
	}
	
	private static void loadFonts() {
		kenvectorFuture = new BitmapFont(Gdx.files.internal("kenvector_future.fnt"));
		kenvectorFuture.setColor(153/255.0f, 153/255.0f, 153/255.0f, 1.0f);
	}
}
