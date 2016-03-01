package gameObjects;

import core.Scene;
import gfx.Renderer;
import maths.Vector2;

public class BoxCollider extends GameObject{

	public BoxCollider(Vector2 position, Scene scene) {
		super(position, scene);
	}

	@Override
	public int[] getPixels() {
		return null;
	}

	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
	}

	@Override
	public void runScript() {
		getPosition().x = getParent().getPosition().x;
		getPosition().y = getParent().getPosition().y + getParent().getHeight() / 2;
	}

}
