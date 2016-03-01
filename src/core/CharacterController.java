package core;

import java.awt.event.KeyEvent;

import maths.Vector2;

public class CharacterController {

	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;

	public static boolean mouseLeft = false;
	public static boolean mouseRight = false;
	
	public static Vector2 mTileCoords;
	public static Vector2 mWorldCoords;
	public static Vector2 mGuiCoords;

	public void update(Vector2 mTileCoords, Vector2 mWorldCoords, Vector2 mGuiCoords, boolean[] mouseButton) {
		CharacterController.mTileCoords = mTileCoords;
		CharacterController.mWorldCoords = mWorldCoords;
		CharacterController.mGuiCoords = mGuiCoords;
		
		mouseLeft = mouseButton[0];
		mouseRight = mouseButton[1];
		
		up = Input.keyPressed(KeyEvent.VK_W);
		down = Input.keyPressed(KeyEvent.VK_S);
		left = Input.keyPressed(KeyEvent.VK_A);
		right = Input.keyPressed(KeyEvent.VK_D);
		

	}

}
