package org.arda;
import java.awt.Color;

public abstract class GameObject implements IGameObject{
	
	protected double x,y;
	protected Color color;
	protected boolean target;
	protected String image;
	
	public GameObject(double x, double y, Color color, boolean target) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.target = target;
		this.image="";
	}
	
	public GameObject(double x, double y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.target = false;
		this.image="";
	}
	
	public GameObject(double x, double y, Color color, String image) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.target = false;
		this.image="resources/" + image;
	}
	
	public GameObject(double x, double y, Color color, boolean target, String image) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.target = target;
		this.image="resources/" + image;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

		
	@Override
	public boolean isTarget() {
		return target;
	}

	public void setTarget(boolean target) {
		this.target = target;
	}
	


}
