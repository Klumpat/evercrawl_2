package testGame;

import core.Game;
import core.TileMapViewer;

public class Main {

	public static void main(String[] args) {
		boolean startViewer = false;
		Gfx.init();
		if (startViewer) {
			TileMapViewer tmv = new TileMapViewer();
			tmv.start();

		}
		else {
			Game game = new TestGame();
			game.start();
		}
	}

}
