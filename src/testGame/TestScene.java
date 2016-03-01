package testGame;

import core.Scene;
import core.Time;
import gfx.Renderer;
import maths.MathUtil;
import maths.Vector2;

public class TestScene extends Scene {
	
	boolean fov = false;

	public TestScene(int width, int height, int tilesize) {
		super(width, height, tilesize);
		generate();
	}

	@Override
	protected void generate() {
		tileMap.generateRandom();
		playerStart = tileMap.getRandomPlayerStartPosition();
	}

	@Override
	protected void populate() {
	}

	@Override
	protected void onUpdateStart() {
		dayNightCycle();

		if(fov){
			for (int y = 0; y < tileMap.getHeight(); y++) {
				for (int x = 0; x < tileMap.getWidth(); x++) {
					tileMap.getTile(x, y).setVisible(false);
				}
			}
			
			
			/*
			 * DIRECTIONS
			 * 
			 * UP = 3.5;
			 * DOWN = 6.5;
			 * LEFT = 2;
			 * RIGHT = 5;
			 * 
			 */
			
			int radius = 16;
			float direction = getPlayer().direction;
			int fov = 120;
			int DIR = (int) (direction*(fov/2));

			for (int angle = 0; angle <= fov; angle += 2) {
				float x = (float) Math.cos(Math.toRadians(angle + DIR));
				float y = (float) Math.sin(Math.toRadians(angle + DIR));
				Vector2 start = getPlayer().getBounds().getCenter();
				Vector2 end = start.add(new Vector2((tileMap.tilesize * radius) * x,(tileMap.tilesize * radius) * y));
				MathUtil.calculateFoV(start, end, 6, tileMap);

				//MathUtil.doFoV(x,y,this);
			}
		}

	}

	@Override
	protected void onUpdateEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onRenderStart(Renderer renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onRenderEnd(Renderer renderer) {
		renderer.drawGuiText(Time.getCurrentGameTimeAndDate(), 10, 10, 0xffffff, false);
		renderer.drawGuiText(getPlayer().getBounds().toString(), 10, 30, 0xffffff, false);
	}

	private void dayNightCycle() {
		switch (Time.getCurrentHour()) {
		case 1:
			Renderer.setLightLevel(4);
			break;
		case 2:
			Renderer.setLightLevel(4);
			break;
		case 3:
			Renderer.setLightLevel(5);
			break;
		case 4:
			Renderer.setLightLevel(6);
			break;
		case 5:
			Renderer.setLightLevel(7);
			break;
		case 6:
			Renderer.setLightLevel(8);
			break;
		case 7:
			Renderer.setLightLevel(9);
			break;
		case 8:
			Renderer.setLightLevel(10);
			break;
		case 9:
			Renderer.setLightLevel(11);
			break;
		case 10:
			Renderer.setLightLevel(12);
			break;
		case 11:
			Renderer.setLightLevel(13);
			break;
		case 13:
			Renderer.setLightLevel(14);
			break;
		case 14:
			Renderer.setLightLevel(14);
			break;
		case 15:
			Renderer.setLightLevel(13);
			break;
		case 16:
			Renderer.setLightLevel(12);
			break;
		case 17:
			Renderer.setLightLevel(11);
			break;
		case 18:
			Renderer.setLightLevel(10);
			break;
		case 19:
			Renderer.setLightLevel(9);
			break;
		case 20:
			Renderer.setLightLevel(8);
			break;
		case 21:
			Renderer.setLightLevel(7);
			break;
		case 22:
			Renderer.setLightLevel(6);
			break;
		case 23:
			Renderer.setLightLevel(5);
			break;

		default:
			break;
		}
	}

}
