package testGame;

import gfx.Bitmap;
import gfx.Sprite;
import gfx.SpriteSheet;

public class Gfx {

	public static Sprite PLAYE_DOWN_0;
	public static Sprite PLAYE_DOWN_1;
	public static Sprite PLAYE_DOWN_2;
	public static Sprite PLAYE_DOWN_3;
	public static Sprite PLAYE_DOWN_4;
	public static Sprite PLAYE_DOWN_5;
	public static Sprite PLAYE_DOWN_6;
	public static Sprite PLAYE_DOWN_7;

	public static Sprite PLAYE_UP_0;
	public static Sprite PLAYE_UP_1;
	public static Sprite PLAYE_UP_2;
	public static Sprite PLAYE_UP_3;
	public static Sprite PLAYE_UP_4;
	public static Sprite PLAYE_UP_5;
	public static Sprite PLAYE_UP_6;
	public static Sprite PLAYE_UP_7;

	public static Sprite PLAYE_LEFT_0;
	public static Sprite PLAYE_LEFT_1;
	public static Sprite PLAYE_LEFT_2;
	public static Sprite PLAYE_LEFT_3;
	public static Sprite PLAYE_LEFT_4;
	public static Sprite PLAYE_LEFT_5;
	public static Sprite PLAYE_LEFT_6;
	public static Sprite PLAYE_LEFT_7;

	public static Sprite PLAYE_RIGHT_0;
	public static Sprite PLAYE_RIGHT_1;
	public static Sprite PLAYE_RIGHT_2;
	public static Sprite PLAYE_RIGHT_3;
	public static Sprite PLAYE_RIGHT_4;
	public static Sprite PLAYE_RIGHT_5;
	public static Sprite PLAYE_RIGHT_6;
	public static Sprite PLAYE_RIGHT_7;

	public static Sprite wallSprite;
	public static Sprite wallSpriteLeft;
	public static Sprite wallSpriteRight;
	public static Sprite wallSpriteLeftCorner;
	public static Sprite wallSpriteRightCorner;
	public static Sprite redSprite;
	public static Sprite grassSprite;
	public static Sprite greenSprite;
	public static Sprite floorSprite;

	public static Sprite ocean_0;
	public static Sprite ocean_1;
	public static Sprite ocean_2;
	public static Sprite ocean_3;
	public static Sprite ocean_4;
	public static Sprite ocean_5;
	public static Sprite ocean_6;
	public static Sprite ocean_7;
	public static Sprite ocean_8;
	public static Sprite ocean_9;
	public static Sprite ocean_10;
	public static Sprite ocean_11;
	public static Sprite ocean_12;
	public static Sprite ocean_13;
	public static Sprite ocean_14;
	public static Sprite ocean_15;

	public static Sprite magma_0;
	public static Sprite magma_1;
	public static Sprite magma_2;
	public static Sprite magma_3;
	public static Sprite magma_4;
	public static Sprite magma_5;
	public static Sprite magma_6;
	public static Sprite magma_7;
	public static Sprite magma_8;
	public static Sprite magma_9;
	public static Sprite magma_10;
	public static Sprite magma_11;
	public static Sprite magma_12;
	public static Sprite magma_13;
	public static Sprite magma_14;
	public static Sprite magma_15;

	public static Sprite torch;

