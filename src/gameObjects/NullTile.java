package gameObjects;

import core.Scene;
import core.TileMap.TileColor;
import gfx.Renderer;
import gfx.Sprite;
import maths.Vector2;

public class NullTile extends Tile {

	public NullTile(Vector2 position, Scene scene) {
		super(position, true, new Sprite(32, 32,0x00), scene, TileColor.NULL);
		
		setLighting(false);
	}

	@Override
	public void runScript() {

	}

	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		renderer.drawTile(this, bounds.getX(), bounds.getY());	}



}
