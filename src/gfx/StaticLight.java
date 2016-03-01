package gfx;

import core.Scene;
import maths.Vector2;

public class StaticLight extends Light{

	public StaticLight(Vector2 position, Scene scene, int intensity, int w) {
		super(position, scene, intensity, w);
		flicker = false;
	}

	@Override
	public void runScript() {
		
	}


}
