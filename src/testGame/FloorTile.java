package testGame;

import core.Scene;
import core.TileMap.TileColor;
import gameObjects.Tile;
import gfx.Renderer;
import maths.Vector2;

public class FloorTile extends Tile{

	public FloorTile(Vector2 position, Scene scene) {
		super(position, false, Gfx.floorSprite, scene, TileColor.GRASS);
	}


	@Override
	public void runScript() {
		
	}


	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		renderer.drawTile(this, bounds.getX(), bounds.getY());	
	}



}
