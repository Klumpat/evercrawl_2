package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameObjects.NullTile;
import gameObjects.Tile;
import gfx.Bitmap;
import mapGenerator.TileMapGenerator;
import maths.Vector2;
import testGame.FloorTile;
import testGame.LeftCornerWallTile;
import testGame.LeftWallTile;
import testGame.MagmaTile;
import testGame.OceanTile;
import testGame.RightCornerWallSprite;
import testGame.RightWallTile;
import testGame.WallTile;

public class TileMap {

	public final int tilesize;
	protected int width;
	protected int height;
	protected Tile[] tiles;
	protected Bitmap mapData;
	protected TileMapGenerator gen;
	protected Scene scene;

	public TileMap(int width, int height, int tilesize, Scene scene) {
		this.width = width;
		this.height = height;
		this.tilesize = tilesize;
		this.mapData = new Bitmap(width, height);
		this.tiles = new Tile[width * height];
		this.scene = scene;
		gen = new TileMapGenerator(width, height);
	}

	public TileMap(String filename, int tilesize, Scene scene) {
		this.tilesize = tilesize;
		this.scene = scene;
		gen = new TileMapGenerator(width, height);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("res/maps/" + filename + ".png"));
			int w = img.getWidth();
			int h = img.getHeight();
			this.width = w;
			this.height = h;
			this.tiles = new Tile[width * height];
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					int color = img.getRGB(x, y);
					createTileFromColor(color, x, y);

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		mapData = new Bitmap(width, height);
		for (int i = 0; i < tiles.length; i++) {
			mapData.pix[i] = tiles[i].getMapColor();
		}
	}

	public void generateRandom() {
		//FIXME add a proper implemantation
		
		int[] data = gen.generateDungeon();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				int index = data[x + y * width];

				switch (index) {
				case TileMapGenerator.AIR:
					tiles[x + y * width] = new NullTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.STONE:
					tiles[x + y * width] = new NullTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.TEMP_ROOM:
					tiles[x + y * width] = new NullTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.CONNECTION:
					tiles[x + y * width] = new FloorTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.WALL:
					tiles[x + y * width] = new WallTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.INVIS_WALL:
					tiles[x + y * width] = new WallTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.RIGHT_WALL:
					tiles[x + y * width] = new RightWallTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.TOP_RIGHT_CORNER:
					tiles[x + y * width] = new RightCornerWallSprite(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.TOP_LEFT_CORNER:
					tiles[x + y * width] = new LeftCornerWallTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				case TileMapGenerator.LEFT_WALL:
					tiles[x + y * width] = new LeftWallTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;

				// actual rooms are rendered here
				default:
					tiles[x + y * width] = new FloorTile(new Vector2(x, y).convertFromTileCoords(), scene);
					break;
				}

			}
		}
	}
	
	//TODO make this better
	public Vector2 getRandomPlayerStartPosition(){
		return gen.rooms.get(0).getRandomCoord();
	}

	public Tile getTile(float ox, float oy) {
		if (ox < 0 || oy < 0 || oy >= height || ox >= width) {
			return new NullTile(new Vector2(ox, oy).convertToWorldCoords(), scene);
		}
		Tile res = tiles[(int) (ox + oy * width)];
		return res;

	}

	public Tile getTile(Vector2 vec) {
		return getTile(vec.x, vec.y);
	}

	private void createTileFromColor(int color, int x, int y) {

		switch (color) {
		case TileColor.OCEAN:
			tiles[x + y * width] = new OceanTile(new Vector2(x * 32, y * 32), scene);
			break;
		case TileColor.GRASS:
			tiles[x + y * width] = new FloorTile(new Vector2(x * 32, y * 32), scene);
			break;
		case TileColor.MAGMA:
			tiles[x + y * width] = new MagmaTile(new Vector2(x * 32, y * 32), scene);
			break;
		case TileColor.NULL:
			tiles[x + y * width] = new NullTile(new Vector2(x * 32, y * 32), scene);
			break;

		default:
			tiles[x + y * width] = new NullTile(new Vector2(x * 32, y * 32), scene);
		}

	}

	public Bitmap getMapData() {
		return mapData;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile[] getTiles() {
		return tiles;
	}
	
	public TileMapGenerator getGenerator() {
		return gen;
	}

	public class TileColor {

		public static final int NULL = 0xffff00ff;
		public static final int OCEAN = 0xff0000ff;
		public static final int MAGMA = 0xffff0000;
		public static final int GRASS = 0xff00ff00;

	}

}
