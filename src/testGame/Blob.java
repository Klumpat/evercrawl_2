package testGame;

import core.CharacterController;
import core.Scene;
import gameObjects.Player;
import gfx.Sprite;
import maths.Vector2;

public class Blob extends Player {

	public Blob(Vector2 position, Sprite sprite, Scene scene) {
		super(position, sprite, scene);
	}

	@Override
	public void runScript() {

		int dx = 0;
		int dy = 0;

		if (CharacterController.up)
			dy++;
		if (CharacterController.down)
			dy--;
		if (CharacterController.right)
			dx--;
		if (CharacterController.left)
			dx++;

		move(dx, dy);
		setDirection(dx, dy);
		animator.update(dir);

	}

}