	public static void init() {

		PLAYE_DOWN_0 = new Sprite(24, 32, 0, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_1 = new Sprite(24, 32, 1, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_2 = new Sprite(24, 32, 2, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_3 = new Sprite(24, 32, 3, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_4 = new Sprite(24, 32, 4, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_5 = new Sprite(24, 32, 5, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_6 = new Sprite(24, 32, 6, 0, SpriteSheet.playersheet);
		PLAYE_DOWN_7 = new Sprite(24, 32, 7, 0, SpriteSheet.playersheet);

		PLAYE_UP_0 = new Sprite(24, 32, 0, 1, SpriteSheet.playersheet);
		PLAYE_UP_1 = new Sprite(24, 32, 1, 1, SpriteSheet.playersheet);
		PLAYE_UP_2 = new Sprite(24, 32, 2, 1, SpriteSheet.playersheet);
		PLAYE_UP_3 = new Sprite(24, 32, 3, 1, SpriteSheet.playersheet);
		PLAYE_UP_4 = new Sprite(24, 32, 4, 1, SpriteSheet.playersheet);
		PLAYE_UP_5 = new Sprite(24, 32, 5, 1, SpriteSheet.playersheet);
		PLAYE_UP_6 = new Sprite(24, 32, 6, 1, SpriteSheet.playersheet);
		PLAYE_UP_7 = new Sprite(24, 32, 7, 1, SpriteSheet.playersheet);

		PLAYE_LEFT_0 = new Sprite(24, 32, 0, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_1 = new Sprite(24, 32, 1, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_2 = new Sprite(24, 32, 2, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_3 = new Sprite(24, 32, 3, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_4 = new Sprite(24, 32, 4, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_5 = new Sprite(24, 32, 5, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_6 = new Sprite(24, 32, 6, 2, SpriteSheet.playersheet);
		PLAYE_LEFT_7 = new Sprite(24, 32, 7, 2, SpriteSheet.playersheet);

		PLAYE_RIGHT_0 = new Sprite(24, 32, 0, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_1 = new Sprite(24, 32, 1, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_2 = new Sprite(24, 32, 2, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_3 = new Sprite(24, 32, 3, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_4 = new Sprite(24, 32, 4, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_5 = new Sprite(24, 32, 5, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_6 = new Sprite(24, 32, 6, 3, SpriteSheet.playersheet);
		PLAYE_RIGHT_7 = new Sprite(24, 32, 7, 3, SpriteSheet.playersheet);

		redSprite = new Sprite(32, 32, 1, 0, SpriteSheet.spriteSheet);
		grassSprite = new Sprite(32, 32, 3, 0, SpriteSheet.spriteSheet);
		greenSprite = new Sprite(32, 32, 2, 0, SpriteSheet.spriteSheet);
		floorSprite = new Sprite(32, 32, 3, 0, SpriteSheet.spriteSheet);
		wallSprite = new Sprite(32, 32, 5, 0, SpriteSheet.spriteSheet);
		wallSpriteLeft = new Sprite(32, 32, 4, 1, SpriteSheet.spriteSheet);
		wallSpriteRight = new Sprite(wallSpriteLeft.flipX());
		wallSpriteLeftCorner = new Sprite(32, 32, 4, 0, SpriteSheet.spriteSheet);
		wallSpriteRightCorner = new Sprite(wallSpriteLeftCorner.flipX());

		// cliff_0 = new Sprite(32, 32, 0, 0, SpriteSheet.sheet);
		// cliff_1 = new Sprite(32, 32, 1, 0, SpriteSheet.sheet);
		// cliff_2 = new Sprite(32, 32, 2, 0, SpriteSheet.sheet);
		// cliff_3 = new Sprite(32, 32, 3, 0, SpriteSheet.sheet);
		// cliff_4 = new Sprite(32, 32, 4, 0, SpriteSheet.sheet);
		// cliff_5 = new Sprite(32, 32, 5, 0, SpriteSheet.sheet);

		ocean_0 = new Sprite(32, 32, 0, 0, SpriteSheet.ocean_sheet);
		ocean_1 = new Sprite(32, 32, 1, 0, SpriteSheet.ocean_sheet);
		ocean_2 = new Sprite(32, 32, 2, 0, SpriteSheet.ocean_sheet);
		ocean_3 = new Sprite(32, 32, 3, 0, SpriteSheet.ocean_sheet);
		ocean_4 = new Sprite(32, 32, 4, 0, SpriteSheet.ocean_sheet);
		ocean_5 = new Sprite(32, 32, 5, 0, SpriteSheet.ocean_sheet);
		ocean_6 = new Sprite(32, 32, 6, 0, SpriteSheet.ocean_sheet);
		ocean_7 = new Sprite(32, 32, 7, 0, SpriteSheet.ocean_sheet);
		ocean_8 = new Sprite(32, 32, 0, 1, SpriteSheet.ocean_sheet);
		ocean_9 = new Sprite(32, 32, 1, 1, SpriteSheet.ocean_sheet);
		ocean_10 = new Sprite(32, 32, 2, 1, SpriteSheet.ocean_sheet);
		ocean_11 = new Sprite(32, 32, 3, 1, SpriteSheet.ocean_sheet);
		ocean_12 = new Sprite(32, 32, 4, 1, SpriteSheet.ocean_sheet);
		ocean_13 = new Sprite(32, 32, 5, 1, SpriteSheet.ocean_sheet);
		ocean_14 = new Sprite(32, 32, 6, 1, SpriteSheet.ocean_sheet);
		ocean_15 = new Sprite(32, 32, 7, 1, SpriteSheet.ocean_sheet);

		magma_0 = new Sprite(32, 32, 0, 0, SpriteSheet.magma_sheet);
		magma_1 = new Sprite(32, 32, 1, 0, SpriteSheet.magma_sheet);
		magma_2 = new Sprite(32, 32, 2, 0, SpriteSheet.magma_sheet);
		magma_3 = new Sprite(32, 32, 3, 0, SpriteSheet.magma_sheet);
		magma_4 = new Sprite(32, 32, 4, 0, SpriteSheet.magma_sheet);
		magma_5 = new Sprite(32, 32, 5, 0, SpriteSheet.magma_sheet);
		magma_6 = new Sprite(32, 32, 6, 0, SpriteSheet.magma_sheet);
		magma_7 = new Sprite(32, 32, 7, 0, SpriteSheet.magma_sheet);
		magma_8 = new Sprite(32, 32, 0, 1, SpriteSheet.magma_sheet);
		magma_9 = new Sprite(32, 32, 1, 1, SpriteSheet.magma_sheet);
		magma_10 = new Sprite(32, 32, 2, 1, SpriteSheet.magma_sheet);
		magma_11 = new Sprite(32, 32, 3, 1, SpriteSheet.magma_sheet);
		magma_12 = new Sprite(32, 32, 4, 1, SpriteSheet.magma_sheet);
		magma_13 = new Sprite(32, 32, 5, 1, SpriteSheet.magma_sheet);
		magma_14 = new Sprite(32, 32, 6, 1, SpriteSheet.magma_sheet);
		magma_15 = new Sprite(32, 32, 7, 1, SpriteSheet.magma_sheet);

		torch = new Sprite(3, 9, 0, 0, SpriteSheet.torch);

	}

}
