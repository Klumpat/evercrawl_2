package gameObjects;

import core.Scene;
import gfx.Sprite;
import maths.Bounds;
import maths.Vector2;

public abstract class Mob extends GameObject{

	
	protected Sprite sprite;
	protected int speed = 1;
	protected State dir;
	protected BoxCollider collider;
	

	public Mob(Vector2 position, Sprite sprite, Scene scene) {
		super(position, scene);
		this.sprite = sprite;
		setWidth(sprite.getWidth());
		setHeight(sprite.getHeight());
		this.collider = new BoxCollider(new Vector2(0,0), scene);
		collider.setWidth(getWidth());
		collider.setHeight(getHeight()/2);
		add(collider);
	}
	
	public State getDir() {
		return dir;
	}


	
	protected void setDirection(int dx, int dy) {
		if (dy > 0) {
			dir = State.DOWN;
		}
		if (dy < 0) {
			dir = State.UP;
		}
		
		if (dx > 0) {
			dir = State.RIGHT;
		}
		if (dx < 0) {
			dir = State.LEFT;
		}
		

		if (dx == 0 && dy == 0) {
			if (dir == State.UP) {
				dir = State.IDLE_UP;
			}
			if (dir == State.DOWN) {
				dir = State.IDLE_DOWN;
			}
		}

		if (dx == 0 && dx == 0) {
			if (dir == State.RIGHT) {
				dir = State.IDLE_RIGHT;
			}
			if (dir == State.LEFT) {
				dir = State.IDLE_LEFT;
			}
		}

	}
	

	protected void move(int dx_, int dy_) {
		int dx = dx_;
		int dy = dy_;

		for (int i = 0; i < speed; i++) {
			if (!collider.getBounds().tileCollision(dx, 0, scene.getTileMap())) {
				if (dx != 0 || dy != 0)
					bounds.setPosition(bounds.getPosition().add(dx, 0));
			}
		}
		
		for (int i = 0; i < speed; i++) {
			if (!collider.getBounds().tileCollision(0, dy, scene.getTileMap())) {
				if (dx != 0 || dy != 0)
					bounds.setPosition(bounds.getPosition().add(0, dy));
			}
		}
	}
	
	public BoxCollider getCollider() {
		return collider;
	}


}
