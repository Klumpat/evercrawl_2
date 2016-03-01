package gfx;

import java.util.ArrayList;
import java.util.List;

import gameObjects.State;
import interfaces.Updateable;

public class Animation implements Updateable{
	
	private State dir;
	private int frameTime;
	private List<Sprite> sprites = new ArrayList<Sprite>();
	private int currentSprite = 0;
	int timer = 0;
	
	public Animation(State dir, int frameTime){
		this.frameTime = frameTime;
		this.dir = dir;
	}

	public void update() {
		timer++;
		if(timer % frameTime == 0){
			nextSprite();
		}
	}
	
	public void start(){
		
	}
	
	public void stop(){
		
	}
	
	public int getFrames(){
		return sprites.size();
	}
	
	public Sprite getCurrentSprite(){
		return sprites.get(currentSprite);
	}
	
	public List<Sprite> getSprites(){
		return sprites;
	}
	
	public State getDirection(){
		return dir;
	}
	
	public void addSprite(Sprite sprite){
		sprites.add(sprite);
	}
	
	public void addSpriteAt(Sprite sprite, int pos){
		sprites.add(pos, sprite);
	}
	
	public void nextSprite(){
		currentSprite++;
		if(currentSprite > getFrames()-1){
			currentSprite = 0;
		}
	}

}
