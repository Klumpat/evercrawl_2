package mapGenerator;

import java.util.List;

import maths.Bounds;
import maths.Vector2;

public class SquaredRoom extends Room {

	public final int width;
	public final int height;
	public Vector2 position;

	public SquaredRoom(int width, int height, Vector2 pos, int col, TileMapGenerator gen) {
		super();
		this.gen = gen;
		this.position = pos;
		this.width = width;
		this.height = height;
		this.color = col;

		for (int y = 0; y < height; y++) {
			int yy = (int) (position.y + y);
			for (int x = 0; x < width; x++) {
				int xx = (int) (position.x + x);
				coords.add(new Vector2(xx, yy));
			}
		}
	}

	public SquaredRoom(int width, int height, int x_, int y_, int col, TileMapGenerator gen) {
		super();
		this.gen = gen;
		this.position = new Vector2(x_, y_);
		this.width = width;
		this.height = height;
		this.color = col;

		for (int y = 0; y < height; y++) {
			int yy = (int) (position.y + y);
			for (int x = 0; x < width; x++) {
				int xx = (int) (position.x + x);
				coords.add(new Vector2(xx, yy));
			}
		}
	}

	public boolean intersects(SquaredRoom room) {
		Bounds me = new Bounds(position, width, height);
		Bounds other = new Bounds(room.position, room.width, room.height);

		return me.intersects(other);

	}

}
