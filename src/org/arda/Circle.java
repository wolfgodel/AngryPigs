package org.arda;

import java.awt.Color;

import stddraw.StdDraw;

public class Circle extends GameObject{
	protected double radius;

	public Circle(int x, int y, Color color, double radius, boolean target) {
		super(x, y, color, target);
		this.radius = radius;
	}

	public Circle(double x, double y, Color color, double radius) {
		super(x, y, color);
		this.radius = radius;
	}
		
	public Circle(double x, double y, Color color, double radius, boolean target, String image) {
		super(x, y, color, target, image);
		this.radius = radius;
	}
	
	public Circle(double x, double y, Color color, double radius,  String image) {
		super(x, y, color, false, image);
		this.radius = radius;
	}
	
	@Override
	public void draw(boolean withImage) {
		if (!image.isEmpty() && withImage) {
			StdDraw.picture(x, y, image, radius*2, radius*2);
		}
		else {
			Color c = StdDraw.getPenColor();
			StdDraw.setPenColor(color);
			StdDraw.filledCircle(x, y, radius);
			StdDraw.setPenColor(c);
		}
	}

	@Override
	public boolean hit(double x, double y) {
		if(Utils.geoDis(x, y, this.x, this.y)<=radius) {
			System.out.println("HIT!!!");
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	
}
