package maths;

import core.Scene;
import core.TileMap;

public class MathUtil {

	public static float getDistance(Vector2 p0, Vector2 p1) {
		return getDistance(p0.x, p0.y, p1.x, p1.y);
	}

	public static float getDistance(float x0, float y0, float x1, float y1) {
		float x = x0 - x1;
		float y = y0 - y1;
		return (float) Math.sqrt(x * x + y * y);
	}

	public static float lerp(float a, float b, float f) {
		return (a * (1.0f - f)) + (b * f);
	}
	
	public static void doFoV(float x, float y, Scene scene){
		int i;
		  float ox,oy;
		  ox = (float)scene.getPlayer().getPosition().x+16f;
		  oy = (float)scene.getPlayer().getPosition().y+16f;
		  for(i=0;i<3;i++)
		  {
			  scene.getTile(ox/32, oy/32).setVisible(true);

				if (scene.getTile(ox/32, oy/32).isSolid()) {
					return;
				}
		    ox+=x;
		    oy+=y;
		  }
	}
	

	public static void calculateFoV(Vector2 start, Vector2 end, int r, TileMap map) {

		int x0 = (int) start.x;
		int x1 = (int) end.x;
		int y0 = (int) start.y;
		int y1 = (int) end.y;

		int w = x1 - x0;
		int h = y1 - y0;

		int dx0 = 0;
		int dy0 = 0;
		int dx1 = 0;
		int dy1 = 0;

		if (w < 0)
			dx0 = -1;
		else if (w > 0)
			dx0 = 1;
		if (h < 0)
			dy0 = -1;
		else if (h > 0)
			dy0 = 1;
		if (w < 0)
			dx1 = -1;
		else if (w > 0)
			dx1 = 1;

		int longest = Math.abs(w);
		int shortest = Math.abs(h);

		if (!(longest > shortest)) {
			longest = Math.abs(h);
			shortest = Math.abs(w);
			if (h < 0)
				dy1 = -1;
			else if (h > 0)
				dy1 = 1;
			dx1 = 0;
		}
		
		int numerator = longest >> 1;
		for (int i = 0; i <= longest; i++) {

			map.getTile(x0/32, y0/32).setVisible(true);

			if (map.getTile(x0/32, y0/32).isSolid()) {
				continue;
			}

			numerator += shortest;
			if (!(numerator < longest)) {
				numerator -= longest;
				x0 += dx0;
				y0 += dy0;
			} else {
				x0 += dx1;
				y0 += dy1;
			}
		}

	}

}
