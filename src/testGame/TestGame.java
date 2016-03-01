package testGame;

import core.Game;
import gameObjects.Player;

public class TestGame extends Game {

	@Override
	protected void initScene() {
		scene = new TestScene(250,250,32);
		scene.addGameObject(new Player(scene.playerStart.convertFromTileCoords(), Gfx.PLAYE_DOWN_1, scene));
	}

	@Override
	protected void initGui() {
		
	}

}
