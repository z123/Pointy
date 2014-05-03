package com.zee.pointy;

import com.badlogic.gdx.Game;

public class PointyGame extends Game {
	
	@Override
	public void create () {
		Assets.load();
		setScreen(new MainMenuScreen(this));
	}

}
