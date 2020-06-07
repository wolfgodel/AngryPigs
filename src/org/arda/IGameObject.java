package org.arda;

public interface IGameObject {
	void draw(boolean withImage);
	boolean hit(double x, double y);
	boolean isTarget();
}
