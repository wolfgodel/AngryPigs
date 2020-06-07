package org.arda;

import java.awt.Color;

import stddraw.StdDraw;

public class RectObject extends GameObject{
	
	protected double width,heigth;
	protected double halfWidth, halfHeigth;
	
	public RectObject(double x, double y, Color color, double width, double heigth) {
		super(x, y, color);
		this.width = width;
		this.heigth = heigth;
		this.halfWidth=width/2;
		this.halfHeigth=heigth/2;
	}
	
	public RectObject(double x, double y, Color color,double width, double heigth, boolean target) {
		super(x, y, color, target);
		this.width = width;
		this.heigth = heigth;
		this.halfWidth=width/2;
		this.halfHeigth=heigth/2;
	}
	
	public RectObject(double x, double y, Color color,double width, double heigth, boolean target, String image) {
		super(x, y, color, target, image);
		this.width = width;
		this.heigth = heigth;
		this.halfWidth=width/2;
		this.halfHeigth=heigth/2;
	}
	
	public RectObject(double x, double y, Color color,double width, double heigth,  String image) {
		super(x, y, color, false, image);
		this.width = width;
		this.heigth = heigth;
		this.halfWidth=width/2;
		this.halfHeigth=heigth/2;
	}

	@Override
	public boolean hit(double x, double y) {
		if(x>=getX1() && x<= getX2()) {
			if(y<=getY1()  && y>=getY2()) {
				System.out.println("Target hit:" + this.toString());
				return true;
			}
				
		}
		
		return false;
	}
	
	public double getX2() {
		return x+halfWidth;
	}
	
	public double getY2() {
		return y-halfHeigth;
	}

	public double getX1() {
		return x;
	}
	
	public double getY1() {
		return y;
	}
	
	@Override
	public String toString() {
		return "Target [width=" + width + ", heigth=" + heigth + ", X2:" + getX2() +", Y2:"  + getY2() +"]";
	}

	@Override
	public void draw(boolean withImage) {
		if (!image.isEmpty() && withImage) {
			StdDraw.picture(getX1(), getY1(), image, width, heigth);
		}
		else {
			Color c = StdDraw.getPenColor();
			StdDraw.setPenColor(color);
			StdDraw.filledRectangle(getX1(),getY1(), halfWidth, halfHeigth);
			StdDraw.setPenColor(c);
		}
		
	}
}
