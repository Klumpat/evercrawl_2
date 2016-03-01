package testGame;

import core.Scene;
import gameObjects.StaticGameObject;
import gfx.Light;
import gfx.Renderer;
import gfx.Sprite;
import gfx.StaticLight;
import maths.Vector2;

public class Torch extends StaticGameObject{
	
	Sprite sprite;
	Light light;

	public Torch(Vector2 position, Scene scene) {
		super(position, scene);
		this.sprite = Gfx.torch;
		this.light = new StaticLight(new Vector2(1,1), getScene(), 15, 64);
		add(light);
	}

	@Override
	public int[] getPixels() {
		return sprite.getPix();
	}

	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		renderer.drawBitMap(sprite, bounds.getX() + x, bounds.getY()+y);
	}

	@Override
	public void runScript() {
		
	}

}
