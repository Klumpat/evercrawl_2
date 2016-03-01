package gameObjects;

import java.util.ArrayList;
import java.util.List;

import core.Scene;
import gfx.Renderer;
import interfaces.Renderable;
import interfaces.Updateable;
import maths.Bounds;
import maths.Vector2;

public abstract class GameObject implements Updateable, Renderable, Scriptable {

	// FIXME there is a bug with the collider, the bounds specified in the mob
	// class doesnt apply correctly
	protected Bounds bounds;
	protected Vector2 offset;
	protected Scene scene;
	protected GameObject parent;
	protected List<GameObject> children = new ArrayList<GameObject>();
	protected boolean visible;

	protected boolean removed;

	public GameObject(Vector2 position, Scene scene) {
		this.bounds = new Bounds(position, 0, 0);
		this.scene = scene;
		offset = new Vector2(0, 0);
		setVisible(true);

	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Vector2 getPosition() {
		return bounds.getPosition();
	}

	public int getWidth() {
		return bounds.getWidth();
	}

	public int getHeight() {
		return bounds.getHeight();
	}

	public void setWidth(int w) {
		bounds.setWidth(w);
	}

	public void setHeight(int h) {
		bounds.setHeight(h);
	}

	public Bounds getBounds() {
		return bounds;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void remove() {
		removed = true;
	}

	public void update() {
		setOffset();
		runScript();
		for (GameObject go : children) {
			go.update();
		}
	}

	public void render(Renderer renderer, float xOffset, float yOffset) {
		renderSelf(renderer, (int)xOffset, (int)yOffset);
		for (GameObject go : children) {
			go.render(renderer, xOffset, yOffset);
		}

	}

	public void add(GameObject child) {
		children.add(child);
		child.setParent(this);
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
		this.offset = getParent().getPosition();
	}

	private void setOffset() {
		if (parent != null) {
			this.offset = getParent().getPosition();
		}
		return;
	}

	public Vector2 getOffset() {
		return offset;
	}

	public Vector2 getWorldPosition() {
		return new Vector2(offset.x + getPosition().x, offset.y + getPosition().y);
	}

	public GameObject getParent() {
		return parent;
	}

}
