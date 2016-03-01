package testGame;

import core.Scene;
import core.TileMap.TileColor;
import gameObjects.State;
import gameObjects.Tile;
import gfx.Animation;
import gfx.Animator;
import gfx.Renderer;
import maths.Vector2;

public class OceanTile extends Tile {
	
	private final Animation ANIM_OCEAN = new Animation(State.TILE, 12);
	private Animator animator;

	public OceanTile(Vector2 position, Scene scene) {
		super(position, true, Gfx.ocean_0, scene, TileColor.OCEAN);
		setLighting(true);
		
		setVisible(true);
		
		ANIM_OCEAN.addSprite(Gfx.ocean_0);
		ANIM_OCEAN.addSprite(Gfx.ocean_1);
		ANIM_OCEAN.addSprite(Gfx.ocean_2);
		ANIM_OCEAN.addSprite(Gfx.ocean_3);
		ANIM_OCEAN.addSprite(Gfx.ocean_4);
		ANIM_OCEAN.addSprite(Gfx.ocean_5);
		ANIM_OCEAN.addSprite(Gfx.ocean_6);
		ANIM_OCEAN.addSprite(Gfx.ocean_7);
		ANIM_OCEAN.addSprite(Gfx.ocean_8);
		ANIM_OCEAN.addSprite(Gfx.ocean_9);
		ANIM_OCEAN.addSprite(Gfx.ocean_10);
		ANIM_OCEAN.addSprite(Gfx.ocean_11);
		ANIM_OCEAN.addSprite(Gfx.ocean_12);
		ANIM_OCEAN.addSprite(Gfx.ocean_13);
		ANIM_OCEAN.addSprite(Gfx.ocean_14);
		ANIM_OCEAN.addSprite(Gfx.ocean_15);

		animator = new Animator();
		animator.addAnimation(ANIM_OCEAN);
	}


	@Override
	public void runScript() {
		animator.update(State.TILE);
	}


	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		sprite = animator.getCurrentAnimation().getCurrentSprite();
		renderer.drawTile(this, bounds.getX(), bounds.getY());	
		
	}






}
