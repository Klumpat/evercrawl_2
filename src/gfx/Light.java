package gfx;

import java.util.Random;

import core.Scene;
import gameObjects.GameObject;
import maths.MathUtil;
import maths.Vector2;

public abstract class Light extends GameObject {

	// make baked/static lights and dynamic lights
	// dynamics dont work

	protected static final int MIN_INTENSITY = 15;

	@SuppressWarnings("unused")
	private int brightness;
	private int radius;
	private int intensity;
	private int attenuation;
	private Bitmap lightMap;

	public boolean flicker;

	int time = 0;

	public Light(Vector2 position, Scene scene, int intensity, int w) {
		super(position, scene);
		this.brightness = MIN_INTENSITY;
		this.radius = w;
		setWidth(w * 2);
		setHeight(w * 2);
		this.intensity = intensity;

		calculateLightMap();

	}

	@Deprecated
	public int getBrightness(float xx, float yy, float xOffs, float yOffs) {

		int distance = (int) MathUtil.getDistance(this.getPosition().x, this.getPosition().y, xx, yy);

		for (int i = 0; i <= intensity; i++) {
			if (attenuation * i >= distance) {
				continue;
			} else {
				int rrr = intensity * i;
				return rrr;
			}
		}

		return 1;

	}

	public int getIntensity() {
		return intensity;
	}

	public int getAttenuation() {
		return attenuation;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int[] getPixels() {
		return lightMap.getPix();
	}

	@Override
	public void update() {
		super.update();
		if (flicker) {
			Random random = new Random();
			int r = random.nextInt(3) - 1;
			intensity += r;
		}
		getPosition().x = getParent().getWidth() / 2 - radius;
		getPosition().y = getParent().getHeight() / 2 - radius;
	}

	public void calculateLightMap() {

		lightMap = new Bitmap(getWidth(), getHeight());

		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {

				float distance = (float) Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
				if (distance < radius) {
					this.lightMap.pix[x + y * getWidth()] = (int) ((1 - distance / radius) % 100 * intensity);
				}

			}
		}

	}

	@Override
	public void renderSelf(Renderer renderer, int xOffs, int yOffs) {
		renderer.drawLightMap(lightMap, getParent().getPosition().x + getPosition().x + xOffs,
				getParent().getPosition().y + getPosition().y + yOffs);
	}

}
