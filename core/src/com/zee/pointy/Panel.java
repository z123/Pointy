package com.zee.pointy;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.zee.pointy.Constants.PanelType;
import com.zee.pointy.Constants.ArrowType;

public class Panel {

	private PanelType panelType;
	private ArrowType arrowType;

	public Panel(PanelType panelType, ArrowType arrowType) {
		this.panelType = panelType;
		this.arrowType = arrowType;
	}
}
