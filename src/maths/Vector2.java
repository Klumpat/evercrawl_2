package maths;

import core.CoreEngine;

public class Vector2 {

	public float x;
	public float y;
	
	public static final Vector2 ZERO = new Vector2(0,0);
	public static final Vector2 UP = new Vector2(0,-1);
	public static final Vector2 DOWN = new Vector2(0,1);
	public static final Vector2 LEFT = new Vector2(-1,0);
	public static final Vector2 RIGHT = new Vector2(1,0);
	public static final Vector2 TOP_LEFT = new Vector2(-1,-1);
	public static final Vector2 TOP_RIGHT = new Vector2(1,-1);
	public static final Vector2 Bottom_LEFT = new Vector2(-1,1);
	public static final Vector2 BOTTOM_RIGHT = new Vector2(1,1);
	

	public Vector2(float f, float g) {
		this.x = f;
		this.y = g;
	}

	public Vector2() {
		this.x = 0;
		this.y = 0;
	}

	public Vector2(Vector2 position) {
		this.x = position.x;
		this.y = position.y;
	}

	public Vector2 mouseToWorld(final int xOffs, final int yOffs) {
		Vector2 p0 = this.mouseToGui();
		p0.x -= CoreEngine.WIDTH / 2;
		p0.y -= CoreEngine.HEIGHT / 2;
		Vector2 p1 = new Vector2(xOffs + p0.x, yOffs + p0.y);

		return p1;
	}

	public Vector2 mouseToTile(final int xOffs, final int yOffs) {
		int xx = xOffs;
		int yy = yOffs;
		Vector2 p0 = this.mouseToGui();
		p0.x -= CoreEngine.WIDTH / 2;
		p0.y -= CoreEngine.HEIGHT / 2;
		Vector2 p1 = new Vector2((xx + p0.x) / 32, (yy + p0.y) / 32);

		return p1;
	}

	public Vector2 mouseToGui() {
		Vector2 p = new Vector2(x, y);

		p.x = x / CoreEngine.SCALE;
		p.y = y / CoreEngine.SCALE;
		return p;
	}

	public Vector2 getTileCoords(int TILE_SIZE) {
		return new Vector2((int) (x / TILE_SIZE), (int) (y / TILE_SIZE));
	}

	public Vector2 convertFromTileCoords() {
		Vector2 res = new Vector2(x, y);
		res.x = (int) x << 5;
		res.y = (int) y << 5;
		return res;
	}

	public Vector2 convertToWorldCoords() {
		// this.x = x >> 5;
		// this.y = y >> 5;
		return new Vector2((int) x >> 5, (int) y >> 5);
	}

	public Vector2 add(float dx, float dy) {
		// x += dx;
		// y += dy;
		return new Vector2((int) (x + dx), (int) (y + dy));
	}

	public Vector2 add(Vector2 p) {
		return new Vector2(x + p.x, y + p.y);
	}

	public String toString() {
		return "x: " + x + " y: " + y;
	}

}
