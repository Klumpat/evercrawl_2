package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gameObjects.GameObject;
import gameObjects.NullTile;
import gameObjects.Player;
import gameObjects.Tile;
import gfx.Renderer;
import interfaces.Renderable;
import maths.MathUtil;
import maths.Vector2;

public abstract class Scene {

	protected float xOffset = 0;
	protected float yOffset = 0;

	public Vector2 playerStart;

	protected Player player;
	protected Random random;

	protected TileMap tileMap;

	protected List<GameObject> objects = new ArrayList<GameObject>();

	public Scene(int width, int height, int tilesize) {
		tileMap = new TileMap(width, height, tilesize, this);
	}

	public Scene(String filename, int tilesize) {
		tileMap = new TileMap(filename, tilesize, this);

	}

	public void update(Input input) {

		onUpdateStart();
		updateTiles();
		updateGameObjects();
		onUpdateEnd();

	}

	public void render(Renderer renderer) {
		onRenderStart(renderer);
		renderTiles(renderer);
		renderEntities(renderer);
		onRenderEnd(renderer);
	}

	public void addGameObject(GameObject e) {
		objects.add(e);
	}

	public void removeGameObject(GameObject e) {
		if (!e.isRemoved())
			return;
		objects.remove(e);
	}

	public void updateGameObjects() {
		for (GameObject e : objects) {
			e.update();
			if (e.isRemoved()) {
				removeGameObject(e);
			}
		}
	}

	public void updateTiles() {
		for (int i = 0; i < tileMap.tiles.length; i++) {
			tileMap.tiles[i].update();
		}
	}

	protected void renderEntities(Renderer renderer) {

		for (GameObject go : objects) {
			if (go instanceof Renderable && go.isVisible()) {
				go.render(renderer, (int) xOffset, (int) yOffset);
			}
		}
	}

	protected void renderTiles(Renderer renderer) {

		float xp = getPlayer().getPosition().x;
		float yp = getPlayer().getPosition().y;

		int xScroll = (int) (xp - renderer.getWidth() / 2);
		int yScroll = (int) (yp - renderer.getHeight() / 2);

		xOffset = xScroll;
		yOffset = yScroll;

		renderer.setOffset(xScroll, yScroll);

		int x0 = (xScroll / tileMap.tilesize) - 1;
		int x1 = (xScroll + renderer.getWidth()) / tileMap.tilesize + 18;
		int y0 = (yScroll / tileMap.tilesize) - 1;
		int y1 = (yScroll + renderer.getHeight()) / tileMap.tilesize + 18;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				GameObject tile = getTile(x, y);

				if (tile.isVisible()) {
					tile.render(renderer, (int) xOffset, (int) yOffset);
				} else
					continue;
			}
		}

	}

	/*
	 * Getter/Setter
	 */

	public Tile getTile(float ox, float oy) {
		if (ox < 0 || oy < 0 || oy >= tileMap.height || ox >= tileMap.width) {
			return new NullTile(new Vector2(ox, oy).convertToWorldCoords(), this);
		}
		Tile res = tileMap.tiles[(int) (ox + oy * tileMap.width)];
		return res;

	}

	public Player getPlayer() {
		for (GameObject go : objects)
			if (go instanceof Player)
				return (Player) go;

		return null;

	}

	public TileMap getTileMap() {
		return tileMap;
	}

	public Tile getTile(Vector2 vec) {
		return getTile(vec.x, vec.y);
	}

	public float getXOffset() {
		return xOffset;
	}

	public float getYOffset() {
		return yOffset;
	}

	/*
	 * Abstracts
	 */

	protected abstract void generate();

	protected abstract void populate();

	protected abstract void onUpdateStart();

	protected abstract void onUpdateEnd();

	protected abstract void onRenderStart(Renderer renderer);

	protected abstract void onRenderEnd(Renderer renderer);

}
