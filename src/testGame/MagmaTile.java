package testGame;

import core.Scene;
import core.TileMap.TileColor;
import gameObjects.State;
import gameObjects.Tile;
import gfx.Animation;
import gfx.Animator;
import gfx.Light;
import gfx.Renderer;
import gfx.StaticLight;
import maths.Vector2;

public class MagmaTile extends Tile {

	private final Animation ANIM_MAGMA = new Animation(State.TILE, 30);
	private Animator animator;
	

	public MagmaTile(Vector2 position, Scene scene) {
		super(position, true, Gfx.magma_0, scene, TileColor.MAGMA);
		animator = new Animator();

		ANIM_MAGMA.addSprite(Gfx.magma_0);
		ANIM_MAGMA.addSprite(Gfx.magma_1);
		ANIM_MAGMA.addSprite(Gfx.magma_2);
		ANIM_MAGMA.addSprite(Gfx.magma_3);
		ANIM_MAGMA.addSprite(Gfx.magma_4);
		ANIM_MAGMA.addSprite(Gfx.magma_5);
		ANIM_MAGMA.addSprite(Gfx.magma_6);
		ANIM_MAGMA.addSprite(Gfx.magma_7);
		ANIM_MAGMA.addSprite(Gfx.magma_8);
		ANIM_MAGMA.addSprite(Gfx.magma_9);
		ANIM_MAGMA.addSprite(Gfx.magma_10);
		ANIM_MAGMA.addSprite(Gfx.magma_11);
		ANIM_MAGMA.addSprite(Gfx.magma_12);
		ANIM_MAGMA.addSprite(Gfx.magma_13);
		ANIM_MAGMA.addSprite(Gfx.magma_14);
		ANIM_MAGMA.addSprite(Gfx.magma_15);

		animator.addAnimation(ANIM_MAGMA);
		
	}

	@Override
	public void renderSelf(Renderer renderer, int x, int y) {
		sprite = animator.getCurrentAnimation().getCurrentSprite();
		renderer.drawTile(this, bounds.getX(), bounds.getY());
	}

	@Override
	public void runScript() {
		animator.update(State.TILE);
	}

}
