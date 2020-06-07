package org.arda;
import stddraw.StdDraw;

//javadoc

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author wolfgodel (ARDA İÇEN)
 * @version 1.0
 *
 */

public class Game {
	public static void main(String[] args) {
;
		// canvas parameters
		int widthRectangle = 1000;
		int heightRectangle = 500;

		// initialize the canvas
		StdDraw.setCanvasSize(widthRectangle, heightRectangle);
		StdDraw.setXscale(0, widthRectangle);
		StdDraw.setYscale(0, heightRectangle);
		StdDraw.enableDoubleBuffering();

		ArrayList<IGameObject> objects = new  ArrayList<IGameObject>();

		objects.add(new RectObject(250,125,StdDraw.BLACK,80,250, "column1.png"));
		
		objects.add(new RectObject(400,75, StdDraw.CYAN,40,150, "column1.png"));
		objects.add(new RectObject(600, 60, StdDraw.BLACK,40,120,"column1.png"));
		objects.add(new RectObject(750,150,StdDraw.GREEN,100,300, "column1.png"));
		
		objects.add(new Circle(750,320,StdDraw.RED,40, true, "redbird1.png"));
		objects.add(new Circle(400, 165, StdDraw.RED, 30, true, "redbird1.png"));
		objects.add(new Circle(520, 20, StdDraw.RED, 40, true, "redbird1.png"));
		
		Scanner sc = new Scanner(System.in);
		double angle=Math.PI/4, velocity=80, 
				x0=0, y0=0, x=x0, y=y0, vx=0, vy=0,t=0;

		Bullet bullet =  new Bullet( x0,   y0,  Color.MAGENTA, 30, "pig1.png");
		
		//daha sonra gameObjectlerin minX lerine göre büyükten
		//küçüğe sıralayıp arraye yerleştiren bir yapı
		//olusturulabilir
		int targetCount=3;
		
		double bx, by;
		
		while (StdDraw.isKeyPressed(KeyEvent.VK_Q)==false) {
			// clear the screen, draw the rectangle, and show it on the screen
			StdDraw.clear();
			
			StdDraw.picture(0, 600, "resources/background1.png",widthRectangle*2, heightRectangle*2.3);
			for (IGameObject gameObject : objects) {
				gameObject.draw(true);
			}
			bx= x0+Math.cos(angle)*velocity;
			by =  y0+Math.sin(angle)*velocity;
			
			bullet.setX(bx);
			bullet.setY(by);
			
			StdDraw.line(x0, y0, bx, by);
			bullet.draw(true);
			

			double xu,yu,vxu,vyu, tu=0;
			do {
				tu+=0.2;
				vxu=Math.cos(angle)*velocity;
				vyu=Math.sin(angle)*velocity;
				xu=bx+vxu*tu;
				yu=by+vyu*tu-0.5*9.8*(tu*tu);
				StdDraw.point(xu, yu);
				
			} while(yu>0 && xu<=widthRectangle);
	
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				velocity-=1;
			} 

			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				velocity+=1;
			}

			if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				angle+=0.05;
			} 

			if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				angle-=0.05;
			}
			
			double turev;
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
				StdDraw.setPenColor(StdDraw.BOOK_RED);
				
			
				t=0;
				do {
					StdDraw.clear();
					
					t+=0.1;
					vx=Math.cos(angle)*velocity;
					vy=Math.sin(angle)*velocity;
					x=bx+vx*t;
					y=by+vy*t-0.5*9.8*(t*t);
					
					
					
					for(int i=0; i<objects.size(); i++) {
						
						if(objects.get(i).hit(x, y)) {
							StdDraw.text(widthRectangle/2, heightRectangle/2, "Target Hit");
							if(objects.get(i).isTarget()) {
								objects.remove(i);
								targetCount--;
							}
							break;

						}
					}
					
					
					
					
					StdDraw.picture(0, 600, "resources/background1.png",widthRectangle*2, heightRectangle*2.3);
					for (IGameObject gameObject : objects) {
						gameObject.draw(true);
					}

					
					
					bullet.setX(x);
					bullet.setY(y);
					
			
					bullet.draw(true);
					
				
					StdDraw.setPenRadius(0.01);
					StdDraw.point(x, y);
					

					StdDraw.show();
					
				
					
				}while(y>0 && x<=widthRectangle);
				
				if(targetCount==0) {
					
					break;
				}
				
				StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);

			}

			
			
			//StdDraw.filledRectangle(x, y, rectHalfSize, rectHalfSize);
			StdDraw.show();
		}
	
		StdDraw.text(widthRectangle/2, heightRectangle/2, "Game Over");
		StdDraw.show();

	}
}
