package com.zee.pointy;

public enum ArrowType {
	BLUE_LEFT(Color.BLUE), BLUE_RIGHT(Color.BLUE),
	BLUE_UP(Color.BLUE), BLUE_DOWN(Color.BLUE),
	GREEN_LEFT(Color.GREEN), GREEN_RIGHT(Color.GREEN),
	GREEN_UP(Color.GREEN), GREEN_DOWN(Color.GREEN),
//	GREY_LEFT, GREY_RIGHT, GREY_UP, GREY_DOWN,
	RED_LEFT(Color.RED), RED_RIGHT(Color.RED),
	RED_UP(Color.RED), RED_DOWN(Color.RED),
	YELLOW_LEFT(Color.YELLOW), YELLOW_RIGHT(Color.YELLOW),
	YELLOW_UP(Color.YELLOW), YELLOW_DOWN(Color.YELLOW);

	
	private Color color;
	private ArrowType(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
}
