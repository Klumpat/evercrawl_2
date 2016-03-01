package gfx;

import java.util.Arrays;

public class Bitmap {

	protected int width, height;
	public final int[] pix;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		this.pix = new int[width * height];
	}
	
	public Bitmap(int width, int height, int col) {
		this.width = width;
		this.height = height;
		this.pix = new int[width * height];
		Arrays.fill(pix, col);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public int[] getPix() {
		return this.pix;
	}

	public Bitmap flipX() {

		Bitmap res = new Bitmap(width, height);

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {
				int xPix = width - x - 1;

				int src = pix[x + y * width];
				res.pix[xPix + y * width] = src;
			}
		}

		return res;

	}
	
	public Bitmap flipY() {

		Bitmap res = new Bitmap(width, height);

		for (int y = 0; y < height; y++) {
			int yPix = height - y - 1;
			for (int x = 0; x < width; x++) {

				int src = pix[x + y * width];
				res.pix[x + yPix * width] = src;
			}
		}

		return res;

	}

	public void setPixel(int x, int y, int value) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return;
		}

		pix[x + y * width] = value;
	}

	public void drawCircle(int x0, int y0, int radius) {
		int x = radius;
		int y = 0;
		int decisionOver2 = 1 - x; // Decision criterion divided by 2 evaluated
									// at x=r, y=0

		while (y <= x) {
			int distance = (int) maths.MathUtil.getDistance(x0, y0, x, y);
			int value = width / distance * 4;

			setPixel(x + x0, y + y0, value); // Octant 1
			setPixel(y + x0, x + y0, value); // Octant 2
			setPixel(-x + x0, y + y0, value); // Octant 4
			setPixel(-y + x0, x + y0, value); // Octant 3
			setPixel(-x + x0, -y + y0, value); // Octant 5
			setPixel(-y + x0, -x + y0, value); // Octant 6
			setPixel(x + x0, -y + y0, value); // Octant 7
			setPixel(y + x0, -x + y0, value); // Octant 8
			y++;
			if (decisionOver2 <= 0) {
				decisionOver2 += 2 * y + 1; // Change in decision criterion for
											// y -> y+1
			} else {
				x--;
				decisionOver2 += 2 * (y - x) + 1; // Change for y -> y+1, x ->
													// x-1
			}
		}
	}

	public void fillCircle(int x0, int y0, int radius) {
		// Decision criterion divided by 2 evaluated
		// at x=r, y=0
		for (int i = 0; i <= radius; i++) {
			int x = radius - i;
			int y = 0;
			int decisionOver2 = 1 - x;
			while (y <= x) {

				int distance = (int) maths.MathUtil.getDistance(x0, y0, x, y);
				int value = width / distance * 16;

				setPixel(x + x0, y + y0, value); // Octant 1
				setPixel(y + x0, x + y0, value); // Octant 2
				setPixel(-x + x0, y + y0, value); // Octant 4
				setPixel(-y + x0, x + y0, value); // Octant 3
				setPixel(-x + x0, -y + y0, value); // Octant 5
				setPixel(-y + x0, -x + y0, value); // Octant 6
				setPixel(x + x0, -y + y0, value); // Octant 7
				setPixel(y + x0, -x + y0, value); // Octant 8
				y++;
				if (decisionOver2 <= 0) {
					decisionOver2 += 2 * y + 1; // Change in decision criterion
												// for
												// y -> y+1
				} else {
					x--;
					decisionOver2 += 2 * (y - x) + 1; // Change for y -> y+1, x
														// ->
														// x-1
				}
			}
		}

		// for (int xx = x0 - x; xx <= x0 + x; xx++) {
		// int distance = (int) maths.MathUtil.getDistance(x0, y0, xx, y);
		// int value = width / distance * 4;
		// setPixel(xx, y0 + y, value);
		// setPixel(xx, y0 - y, value);
		// }
		//
		// for (int xx = x0 - y; xx <= x0 + y; xx++) {
		// int distance = (int) maths.MathUtil.getDistance(x0, y0, xx, y);
		// int value = width / distance * 4;
		// setPixel(xx, y0 + x, value);
		// setPixel(xx, y0 - x, value);
		// }

	}

}
