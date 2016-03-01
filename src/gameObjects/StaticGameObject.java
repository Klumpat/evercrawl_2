package gameObjects;

import core.Scene;
import gfx.Sprite;
import maths.Vector2;

public abstract class StaticGameObject extends GameObject {
	
	protected Sprite sprite;

	public StaticGameObject(Vector2 position, Scene scene) {
		super(position, scene);
	}

}
