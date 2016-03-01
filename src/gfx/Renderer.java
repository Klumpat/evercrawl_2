package gfx;

import gameObjects.Tile;

//TODO finish lighting

/*
 * 
 * If the lightmap value == -1 THEN no std lightlevel is aplied in the postprocess function
 * The lightmap value cant be higher then 15 -> 15 is daylight - 0 is no light - so we can get 16 different light scales
 * 
 */

public class Renderer extends Bitmap {

	private int xOffset = 0;
	private int yOffset = 0;

	private int scale;

	public static int lightLevel;
	private int[] lightMap;

	private Font smallFont;
	private Font largetFont;

	public Renderer(int width, int height, int scale) {
		super(width, height);
		this.scale = scale;
		lightLevel = 15;

		lightMap = new int[width * height];

		this.smallFont = new Font(SpriteSheet.fontSheet8x8, 8);
		this.largetFont = new Font(SpriteSheet.fontSheet16x16, 16);

	}

	public int[] getLightMap() {
		return lightMap;
	}

	public void draw(Bitmap bitmap, float xPos, float yPos, boolean light) {

		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < bitmap.getHeight(); y++) {
			int yp = (int) (y + yPos);
			for (int x = 0; x < bitmap.getWidth(); x++) {
				int xp = (int) (x + xPos);

				if (xp < 0 || yp < 0 || xp >= width || yp >= height)
					continue;

				int col = bitmap.pix[x + y * bitmap.width];
				if (col != 0xffff00ff) {
					if (!light) {
						lightMap[xp + yp * width] = -1;
					}
					pix[xp + yp * width] = col;

				}

			}
		}

	}

	public void GUIfillRectangle(int col, int width, int height, float xPos, float yPos) {
		for (int y = 0; y < height; y++) {
			int yp = (int) (y + yPos);
			for (int x = 0; x < width; x++) {
				int xp = (int) (x + xPos);

				if (xp < 0 || yp < 0 || xp >= getWidth() || yp >= getHeight())
					break;

				int a = col;
				pix[xp + yp * getWidth()] = a;

			}
		}

	}

	public void GUIdrawBitmap(Bitmap bitmap, float xPos, float yPos) {
		for (int y = 0; y < bitmap.getHeight(); y++) {
			int yp = (int) (y + yPos);
			for (int x = 0; x < bitmap.getWidth(); x++) {
				int xp = (int) (x + xPos);

				if (xp < 0 || yp < 0 || xp >= width || yp >= height)
					continue;

				int col = bitmap.pix[x + y * bitmap.width];
				if (col != 0xffff00ff) {
					lightMap[xp + yp * width] = -1;
					pix[xp + yp * width] = col;

				}

			}
		}

	}

	public void drawRectangle(int col, int width, int height, float xPos, float yPos, int thickness) {

		for (int y = 0; y < height; y++) {
			int yp = (int) (y + yPos);
			for (int x = 0; x < width; x++) {
				int xp = (int) (x + xPos);

				if (xp < 0 || yp < 0 || xp >= getWidth() || yp >= getHeight())
					break;

				if (y <= thickness || y >= (width - thickness)) {
					pix[xp + yp * getWidth()] = col;
				}

				if (x <= thickness || x >= (height - thickness)) {
					pix[xp + yp * getWidth()] = col;
				}

			}
		}
	}

	public void drawPlayer(Sprite sprite, float xPos, float yPos) {
		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < sprite.getHeight(); y++) {
			int yp = (int) (y + yPos);
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xp = (int) (x + xPos);

				if (xp < -sprite.getWidth() || yp < 0 || xp >= width || yp >= height)
					break;
				if (xp < 0)
					xp = 0;

				int col = sprite.pix[x + y * sprite.width];

				if (col != 0xffff00ff)
					pix[xp + yp * width] = col;

			}
		}

	}

	public void drawTile(Tile tile, float xPos, float yPos) {

		// this is the ugly version, dont use raw numbers .... handle this in
		// the tile class?

		// xPos = xPos << 5;
		// yPos = yPos << 5;

		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < tile.getHeight(); y++) {
			int yp = (int) (y + yPos);
			for (int x = 0; x < tile.getWidth(); x++) {
				int xp = (int) (x + xPos);

				if (xp < -tile.getWidth() || yp < 0 || xp >= width || yp >= height)
					break;
				if (xp < 0)
					xp = 0;

				int col = tile.getPixels()[x + y * tile.getWidth()];
				pix[xp + yp * width] = col;
				if (!tile.isLighting()) {
					lightMap[xp + yp * width] = -1;
				}

			}
		}

	}

	@Deprecated
	public void drawText(String text, float xPos, float yPos) {
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int charIndex = smallFont.getCharset().indexOf(currentChar);
			if (charIndex == -1) {
				continue;
			}
			Sprite sprite = (Sprite) smallFont.getCharSprite(charIndex);
			draw(sprite, xPos + i * smallFont.getFontSize(), yPos, false);
		}
	}

	public void drawGuiText(String text, float xPos, float yPos, int col, boolean big) {
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int charIndex = smallFont.getCharset().indexOf(currentChar);
			if (charIndex == -1) {
				continue;
			}

			Sprite sprite;

			if (big) {
				sprite = (Sprite) largetFont.getCharSprite(charIndex);
				for (int y = 0; y < sprite.getHeight(); y++) {
					int yp = (int) (y + yPos);
					for (int x = 0; x < sprite.getWidth(); x++) {
						int xp = (int) (x + xPos);

						if (xp < 0 || yp < 0 || xp >= width || yp >= height)
							continue;

						int a = sprite.pix[x + y * sprite.width];
						if (a != 0xff00ff) {
							pix[(xp + i * largetFont.getFontSize()) + yp * width] = col;
							lightMap[(xp + i * largetFont.getFontSize()) + yp * width] = -1;

						}

					}
				}
			} else {
				sprite = (Sprite) smallFont.getCharSprite(charIndex);
				for (int y = 0; y < sprite.getHeight(); y++) {
					int yp = (int) (y + yPos);
					for (int x = 0; x < sprite.getWidth(); x++) {
						int xp = (int) (x + xPos);

						if (xp < 0 || yp < 0 || xp >= width || yp >= height)
							continue;

						int a = sprite.pix[x + y * sprite.width];
						if (a != 0xffff00ff) {
							pix[(xp + i * smallFont.getFontSize()) + yp * width] = col;
							lightMap[(xp + i * smallFont.getFontSize()) + yp * width] = -1;

						}

					}
				}
			}

		}
	}

	@Deprecated
	public void drawLightCircle(Light light, float xPos, float yPos) {

		// http://members.chello.at/~easyfilter/bresenham.html

		xPos -= xOffset;
		yPos -= yOffset;

		int d = (5 - (light.getWidth()) * 4) / 4;
		int x = 0;
		int y = light.getWidth();
		while (x <= y) {

			for (int xx = (int) (xPos - x); xx <= xPos + x; xx++) {
				// setLightMap(xx, yPos + y, light);
				// setLightMap(xx, yPos - y, light);
			}

			for (int xx = (int) (xPos - y); xx <= xPos + y; xx++) {
				// setLightMap(xx, yPos + x, light);
				// setLightMap(xx, yPos - x, light);
			}

			// setLightMap(xPos-x, yPos+y, light);
			// setLightMap(xPos-x, yPos-y, light);
			// setLightMap(xPos+x, yPos+y, light);
			// setLightMap(xPos+x, yPos-y, light);

			if (d < 0) {
				d += 2 * x + 1;
			} else {
				d += 2 * (x - y) + 1;
				y--;
			}
			x++;
		}

	}

	public void drawLightMap(Bitmap map, float xPos, float yPos) {

		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < map.height; y++) {
			int yy = (int) (y + yPos);
			for (int x = 0; x < map.width; x++) {
				int xx = (int) (x + xPos);
				if (yy < 0 || xx < -map.width || yy >= height || xx >= width)
					break;
				if (xx < 0) {
					xx = 0;
				}
				// System.out.println(map.pix[x + y * map.width] + lightLevel);
				lightMap[xx + yy * width] += map.pix[x + y * map.width];
			}
		}

	}

	public void drawBitMap(Bitmap map, float xPos, float yPos) {

		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < map.height; y++) {
			int yy = (int) (y + yPos);
			for (int x = 0; x < map.width; x++) {
				int xx = (int) (x + xPos);
				if (yy < 0 || xx < -map.width || yy >= height || xx >= width)
					break;
				if (xx < 0) {
					xx = 0;
				}

				int a = map.pix[x + y * map.width];
				if (a != 0xffff00ff)
					pix[xx + yy * width] = map.pix[x + y * map.width];
			}
		}

	}

	@Deprecated
	public void drawLightTest(Light light, float xPos, float yPos) {

		int w = light.getWidth();
		int h = light.getHeight();

		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < h; y++) {
			int yy = (int) (y + yPos);
			for (int x = 0; x < w; x++) {
				int xx = (int) (x + xPos);
				if (yy < 0 || xx < 0 || yy >= height || xx >= width)
					break;

				lightMap[xx + yy * width] = 15;
			}
		}

	}

	public void postProcess() {

		if (lightLevel < 0) {
			lightLevel = 0;
		}
		if (lightLevel > 15) {
			lightLevel = 15;
		}

		for (int y = 0; y < pix.length; y++) {
			int index = y;

			// System.out.println(intensity);

			if (lightMap[index] < lightLevel) {
				lightMap[index] = lightLevel;
			}

			if (lightMap[index] == -1) {
				continue;
			}

			if (lightMap[index] > 15) {
				lightMap[index] = 15;
			}
			int intensity = Math.max((int) (lightMap[index]), lightLevel);

			int col = pix[index];

			int brightness = (int) Math.pow(intensity, 2);

			int r = (col >> 16) & 0xff;
			int g = (col >> 8) & 0xff;
			int b = (col) & 0xff;

			r = r * brightness / 255;
			g = g * brightness / 255;
			b = b * brightness / 255;

			if (r > 255)
				r = 255;
			if (g > 255)
				g = 255;
			if (b > 255)
				b = 255;

			pix[index] = r << 16 | g << 8 | b;
		}

	}

	@Deprecated
	public int processLight(int col, int lightLevel) {

		int brightness = (int) Math.pow(lightLevel, 2);

		int r = (col >> 16) & 0xff;
		int g = (col >> 8) & 0xff;
		int b = (col) & 0xff;

		r = r * brightness / 255;
		g = g * brightness / 255;
		b = b * brightness / 255;

		int res = r << 16 | g << 8 | b;

		return res;

	}

	public void clear(int color) {
		for (int i = 0; i < pix.length; i++) {
			pix[i] = color;
			lightMap[i] = lightLevel;
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public int getScale() {
		return scale;
	}

	public int getLightLevel() {
		return lightLevel;
	}

	public static void setLightLevel(int level) {
		
		if (level < 0) {
			level = 0;
		}
		if (level > 15) {
			level = 15;
		}

		lightLevel = level;
	}
	

}
