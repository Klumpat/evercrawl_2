package mapGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import maths.Bounds;
import maths.Vector2;

public class Room {
	
	protected static int ID_COUNT = -1;
	
	public final int ID;

	public final List<Vector2> coords = new ArrayList<Vector2>();
	public final List<Vector2> walls = new ArrayList<Vector2>();
	public final List<Room> connectedRooms = new ArrayList<Room>();
	public int color;
	protected TileMapGenerator gen;

	public Room(int color, TileMapGenerator gen) {
		ID_COUNT++;
		ID = ID_COUNT;
		this.color = color;
		this.gen = gen;
	}

	public Room() {
		ID_COUNT++;
		ID = ID_COUNT;
	}

	public static void connectRooms(Room roomA, Room roomB) {
		roomA.connectedRooms.add(roomB);
		roomB.connectedRooms.add(roomA);
	}

	public boolean isConnected(Room otherRoom) {
		return connectedRooms.contains(otherRoom);
	}

	public void add(Vector2 vec) {
		coords.add(vec);
	}

	/*
	 * floodfill
	 */
	public void expand(int x, int y) {
		if (gen.getData()[x + y * gen.width] == TileMapGenerator.TEMP_ROOM) {

			add(new Vector2(x, y));
			gen.getData()[x + y * gen.width] = color;

			expand(x, y + 1); // unten
			expand(x, y - 1); // oben
			expand(x - 1, y); // links
			expand(x + 1, y); // rechts

		}
		return;
	}

	public void discard() {
		for (int i = 0; i < coords.size(); i++) {
			float index = coords.get(i).x + coords.get(i).y * gen.width;
			gen.getData()[(int) index] = TileMapGenerator.STONE;
		}
		
		for (int i = 0; i < walls.size(); i++) {
			float index = walls.get(i).x + walls.get(i).y * gen.width;
			gen.getData()[(int) index] = TileMapGenerator.STONE;
		}
		
		gen.rooms.remove(this);

	}

	public Vector2 getRandomCoord() {
		Random random = new Random();
		return coords.get(random.nextInt(coords.size() - 1) + 1);
	}

	public Vector2 getRandomWall() {
		Random random = new Random();
		return walls.get(random.nextInt(walls.size() - 1) + 1);
	}

	public void setOutline() {

		for (int i = 0; i < coords.size(); i++) {
			Vector2 v = coords.get(i);
			setWall(v);
		}
	}

	protected void setWall(Vector2 vec) {

		if (gen.getData()[(int) ((vec.x + 1) + vec.y * gen.width)] == TileMapGenerator.STONE) {
			gen.getData()[(int) ((vec.x + 1) + vec.y * gen.width)] = TileMapGenerator.INVIS_WALL;
			walls.add(new Vector2(vec.x + 1, vec.y));
		}
		if (gen.getData()[(int) ((vec.x - 1) + vec.y * gen.width)] == TileMapGenerator.STONE) {
			gen.getData()[(int) ((vec.x - 1) + vec.y * gen.width)] = TileMapGenerator.INVIS_WALL;
			walls.add(new Vector2(vec.x - 1, vec.y));
		}

		if (gen.getData()[(int) (vec.x + (vec.y - 1) * gen.width)] == TileMapGenerator.STONE) {
			gen.getData()[(int) (vec.x + (vec.y - 1) * gen.width)] = TileMapGenerator.INVIS_WALL;
			walls.add(new Vector2(vec.x, vec.y - 1));
		}

		if (gen.getData()[(int) (vec.x + (vec.y + 1) * gen.width)] == TileMapGenerator.STONE) {
			gen.getData()[(int) (vec.x + (vec.y + 1) * gen.width)] = TileMapGenerator.INVIS_WALL;
			walls.add(new Vector2(vec.x, vec.y + 1));
		}

	}


	private int checkNeighbour(Vector2 vec, Vector2 dir) {
		int x = (int) (vec.x + dir.x);
		int y = (int) (vec.y + dir.y);
		if (x < 0 || y < 0 || x >= gen.width || y >= gen.height) {
			return color;
		}

		return gen.getData()[(int) ((vec.x + dir.x) + (vec.y + dir.y) * gen.width)];
	}

	

}
