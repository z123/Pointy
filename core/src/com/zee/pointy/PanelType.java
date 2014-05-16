package com.zee.pointy;

public enum PanelType {
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    GREY(Color.GREY), RED(Color.RED),
    YELLOW(Color.YELLOW);
    
    private Color color;
    private PanelType(Color color) {
    	this.color = color;
    }
    
    public Color getColor() {
    	return color;
    }
}
