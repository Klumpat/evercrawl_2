package testGame;

import core.Scene;
import core.TileMap.TileColor;
import gameObjects.Tile;
import gfx.Renderer;
import maths.Vector2;

public class LeftWallTile extends Tile{
	
	public LeftWallTile(Vector2 position, Scene scene) {
		super(position, true, Gfx.wallSpriteLeft, scene, TileColor.NULL);
		setLighting(true);
	}

	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runScript() {
		// TODO Auto-generated method stub
		
	}

}
