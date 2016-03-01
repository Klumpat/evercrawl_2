package gfx;

import java.util.ArrayList;
import java.util.List;

import gameObjects.State;

public class Animator {

	private List<Animation> animations = new ArrayList<Animation>();
	private int currentAnimation;

	public void update(State dir) {

		if (getCurrentAnimation().getDirection() != dir) {
			setAnimation(dir);
		}

		getCurrentAnimation().update();
	}

	public Animation getCurrentAnimation() {
		return animations.get(currentAnimation);
	}

	public void addAnimation(Animation animation) {
		animations.add(animation);
	}

	public void setAnimation(State dir) {
		stopAnimation();
		for (int i = 0; i < animations.size(); i++) {
			if (animations.get(i).getDirection().equals(dir)) {
				currentAnimation = i;
			}
		}

		startAnimation();
	}

	public void startAnimation() {
		animations.get(currentAnimation).start();
	}

	public void stopAnimation() {
		animations.get(currentAnimation).stop();
	}

}
