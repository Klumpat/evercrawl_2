package gameObjects;

import core.Scene;
import gfx.Sprite;
import maths.Vector2;

public abstract class Tile extends GameObject {

	private boolean isSolid;
	private boolean lighting;
	protected Sprite sprite;
	private int lightLevel;

	protected int mapColor;

	public Tile(Vector2 position, boolean solid, Sprite sprite, Scene scene, int mapColor) {
		super(position, scene);
		this.mapColor = mapColor;
		this.isSolid = solid;
		this.sprite = sprite;
		setWidth(sprite.getWidth());
		setHeight(sprite.getHeight());
		lighting = true;
	}

	public int getMapColor() {
		return mapColor;
	}

	/**
	 * Returns a boolean
	 * 
	 * @return isSolid
	 */
	public boolean isSolid() {
		return isSolid;
	}

	public boolean isLighting() {
		return lighting;
	}

	public void setLighting(boolean lighting) {
		this.lighting = lighting;
	}

	/**
	 * Returns the Width as int
	 * 
	 * @return width
	 */
	public int getWidth() {
		return sprite.getWidth();
	}

	/**
	 * Returns the Height as int
	 * 
	 * @return height
	 */
	public int getHeight() {
		return sprite.getHeight();
	}

	public int[] getPixels() {
		return sprite.getPix();
	}

	public int getID() {
		return sprite.getID();
	}

	public int getightLevel() {
		return this.lightLevel;
	}

	public String toString() {
		return getWorldPosition().toString();

	}

	// @Override
	// public void render(Renderer renderer, int xOffs, int yOffs) {
	// super.render(renderer, xOffs, yOffs);
	//
	// }

	// @Override
	// public void renderSelf(Renderer renderer) {
	// renderer.drawTile(this,
	// getBounds().getPosition().convertFromTileCoords().x,getBounds().getPosition().convertFromTileCoords().y);
	// }

}
