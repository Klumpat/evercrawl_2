package testGame;

import core.Scene;
import core.TileMap.TileColor;
import gameObjects.Tile;
import gfx.Renderer;
import gfx.Sprite;
import maths.Vector2;

public class WallTile extends Tile {

	public WallTile(Vector2 position, Scene scene) {
		super(position, true, Gfx.wallSprite, scene, TileColor.NULL);
		setLighting(true);
	}

	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		renderer.drawTile(this, bounds.getX(), bounds.getY());
	}

	@Override
	public void runScript() {

	}

}
