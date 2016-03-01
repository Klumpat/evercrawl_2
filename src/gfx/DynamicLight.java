package gfx;

import core.Scene;
import maths.Vector2;

public class DynamicLight extends Light{

	public DynamicLight(Vector2 position, Scene scene, int intensity, int w) {
		super(position, scene, intensity, w);
		flicker = false;
	}

	@Override
	public void runScript() {
		calculateLightMap();
	}


}
