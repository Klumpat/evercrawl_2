package core;

import java.awt.event.KeyEvent;

import gfx.Bitmap;
import gfx.Renderer;
import mapGenerator.TileMapGenerator;

public class TileMapViewer {

	public TileMapGenerator gen;
	protected CoreEngine core;

	private int[] tiles;

	int TILESIZE = 2;

	Bitmap BLACK;
	Bitmap WHITE;
	Bitmap BLUE;
	Bitmap RED;
	Bitmap PURPLE;
	Bitmap GREEN;

	public int smooth = 3;
	public int wallpct = 48;
	public int minroomsize = 64;
	public int maxroomsize = 99999999;

	public TileMapViewer() {
		
		core = new CoreEngine(null, this);
		
		PURPLE = new Bitmap(TILESIZE, TILESIZE, 0xff00ff);
		WHITE = new Bitmap(TILESIZE, TILESIZE, 0xffffff);
		BLACK = new Bitmap(TILESIZE, TILESIZE, 0x00);
		RED = new Bitmap(TILESIZE, TILESIZE, 0xff0000);
		GREEN = new Bitmap(TILESIZE, TILESIZE, 0x00ff00);
		BLUE = new Bitmap(TILESIZE, TILESIZE, 0xff);

		gen = new TileMapGenerator(core.WIDTH/core.SCALE, core.HEIGHT/core.SCALE);

		//gen.generateRooms(15, 10, 25, 40, 100);
//		gen.generateDungeon();
//		tiles = gen.getData();
		
		tiles = gen.generateDungeon();

	}
	
	public void start(){
		core.start();

	}
	
	public void stop(){
		core.stop();
	}

	public void update() {
		smooth = 5;
		wallpct = 53;
		minroomsize = 64;

		// generate once
		if (Input.keyTyped(KeyEvent.VK_SPACE)) {
			System.out.println("generate NEW");
			gen.reset();
			gen.generateCave();
			tiles = gen.getData();
		}

		if (Input.keyTyped(KeyEvent.VK_1)) {
			gen.reset();
			tiles = gen.generateDungeon();
		}

	}

	public void render(Renderer renderer) {

		for (int y = 0; y < gen.height; y++) {
			for (int x = 0; x < gen.width; x++) {

				int index = tiles[x + y * gen.width];

				switch (index) {
				case TileMapGenerator.AIR:
					renderer.drawBitMap(WHITE, x * TILESIZE, y * TILESIZE);
					break;
				case TileMapGenerator.STONE:
					renderer.drawBitMap(BLACK, x * TILESIZE, y * TILESIZE);
					break;
				case TileMapGenerator.TEMP_ROOM:
					renderer.drawBitMap(BLUE, x * TILESIZE, y * TILESIZE);
					break;
				case TileMapGenerator.CONNECTION:
					renderer.drawBitMap(RED, x * TILESIZE, y * TILESIZE);
					break;
				case TileMapGenerator.WALL:
					renderer.drawBitMap(GREEN, x * TILESIZE, y * TILESIZE);
					break;
				case TileMapGenerator.INVIS_WALL:
					renderer.drawBitMap(GREEN, x * TILESIZE, y * TILESIZE);
					break;

				// actual rooms are rendered here
				default:
					renderer.drawBitMap(PURPLE, x * TILESIZE, y * TILESIZE);
					break;
				}

			}
		}

	}

}
