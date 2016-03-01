package util;

import java.awt.Color;
import java.awt.Graphics;

public class Debug {
	
	private static Graphics g;
	
	public static void init(Graphics g){
		Debug.g = g;
	}
	
	
	//TODO meh
	public static void drawLine(float x0,float x1,float y0,float y1){
		g.setColor(Color.RED);
		g.drawLine((int)x0, (int)y0, (int)x1, (int)y1);
	}

}
