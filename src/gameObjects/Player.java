package gameObjects;

import core.CharacterController;
import core.Scene;
import gfx.Animation;
import gfx.Animator;
import gfx.Renderer;
import gfx.Sprite;
import maths.Vector2;
import testGame.Gfx;

public class Player extends Mob {

	protected Animator animator;
	
	public float direction = 0.0f;
	
	private final Animation ANIM_PLAYER_DOWN = new Animation(State.DOWN, 6);
	private final Animation ANIM_PLAYER_UP = new Animation(State.UP, 6);
	private final Animation ANIM_PLAYER_LEFT = new Animation(State.LEFT, 6);
	private final Animation ANIM_PLAYER_RIGHT = new Animation(State.RIGHT, 6);
	private final Animation ANIM_PLAYER_IDLE_UP = new Animation(State.IDLE_UP, 6);
	private final Animation ANIM_PLAYER_IDLE_DOWN = new Animation(State.IDLE_DOWN, 6);
	private final Animation ANIM_PLAYER_IDLE_RIGHT = new Animation(State.IDLE_RIGHT, 6);
	private final Animation ANIM_PLAYER_IDLE_LEFT = new Animation(State.IDLE_LEFT, 6);

	public Player(Vector2 position, Sprite sprite, Scene scene) {
		super(position, sprite, scene);
		initAnimations();
		dir = State.DOWN;
	}
	
	private void initAnimations(){
		
		animator = new Animator();
		animator.addAnimation(ANIM_PLAYER_DOWN);
		animator.addAnimation(ANIM_PLAYER_UP);
		animator.addAnimation(ANIM_PLAYER_LEFT);
		animator.addAnimation(ANIM_PLAYER_RIGHT);
		animator.addAnimation(ANIM_PLAYER_IDLE_DOWN);
		animator.addAnimation(ANIM_PLAYER_IDLE_UP);
		animator.addAnimation(ANIM_PLAYER_IDLE_LEFT);
		animator.addAnimation(ANIM_PLAYER_IDLE_RIGHT);
		
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_0);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_1);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_2);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_3);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_4);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_5);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_6);
		ANIM_PLAYER_DOWN.addSprite(Gfx.PLAYE_DOWN_7);

		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_0);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_1);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_2);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_3);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_4);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_5);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_6);
		ANIM_PLAYER_UP.addSprite(Gfx.PLAYE_UP_7);

		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_0);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_1);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_2);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_3);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_4);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_5);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_6);
		ANIM_PLAYER_LEFT.addSprite(Gfx.PLAYE_LEFT_7);

		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_0);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_1);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_2);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_3);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_4);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_5);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_6);
		ANIM_PLAYER_RIGHT.addSprite(Gfx.PLAYE_RIGHT_7);

		ANIM_PLAYER_IDLE_UP.addSprite(Gfx.PLAYE_UP_0);
		ANIM_PLAYER_IDLE_DOWN.addSprite(Gfx.PLAYE_DOWN_0);
		ANIM_PLAYER_IDLE_LEFT.addSprite(Gfx.PLAYE_LEFT_0);
		ANIM_PLAYER_IDLE_RIGHT.addSprite(Gfx.PLAYE_RIGHT_0);
		
	}

	public void renderSelf(Renderer renderer, int xOffs, int yOffs) {
		sprite = animator.getCurrentAnimation().getCurrentSprite();
		renderer.drawPlayer(sprite, bounds.getX(), bounds.getY());
	}

	@Override
	public int getWidth() {
		return sprite.getWidth();
	}

	@Override
	public int getHeight() {
		return sprite.getHeight();
	}

	@Override
	public int[] getPixels() {
		return sprite.getPix();
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

	@Override
	public void runScript() {
		
		int dx = 0;
		int dy = 0;
		
		switch (dir) {
		case DOWN:
			direction = 6.5f;
			break;
		case UP:
			direction = 3.5f;
			break;
		case LEFT:
			direction = 2.0f;
			break;
		case RIGHT:
			direction = 5.0f;
			break;

		default:
			break;
		}
		

		if (CharacterController.up)
			dy--;
		if (CharacterController.down)
			dy++;
		if (CharacterController.right)
			dx++;
		if (CharacterController.left)
			dx--;


		move(dx, dy);
		setDirection(dx, dy);
		animator.update(dir);
		
		
		

	}

	


}
