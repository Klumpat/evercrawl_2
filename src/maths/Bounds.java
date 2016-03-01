package maths;

import core.TileMap;

public class Bounds {

	protected Vector2 position;
	protected int height;
	protected int width;

	public Bounds(Vector2 p, int width, int height) {
		this.position = p;
		this.width = width;
		this.height = height;

	}

	public Bounds() {
		this.position = new Vector2(0, 0);
		this.width = 0;
		this.height = 0;
	}

	public Bounds(float x, float y, int width, int height) {
		position = new Vector2(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public Vector2 getCenter() {
		return new Vector2(getX() + getWidth() / 2, getY() + getHeight() / 2);
	}

	public boolean intersects(Bounds r) {
		int tw = this.width;
		int th = this.height;
		int rw = r.width;
		int rh = r.height;
		if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
			return false;
		}
		int tx = (int) this.getX();
		int ty = (int) this.getY();
		int rx = (int) r.getX();
		int ry = (int) r.getY();
		rw += rx;
		rh += ry;
		tw += tx;
		th += ty;
		return ((rw < rx || rw > tx) && (rh < ry || rh > ty) && (tw < tx || tw > rx) && (th < ty || th > ry));
	}

	public boolean contains(Vector2 p) {
		return contains(p.x, p.y, 1, 1);
	}

	public boolean contains(Bounds b) {
		return contains(b.getX(), b.getHeight(), b.getWidth(), b.getHeight());
	}

	public boolean contains(float X, float Y, float W, float H) {
		int w = this.width;
		int h = this.height;
		if (((int) w | (int) h | (int) W | (int) H) < 0) {
			return false;
		}
		int x = (int) this.getX();
		int y = (int) this.getY();
		if (X < x || Y < y) {
			return false;
		}
		w += x;
		W += X;
		if (W <= X) {

			if (w >= x || W > w)
				return false;
		} else {

			if (w >= x && W > w)
				return false;
		}
		h += y;
		H += Y;
		if (H <= Y) {
			if (h >= y || H > h)
				return false;
		} else {
			if (h >= y && H > h)
				return false;
		}
		return true;
	}

	public boolean tileCollision(int dx, int dy, TileMap tilemap) {

		Vector2 p0 = new Vector2(getPosition().x + dx, getPosition().y + dy);
		Vector2 p1 = new Vector2(getPosition().x + getWidth() - 1 + dx, getPosition().y + dy);
		Vector2 p2 = new Vector2(getPosition().x + dx, getPosition().y + getHeight() - 1 + dy);
		Vector2 p3 = new Vector2(getPosition().x + getWidth() - 1 + dx, getPosition().y + getHeight() - 1 + dy);

		boolean a = tilemap.getTile(p0.getTileCoords(tilemap.tilesize).x, p0.getTileCoords(tilemap.tilesize).y)
				.isSolid();
		boolean b = tilemap.getTile(p1.getTileCoords(tilemap.tilesize).x, p1.getTileCoords(tilemap.tilesize).y)
				.isSolid();
		boolean c = tilemap.getTile(p2.getTileCoords(tilemap.tilesize).x, p2.getTileCoords(tilemap.tilesize).y)
				.isSolid();
		boolean d = tilemap.getTile(p3.getTileCoords(tilemap.tilesize).x, p3.getTileCoords(tilemap.tilesize).y)
				.isSolid();

		boolean res = a | b | c | d;
		return res;

	}

	@Override
	public String toString() {
		return position.toString() + " w: " + width + " h: " + height;
	}

}
