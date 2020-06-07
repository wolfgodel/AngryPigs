package org.arda;

import java.awt.Color;

import stddraw.StdDraw;

public class Point extends GameObject{

	public Point(double x, double y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hit(double x, double y) {
		return x==this.x && y==this.y;
	}
	
	@Override
	public void draw(boolean withImage) {
		
		if (!image.isEmpty() && withImage) {
			StdDraw.picture(x, y, image, 1, 1);
		}
		else {
			StdDraw.point(x, y);
			Color c = StdDraw.getPenColor();
			StdDraw.setPenColor(color);
			StdDraw.point(x, y);
			StdDraw.setPenColor(c);
		}
		
	}


}
